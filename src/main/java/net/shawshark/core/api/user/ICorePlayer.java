package net.shawshark.core.api.user;

import net.shawshark.core.api.user.minigames.MinigameCurrency;
import net.shawshark.core.api.user.minigames.MinigameData;

public interface ICorePlayer {
    void registerMiniGameType(MinigameTypes type);

    MinigameCurrency getMiniGameCurrency(MinigameTypes type);
    MinigameData getMiniGameData(MinigameTypes type);
}
