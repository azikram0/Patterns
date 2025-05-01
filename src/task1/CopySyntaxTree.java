package task1;

public class CopySyntaxTree implements Transformer {
    @Override
    public Expression transformNumber(Number number) {
        return new Number(number.value());
    }

    @Override
    public Expression transformBinaryOperation(BinaryOperation binOp) {
        Expression newLeft = binOp.left().transform(this);
        Expression newRight = binOp.right().transform(this);
        return new BinaryOperation(newLeft, binOp.operation(), newRight);
    }

    @Override
    public Expression transformFunctionCall(FunctionCall funcCall) {
        return null;
    }

    @Override
    public Expression transformVariable(Variable variable) {
        return null;
    }
}
