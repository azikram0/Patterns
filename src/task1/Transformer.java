package task1;

public interface Transformer {
    Expression transformNumber(Number number);
    Expression transformBinaryOperation(BinaryOperation binOp);
    Expression transformFunctionCall(FunctionCall funcCall);
    Expression transformVariable(Variable variable);
}

