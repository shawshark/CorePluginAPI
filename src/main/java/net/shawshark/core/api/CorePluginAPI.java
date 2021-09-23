package net.shawshark.core.api;

public class CorePluginAPI {

    private static CorePluginPlugin plugin;

    public static void setAPI(CorePluginPlugin plugin) {
        CorePluginAPI.plugin = plugin;
    }

    public static CorePluginPlugin getPlugin() {
        if(plugin == null)
            throw new IllegalStateException("no api set");
        return plugin;
    }
}
