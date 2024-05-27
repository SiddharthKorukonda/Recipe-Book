/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 7
 */
import java.util.Scanner;

public class TestRecipeBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeBook recipeBook = new RecipeBook("Gourmet Recipes");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Recipe");
            System.out.println("2. Calculate Calories of a Recipe");
            System.out.println("3. Remove Ingredient from Recipe");
            System.out.println("4. Find Recipes with Few Ingredients");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter recipe name:");
                    String recipeName = scanner.nextLine();
                    System.out.println("Enter ingredients (format: Name,Unit,Calories,Quantity; separate multiple with commas):");
                    String[] ingredientDetails = scanner.nextLine().split(";");
                    RecipeIngredients[] ingredients = new RecipeIngredients[ingredientDetails.length];
                    for (int i = 0; i < ingredientDetails.length; i++) {
                        String[] details = ingredientDetails[i].split(",");
                        ingredients[i] = new RecipeIngredients(details[0].trim(), details[1].trim(), Integer.parseInt(details[2].trim()), Float.parseFloat(details[3].trim()));
                    }
                    recipeBook.addRecipe(recipeName, ingredients);
                    System.out.println("Recipe added.");
                    break;
                case 2:
                    System.out.println("Enter the name of the recipe for calorie calculation:");
                    recipeName = scanner.nextLine();
                    CookingRecipe recipe = recipeBook.getRecipe(recipeName);
                    if (recipe != null) {
                        System.out.println("Total calories: " + recipe.calculateCalories());
                    } else {
                        System.out.println("Recipe not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the name of the recipe to remove an ingredient from:");
                    recipeName = scanner.nextLine();
                    System.out.println("Enter the name of the ingredient to remove:");
                    String ingredientName = scanner.nextLine();
                    recipe = recipeBook.getRecipe(recipeName);
                    if (recipe != null && recipe.removeRecipeIngredient(ingredientName) != null) {
                        System.out.println("Ingredient removed.");
                    } else {
                        System.out.println("Ingredient or recipe not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter maximum number of ingredients:");
                    int maxIngredients = scanner.nextInt();
                    CookingRecipe[] foundRecipes = recipeBook.findRecipesWithFewIngredients(maxIngredients);
                    if (foundRecipes != null && foundRecipes.length > 0) {
                        System.out.println("Recipes with " + maxIngredients + " or fewer ingredients:");
                        for (CookingRecipe r : foundRecipes) {
                            System.out.println(r);
                        }
                    } else {
                        System.out.println("No recipes found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}
