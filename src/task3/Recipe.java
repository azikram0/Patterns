package task3;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private final Map<Ingredient, Double> ingredients;

    public Recipe() {
        ingredients = new HashMap<>();
    }

    public void addIngredient(Ingredient ingredient, Double weight) {
        ingredients.put(ingredient, weight);
    }

    public void accept(IngredientVisitor visitor) {
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            entry.getKey().accept(visitor, entry.getValue());
        }
    }
}
