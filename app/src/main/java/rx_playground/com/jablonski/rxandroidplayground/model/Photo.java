package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yabol on 27.05.2017.
 */

public class Photo implements Parcelable{
    private String title;
    private String category;
    private List<ImageSource> sources;

    public Photo(){
        this.sources = new ArrayList<>();
    }

    public Photo(List<ImageSource> sources){
        this.sources = sources;
    }

    private Photo(Parcel in){
        String elemtns[] = new String[2];
        in.readStringArray(elemtns);
        this.title = elemtns[0];
        this.category = elemtns[1];
        in.readList(this.sources, ImageSource.class.getClassLoader());
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public List<ImageSource> getSources() {
        return sources;
    }

    public void setSources(List<ImageSource> sources) {
        this.sources = sources;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void addPhotoSources(List<ImageSource> sources){
        if(this.sources == null){
            this.sources = new ArrayList<>();
        }
        this.sources.addAll(sources);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(sources);
        dest.writeStringArray(new String[]{title, category});
    }
}
