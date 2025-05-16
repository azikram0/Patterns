import task1.*;
import task1.Number;
import task2.FoldConstants;
import task3.*;

public class Test {
    public void checkingTheHierarchyOperation(){
        //Пример 1: 1.234 / -1.234
        Expression e1 = new Number(1.234);
        Expression e2 = new Number(-1.234);
        Expression e3 = new BinaryOperation(e1, BinaryOperation.DIV, e2);
        System.out.println(e3.evaluate());

        //Пример 2: abs(2 * sqrt(32 - 16))
        Expression n32 = new Number(32.0);
        Expression n16 = new Number(16.0);
        Expression minus = new BinaryOperation(n32, BinaryOperation.MINUS, n16);
        Expression callSqrt = new FunctionCall("sqrt", minus);
        Expression n2 = new Number(2.0);
        Expression mult = new BinaryOperation(n2, BinaryOperation.MUL, callSqrt);
        Expression callAbs = new FunctionCall("abs", mult);
        System.out.println(callAbs.evaluate());
    }

    public void attemptToCopyExpressionTree(){
        //Исходные выражения
        Number n32 = new Number(32.0);
        Number n16 = new Number(16.0);
        BinaryOperation minus = new BinaryOperation(n32, BinaryOperation.MINUS, n16);
        FunctionCall callSqrt = new FunctionCall("sqrt", minus);
        Variable var = new Variable("var", 2.0);
        BinaryOperation mult = new BinaryOperation(var, BinaryOperation.MUL, callSqrt);
        FunctionCall callAbs = new FunctionCall("abs", mult);

        //Копирование дерева выражений
        CopySyntaxTree CST = new CopySyntaxTree();
        Expression newExpr = callAbs.transform(CST);

        //Пример вычисления нового выражения
        System.out.println("Результат: " + newExpr.evaluate());
    }

    public void attemptToCollapseExpressionTree(){
        Expression n32 = new Number(32.0);
        Expression n16 = new Number(16.0);
        Expression minus = new BinaryOperation(n32, BinaryOperation.MINUS, n16);
        Expression callSqrt = new FunctionCall("sqrt", minus);
        Expression var = new Variable("var", 2.0);
        Expression mult = new BinaryOperation(var, BinaryOperation.MUL, callSqrt);
        Expression callAbs = new FunctionCall("abs", mult);

        FoldConstants fc = new FoldConstants();
        Expression newExpr = callAbs.transform(fc);

        System.out.println(newExpr.evaluate());
    }

    public void checkingTheWorkOfYourOwnVisior(){
        Recipe recipe = new Recipe();
        recipe.addIngredient(new Champignon(), 500.0);
        recipe.addIngredient(new Shrimp(), 100.0);
        recipe.addIngredient(new SourCream(), 30.0);
        recipe.addIngredient(new Cheese(), 20.0);
        recipe.addIngredient(new Spice(), 30.0);

        NutritionCalculatorVisitor visitor = new NutritionCalculatorVisitor();
        recipe.accept(visitor);

        System.out.printf("Калорийность: %.2f кКал\n", visitor.getTotalCalories());
        System.out.printf("Белки: %.2f г\n", visitor.getTotalProteins());
        System.out.printf("Жиры: %.2f г\n", visitor.getTotalFats());
        System.out.printf("Углеводы: %.2f г\n", visitor.getTotalCarbs());
        System.out.printf("Стоимость: %.2f руб\n", visitor.getTotalPrice());
    }
}
