package Ex16Example;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date; 
import java.util.ArrayList;

public class WriteToTextFile{

   public void writeToFile(ArrayList<String> meals, float accumCalories){
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		Date now = new Date();
		String date = df.format(now);
		
		File dir=new File(date + "_Meal");
		if(!dir.exists()){
		   dir.mkdir();
		}
		
		File file = new File(dir,date+"_MealDetails.txt");
									
		try
		 (
		 FileWriter fw = new FileWriter(file);
		 BufferedWriter bw = new BufferedWriter(fw);
		 PrintWriter pw = new PrintWriter(bw);
		 )
		 {
		  pw.println("Meal Selection");
		  pw.println("Date: " + new Date());
		  pw.println("");
			
		  for(String s:meals){
			pw.println(s);
			pw.println("");
		  }// loop
		  
		  pw.println("Calorie Count: " + accumCalories);
			
		  pw.println("****************Have a good day****************");
			
		 }catch(IOException e){
			 e.printStackTrace();
		 }
			
	}// method

}// class