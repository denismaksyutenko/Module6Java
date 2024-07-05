package Exercise8And12;

import java.util.Random;
import java.util.Scanner;

public class DifferentMethods {
    public void guesstingMethod(){
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(10);
        boolean guess = true;
        int guessAmount = 3;
        int parsedValue;

        System.out.println("you have 3 guesses!");
        while (guess && (guessAmount > 0)){
            try {

                System.out.print("your guess: ");
                parsedValue = Integer.parseInt(scanner.nextLine());

                if((parsedValue>=10)||(parsedValue<0))
                    throw new RangeException();
                else if (parsedValue == rand_int1){
                    System.out.println("You win!");
                    guessAmount--;
                    guess = false;
                }
                else {
                    System.out.println("wrong! guesses remaining: " + --guessAmount);
                }
            }
            catch (RangeException e){
                System.err.println("your number should be between 0 and 10");
            }
            catch (NumberFormatException e){
                System.err.println(e.fillInStackTrace());
                System.err.println(e.getMessage());
            }
        }
        if (guessAmount !=0)
            System.out.println("Congratulation, you save " + guessAmount + " guesses");
        else System.out.println("You lose! Game over");
    }

    public void cityMethod(){
        Scanner scanner = new Scanner(System.in);
        String[] value = {"Cork","Athlone","Limeric","Sligo","Dublin"};
        int parsedValue;
        boolean abs = true;

        while (abs){
            try {
                System.out.println("Enter a value: ");
                parsedValue = Integer.parseInt(scanner.nextLine());
                System.out.println("City is: "+ value[parsedValue]);
                abs = false;
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.err.println(e.fillInStackTrace());
                System.err.println("incorrect input, out of bounds");
            }
            catch (NumberFormatException e) {
                System.err.println(e.fillInStackTrace());
                System.err.println("not a number or not integer");
            }}
    }
}
