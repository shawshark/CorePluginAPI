package net.shawshark.core.api;

import net.shawshark.core.api.database.IDatabaseManager;
import net.shawshark.core.api.user.CoreMetadata;
import net.shawshark.core.api.user.ICorePlayer;

public class CorePluginAPI {

    public static CorePluginPlugin plugin;

    public static void setAPI(CorePluginPlugin plugin) {
        CorePluginAPI.plugin = plugin;
    }

    public static void checkState() {
        if(plugin == null)
            throw new IllegalStateException("no api set");
    }

    public static CorePluginPlugin getPlugin() {
        checkState();
        return plugin;
    }

    public IPlayerDataManager getPlayerDataManager() {
        checkState();
        return getPlugin().getPlayerDataManager();
    }

    public IDatabaseManager getDatabaseManager() {
        checkState();
        return getPlugin().getDatabaseManager();
    }
}
