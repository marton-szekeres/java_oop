import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class SecondNullNested extends Comparison implements CompareStrategy {

    private final ObjectMapper mapper = new ObjectMapper();

    public void compareAction(Param param) {
        if (param.getMapTwo().get(param.getKey()) == null
                && !(param.getMapOne().get(param.getKey()) instanceof String)) {
            param.getOutput().addBeanField(param.getKey(),
                    compareProfiles(mapper.convertValue(param.getMapOne().get(param.getKey()), HashMap.class),
                            null));

        }
    }
}
