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
    private String drivenWheels;
    private int numOfDoors;
    private Engine engine;
    private Transmission transmission;
    private Category categories;


    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getDrivenWheels() {
        return drivenWheels;
    }

    public void setDrivenWheels(String drivenWheels) {
        this.drivenWheels = drivenWheels;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }
}
