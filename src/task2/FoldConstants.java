package task2;

import task1.*;
import task1.Number;

public class FoldConstants implements Transformer {
    @Override
    public Expression transformNumber(Number number) {
        return new Number(number.value());
    }

    @Override
    public Expression transformBinaryOperation(BinaryOperation binOp) {
        Expression left = binOp.left().transform(this);
        Expression right = binOp.right().transform(this);
        double l = ((Number) left).value();
        double r = ((Number) right).value();
        double result;
        switch (binOp.operation()){
            case '+': result = l + r; break;
            case '-': result = l - r; break;
            case '*': result = l * r; break;
            case '/': result = l / r; break;
            default:
                throw new UnsupportedOperationException("Неизвестный оператор: " + (char) binOp.operation());
        }
        return new Number(result);
    }

    @Override
    public Expression transformFunctionCall(FunctionCall funcCall) {
        return null;
    }

    @Override
    public Expression transformVariable(Variable variable) {
        return new Variable(variable.name(), variable.value());
    }
}
