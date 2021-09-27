package net.shawshark.core.api;

import net.shawshark.core.api.user.CoreData;

public interface LoadHandler<T extends CoreData> {

    void load(T metadata);
}
