package net.shawshark.core.api.user.minigames;

import lombok.Getter;
import net.shawshark.core.api.CorePluginAPI;
import net.shawshark.core.api.LoadHandler;
import net.shawshark.core.api.SaveHandler;
import net.shawshark.core.api.user.CoreData;
import net.shawshark.core.api.user.CoreMetadata;
import net.shawshark.core.api.user.StreaksData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ExampleCoreMetdata {

    @Getter private CoreMetadata<StreaksData> streaks;

    // player data storage
    @Getter private Map<UUID, StreaksData> streakData = new HashMap<>();

    public void onEnable() {

        // register the key
        streaks = new CoreMetadata<>("streak", CorePluginAPI.getPlugin());

        // load the player
        getStreaks().load(new LoadHandler<StreaksData>() {
            @Override
            public void load(StreaksData metadata) {
                getStreakData().put(UUID.randomUUID(), metadata);
            }
        }, UUID.randomUUID(), StreaksData.class);

        //save the player data
        getStreaks().save(UUID.randomUUID(), getStreakData().get(UUID.randomUUID()), new SaveHandler() {
            @Override
            public void save(CoreData metadata, Status status) {
                if(status == Status.FAILED) {
                    System.out.println("Failed to save name steak data to database!");
                } else if(status == Status.SUCCESS) {
                    System.out.println("Saved name streak data to database!");
                }
            }
        });
    }
}
