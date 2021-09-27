package net.shawshark.core.api;

import net.shawshark.core.api.user.ICorePlayer;
import net.shawshark.core.api.user.minigames.MiniGame;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public interface IPlayerDataManager {
    void registerMiniGame(String name, String SQLTableName, String sqlCurrencyTableName);
    MiniGame getMiniGame(String name);
    ConcurrentHashMap<UUID, ICorePlayer> getPlayers();
    HashMap<String, MiniGame> getMiniGames();
}
