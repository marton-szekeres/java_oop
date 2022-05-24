import java.util.HashMap;
import java.util.Map;

public class Output {
    private Map<String, String[]> fields;
    private Map<String, Output> nestedObjects;

    Output() {
        fields = new HashMap<>();
        nestedObjects = new HashMap<>();
    }

    public Map<String, String[]> getFields() {
        return fields;
    }

    public void setFields(Map<String, String[]> fields) {
        this.fields = fields;
    }

    public Map<String, Output> getNestedObjects() {
        return nestedObjects;
    }

    public void setNestedObjects(Map<String, Output> nestedObjects) {
        this.nestedObjects = nestedObjects;
    }

    public void addPrimitiveField(String key, String[] value) {
        fields.put(key, value);
    }

    public void addBeanField(String key, Output value) {
        nestedObjects.put(key, value);
    }
}




