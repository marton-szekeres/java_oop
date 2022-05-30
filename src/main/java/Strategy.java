import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Strategy {
    public abstract void compareAction(Param param);

    public static Output compareProfiles(HashMap<String, Object> inputMapOne, HashMap<String, Object> inputMapTwo) {
        Param param = new Param();
        param.setMapOne(inputMapOne == null ? new HashMap<>() : inputMapOne);
        param.setMapTwo(inputMapTwo == null ? new HashMap<>() : inputMapTwo);

        Set<String> keySetOne = param.getMapOne().keySet();
        Set<String> keySetTwo = param.getMapTwo().keySet();
        Set<String> keySetunion = new HashSet<String>(keySetOne);
        keySetunion.addAll(keySetTwo);

        DiffValuesString a = new DiffValuesString();
        DiffValuesNested b = new DiffValuesNested();
        FirstNullString c = new FirstNullString();
        FirstNullNested d = new FirstNullNested();

        for (String key : keySetunion) {
            param.setKey(key);
            a.compareAction(param);
            b.compareAction(param);
            c.compareAction(param);
            d.compareAction(param);

        }
        return param.getOutput();
    }

}
