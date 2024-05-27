/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 7
 */

public class Ingredients {
    private String name;
    private String measuringUnit;
    private int caloriesPerUnit;

    public Ingredients(String name, String measuringUnit, int caloriesPerUnit) {
        this.name = name;
        this.measuringUnit = measuringUnit;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public String getName() {
        return name;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public int getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    public void setCaloriesPerUnit(int caloriesPerUnit) {
        this.caloriesPerUnit = caloriesPerUnit;
    }

    @Override
    public String toString() {
        return "Ingredient\n"+"name="+name+"\n"+"measuringUnit="+measuringUnit+"\n"+"caloriesPerUnit="+caloriesPerUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        else if (obj==null || getClass()!=obj.getClass()) {
            return false;
        }
        Ingredients that = (Ingredients) obj;
        return caloriesPerUnit == that.caloriesPerUnit && name.equals(that.name) && measuringUnit.equals(that.measuringUnit);
    }
}
