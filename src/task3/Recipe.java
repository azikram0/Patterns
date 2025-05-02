package task3;

import java.util.Map;

public class Recipe {
    private Map<Ingredient, Double> ingredients;

    public Recipe(Map<Ingredient, Double> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient, Double weight){
        ingredients.put(ingredient, weight);
    }

    public Map<Ingredient, Double> getIngredients() {
        return ingredients;
    }
}
