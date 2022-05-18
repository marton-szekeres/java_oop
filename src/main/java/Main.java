import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class Main {

    public static HashMap<String, Object> getFieldValues(Object o) {
        HashMap<String, Object> output = new HashMap<>();
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            output.put(name, value);
        }
        return output;
    }

    public static Output compareProfiles(HashMap<String, Object> mapOne, HashMap<String, Object> mapTwo, Output out) {

        Output output = out;
        Entry entry = new Entry();

        Set<String> keySetOne = mapOne.keySet();
        Set<String> keySetTwo = mapTwo.keySet();
        Set<String> keySetunion = new HashSet<String>(keySetOne);
        keySetunion.addAll(keySetTwo);

        for (String key : keySetunion) {
            if (mapOne.containsKey(key) && mapTwo.containsKey(key) && !mapOne.get(key).equals(mapTwo.get(key))) {
                if (mapOne.get(key) instanceof String) {
                    entry.setElementOne((String) mapOne.get(key));
                    entry.setElementTwo((String) mapTwo.get(key));
                    System.out.println(entry.getElementTwo() + " + " + key);
                    output.addPrimitiveField(key,entry.toList());
                } else {
                    output.addBeanField(key, compareProfiles((HashMap<String, Object>) mapOne.get(key),(HashMap<String, Object>) mapTwo.get(key), out));
                }
            } else if (!mapOne.containsKey(key)) {
                entry.setElementOne(null);
                entry.setElementTwo((String) mapTwo.get(key));
                if (mapOne.get(key) instanceof String) {
                    output.addPrimitiveField(key,entry.toList());
                } else {
                    output.addBeanField(key, compareProfiles(null,(HashMap<String, Object>) mapTwo.get(key), out));
                }
            } else if (!mapTwo.containsKey(key)) {
                entry.setElementOne((String) mapOne.get(key));
                entry.setElementTwo(null);
                if (mapOne.get(key) instanceof String) {
                    output.addPrimitiveField(key,entry.toList());
                } else {
                    output.addBeanField(key, compareProfiles((HashMap<String, Object>) mapOne.get(key),null, out));
                }
            }
        }        return output;
    }

    public static void main(String[] args) {
        Profile profileOne = new Profile();
        Profile profileTwo = new Profile();
        File fileOne = new File("src/main/resources/profile_jane.json");
        File fileTwo = new File("src/main/resources/profile_john.json");
        Output OutputOne = new Output();
        ObjectMapper mapper = new ObjectMapper();

        try {
            profileOne = mapper.readValue(fileOne, Profile.class);
            profileTwo = mapper.readValue(fileTwo, Profile.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, Object> m1 = getFieldValues(profileOne);
        HashMap<String, Object> m2 = getFieldValues(profileTwo);

        System.out.println(compareProfiles(m1, m2, new Output()));

    }
}
