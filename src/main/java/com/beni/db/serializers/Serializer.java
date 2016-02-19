package com.beni.db.serializers;

/**
 * Created by Beni on 19/02/2016.
 */
public interface Serializer<T> {
    String serialize(T obj);
    T deserialize(String str);
}