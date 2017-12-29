package rx_playground.com.jablonski.rxandroidplayground.modeldetails;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import rx_playground.com.jablonski.rxandroidplayground.model.Category;
import rx_playground.com.jablonski.rxandroidplayground.model.Engine;
import rx_playground.com.jablonski.rxandroidplayground.model.ImageLink;
import rx_playground.com.jablonski.rxandroidplayground.model.ImageSource;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.ModelDetailsResult;
import rx_playground.com.jablonski.rxandroidplayground.model.Photo;
import rx_playground.com.jablonski.rxandroidplayground.model.PhotosResult;
import rx_playground.com.jablonski.rxandroidplayground.model.Transmission;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 20.05.2017.
 */

public class ModelDetailsRepositoryMock implements ModelDetailsContract.Repository {
    private NetworkConnector connector;
    private Photo resultPhoto;

    public ModelDetailsRepositoryMock(){
        this.connector = new NetworkConnector();
    }
    @Override
    public Observable<ModelDetailsResult> getModelDetails(String modelId) {
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
        ModelDetailsResult result = new ModelDetailsResult();
        result.setModel(model);
        result.setEngine(engine);
        result.setCategories(category);
        result.setTransmission(transmission);
        return Observable.just(result);
    }

    @Override
    public Observable<PhotosResult> getModelPhotos(String modelId) {
        ImageLink link = new ImageLink("/mazda/3/2015/oem/2015_mazda_3_sedan_s-grand-touring_fq_oem_1_815.jpg");
        ImageSource source = new ImageSource(link);
        List<ImageSource> sources = new ArrayList<>();
        sources.add(source);
        link = new ImageLink("/mazda/3/2015/oem/2015_mazda_3_4dr-hatchback_i-touring_fq_oem_2_423.jpg");
        source = new ImageSource(link);
        sources.add(source);
        Photo resultPhoto = new Photo(sources);
        PhotosResult result = new PhotosResult();
        List<Photo> photos = new ArrayList<>();
        photos.add(resultPhoto);
        result.setPhotos(photos);
        return Observable.just(result);
    }
}
