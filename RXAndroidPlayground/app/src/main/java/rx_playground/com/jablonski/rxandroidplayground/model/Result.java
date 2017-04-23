package rx_playground.com.jablonski.rxandroidplayground.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yabol on 12.04.2017.
 */

public class Result {

    @SerializedName("Count")
    private int count;
    @SerializedName("Message")
    private String message;
    @SerializedName("makes")
    private List<Manufacturer> manufacturers;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }
}
