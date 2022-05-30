public class SecondNullString implements Strategy {
    public void compareAction(Param param) {
        if (param.getMapTwo().get(param.getKey()) == null
                && param.getMapOne().get(param.getKey()) instanceof String) {
            param.getEntry().setElementOne((String) param.getMapOne().get(param.getKey()));
            param.getEntry().setElementTwo(null);
            param.getOutput().addPrimitiveField(param.getKey(), param.getEntry().toList());
        }
    }
}
