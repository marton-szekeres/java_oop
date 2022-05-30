import java.util.HashMap;

public class SecondNullNested extends Comparison implements Strategy {
    public void compareAction(Param param) {
        if (param.getMapTwo().get(param.getKey()) == null
                && param.getMapOne().get(param.getKey()) instanceof String  == false) {
            param.getOutput().addBeanField(param.getKey(),
                    compareProfiles(param.getMapper().convertValue(param.getMapOne().get(param.getKey()), HashMap.class),
                            null));

        }
    }
}
