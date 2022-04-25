import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

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

        System.out.println("Jane: " + profileOne.getBillingAddress().getStreet());
        System.out.println("John: " + profileTwo.getBillingAddress().getStreet());
    }
}
