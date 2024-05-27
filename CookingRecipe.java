/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 7
 */

public class CookingRecipe {
    private String name;
    private RecipeIngredients[] ingredients;
    private int size;

    public CookingRecipe(String name) {
        this.name = name;
        this.ingredients = new RecipeIngredients[100];
        this.size = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addOrUpdateRecipeIngredient(Ingredients ingredient, float quantity) {
        for (int i=0; i<size; i++) {
            if (ingredients[i].getName().equals(ingredient.getName())) {
                ingredients[i].setQuantity(quantity);
                return;
            }
        }
        if (size==ingredients.length) {
            resize();
        }
        ingredients[size++] = new RecipeIngredients(ingredient.getName(), ingredient.getMeasuringUnit(), ingredient.getCaloriesPerUnit(), quantity);
    }

    private void resize() {
        int length = ingredients.length;
        RecipeIngredients[] newIngredients = new RecipeIngredients[length*2];
        for (int i=0; i<size; i++) {
            newIngredients[i] = ingredients[i];
        }
        ingredients = newIngredients;
    }


    public RecipeIngredients getRecipeIngredient(String ingredientName) {
        for (int i=0; i<size; i++) {
            if (ingredients[i]!=null && ingredients[i].getName().equals(ingredientName)) {
                return ingredients[i];
            }
        }
        return null;
    }

    public RecipeIngredients removeRecipeIngredient(String ingredientName) {
        for (int i=0; i<size; i++) {
            if (ingredients[i].getName().equals(ingredientName)) {
                RecipeIngredients temp = ingredients[i];
                ingredients[i] = ingredients[size-1];
                ingredients[size--] = null;
                return temp;
            }
        }
        return null;
    }

    public float calculateCalories() {
        float totalCalories = 0;
        for (int i = 0; i < size; i++) {
            totalCalories += ingredients[i].getCaloriesPerUnit() * ingredients[i].getQuantity();
        }
        return totalCalories;
    }

    public int getNumberOfIngredients() {
        return size;
    }

    @Override
    public String toString() {
        String result = "Recipe: "+name+"\n";
        for (int i=0; i<size; i++) {
            if (ingredients[i]!=null) {
                result+=ingredients[i].toString()+"\n";
            }
        }
        return result;
    }
}
