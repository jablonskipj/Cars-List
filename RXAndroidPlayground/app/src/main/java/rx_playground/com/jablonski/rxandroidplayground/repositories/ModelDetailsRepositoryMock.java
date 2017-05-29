package rx_playground.com.jablonski.rxandroidplayground.repositories;

import rx_playground.com.jablonski.rxandroidplayground.contracts.ModelDetailsContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Category;
import rx_playground.com.jablonski.rxandroidplayground.model.Engine;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Transmission;

/**
 * Created by yabol on 20.05.2017.
 */

public class ModelDetailsRepositoryMock implements ModelDetailsContract.Repository {
    private ModelDetailsContract.Presenter presenter;

    public ModelDetailsRepositoryMock(ModelDetailsContract.Presenter presenter){
        this.presenter = presenter;
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
        engine.setId("1242556");
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

    }
}
