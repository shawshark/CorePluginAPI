# CorePluginAPI
```
<repository>
	<id>skycadia</id>
        <url>http://play.skycadia.games/repo/</url>
</repository>
```


```
<dependency>
        <groupId>net.shawshark</groupId>
        <artifactId>CorePluginAPI</artifactId>
        <version>1.1-SNAPSHOT</version>
        <scope>provided</scope>
</dependency>
```

```
//register minigame
CorePluginAPI.getPlugin().getPlayerDataManager().registerMiniGame("MinigameName", "SQLDataTableName", "SQLCurrencyName");

//getting core player
ICorePlayer cplayer = CorePluginAPI.getPlugin().getCorePlayer(UUID.randomUUID());

//getting currency
MinigameCurrency currency = cplayer.getMiniGameCurrency("MinigameName");
currency.setBalance(1000);

//getting data
MinigameData data = cplayer.getMiniGameData("MinigameName");
data.setKills((data.getKills() + 1));
data.setPlayed((data.getPlayed() + 1));
```
```
registerMiniGame("Pirates", "pirates_data", "pirates_currency_data");```
