package rx_playground.com.jablonski.rxandroidplayground.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yabol on 11.05.2017.
 */

public class Category implements ListElement{
    public static final String VEHICLE_SIZE = "vehicleSize";
    public static final String VEHICLE_BODY_TYPE = "primaryBodyType";
    public static final String VEHICLE_STYLE = "vehicleStyle";
    public static final String VEHICLE_TYPE = "vehicleType";

    @SerializedName("vehicleSize")
    private String vehicleSize;
    @SerializedName("primaryBodyType")
    private String primaryBodyType;
    @SerializedName("vehicleStyle")
    private String vehicleStyle;
    @SerializedName("vehicleType")
    private String vehicleType;

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getPrimaryBodyType() {
        return primaryBodyType;
    }

    public void setPrimaryBodyType(String primaryBodyType) {
        this.primaryBodyType = primaryBodyType;
    }

    public String getVehicleStyle() {
        return vehicleStyle;
    }

    public void setVehicleStyle(String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public int getViewType() {
        return 1;
    }

    @Override
    public RowConfig getRowConfig() {
        RowConfig config = new RowConfig();
        config.addValue(VEHICLE_SIZE, this.vehicleSize);
        config.addValue(VEHICLE_BODY_TYPE, this.primaryBodyType);
        config.addValue(VEHICLE_STYLE, this.vehicleStyle);
        config.addValue(VEHICLE_TYPE, this.vehicleType);
        return config;
    }
}
