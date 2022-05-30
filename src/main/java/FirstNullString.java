public class FirstNullString extends Strategy {
    public void compareAction(Param param) {
        if (param.getMapOne().get(param.getKey()) == null) {
            param.getEntry().setElementOne((String) param.getMapOne().get(param.getKey()));
            param.getEntry().setElementTwo((String) param.getMapTwo().get(param.getKey()));
            param.getOutput().addPrimitiveField(param.getKey(), param.getEntry().toList());
        }
    }
}
