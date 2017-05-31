package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.SubmodelsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 26.05.2017.
 */

public class SubmodelReposioryMock implements SubmodelsViewContract.Repository{
    private SubmodelsViewContract.Presenter presenter;

    public SubmodelReposioryMock(SubmodelsViewContract.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void loadElements(String manufacturer, String modelNiceName, String year) {
        List<Model> elements = new ArrayList<>();

        Model x6 = new Model("x6 2.5i");
        x6.setNiceName("BMW X6");
        x6.setSubmodelName("X6 2.5");
        x6.setId("200703383");
        elements.add(x6);

        this.presenter.displayElements(elements);
    }
}
