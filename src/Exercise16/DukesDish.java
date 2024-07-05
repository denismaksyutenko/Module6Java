package Exercise16;

public class DukesDish {
    private String nameOfDish;
    private int calories;

    public int getCalories() {
        return calories;
    }//method

    public String getNameOfDish() {
        return nameOfDish;
    }//method

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }//method

    public void setCalories(int calories) {
        this.calories = calories;
    }//method
    public DukesDish(String nameOfDish, int calories){
        this.calories = calories;
        this.nameOfDish = nameOfDish;
    } //constructor
}//class
