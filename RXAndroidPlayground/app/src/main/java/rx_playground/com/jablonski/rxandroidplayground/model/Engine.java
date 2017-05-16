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
    private String type;

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
        RowConfig config = new RowConfig();

        return config;
    }
}
