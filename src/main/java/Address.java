import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Address implements Serializable {
    private String city;
    private String postCode;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public HashMap<String, Object> toMap {

    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
