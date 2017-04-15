package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yabol on 08.04.2017.
 */

public class Concern implements Parcelable {
    int id;
    String name;
    String niceName;
    ArrayList<Car> models;

    public Concern(String niceName){
        this.niceName = niceName;
    }
    public Concern(){

    }

    public String getName(){
        return this.name;
    }
    public String getNiceName(){
        return this.niceName;
    }
    public ArrayList<Car>getModels(){
        return this.models;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Concern>(){

        @Override
        public Concern createFromParcel(Parcel source) {
            return new Concern(source);
        }

        @Override
        public Concern[] newArray(int size) {
            return new Concern[size];
        }
    };

    public Concern(Parcel in){
        String [] fields = new String[3];
        in.readStringArray(fields);

        this.id = Integer.parseInt(fields[0]);
        this.name = fields[1];
        this.niceName = fields[2];
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
                this.niceName
        });
        dest.writeList(models);
    }
}
