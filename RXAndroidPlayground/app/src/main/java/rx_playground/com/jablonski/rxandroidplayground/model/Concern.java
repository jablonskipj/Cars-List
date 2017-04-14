package rx_playground.com.jablonski.rxandroidplayground.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yabol on 08.04.2017.
 */

public class Concern {
    int id;
    String name;
    String niceName;
    ArrayList<Car> models;

    public Concern(String niceName){
        this.niceName = niceName;
    }
    public Concern(){

    }

    public String getName(){
        return this.name;
    }
    public String getNiceName(){
        return this.niceName;
    }
    public ArrayList<Car>getModels(){
        return this.models;
    }
}
