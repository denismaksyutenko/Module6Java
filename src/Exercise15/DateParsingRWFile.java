package Exercise15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateParsingRWFile {
    public static void main(String[] args) {
        //create objects
        File file = new File("December_2016.txt");
        Scanner sc;

        List<TemperatureIreland> temperatureIrelands = new ArrayList<>();
        //create variables
        int maxTemperature = 0;
        int minTemperature = 10;
        int tmp;
        double average = 0;

        try {
            sc = new Scanner(file);
            while (sc.hasNext()) {
                String date = sc.nextLine();
                String[] line = date.split(" ");
                temperatureIrelands.add(parser(line));
            }//loop
        }//writing file data to list
        catch (FileNotFoundException e) {
            System.out.println(e.fillInStackTrace());
        }
        catch (ParseException e) {
            System.out.println(e.fillInStackTrace());
        }

        Iterator<TemperatureIreland> iterator = temperatureIrelands.iterator();
        //operations with numbers: max, min, average
        while (iterator.hasNext()){
            tmp = iterator.next().getTemperatureIreland();
            average += tmp;
            if (tmp > maxTemperature)
                maxTemperature = tmp;
            if(tmp < minTemperature)
                minTemperature = tmp;
        }//loop
        average = average / temperatureIrelands.size();
        //output
        System.out.format("average %.2f",average);
        System.out.println("\naverage: "+average);
        System.out.println("max: "+maxTemperature +"\nmin: "+ minTemperature);

        try {
            newFile(average,maxTemperature,minTemperature,temperatureIrelands);
        }//writing to file
        catch (Exception e){
            e.printStackTrace();

        }
    }

    //reading data from file
    public static TemperatureIreland parser(String[] line) throws ParseException {
        //create objects TemperatureIreland, SimpleDateFormat, Date
        TemperatureIreland temperatureIreland = new TemperatureIreland();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format.parse(line[0]);
        //fill instance from file
        temperatureIreland.setDateIreland(date);
        temperatureIreland.setTemperatureIreland(Integer.parseInt(line[1].trim()));
        //print
        System.out.println(temperatureIreland.getDateIreland() + " " + temperatureIreland.getTemperatureIreland());
        return temperatureIreland;
    }//method

    //write data to file
    public static void newFile(double average, int max, int min, List<TemperatureIreland> temperatureIrelands) throws Exception {
        FileWriter nFile = new FileWriter("Analysis.txt");//create object
        //file filling
        nFile.write(String.format("average is " + average));
        nFile.write("\nmax is "+ max +" (the warmest day)");
        nFile.write("\nmin is "+ min +" (the coldest day)");
        //filling parsed date and temperature
        for (TemperatureIreland temperatureIreland: temperatureIrelands){
            nFile.write("\n"+temperatureIreland.getDateIreland()+" "+ temperatureIreland.getTemperatureIreland());
        }
        nFile.close();//close file
    }//method
}
