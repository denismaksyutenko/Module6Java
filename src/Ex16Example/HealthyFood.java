package Ex16Example;

public class HealthyFood{
  private String name;
  private float noOfCalories;

  public HealthyFood(String name, float noOfCalories){
    this.name = name;
    this.noOfCalories = noOfCalories;	
  }// constructor
  
  public void setName(String food){
   this.name = food;
  }// method
  
  public String getName(){
   return name;
  }// method
  
  public void setNoOfCalories(float noOfCalories){
   this.noOfCalories = noOfCalories;
  }// method
  
  public float getNoOfCalories(){
   return noOfCalories;
  }// method
  
  public String toString(){
   return (name + ": " + "(" + noOfCalories + ")");
  }// method

}// class