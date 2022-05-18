public class Entry {
    private String elementOne;
    private String elementTwo;
    private Output beanElementOne;
    private Output beanElementTwo;

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

    public Output getBeanElementOne() {
        return beanElementOne;
    }

    public void setBeanElementOne(Output beanElementOne) {
        this.beanElementOne = beanElementOne;
    }

    public Output getBeanElementTwo() {
        return beanElementTwo;
    }

    public void setBeanElementTwo(Output beanElementTwo) {
        this.beanElementTwo = beanElementTwo;
    }

    public String[] toList() {
        return new String[]{elementOne, elementTwo};
    }

    public Output[] toBeanList() {
        return new Output[]{beanElementOne, beanElementTwo};
    }
}
