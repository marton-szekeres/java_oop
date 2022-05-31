import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class Param {
    private HashMap<String, Object> mapOne;
    private HashMap<String, Object> mapTwo;
    private Output output;
    private Entry entry;
    private String key;
    private Comparison comparison;

    public void setComparison(Comparison comparison) {
        this.comparison = comparison;
    }

    public Comparison getComparison() {
        return comparison;
    }

    Param() {
        output = new Output();
        entry = new Entry();
    }

    public HashMap<String, Object> getMapOne() {
        return mapOne;
    }

    public void setMapOne(HashMap<String, Object> mapOne) {
        this.mapOne = mapOne;
    }

    public HashMap<String, Object> getMapTwo() {
        return mapTwo;
    }

    public void setMapTwo(HashMap<String, Object> mapTwo) {
        this.mapTwo = mapTwo;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
