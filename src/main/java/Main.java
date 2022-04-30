import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class Main {

    public static Map<String, Object> fieldGetter(Object o, HashMap<String, Object> out, int count) {
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            String s = String.valueOf(count);
            try {
                value = field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (!(value instanceof String) && value != null) {
                count += 1;
                fieldGetter(value, out, count);
            } else {
                out.put("level." + s + "." + name, value);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Profile profileOne = new Profile();
        Profile profileTwo = new Profile();
        File fileOne = new File("src/main/resources/profile_jane.json");
        File fileTwo = new File("src/main/resources/profile_john.json");
        ObjectMapper mapper = new ObjectMapper();

        try {
            profileOne = mapper.readValue(fileOne, Profile.class);
            profileTwo = mapper.readValue(fileTwo, Profile.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int c = 0;
        HashMap<String, Object> outputOne = new HashMap<>();
        fieldGetter(profileOne, outputOne, c);

        c = 0;
        HashMap<String, Object> outputTwo = new HashMap<>();
        fieldGetter(profileTwo, outputTwo, c);

        HashMap<String, Object> commonEntries = new HashMap<>();
        for (String key : outputOne.keySet()) {
            if (outputTwo.containsKey(key) && outputTwo.get(key).equals(outputOne.get(key))) {
                commonEntries.put(key, outputOne.get(key));
                System.out.println("Matching entries: " + key + ": " + outputOne.get(key));
            }
        }
        System.out.println(commonEntries);
    }
}
