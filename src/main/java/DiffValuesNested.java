import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class DiffValuesNested implements CompareStrategy {

    private final ObjectMapper mapper = new ObjectMapper();

    public void compareAction(Param param) {
        if (param.getMapOne().get(param.getKey()) != null
                && param.getMapTwo().get(param.getKey()) != null
                && !param.getMapOne().get(param.getKey()).equals(param.getMapTwo().get(param.getKey()))
                && !(param.getMapOne().get(param.getKey()) instanceof String)) {
            param.getOutput().addBeanField(param.getKey(),
                    param.getComparison().compareProfiles(mapper.convertValue(param.getMapOne().get(param.getKey()), HashMap.class),
                            mapper.convertValue(param.getMapTwo().get(param.getKey()), HashMap.class)));

        }
    }
}
