package models;

public class FoodEntity {
    private int food_id;
    private String food_name;
    public FoodEntity(int food_id, String food_name) {
        this.food_id = food_id;
        this.food_name = food_name;
    }
    public int getFood_id() {
        return food_id;
    }
    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }
    public String getFood() {
        return food_name;
    }
    public void setFood(String food_name) {
        this.food_name = food_name;
    }
}
