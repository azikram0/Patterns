package task1;

import exception.NullArgument;
import exception.UnsupportedOperation;

public class BinaryOperation extends Expression {
    public static final int PLUS = '+';
    public static final int MINUS = '-';
    public static final int DIV = '/';
    public static final int MUL = '*';

    private final Expression left;
    private final Expression right;
    private final int op;

    public BinaryOperation(Expression left, int op, Expression right) {
        try {
            if (left == null || right == null) {
                throw new NullArgument("Операнды не должны быть пустыми");
            }
        } catch (NullArgument e) {
            System.out.println(e.getMessage());
            ;
        }
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Expression left() {
        return left;
    }

    public Expression right() {
        return right;
    }

    public int operation() {
        return op;
    }

    @Override
    public double evaluate() {
        double l = left.evaluate();
        double r = right.evaluate();
        double result = 0;
        try {
            result = switch (op) {
                case PLUS -> l + r;
                case MINUS -> l - r;
                case DIV -> l / r;
                case MUL -> l * r;
                default -> throw new UnsupportedOperation("Неизвестный оператор: " + (char) op);
            };
        } catch (UnsupportedOperation e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformBinaryOperation(this);
    }
}

