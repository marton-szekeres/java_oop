public class DiffValuesString implements Strategy {
    public void compareAction(Param param) {
        if (param.getMapOne().get(param.getKey()) != null
                && param.getMapTwo().get(param.getKey()) != null
                && !param.getMapOne().get(param.getKey()).equals(param.getMapTwo().get(param.getKey()))
                && param.getMapOne().get(param.getKey()) instanceof String) {
            param.getEntry().setElementOne((String) param.getMapOne().get(param.getKey()));
            param.getEntry().setElementTwo((String) param.getMapTwo().get(param.getKey()));
            param.getOutput().addPrimitiveField(param.getKey(), param.getEntry().toList());
        }
    }
}
