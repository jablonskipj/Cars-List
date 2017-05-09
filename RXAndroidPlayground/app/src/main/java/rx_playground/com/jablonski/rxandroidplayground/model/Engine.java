package rx_playground.com.jablonski.rxandroidplayground.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yabol on 09.05.2017.
 */

public class Engine {
    private String id;
    private String name;
    private float compressionRation;
    private int cylinder;
    private float size;
    private String configuration;
    @SerializedName("horsepower")
    private int horsePower;
}
