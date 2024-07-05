package Exercise13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberOfAmazing {
    //reading string from the file and count "amazing" words
    public static void main(String[] args) {
        //create objects
        File file = new File("Duke.txt");
        Scanner sc = null;
        //create variables
        String string="";
        int stringPoint = 1;
        int counter =0;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                string += sc.nextLine();
            }//read from the file
            System.out.println(string);
        }
        catch (FileNotFoundException e) {
            System.err.println(e.fillInStackTrace());
        }
        finally {
            sc.close();//close scanner
        }
        while (stringPoint != 0)
        {   //count number of choose word
            if(stringPoint < string.length()){
                stringPoint = string.indexOf("amazing", stringPoint) + 1;
                counter++;
                System.out.println(stringPoint);
            }
        }//loop

        System.out.println("you have 'amazing': " + counter + " times");//output
    }
}
