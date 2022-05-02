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

        HashMap<String, Object> commonEntries = new HashMap<>();
        ArrayList<String> differentEntries = new ArrayList<>();
        ArrayList<String> notFoundEntriesOne = new ArrayList<>();
        ArrayList<String> notFoundEntriesTwo = new ArrayList<>();

        for (String key : outputOne.keySet()) {
            if (outputTwo.containsKey(key) && outputTwo.get(key).equals(outputOne.get(key))) {
                commonEntries.put(key, outputOne.get(key));
            } else if (outputTwo.containsKey(key) && !outputTwo.get(key).equals(outputOne.get(key))) {
                differentEntries.add(key);
            } else {
                notFoundEntriesOne.add(key);
            }
        }

        for (String key : outputTwo.keySet()) {
            if (!outputOne.containsKey(key)) {
                notFoundEntriesTwo.add(key);
            }
        }

        Map<String, Object> commonEntriesTwo = outputOne.entrySet().stream()
                .filter(x -> outputTwo.containsKey(x.getKey()))
                .filter(x -> outputTwo.get(x.getKey()).equals(x.getValue()))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        HashMap<String, Object> diffEntries = new HashMap<>();

        for (String key : outputOne.keySet()) {
            if (outputTwo.containsKey(key) && !outputTwo.get(key).equals(outputOne.get(key))) {
                diffEntries.put(key, new ArrayList<>(Arrays.asList(outputOne.get(key), outputTwo.get(key))));
            }
        }

        System.out.println(diffEntries);


        System.out.println("Common entries: " + commonEntries);
        System.out.println("Common entries via stream: " + commonEntriesTwo);
        System.out.println("Different entries: " + differentEntries);
        System.out.println("Entries not found in first profile: " + notFoundEntriesTwo);
        System.out.println("Entries not found in second profile: " + notFoundEntriesOne);
    }
}
