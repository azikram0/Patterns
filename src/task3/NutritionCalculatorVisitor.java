package task3;

public class NutritionCalculatorVisitor implements IngredientVisitor {
    private double totalCalories = 0;
    private double totalProteins = 0;
    private double totalFats = 0;
    private double totalCarbs = 0;
    private double totalPrice = 0;

    @Override
    public void visit(Ingredient ingredient, double weight) {
        totalCalories += ingredient.getCalories(weight);
        totalProteins += ingredient.getProteins(weight);
        totalFats += ingredient.getFats(weight);
        totalCarbs += ingredient.getCarbs(weight);
        totalPrice += ingredient.getPrice(weight);
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public double getTotalProteins() {
        return totalProteins;
    }

    public double getTotalFats() {
        return totalFats;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
