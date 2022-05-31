import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class FirstNullNested extends Comparison implements CompareStrategy {

    private final ObjectMapper mapper = new ObjectMapper();

    public void compareAction(Param param) {
        if (param.getMapOne().get(param.getKey()) == null
                && !(param.getMapOne().get(param.getKey()) instanceof String)) {
            param.getOutput().addBeanField(param.getKey(),
                    compareProfiles(null,
                            mapper.convertValue(param.getMapTwo().get(param.getKey()), HashMap.class)));

        }
    }
}
