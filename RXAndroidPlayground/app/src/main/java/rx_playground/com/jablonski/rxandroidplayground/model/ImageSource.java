package rx_playground.com.jablonski.rxandroidplayground.model;

/**
 * Created by yabol on 27.05.2017.
 */

public class ImageSource {
    private ImageLink imageLink;
    private ImageSize size;
    private String extension;
    private int photosCount;

    public ImageSize getSize() {
        return size;
    }

    public void setSize(ImageSize size) {
        this.size = size;
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
}
