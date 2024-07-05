package Ex16Example;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DietPlan{
	
	// Declare and create a Scanner object.
	private Scanner scanner = new Scanner(System.in);
	
	// Declare an ArrayList of HealthyFood objects.
	private ArrayList<HealthyFood> foods = new ArrayList<HealthyFood>();
	
	// Declare an ArrayList to store the user's meal selections.
	private ArrayList<String> foodsSelected = new ArrayList<String>();
	
	// Declare a variable to store the accumulated no. of calories.
	private float accumulatedCalories;
	
	// Declare a variable to store the no. of calories per the diet.
	private final float NO_OF_CALS = 2000; 
	
	// Declare a variable to store the number of calories remaining.
	private float noOfCaloriesRemaining =  NO_OF_CALS;
	
	public DietPlan(){
	  // Populate the ArrayList
	  foods.add(new HealthyFood("Low Fat Beef Casserole", 350f));
	  foods.add(new HealthyFood("Low Fat Steak and Kidney Pie", 450f));
	  foods.add(new HealthyFood("Low Fat Ham and Cheese Sandwich", 300f));
	  foods.add(new HealthyFood("Salad Bowl", 200f));
	  foods.add(new HealthyFood("Low Fat Chips", 180f));
	  foods.add(new HealthyFood("Low Fat Burger", 190f));
	  foods.add(new HealthyFood("Low Fat Pizza", 240f));
	  foods.add(new HealthyFood("Low Fat Chocolate Cake Slice", 310f));
	  foods.add(new HealthyFood("Low Fat Strawberries and Cream", 290f));
	}// Constructor
	
	public static void main(String[] args){
	  // Create an object from this class.
      DietPlan dp = new DietPlan();
      dp.presentMenu();
	  dp.processSelection();
	}// main
	
	public void presentMenu(){
	  // present the menu
	  System.out.println("\n********************Welcome to Duke's 2000 Calorie Daily Diet****************\n");
	  System.out.println("The diet plan does not allow you to exceed 2000 calories.");
	  System.out.println("Enter 999 To View the Menu");
      System.out.println("Enter 0: To Exit"); // ***************
	  System.out.println("Enter 1: To View Meals Selected.");
		 
	  System.out.println(""); // presentation purposes
		  
	  int counter = 1; // label for meal selections
		  
	  // Display the Meals selections.
	  for (HealthyFood hf:foods){
		System.out.println("Enter: " + ++counter + ": " +hf.toString() + " calories.");
	  }// loop
		  
	  System.out.println(""); // presentation purposes
		
	}// method
	
	public void processSelection(){
		
		int sentinel = 1; // user selection
	 
		 outer: do{
		  try{
		   // Ask the user for their input.
		   System.out.print("Make your selection: ");
		   sentinel = scanner.nextInt();
		  }catch(InputMismatchException e){ // validation
            System.out.println("Please enter a number from 1 to " + (foods.size()+1) + ".");
			scanner.nextLine(); // read in the new line character
			continue outer; // leave the current iteration.
          }

          // Continue to validate the user selection.		  
		  if(sentinel == 0){ // exit condition
		     if(foodsSelected.size()>0){ // has the user entered meals?
			     int response = JOptionPane.showConfirmDialog(null, "Save menu selections to text file?", "Program Exit",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			      if(response == 0){
			       //Create Object
			       WriteToTextFile obj = new WriteToTextFile();
			       obj.writeToFile(foodsSelected,accumulatedCalories);
			       System.out.println("Goodbye");
			      }else{
				   System.out.println("Goodbye");
				  }
			 }else{
			  System.out.println("No meals selected - Goodbye.");
			 }
		   break outer;
		  }// if statement
		  
		  if(sentinel == 1) { // user wishes to view the meals selected so far.
		    System.out.println("You wish to view your meal selections."); 
			// Call a method to show the user's meal selections (if any).
			displayMealSelections();
			continue outer;
		  }// if statement
		  
		  if(sentinel == 999) {
			 presentMenu();
			 continue outer;
		  }	  
		  
		  if((sentinel < 1) || (sentinel-1 > foods.size())){
		    System.out.println("Please enter a number from 1 to " + (foods.size()+1) + ".");
			sentinel = 1; // reset it so the loop runs again.
			continue outer; // leave the current iteration.
		  }else{
            // The user has entered a number between 2-10 (inc).
			System.out.println(foods.get(sentinel-2).toString());
			// Call the method checkCalorieCount and pass in the user entry.
			if(checkCalorieCount(foods.get(sentinel-2).getNoOfCalories())){
			  // update attributes
			  accumulatedCalories+=foods.get(sentinel-2).getNoOfCalories(); 
			  noOfCaloriesRemaining = (NO_OF_CALS - accumulatedCalories);
			  System.out.println(""); // presentation
			  System.out.println(">>>>>>>>>> "+ "No. of Calories Accumulated: " + accumulatedCalories + "<<<<<<<<");
		      System.out.println(">>>>>>>>>> " + "No. of Calories Remaining: " + noOfCaloriesRemaining + "<<<<<<<<");
			  
			  // update 'shopping basket'
			  foodsSelected.add(foods.get(sentinel-2).toString());
			  
			}else{
			  System.out.println("You do not have sufficient calories remaining for that option.");
			}
          }// else		  
		   
		 }while(sentinel != 0);// while loop
	}// method
	
	public boolean checkCalorieCount(float noOfCaloriesProposed){
	 if ((noOfCaloriesRemaining - noOfCaloriesProposed)>=0 ){
	  return true;
	 }else{
	  return false;
	 }
	}// method
	
    public void displayMealSelections(){
	 // Check the length of the ArrayList - it could be empty.
	 if(foodsSelected.size() > 0){
       for(String s:foodsSelected){
	     System.out.println(s);
	   }//loop
	   // Display the calorie information. 
	   System.out.println(">>>>>>>>>> "+ "No. of Calories Accumulated: " + accumulatedCalories + "<<<<<<<<");
	   System.out.println(">>>>>>>>>> " + "No. of Calories Remaining: " + noOfCaloriesRemaining + "<<<<<<<<");
	   System.out.println(""); // presentation
     }else{
	    System.out.println("You have not made any selections.");
	 }
	}// method
	
}// class