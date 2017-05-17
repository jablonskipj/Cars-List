package rx_playground.com.jablonski.rxandroidplayground.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yabol on 09.05.2017.
 */

public class Engine implements ListElement {
    private String id;
    private String name;
    private float compressionRation;
    private int cylinder;
    private float size;
    private String configuration;
    @SerializedName("horsepower")
    private int horsePower;
    private int totalValves;
    private int torque;
    private String type;
    private float displacement;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCompressionRation() {
        return compressionRation;
    }

    public void setCompressionRation(float compressionRation) {
        this.compressionRation = compressionRation;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getTotalValves() {
        return totalValves;
    }

    public void setTotalValves(int totalValves) {
        this.totalValves = totalValves;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getViewType() {
        return 2;
    }

    public RowConfig getRowConfig(){

        //TODO better way to format ints and floats to string NEEDED
        RowConfig config = new RowConfig();
        config.addValue("engineName", this.name);
        config.addValue("engineCompressionRation", String.valueOf(this.compressionRation));
        config.addValue("engineCylinderCount", String.valueOf(this.cylinder));
        config.addValue("engineSize", String.valueOf(this.size));
        config.addValue("engineConfiguration", this.configuration);
        config.addValue("engineHorsePower", String.valueOf(this.horsePower));
        config.addValue("engineTorque", String.valueOf(this.totalValves));
        config.addValue("engineDisplacement", String.valueOf(this.displacement));
        return config;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public float getDisplacement() {
        return displacement;
    }

    public void setDisplacement(float displacement) {
        this.displacement = displacement;
    }
}
