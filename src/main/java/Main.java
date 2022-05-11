import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Map<String, Object> fieldGetter(Object o, HashMap<String, Object> out, String prefix) {
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            String newPrefix = (prefix == null ? "" : prefix + ".") + name;
            if (!(value instanceof String) && value != null) {
                fieldGetter(value, out, newPrefix);
            } else {
                out.put(newPrefix, value);
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

        HashMap<String, Object> outputOne = new HashMap<>();
        fieldGetter(profileOne, outputOne, null);

        HashMap<String, Object> outputTwo = new HashMap<>();
        fieldGetter(profileTwo, outputTwo, null);



        Set<String> one = outputOne.keySet();
        Set<String> two = outputTwo.keySet();
        Set<String> union = new HashSet<String>(one);
        union.addAll(two);

        HashMap<String, Object> differentEntries = new HashMap<>();

        for (String key : union) {
            if (outputOne.containsKey(key) && outputTwo.containsKey(key) && !outputOne.get(key).equals(outputTwo.get(key))) {
                Object[] temp = new Object[]{outputOne.get(key), outputTwo.get(key)};
                differentEntries.put(key, temp);
            } else if (!outputOne.containsKey(key)) {
                Object[] temp = new Object[]{null, outputTwo.get(key)};
                differentEntries.put(key, temp);
            } else if (!outputTwo.containsKey(key)) {
                Object[] temp = new Object[]{outputOne.get(key), null};
                differentEntries.put(key, temp);
            }
        }

        System.out.println(union);
    }
}
