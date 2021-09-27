package net.shawshark.core.api.user;

import com.google.gson.Gson;

public abstract class CoreData {

    public final String data;
    public Gson gson;

    public CoreData(String data) {
        this.data = data;
        this.gson = new Gson();
    }

    public CoreData() {
        this.data = "";
        this.gson = new Gson();
    }

    abstract void load();
    abstract String save();
    abstract void loadDefault();
}
