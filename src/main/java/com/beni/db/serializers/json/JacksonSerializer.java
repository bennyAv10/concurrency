package com.beni.db.serializers.json;


import com.beni.db.imp.memory.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import java.io.IOException;

/**
 * Created by Beni on 19/02/2016.
 */
public class JacksonSerializer<T> implements Serializer<T> {
    static ObjectMapper mapper = new ObjectMapper();
    {
        mapper.registerModule(new JSR310Module());
    }
    @Override
    public String serialize(T obj) throws IOException {
        return mapper.writeValueAsString(obj);

    }

    @Override
    public T deserialize(String input, Class<T> valueType) throws IOException {
        return mapper.readValue(input, valueType);
    }
}
