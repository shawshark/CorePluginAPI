package net.shawshark.core.api;

import net.shawshark.core.api.database.IDatabaseManager;
import net.shawshark.core.api.user.ICorePlayer;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public interface CorePluginPlugin extends Plugin {
    /**
     * Get the player data manager, Get minigame data and {@link ICorePlayer} object
     * @return
     */
    IPlayerDataManager getPlayerDataManager();

    /**
     * Get the database manager, from here you can execute
     * database querys, collect - save data
     * @return IDatabaseManager
     */
    IDatabaseManager getDatabaseManager();

    /**
     * Get the profile of a player. Player must be online
     * If you wish to get a offline profile of CorePlayer you must manually load it
     * @param uuid of the player you wish to get the profile of
     * @return
     */
    ICorePlayer getCorePlayer(UUID uuid);

    /**
     * Unsupported - coming soon
     * @param uuid of the player you wish to get the profile of
     * @return
     */
    ICorePlayer getOfflineCorePlayer(UUID uuid);
}