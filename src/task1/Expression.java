package task1;

public abstract class Expression {
    public abstract double evaluate();
    public abstract Expression transform(Transformer tr);
}

