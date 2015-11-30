package models;


public class DietPlanFoodEntity {
    private String foodName;
    private int foodId;
    private String servings;
    private String unit;
    public DietPlanFoodEntity(String foodName, int foodId, String servings, String unit) {
        this.foodName = foodName;
        this.foodId = foodId;
        this.servings = servings;
        this.unit = unit;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getServings() {
        return servings;
    }
    public void setServings(String servings) {
        this.servings = servings;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
