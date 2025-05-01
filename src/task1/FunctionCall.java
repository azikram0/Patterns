package task1;

public class FunctionCall extends Expression {
    private final String name;
    private final Expression arg;

    public FunctionCall(String name, Expression arg) {
        if (arg == null) {
            throw new IllegalArgumentException("Аргумент не может быть нулевым");
        }
        if (!"sqrt".equals(name) && !"abs".equals(name)) {
            throw new IllegalArgumentException("Поддерживаются только 'sqrt' и 'abs'");
        }
        this.name = name;
        this.arg = arg;
    }

    public String name() {
        return name;
    }

    public Expression arg() {
        return arg;
    }

    @Override
    public double evaluate() {
        double value = arg.evaluate();
        return switch (name) {
            case "sqrt" -> Math.sqrt(value);
            case "abs" -> Math.abs(value);
            default -> throw new UnsupportedOperationException("Неподдерживаемая функция: " + name);
        };
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformFunctionCall(this);
    }
}
