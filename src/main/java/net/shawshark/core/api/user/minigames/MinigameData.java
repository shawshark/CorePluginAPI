package net.shawshark.core.api.user.minigames;

import lombok.Getter;
import lombok.Setter;
import net.shawshark.core.api.user.ICorePlayer;
import net.shawshark.core.api.user.MinigameTypes;

public abstract class MinigameData {

    private MinigameTypes type;
    private ICorePlayer corePlayer;

    @Getter@Setter private long lastPlayed = -1;
    @Getter@Setter int played = 0;
    @Getter@Setter private int kills = 0, deaths = 0, wins = 0, lost = 0;

    public MinigameData(MinigameTypes type, ICorePlayer corePlayer) {
        this.type = type;
        this.corePlayer = corePlayer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(type.getName() + ", lastplayed = " + lastPlayed +
                ", kills = " + kills + ", deaths = " + deaths + ", wins = " + wins + ", lost =" + lost);
        return sb.toString();
    }
}
