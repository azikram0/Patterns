package task1;

public class Variable extends Expression {
    private final String name;
    private final double value;

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String name() {
        return name;
    }

    public double value() {
        return value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformVariable(this);
    }
}
