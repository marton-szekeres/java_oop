import java.util.HashMap;
import java.util.Map;

public class Output {
    private Map<String, String[]> primitiveFields;
    private Map<String, Output> beanFields;

    Output() {
        primitiveFields = new HashMap<>();
        beanFields = new HashMap<>();
    }

    public Map<String, String[]> getPrimitiveFields() {
        return primitiveFields;
    }

    public void setPrimitiveFields(Map<String, String[]> primitiveFields) {
        this.primitiveFields = primitiveFields;
    }

    public Map<String, Output> getBeanFields() {
        return beanFields;
    }

    public void setBeanFields(Map<String, Output> beanFields) {
        this.beanFields = beanFields;
    }

    public void addPrimitiveField(String key, String[] value) {
        primitiveFields.put(key, value);
    }

    public void addBeanField(String key, Output value) {
        beanFields.put(key, value);
    }

    @Override
    public String toString() {
        return "Output{" +
                ", primitiveFields=" + primitiveFields +
                ", beanFields=" + beanFields +
                '}';
    }
}
