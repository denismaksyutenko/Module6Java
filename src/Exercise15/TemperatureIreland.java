package Exercise15;

import java.util.Date;

public class TemperatureIreland {
    private Date dateIreland;
    private int temperatureIreland;

    public Date getDateIreland() {
        return dateIreland;
    }//method

    public int getTemperatureIreland() {
        return temperatureIreland;
    }//method

    public void setDateIreland(Date dateIreland) {
        this.dateIreland = dateIreland;
    }//method

    public void setTemperatureIreland(int temperatureIreland) {
        this.temperatureIreland = temperatureIreland;
    }//method
    public TemperatureIreland(Date dateIreland, int temperatureIreland){
        this.dateIreland =dateIreland;
        this.temperatureIreland = temperatureIreland;
    }//constructor
    public TemperatureIreland(){}//constructor
}
