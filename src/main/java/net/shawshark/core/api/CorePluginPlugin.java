package net.shawshark.core.api;

import net.shawshark.core.api.user.ICorePlayer;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public interface CorePluginPlugin extends Plugin {
    IPlayerDataManager getPlayerDataManager();
    ICorePlayer getCorePlayer(UUID uuid);
}