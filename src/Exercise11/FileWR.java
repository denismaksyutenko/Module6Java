package Exercise11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileWR {
    //read numbers from file, do some operations and write to other file
    public static void main(String[] args) {
        File file = new File("file2.txt");//File object
        Scanner sc = null;//Scanner object
        // ArrayList for reading from the file
        ArrayList<Integer> numbersFromFile = new ArrayList<>();
        // variables
        int counter = 0;
        int sum = 0;
        double average;

        try {
            sc = new Scanner(file);
            while (sc.hasNext()) {
                int number = sc.nextInt();
                numbersFromFile.add(number);
                counter++;
                sum+=number;
            }//scan numbers from the file to numbersFromFile

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (InputMismatchException e){
            System.err.println(e.fillInStackTrace());
        }
        finally {
            sc.close();//close scanner
            average = (double) sum / counter;
            // output
            System.out.println("counter: " + counter);
            System.out.println("sum: " + sum);
            System.out.println("average: " + average);
        }
        try {
            newFile(counter,sum,average);//file filing
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }//main method

    public static void newFile(int counter, int sum, double average) throws Exception {
        FileWriter nFile = new FileWriter("Sales Summary.txt"); //File object
        //file filing
        nFile.write("counter is " + counter);
        nFile.write("sum is " + sum);
        nFile.write("average is " + average);

        nFile.close();// close file
    }//method for filling file
}//class