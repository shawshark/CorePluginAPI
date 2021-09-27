package net.shawshark.core.api;

import net.shawshark.core.api.user.CoreData;

public interface SaveHandler<T extends CoreData> {
    void save(T metadata, Status status);

    enum Status {
        FAILED,
        SUCCESS
    }
}