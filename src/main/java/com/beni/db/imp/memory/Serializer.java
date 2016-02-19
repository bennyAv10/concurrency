package com.beni.db.imp.memory;

import java.io.IOException;

/**
 * Created by Beni on 19/02/2016.
 */
public interface Serializer<T> {
    String serialize(T obj) throws IOException;
    T deserialize(String str, Class<T> valueType) throws IOException;
}
