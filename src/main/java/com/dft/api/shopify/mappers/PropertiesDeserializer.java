package com.dft.api.shopify.mappers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;

public class PropertiesDeserializer extends JsonDeserializer<HashMap<String, String>> {

    @Override
    public HashMap<String, String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return new ObjectMapper().readValue(jsonParser, HashMap.class);
    }
}