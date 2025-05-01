package task1;

class Variable extends Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public double evaluate() {
        return 0.0;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformVariable(this);
    }
}
