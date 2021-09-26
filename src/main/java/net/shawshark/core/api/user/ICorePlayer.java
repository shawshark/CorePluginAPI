package net.shawshark.core.api.user;

import net.shawshark.core.api.ProfileLoad;
import net.shawshark.core.api.user.minigames.MiniGame;
import net.shawshark.core.api.user.minigames.MinigameCurrency;
import net.shawshark.core.api.user.minigames.MinigameData;

import java.util.UUID;

public interface ICorePlayer {

    MinigameCurrency getMiniGameCurrency(String name);
    MinigameData getMiniGameData(String name);

    void saveMiniGameData();
    void saveCorePlayer();
    void loadFromDatabase();
    void saveCurrency(MiniGame type, MinigameCurrency currency);
    void loadCurrency(MiniGame type);
    void saveMiniGameData(MiniGame type, MinigameData data);
    void loadMiniGameData(MiniGame type, MinigameData data);

    void addCosmeticLoadHandler(MiniGame type, ProfileLoad load);

    String getRankString();
    String getDisplayName();
    String getName();
    UUID getPlayerUUID();

    int getGems();
}