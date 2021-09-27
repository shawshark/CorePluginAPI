package net.shawshark.core.api.user;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class StreaksData extends CoreData {

    @SerializedName("streak")
    @Getter private int streak;

    public StreaksData(String data) {
        super(data);
        load();
    }

    @Override
    public void load() {
        StreaksData data = gson.fromJson(this.data, StreaksData.class);
        this.streak = data.getStreak();
    }

    @Override
    public String save() {
        return gson.toJson(this);
    }

    @Override
    void loadDefault() {
        this.streak = 0;
    }
}
