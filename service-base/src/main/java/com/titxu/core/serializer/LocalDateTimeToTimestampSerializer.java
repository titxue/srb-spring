package com.titxu.core.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lxue
 */
@Component
public class LocalDateTimeToTimestampSerializer implements ObjectSerializer {
 
    public static final LocalDateTimeToTimestampSerializer INSTANCE = new LocalDateTimeToTimestampSerializer();
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
 
    public LocalDateTimeToTimestampSerializer() {
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) {
        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeNull();
        } else {
            LocalDateTime result = (LocalDateTime) object;
            out.writeString(result.format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN)));
        }
    }
 
}