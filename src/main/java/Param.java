import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class Param {
    private HashMap<String, Object> mapOne;
    private HashMap<String, Object> mapTwo;
    private Output output;
    private Entry entry;
    private ObjectMapper mapper;
    private String key;

    Param() {
        output = new Output();
        entry = new Entry();
        mapper = new ObjectMapper();
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

    public ObjectMapper getMapper() {
        return mapper;
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
