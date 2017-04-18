package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.ConcernsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;

/**
 * Created by yabol on 13.04.2017.
 */

public class ConcernsRepositoryMock implements ConcernsViewContract.Repository {
    private ConcernsViewContract.Presenter presenter;

    public ConcernsRepositoryMock(ConcernsViewContract.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void getManufacturers(String year) {
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer("BMW"));
        manufacturers.add(new Manufacturer("Audi"));
        presenter.displayElements(manufacturers);
    }
}
