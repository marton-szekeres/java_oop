import java.util.HashMap;

public class FirstNullNested extends Comparison implements Strategy {
    public void compareAction(Param param) {
        if (param.getMapOne().get(param.getKey()) == null
                && param.getMapOne().get(param.getKey()) instanceof String == false) {
            param.getOutput().addBeanField(param.getKey(),
                    compareProfiles(null,
                            param.getMapper().convertValue(param.getMapTwo().get(param.getKey()), HashMap.class)));

        }
    }
}
