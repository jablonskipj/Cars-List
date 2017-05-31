package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yabol on 27.05.2017.
 */

public class ImageLink implements Parcelable {
    private String href;

    private ImageLink(Parcel in) {
        href = in.readString();
    }

    public static final Creator<ImageLink> CREATOR = new Creator<ImageLink>() {
        @Override
        public ImageLink createFromParcel(Parcel in) {
            return new ImageLink(in);
        }

        @Override
        public ImageLink[] newArray(int size) {
            return new ImageLink[size];
        }
    };

    public String getHref() {
        return "http://media.ed.edmunds-media.com" + href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(href);
    }
}
