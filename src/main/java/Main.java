import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Profile profileOne = new Profile();
        Profile profileTwo = new Profile();
        File fileOne = new File("src/main/resources/profile_jane.json");
        File fileTwo = new File("src/main/resources/profile_john.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            profileOne.setUserinfo(objectMapper.readValue(fileOne, Map.class));
            profileTwo.setUserinfo(objectMapper.readValue(fileTwo, Map.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
