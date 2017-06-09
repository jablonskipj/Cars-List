package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ModelDetailsContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Category;
import rx_playground.com.jablonski.rxandroidplayground.model.Engine;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Photo;
import rx_playground.com.jablonski.rxandroidplayground.model.PhotosResult;
import rx_playground.com.jablonski.rxandroidplayground.model.Transmission;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 20.05.2017.
 */

public class ModelDetailsRepositoryMock implements ModelDetailsContract.Repository {
    private ModelDetailsContract.Presenter presenter;
    private NetworkConnector connector;
    private Photo resultPhoto;

    public ModelDetailsRepositoryMock(ModelDetailsContract.Presenter presenter){
        this.presenter = presenter;
        this.connector = new NetworkConnector();
    }
    @Override
    public void getModelDetails(String modelId) {
        Model model = new Model("Civic");

        Engine engine = new Engine();
        engine.setCompressionRatio(1.0f);
        engine.setConfiguration("inline");
        engine.setCylinder(4);
        engine.setDisplacement(3.5f);
        engine.setHorsePower(200);
        engine.setId("200703383");
        engine.setName("Super engine");
        model.setEngine(engine);

        Category category = new Category();
        category.setPrimaryBodyType("Coupe");
        category.setVehicleSize("small");
        category.setVehicleStyle("fast");
        category.setVehicleType("furious");
        model.setCategory(category);

        Transmission transmission = new Transmission();
        transmission.setId("!2334");
        transmission.setName("Good transmission");
        transmission.setTransmissionType("Rear");
        model.setTransmission(transmission);


        this.presenter.displayModel(model);
    }

    @Override
    public void getModelPhotos(String modelId) {
        this.connector.getPhotos(modelId).subscribeOn(Schedulers.newThread())
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

                    }

                    @Override
                    public void onComplete() {
                        presenter.displayPhotos(resultPhoto);
                    }
                });
        /*ImageLink link = new ImageLink("/mazda/3/2015/oem/2015_mazda_3_sedan_s-grand-touring_fq_oem_1_815.jpg");
        ImageSource source = new ImageSource(link);
        List<ImageSource> sources = new ArrayList<>();
        sources.add(source);
        link = new ImageLink("/mazda/3/2015/oem/2015_mazda_3_4dr-hatchback_i-touring_fq_oem_2_423.jpg");
        source = new ImageSource(link);
        sources.add(source);
        Photo resultPhoto = new Photo(sources);
        presenter.displayPhotos(resultPhoto);*/
    }
}
