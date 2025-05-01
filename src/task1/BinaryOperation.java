package task1;

public class BinaryOperation extends Expression {
    public static final int PLUS  = '+';
    public static final int MINUS = '-';
    public static final int DIV   = '/';
    public static final int MUL   = '*';

    private final Expression left;
    private final Expression right;
    private final int op;

    public BinaryOperation(Expression left, int op, Expression right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("Операнды не должны быть пустыми");
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
        switch (op) {
            case PLUS:
                return l + r;
            case MINUS:
                return l - r;
            case DIV:
                return l / r;
            case MUL:
                return l * r;
            default:
                throw new UnsupportedOperationException("Unknown operator: " + (char) op);
        }
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformBinaryOperation(this);
    }
}

