import java.util.HashMap;

public class FirstNullNested extends Strategy {
    public void compareAction(Param param) {
        if (param.getMapOne().get(param.getKey()) != null
                && param.getMapTwo().get(param.getKey()) != null
                && !param.getMapOne().get(param.getKey()).equals(param.getMapTwo().get(param.getKey()))) {
            param.getOutput().addBeanField(param.getKey(),
                    compareProfiles(param.getMapper().convertValue(param.getMapOne().get(param.getKey()), HashMap.class),
                            param.getMapper().convertValue(param.getMapTwo().get(param.getKey()), HashMap.class)));

        }
    }
}
