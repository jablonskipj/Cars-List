package rx_playground.com.jablonski.rxandroidplayground.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yabol on 09.05.2017.
 */

public class ModelDetailsResult {
    @SerializedName("make")
    private Manufacturer manufacturer;
    @SerializedName("model")
    private Model model;

}
