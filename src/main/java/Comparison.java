import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Comparison {

    private static final CompareStrategy[] strats = new CompareStrategy[]{new DiffValuesString()
            , new DiffValuesNested()
            , new FirstNullString()
            , new FirstNullNested()
            , new SecondNullString()
            , new SecondNullNested()};

    public Output compareProfiles(HashMap<String, Object> inputMapOne, HashMap<String, Object> inputMapTwo) {
        Param param = new Param();
        param.setComparison(this);
        param.setMapOne(inputMapOne == null ? new HashMap<>() : inputMapOne);
        param.setMapTwo(inputMapTwo == null ? new HashMap<>() : inputMapTwo);

        Set<String> keySetOne = param.getMapOne().keySet();
        Set<String> keySetTwo = param.getMapTwo().keySet();
        Set<String> keySetunion = new HashSet<String>(keySetOne);
        keySetunion.addAll(keySetTwo);

        for (String key : keySetunion) {
            param.setKey(key);
            for (CompareStrategy strat : strats) {
                strat.compareAction(param);
            }
        }
        return param.getOutput();
    }
}
