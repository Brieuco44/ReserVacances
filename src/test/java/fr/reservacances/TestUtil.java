package fr.reservacances;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
    private TestUtil() { }

    public static String json(Object value) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(value);
        }

        catch (Exception ex) {
            return "";
        }
    }
}
