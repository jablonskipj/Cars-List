package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yabol on 08.04.2017.
 */

public class Car implements Parcelable {
    String id;
    String name;
    String niceName;

    public String getNiceName(){
        return this.niceName;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Car>(){

        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public Car(Parcel in){
        String [] fields = new String[3];
        in.readStringArray(fields);

        this.id = fields[0];
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
                this.id,
                this.name,
                this.niceName
        });
    }
}
