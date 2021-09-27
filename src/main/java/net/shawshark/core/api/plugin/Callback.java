package net.shawshark.core.api.plugin;

public interface Callback<R> {
    public void execute(R response);
}