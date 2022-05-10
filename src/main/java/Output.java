import java.util.Map;

public class Output {
    private Map<String, String[]> primitiveFields;
    private Map<String, Output> beanFields;

    public Map<String, String[]> getPrimitiveFields() {
        return primitiveFields;
    }

    public void setPrimitiveFields(Map<String, String[]> primitiveFields) {
        this.primitiveFields = primitiveFields;
    }

    public Map<String, Output[]> getBeanFields() {
        return beanFields;
    }

    public void setBeanFields(Map<String, Output[]> beanFields) {
        this.beanFields = beanFields;
    }

    @Override
    public String toString() {
        return "Output{" +
                ", primitiveFields=" + primitiveFields +
                ", beanFields=" + beanFields +
                '}';
    }
}
