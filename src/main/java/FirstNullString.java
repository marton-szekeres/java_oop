public class FirstNullString implements Strategy {
    public void compareAction(Param param) {
        if (param.getMapOne().get(param.getKey()) == null
                && param.getMapTwo().get(param.getKey()) instanceof String) {
            param.getEntry().setElementOne(null);
            param.getEntry().setElementTwo((String) param.getMapTwo().get(param.getKey()));
            param.getOutput().addPrimitiveField(param.getKey(), param.getEntry().toList());
        }
    }
}
