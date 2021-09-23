package net.shawshark.core.api;

import net.shawshark.core.api.user.ICorePlayer;

import java.util.UUID;

public interface CorePluginPlugin {
    IPlayerDataManager getPlayerDataManager();
    ICorePlayer getCorePlayer(UUID uuid);
}
