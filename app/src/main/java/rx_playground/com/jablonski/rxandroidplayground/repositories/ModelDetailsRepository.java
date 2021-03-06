package rx_playground.com.jablonski.rxandroidplayground.repositories;

import android.util.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ModelDetailsContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.ModelDetailsResult;
import rx_playground.com.jablonski.rxandroidplayground.model.Photo;
import rx_playground.com.jablonski.rxandroidplayground.model.PhotosResult;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 19.04.2017.
 */

public class ModelDetailsRepository implements ModelDetailsContract.Repository{

    private NetworkConnector connector;
    private Model model;
    private ModelDetailsContract.Presenter presenter;
    private Photo resultPhoto;

    public ModelDetailsRepository(ModelDetailsContract.Presenter presenter){
        this.connector = new NetworkConnector();
        this.presenter = presenter;

    }

    public void getModelDetails(String modelId) {
        this.connector.getModelsDetails(modelId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ModelDetailsResult>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("Subscribe", "hello");
            }

            @Override
            public void onNext(ModelDetailsResult result) {
                model = result.getModel();
                model.setEngine(result.getEngine());
                model.setTransmission(result.getTransmission());
                model.setCategory(result.getCategories());
                model.setDrivenWheels(result.getDrivenWheels());
                model.setNumberOfDoors(result.getNumOfDoors());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Exception", e.getMessage());
            }

            @Override
            public void onComplete(){
               presenter.displayModel(model);
            }
        });
    }

    @Override
    public void getModelPhotos(String modelId) {
        this.connector.getPhotos(modelId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PhotosResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PhotosResult photosResult) {
                        List<Photo> photos = photosResult.getPhotos();
                        resultPhoto = new Photo();
                        for(Photo singlePhoto: photos){
                            resultPhoto.addPhotoSources(singlePhoto.getSources());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Exception", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        presenter.displayPhotos(resultPhoto);
                    }
                });
    }
}
