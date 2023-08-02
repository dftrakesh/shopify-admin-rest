package com.dft.api.shopify.mappers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        try {
            String formattedDateTime = localDateTime.format(formatter);
            jsonGenerator.writeString(formattedDateTime);
        } catch (Exception exception) {
            log.error("Exception occurred while serializing datetime. Error Message: {}", exception.getMessage(), exception);
        }
    }
}
