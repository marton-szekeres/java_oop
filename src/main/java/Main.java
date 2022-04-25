import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File fileOne = new File("src/main/resources/profile_jane.json");
        File fileTwo = new File("src/main/resources/profile_john.json");
        ObjectMapper mapper = new ObjectMapper();
        Profile profileOne = new Profile();
        Profile profileTwo = new Profile();

        try {
            profileOne = mapper.readValue(fileOne, Profile.class);
            profileTwo = mapper.readValue(fileTwo, Profile.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, String> mapOne = new ObjectMapper().convertValue(profileOne, Map.class);
        Map<String, String> mapTwo = new ObjectMapper().convertValue(profileTwo, Map.class);

        mapTwo.forEach(
                (key, value) -> mapOne.merge( key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2)
        );

        System.out.println(mapOne);

    }


}
