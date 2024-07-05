package Exercise16;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class WriteMealsFile {
    public void newFile(ArrayList<DukesDish> selectedDishes, int totalCalories) throws Exception {
        // Creating objects for file
        FileWriter nFile = new FileWriter("file2.txt");
        Date date =new Date();
        nFile.write(date.toString());
        //write selected dishes in the file
        for (DukesDish dish: selectedDishes){
            nFile.write("\n"+dish.getNameOfDish()+" "+ dish.getCalories() + " calories");
        }
        nFile.write("\nTotal calories is " + totalCalories);

        nFile.close();//close file
    }//method

}//class
