package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by yabol on 08.04.2017.
 */

public class Manufacturer implements Parcelable {
    @SerializedName("Country")
    private String country;
    @SerializedName("name")
    private String name;
    @SerializedName("niceName")
    private String niceName;
    @SerializedName("id")
    private int id;
    @SerializedName("models")
    ArrayList<Model> models;

    public Manufacturer(String niceName){
        this.niceName = niceName;
    }
    public Manufacturer(){

    }

    public void addModel(Model model){
        if(models == null) models = new ArrayList<>();

        models.add(model);
    }

    public String getName(){
        return this.name;
    }
    public String getNiceName(){
        return this.niceName;
    }

    public String getManufactureName(){
        return this.niceName == null ? this.name : this.niceName;
    }
    public ArrayList<Model>getModels(){
        return this.models;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Manufacturer>(){

        @Override
        public Manufacturer createFromParcel(Parcel source) {
            return new Manufacturer(source);
        }

        @Override
        public Manufacturer[] newArray(int size) {
            return new Manufacturer[size];
        }
    };

    public Manufacturer(Parcel in){
        String [] fields = new String[3];
        in.readStringArray(fields);

        this.id = Integer.parseInt(fields[0]);
        this.name = fields[1];
        this.niceName = fields[2];
        this.country = fields[3];
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                String.valueOf(this.id),
                this.name,
                this.niceName,
                this.country
        });
        dest.writeList(models);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
