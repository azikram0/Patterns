package task3;

public abstract class Ingredient {
    private final String name;
    private final double caloriesPer100g;
    private final double proteinsPer100g;
    private final double fatsPer100g;
    private final double carbsPer100g;
    private final double pricePer100g;

    public Ingredient(
            String name,
            double caloriesPer100g,
            double proteinsPer100g,
            double fatsPer100g,
            double carbsPer100g,
            double pricePer100g
    ) {
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
        this.proteinsPer100g = proteinsPer100g;
        this.fatsPer100g = fatsPer100g;
        this.carbsPer100g = carbsPer100g;
        this.pricePer100g = pricePer100g;
    }

    public String getName() {
        return name;
    }

    public double getCalories(double weight) {
        return (caloriesPer100g / 100.0) * weight;
    }

    public double getProteins(double weight) {
        return (proteinsPer100g / 100.0) * weight;
    }

    public double getFats(double weight) {
        return (fatsPer100g / 100.0) * weight;
    }

    public double getCarbs(double weight) {
        return (carbsPer100g / 100.0) * weight;
    }

    public double getPrice(double weight) {
        return (pricePer100g / 100.0) * weight;
    }

    public void accept(IngredientVisitor visitor, Double value) {
        visitor.visit(this, value);
    }
}
