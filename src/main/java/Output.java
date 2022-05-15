import java.util.HashMap;
import java.util.Map;

public class Output {
    private Map<String, String[]> fields;

    Output() {
        fields = new HashMap<>();
    }

    public Map<String, String[]> getFields() {
        return fields;
    }

    public void setFields(Map<String, String[]> fields) {
        fields = fields;
    }

    public void addField(String key, String[] value) {
        fields.put(key, value);
    }
}
