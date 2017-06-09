package rx_playground.com.jablonski.rxandroidplayground.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yabol on 15.05.2017.
 */

public class RowConfig {
    private Map<String, String> values;

    public RowConfig(){
        this.values = new HashMap<>();
    }

    public void addValue(String name, String value){
       this.values.put(name, value);
    }

    public String getValue(String name){
        return this.values.get(name);
    }
}
