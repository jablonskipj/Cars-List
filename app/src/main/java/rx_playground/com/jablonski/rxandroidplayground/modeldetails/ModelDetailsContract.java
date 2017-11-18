package rx_playground.com.jablonski.rxandroidplayground.modeldetails;

import android.support.v4.app.Fragment;

import rx_playground.com.jablonski.rxandroidplayground.model.ImageSource;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Photo;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 15.05.2017.
 */

public class ModelDetailsContract {
    public interface Provider{
        RowConfig getObject(int position);
        int getCount();
        int getPositionType(int position);
    }

    public interface ImagesProvider{
        ImageSource getImage(int position);
        int getPhotosCount();
    }

    public interface Presenter{
        void loadModelData(String modelId);
        void displayModel(Model model);
        void displayPhotos(Photo photos);
        Model getModel();
    }

    public interface View{
        void displayModelDetails();
        void displayPhotos();
    }

    public interface Repository{
        void getModelDetails(String modelId);
        void getModelPhotos(String modelId);
    }
}
