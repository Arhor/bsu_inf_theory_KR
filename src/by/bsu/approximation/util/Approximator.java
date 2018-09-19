package by.bsu.approximation.util;

public abstract class Approximator {

    protected String source;
    protected String dict;

    public Approximator(String source) {
        this.source = source.toLowerCase();
        this.dict = SimpleDictBuilder.buildDictionary(this.source);
    }

    public abstract String approximate();


}
