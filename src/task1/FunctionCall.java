package task1;

import exception.FunctionNotSqrtOrAbs;
import exception.NullArgument;

public class FunctionCall extends Expression {
    private final String name;
    private final Expression arg;

    public FunctionCall(String name, Expression arg) {
        try {
            if (arg == null) {
                throw new NullArgument("Аргумент не может быть нулевым");
            }
            if (!"sqrt".equals(name) && !"abs".equals(name)) {
                throw new FunctionNotSqrtOrAbs("Поддерживаются только 'sqrt' и 'abs'");
            }
        } catch (NullArgument e) {
            System.out.println(e.getMessage());
        } catch (FunctionNotSqrtOrAbs e) {
            System.out.println(e.getMessage());
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
        double result = 0;
        try {
            result = switch (name) {
                case "sqrt" -> Math.sqrt(value);
                case "abs" -> Math.abs(value);
                default -> throw new FunctionNotSqrtOrAbs("Неподдерживаемая функция: " + name);
            };
        } catch (FunctionNotSqrtOrAbs e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformFunctionCall(this);
    }
}
