package task1;

public class Number extends Expression {
    private final double value;

    public Number(double value) {
        this.value = value;
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
        return tr.transformNumber(this);
    }
}
