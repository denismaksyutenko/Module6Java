package Exercise16;

import java.util.ArrayList;
import java.util.Scanner;

public class DukesDiet {
    public static int upTo2000Calories = 0;//field for counting calories

    public static void main(String[] args) {
        int pressedButton = 1;//input for user
        String inputFromUser;
        // create object of Scanner
        Scanner scanner = new Scanner(System.in);
        //create 2 ArrayLists for available and selected dishes
        ArrayList<DukesDish> dishes = new ArrayList<>();
        ArrayList<DukesDish> selectedDishes = new ArrayList<>();

        fillOut(dishes);//array filling

        //start menu
        System.out.println("You cannot exceed the daily total of 2000 calories ");
        System.out.println("Enter 0: to exit\nEnter 1: to meals selected");
        for (int i=0;i< dishes.size();i++){
            System.out.println("Enter "+(i+2)+": "+dishes.get(i).getNameOfDish() + ": " + dishes.get(i).getCalories() + " calories");
        }

        while (true){
            try {
                System.out.print("input your number: ");
                inputFromUser = scanner.nextLine();
                pressedButton = Integer.parseInt(inputFromUser);//parsing inputted command

                if (pressedButton == 0){
                    System.out.println("Goodbye!");
                    break;
                }//exit
                else if (pressedButton == 1) {
                    if (selectedDishes.isEmpty()){
                        System.out.println("you have not selected dishes");
                    }// without selected dishes
                    else {
                        System.out.println("you selected:");
                        for (DukesDish selectedDish : selectedDishes) {
                            System.out.println(selectedDish.getNameOfDish() + ": " + selectedDish.getCalories() + " calories");
                        }
                        System.out.println("Total calories is " + upTo2000Calories);
                    }
                }// selected dishes list
                else if ((pressedButton > 1) && (pressedButton<=9)){
                    countingCaloriesForUser(dishes.get(pressedButton - 2).getCalories(),pressedButton -2,dishes,selectedDishes);
                }//add new dish to meal
                else System.out.println("wrong command");
            }
            catch (NumberFormatException e){
                System.out.println("incorrect input try again!");
                //e.printStackTrace();
            }
        }//loop
        try {
            WriteMealsFile wf = new WriteMealsFile();
            wf.newFile(selectedDishes,upTo2000Calories);
        }// write selected dishes to file
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//main method

    // fill in some instances of dishes
    public static void fillOut(ArrayList<DukesDish> dish){
        dish.add(new DukesDish("Low fat beef casserole", 350));
        dish.add(new DukesDish("Steak and kidney pie", 450));
        dish.add(new DukesDish("Ham and cheese sandwich", 300));
        dish.add(new DukesDish("Salad bowl", 200));
        dish.add(new DukesDish("Chips", 180));
        dish.add(new DukesDish("Burger", 190));
        dish.add(new DukesDish("Pizza", 240));
        dish.add(new DukesDish("Strawberries and cream", 290));
    }// method

    public static void countingCaloriesForUser(int calories, int pressedButton, ArrayList<DukesDish> dishes, ArrayList<DukesDish> selectedDishes){
        //check amount of calories <= 2000
        if((upTo2000Calories+calories)<=2000){
            upTo2000Calories+=calories;
            selectedDishes.add(dishes.get(pressedButton));
            System.out.println("you choose: " + dishes.get(pressedButton).getNameOfDish() + ": " + dishes.get(pressedButton).getCalories() + " calories");
        } else{
            System.out.println("it's over than 2000, sorry");
        }
    }//method
}
