package net.shawshark.core.api.user;

import com.google.gson.Gson;

public abstract class CoreData {

    public final String data;
    public Gson gson;

    public CoreData(String data) {
        this.data = data;
        this.gson = new Gson();
    }

    public abstract void load();
    public abstract String save();
    public abstract void loadDefault();
}
