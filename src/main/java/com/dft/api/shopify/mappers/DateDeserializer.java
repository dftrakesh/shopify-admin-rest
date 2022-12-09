package com.dft.api.shopify.mappers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DateDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        try {
            ZonedDateTime zdtWithZoneOffset = ZonedDateTime.parse(jsonParser.getText().trim(), DateTimeFormatter.ISO_ZONED_DATE_TIME);
            return zdtWithZoneOffset.toLocalDateTime();
        } catch (Exception exception) {
            log.error("Exception occurred while parsing date: {}", exception.getMessage(), exception);
        }
        return null;
    }
}
