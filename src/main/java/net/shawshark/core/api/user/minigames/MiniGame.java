package net.shawshark.core.api.user.minigames;

import lombok.Getter;
import lombok.Setter;

public class MiniGame {

    @Getter@Setter private String name, sqlDataTableName, sqlCurrencyTableName;

    public MiniGame(String name, String sqlTableName, String sqlCurrencyTableName) {
        this.name = name;
        this.sqlDataTableName = sqlTableName;
        this.sqlCurrencyTableName = sqlCurrencyTableName;
    }
}
