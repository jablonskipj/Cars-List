package rx_playground.com.jablonski.rxandroidplayground.model;

import java.util.List;

/**
 * Created by yabol on 27.05.2017.
 */

public class Photo {
    private String title;
    private String category;
    private List<ImageSource> sources;

    public List<ImageSource> getSources() {
        return sources;
    }

    public void setSources(List<ImageSource> sources) {
        this.sources = sources;
    }
}
