package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yabol on 27.05.2017.
 */

public class ImageSource implements Parcelable {
    @SerializedName("link")
    private ImageLink imageLink;
    private String extension;
    private int photosCount;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<ImageSource>() {

        @Override
        public ImageSource createFromParcel(Parcel source) {
            return new ImageSource(source);
        }

        @Override
        public ImageSource[] newArray(int size) {
            return new ImageSource[size];
        }
    };

    public ImageSource(ImageLink link){
        this.imageLink = link;
    }
    private ImageSource(Parcel in){
        this.photosCount = in.readInt();
        this.extension = in.readString();
        this.imageLink = in.readParcelable(ImageLink.class.getClassLoader());
    }


    public ImageLink getImageLink() {
        return imageLink;
    }

    public void setImageLink(ImageLink imageLink) {
        this.imageLink = imageLink;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getPhotosCount() {
        return photosCount;
    }

    public void setPhotosCount(int photosCount) {
        this.photosCount = photosCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photosCount);
        dest.writeString(this.extension);
        dest.writeParcelable(this.imageLink, flags);
    }
}
