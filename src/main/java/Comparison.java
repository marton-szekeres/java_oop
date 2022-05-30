import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Comparison {
    public Output compareProfiles(HashMap<String, Object> inputMapOne, HashMap<String, Object> inputMapTwo) {
        Param param = new Param();
        param.setMapOne(inputMapOne == null ? new HashMap<>() : inputMapOne);
        param.setMapTwo(inputMapTwo == null ? new HashMap<>() : inputMapTwo);

        Set<String> keySetOne = param.getMapOne().keySet();
        Set<String> keySetTwo = param.getMapTwo().keySet();
        Set<String> keySetunion = new HashSet<String>(keySetOne);
        keySetunion.addAll(keySetTwo);

        for (String key : keySetunion) {
            param.setKey(key);
            new DiffValuesString().compareAction(param);
            new DiffValuesNested().compareAction(param);
            new FirstNullString().compareAction(param);
            new FirstNullNested().compareAction(param);
            new SecondNullString().compareAction(param);
            new SecondNullNested().compareAction(param);
        }
        return param.getOutput();
    }
}
