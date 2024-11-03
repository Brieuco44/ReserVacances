package fr.reservacances;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TestUtil {
    private TestUtil() { }

    public static String json(Object value) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            return mapper.writeValueAsString(value);
        }

        catch (Exception ex) {
            return "";
        }
    }
}