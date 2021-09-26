package net.shawshark.core.api.user.minigames;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.shawshark.core.api.user.MinigameTypes;

import java.util.UUID;

@AllArgsConstructor
public class MinigameCurrency {
    @Getter@Setter private UUID uuid;
    @Getter@Setter private MiniGame minigameType;
    @Getter@Setter private int balance;
}
