package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yabol on 08.04.2017.
 */

public class Model implements Parcelable {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("niceName")
    private String niceName;
    @SerializedName("styles")
    private List<Model> submodels;
    @SerializedName("trim")
    private String submodelName;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Model>() {

        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };


    public Model(String name) {
        this.name = name;
    }

    public Model(Parcel in) {
        String[] fields = new String[3];
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
                this.niceName,
        });
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
