package net.shawshark.core.api.user;

import com.google.gson.Gson;
import lombok.Getter;
import net.shawshark.core.api.CorePluginPlugin;
import net.shawshark.core.api.LoadHandler;
import net.shawshark.core.api.SaveHandler;
import net.shawshark.core.api.database.DataTable;
import net.shawshark.core.api.database.SqlInputType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CoreMetadata<T> {

    @Getter
    private final String key;
    private Gson gson;
    @Getter
    private CorePluginPlugin plugin;
    private List<DataTable> columns;

    public CoreMetadata(String key, CorePluginPlugin plugin) {
        this.key = key;
        this.gson = new Gson();
        this.plugin = plugin;

        columns = Arrays.asList(
                new DataTable("UUID", null, DataTable.DataType.STRING),
                new DataTable("data", null, DataTable.DataType.LONGTEXT));

        // Create table in database with key
        plugin.getDatabaseManager().runSqlCommandLine(getCreateTableQuery(), null);
    }

    public void load(LoadHandler load, UUID uuid, Class<? extends CoreData> object) {

        String key = uuid.toString().replace("-", "");
        String query = "SELECT * FROM " + getTableName() + " WHERE UUID = '" + key + "';";

        //runs async
        getPlugin().getDatabaseManager().getData("UUID", query, response -> {
            try {
                if (response.containsKey(key) && response.get(key).size() > 0) {
                    for (DataTable col : response.get(key)) {
                        if (col.getName().equalsIgnoreCase("data")) {
                            final Constructor<? extends CoreData> constructor = object.getConstructor(String.class);
                            CoreData data = constructor.newInstance(col.getData());
                            //run the callback to the user
                            load.load(data);
                            break;

                        }
                    }
                } else {
                    final Constructor<? extends CoreData> constructor = object.getConstructor(String.class);
                    CoreData data = constructor.newInstance(null);
                    data.loadDefault();
                    load.load(data);
                    return;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }, columns.toArray(new DataTable[columns.size()]));
    }

    public void save(UUID uuid, CoreData object, SaveHandler save) {

        List<DataTable> col = new ArrayList<>(this.columns);
        col.stream().forEach(c -> {
            if(c.getName().equalsIgnoreCase("UUID")) {
                c.setData(uuid.toString().replace("-", ""));
            } else if(c.getName().equalsIgnoreCase("data")) {
                c.setData(object.save());
            }
        });

        getPlugin().getDatabaseManager().insertData(SqlInputType.REPLACE_INTO, getTableName(), col, response -> {
            if(response == -1) {
                save.save(object, SaveHandler.Status.FAILED);
            } else {
                save.save(object, SaveHandler.Status.SUCCESS);
            }
        });
    }

    public String getTableName() {
        return "core_metadata_" + getKey();
    }

    public String getCreateTableQuery() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS `" + getTableName() + "`" +
                "(");
        sb.append(" `UUID` varchar(100) NOT NULL,");
        sb.append(" `data` LONGTEXT NOT NULL,");
        sb.append(" UNIQUE KEY `UUID` (`UUID`)");
        sb.append(") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        return sb.toString();
    }
}
