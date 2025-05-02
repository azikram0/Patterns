package task2;

import task1.*;
import task1.Number;

import java.util.ArrayList;
import java.util.List;

public class FoldConstants implements Transformer {
    @Override
    public Expression transformNumber(Number number) {
        return new Number(number.value());
    }

    @Override
    public Expression transformBinaryOperation(BinaryOperation binOp) {
        Expression left = binOp.left().transform(this);
        Expression right = binOp.right().transform(this);
        if (left instanceof Number && right instanceof Number) {
            double l = ((Number) left).value();
            double r = ((Number) right).value();
            double result;
            switch (binOp.operation()) {
                case '+':
                    result = l + r;
                    break;
                case '-':
                    result = l - r;
                    break;
                case '*':
                    result = l * r;
                    break;
                case '/':
                    result = l / r;
                    break;
                default:
                    throw new UnsupportedOperationException("Неизвестный оператор: " + (char) binOp.operation());
            }
            return new Number(result);
        }
        return new BinaryOperation(left, binOp.operation(), right);
    }

    @Override
    public Expression transformFunctionCall(FunctionCall funcCall) {
        Expression arg = funcCall.arg().transform(this);
        if (arg instanceof Number){
            double value = ((Number) arg).value();
            switch (funcCall.name()){
                case "sqrt": return new Number(Math.sqrt(value));
                case "abs": return new Number(Math.abs(value));
                default:
                    throw new UnsupportedOperationException("Неподдерживаемая функция: " + funcCall.name());
            }
        }
        return new FunctionCall(funcCall.name(), arg);
    }

    @Override
    public Expression transformVariable(Variable variable) {
        return new Variable(variable.name(), variable.value());
    }
}
