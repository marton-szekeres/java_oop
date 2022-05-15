import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

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
        out.values().removeIf(Objects::isNull);
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

        Set<String> keySetOne = outputOne.keySet();
        Set<String> keySetTwo = outputTwo.keySet();
        Set<String> keySetunion = new HashSet<String>(keySetOne);
        keySetunion.addAll(keySetTwo);

        Output output = new Output();

        for (String key : keySetunion) {
            if (outputOne.containsKey(key) && outputTwo.containsKey(key) && !outputOne.get(key).equals(outputTwo.get(key))) {
                Entry entry = new Entry();
                entry.setElementOne((String) outputOne.get(key));
                entry.setElementTwo((String) outputTwo.get(key));
                output.getPrimitiveFields().put(key, entry);
            } else if (!outputOne.containsKey(key)) {
                Entry entry = new Entry();
                entry.setElementOne(null);
                entry.setElementTwo((String) outputTwo.get(key));
                output.getPrimitiveFields().put(key, entry);
            } else if (!outputTwo.containsKey(key)) {
                Entry entry = new Entry();
                entry.setElementOne((String) outputOne.get(key));
                entry.setElementTwo(null);
                output.getPrimitiveFields().put(key, entry);
            }
        }


        System.out.println(output);
    }
}
