package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ManufacturersViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;

/**
 * Created by yabol on 13.04.2017.
 */

public class ManufacturersRepositoryMock implements ManufacturersViewContract.Repository {
    private BaseViewCotract.BasePresenter presenter;

    public ManufacturersRepositoryMock(BaseViewCotract.BasePresenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void getManufacturers(String year) {
        List<Manufacturer> manufacturers = new ArrayList<>();
        Manufacturer manu = new Manufacturer("bmw");
        manu.addModel(new Model("x3"));
        manufacturers.add(manu);
        manufacturers.add(new Manufacturer("Audi"));
        presenter.displayElements(manufacturers);
    }
}
