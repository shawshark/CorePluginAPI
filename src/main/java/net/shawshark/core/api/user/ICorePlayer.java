package net.shawshark.core.api.user;

import net.shawshark.core.api.user.minigames.MiniGame;
import net.shawshark.core.api.user.minigames.MinigameCurrency;
import net.shawshark.core.api.user.minigames.MinigameData;

public interface ICorePlayer {
    void registerMiniGameType(MiniGame minigame);

    MinigameCurrency getMiniGameCurrency(String name);
    MinigameData getMiniGameData(String name);
}
