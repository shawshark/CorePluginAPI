package net.shawshark.core.api.database;

import net.shawshark.core.api.plugin.Callback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface IDatabaseManager {

    <T> T execute(ConnectionCallback<T> callback) throws IllegalAccessException;

    interface ConnectionCallback<T> {
        public T doInConnection(Connection conn) throws SQLException;
    }

    void getAllData(String uniqueKey, String query, Callback<ConcurrentHashMap<String, List<DataTable>>> callback, DataTable... columns);
    void getData(String key, String query, Callback<ConcurrentHashMap<String, List<DataTable>>> callback, DataTable... columns);
    void runSqlCommandLine(String query, Callback<Integer> callback);
    void insertData(SqlInputType inputType, String tableName, List<DataTable> data, Callback<Integer> callback);
    void update(String query, Object newData, Object where, DataTable.DataType type, Callback<Integer> callback);
}
