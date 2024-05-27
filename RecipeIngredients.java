/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 7
 */

public class RecipeIngredients extends Ingredients{
    private float quantity;

    public RecipeIngredients(String name, String measuringUnit, int caloriesPerUnit, float quantity) {
        super(name, measuringUnit, caloriesPerUnit);
        this.quantity = quantity;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecipeIngredient\n"+super.toString()+"\nquantity="+quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        RecipeIngredients that = (RecipeIngredients) obj;
        return Float.compare(that.quantity, quantity)==0;
    }
}
