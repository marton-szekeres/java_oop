import java.util.HashMap;

public class DiffValuesNested extends Comparison implements Strategy {
    public void compareAction(Param param) {
        if (param.getMapOne().get(param.getKey()) != null
                && param.getMapTwo().get(param.getKey()) != null
                && !param.getMapOne().get(param.getKey()).equals(param.getMapTwo().get(param.getKey()))
                && !(param.getMapOne().get(param.getKey()) instanceof String)) {
            param.getOutput().addBeanField(param.getKey(),
                    compareProfiles(param.getMapper().convertValue(param.getMapOne().get(param.getKey()), HashMap.class),
                            param.getMapper().convertValue(param.getMapTwo().get(param.getKey()), HashMap.class)));

        }
    }
}
