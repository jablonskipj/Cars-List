package rx_playground.com.jablonski.rxandroidplayground.model;

import com.google.gson.annotations.SerializedName;

import java.text.NumberFormat;

/**
 * Created by yabol on 09.05.2017.
 */

public class Engine implements ListElement {
    public static final String ENGINE_NAME = "engineName";
    public static final String ENGINE_COMPRESSION_RATIO = "engineCompressionRatio";
    public static final String ENGINE_CYLINDERS_COUNT = "engineCylinderCount";
    public static final String ENGINE_SIZE = "engineSize";
    public static final String ENGINE_CONFIGURATION = "engineConfiguration";
    public static final String ENGINE_POWER = "engineHorsePower";
    public static final String ENGINE_TORQUE = "engineTorque";
    public static final String ENGINE_DISPLACEMENT = "engineDisplacement";

    private String id;
    private String name;

    @SerializedName("compressionRatio")
    private float compressionRatio;
    @SerializedName("cylinder")
    private int cylinder;
    @SerializedName("size")
    private float size;
    private String configuration;
    @SerializedName("horsepower")
    private int horsePower;
    @SerializedName("totalValves")
    private int totalValves;
    @SerializedName("torque")
    private int torque;
    private String type;
    @SerializedName("displacement")
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

    public float getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(float compressionRatio) {
        this.compressionRatio = compressionRatio;
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
        NumberFormat floatFormat = NumberFormat.getNumberInstance();
        NumberFormat intFormat = NumberFormat.getIntegerInstance();

        RowConfig config = new RowConfig();
        config.addValue(ENGINE_NAME, this.name);
        config.addValue(ENGINE_COMPRESSION_RATIO, floatFormat.format(this.compressionRatio));
        config.addValue(ENGINE_CYLINDERS_COUNT, intFormat.format(this.cylinder));
        config.addValue(ENGINE_SIZE, intFormat.format(this.size));
        config.addValue(ENGINE_CONFIGURATION, this.configuration);
        config.addValue(ENGINE_POWER, intFormat.format(this.horsePower));
        config.addValue(ENGINE_TORQUE, intFormat.format(this.torque));
        config.addValue(ENGINE_DISPLACEMENT, floatFormat.format(this.displacement));
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
