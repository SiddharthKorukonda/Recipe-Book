/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 7
 */

public class RecipeBook {
    private String bookName;
    private CookingRecipe[] recipes;
    private int recipeCount;

    public RecipeBook(String bookName) {
        this.bookName = bookName;
        this.recipes = new CookingRecipe[100];
        this.recipeCount = 0;
    }

    public CookingRecipe addRecipe(String name, RecipeIngredients[] ingredients) {
        for (int i = 0; i < recipeCount; i++) {
            if (recipes[i].getName().equals(name)) {
                return null;
            }
        }
        if (recipeCount == recipes.length) {
            resize();
        }
        CookingRecipe newRecipe = new CookingRecipe(name);

        for (int i = 0; i < ingredients.length; i++) {
            RecipeIngredients ingredient = ingredients[i];
            newRecipe.addOrUpdateRecipeIngredient(ingredient, ingredient.getQuantity());
        }
        recipes[recipeCount++] = newRecipe;
        return newRecipe;
    }

    private void resize() {
        CookingRecipe[] newRecipes = new CookingRecipe[recipes.length * 2];
        for (int i = 0; i < recipeCount; i++) {
            newRecipes[i] = recipes[i];
        }
        recipes = newRecipes;
    }

    public CookingRecipe removeRecipe(String name) {
        for (int i = 0; i < recipeCount; i++) {
            if (recipes[i].getName().equals(name)) {
                CookingRecipe removedRecipe = recipes[i];
                recipes[i] = recipes[recipeCount - 1];
                recipeCount--;
                return removedRecipe;
            }
        }
        return null;
    }

    public CookingRecipe[] findRecipes(RecipeIngredients[] ingredients) {
        boolean allMatch;
        CookingRecipe[] foundRecipes = new CookingRecipe[recipeCount];
        int count = 0;
        for (int i = 0; i < recipes.length; i++) {
            CookingRecipe recipe = recipes[i];
            if (recipe != null) {
                allMatch = true;
                for (int j = 0; j < ingredients.length; j++) {
                    RecipeIngredients ingredient = ingredients[i];
                    if (recipe.getRecipeIngredient(ingredient.getName()) == null) {
                        allMatch = false;
                        break;
                    }
                }
                if (allMatch) {
                    foundRecipes[count++] = recipe;
                }
            }
        }
        if (count == 0) {
            return null;
        } else {
            CookingRecipe[] exactSizeRecipes = new CookingRecipe[count];
            for (int i = 0; i < count; i++) {
                exactSizeRecipes[i] = foundRecipes[i];
            }
            return exactSizeRecipes;
        }
    }

    public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients) {
        CookingRecipe[] foundRecipes = new CookingRecipe[recipeCount];
        int count = 0;
        for (int i = 0; i < recipes.length; i++) {
            if (recipes[i] != null && recipes[i].getNumberOfIngredients() <= numberOfIngredients) {
                foundRecipes[count++] = recipes[i];
            }
        }
        if (count == 0) {
            return null;
        } else {
            CookingRecipe[] exactSizeRecipes = new CookingRecipe[count];
            for (int i = 0; i < count; i++) {
                exactSizeRecipes[i] = foundRecipes[i];
            }
            return exactSizeRecipes;
        }
    }

    public CookingRecipe getRecipe(String recipeName) {
        return null;
    }
}
