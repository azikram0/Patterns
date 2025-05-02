package task3;

public abstract class Ingredient {
    private final String name;
    private final double caloriesPer100g;
    private final double proteinsPer100g;
    private final double fatsPer100g;
    private final double carbsPer100g;
    private final double pricePer100g;

    public Ingredient(String name, double caloriesPer100g, double proteinsPer100g,
                      double fatsPer100g, double carbsPer100g, double pricePer100g) {
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

    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public double getProteinsPer100g() {
        return proteinsPer100g;
    }

    public double getFatsPer100g() {
        return fatsPer100g;
    }

    public double getCarbsPer100g() {
        return carbsPer100g;
    }

    public double getPricePer100g() {
        return pricePer100g;
    }
}
