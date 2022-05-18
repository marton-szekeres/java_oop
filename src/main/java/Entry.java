public class Entry {
    private String elementOne;
    private String elementTwo;

    public String getElementOne() {
        return elementOne;
    }

    public void setElementOne(String elementOne) {
        this.elementOne = elementOne;
    }

    public String getElementTwo() {
        return elementTwo;
    }

    public void setElementTwo(String elementTwo) {
        this.elementTwo = elementTwo;
    }

    public String[] toList() {
        return new String[]{elementOne, elementTwo};
    }
}
