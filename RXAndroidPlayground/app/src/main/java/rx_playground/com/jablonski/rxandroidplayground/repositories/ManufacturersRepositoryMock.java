package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ManufacturersViewContract;
import rx_playground.com.jablonski.rxandroidplayground.fragments.ManufacturersListFragment;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;
import rx_playground.com.jablonski.rxandroidplayground.presenters.ManufacturersListPresenter;

/**
 * Created by yabol on 13.04.2017.
 */

public class ManufacturersRepositoryMock implements ManufacturersViewContract.Repository {
    private ManufacturersListPresenter presenter;

    public ManufacturersRepositoryMock(ManufacturersListPresenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void getManufacturers(String year) {
        List<Manufacturer> manufacturers = new ArrayList<>();
        Manufacturer manu = new Manufacturer("bmw");
        manu.setName("BMW");
        Model bmw = new Model("x3");
        bmw.setNiceName("X3 3.0D");
        bmw.setSubmodelName("X3 3.0D M");
        manu.addModel(bmw);
        manufacturers.add(manu);
        manufacturers.add(new Manufacturer("Audi"));
        presenter.displayElements(manufacturers);
    }
}
