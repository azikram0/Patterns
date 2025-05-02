package task2;

import task1.*;
import task1.Number;

public class FoldConstants implements Transformer {
    @Override
    public Expression transformNumber(Number number) {
        return null;
    }

    @Override
    public Expression transformBinaryOperation(BinaryOperation binOp) {
        return null;
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
