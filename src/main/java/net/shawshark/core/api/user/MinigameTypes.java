package net.shawshark.core.api.user;

import lombok.Getter;

public enum MinigameTypes {
	PIRATES("pirates", "pirates_data", "pirates_currency_data");

	@Getter private String name, sqlTableName, sqlCurrencyTableName;
	MinigameTypes(String name, String sqlTableName, String sqlCurrencyTableName) {
		this.name = name;
		this.sqlTableName = sqlTableName;
		this.sqlCurrencyTableName = sqlCurrencyTableName;
	}
}