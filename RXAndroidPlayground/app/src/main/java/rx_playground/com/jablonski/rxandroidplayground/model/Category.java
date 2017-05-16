package rx_playground.com.jablonski.rxandroidplayground.model;

/**
 * Created by yabol on 11.05.2017.
 */

public class Category implements ListElement{
    private String vehicleSize;
    private String primaryBodyType;
    private String vehicleStyle;
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
        return config;
    }
}
