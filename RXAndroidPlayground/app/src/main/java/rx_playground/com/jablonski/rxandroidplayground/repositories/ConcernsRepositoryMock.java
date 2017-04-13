package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 13.04.2017.
 */

public class ConcernsRepositoryMock implements ViewContract.Repository {
    private ViewContract.Presenter presenter;

    public ConcernsRepositoryMock(ViewContract.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void getConcerns(String year) {
        List<Concern> concerns = new ArrayList<>();
        concerns.add(new Concern("BMW"));
        concerns.add(new Concern("Audi"));
        presenter.displayElements(concerns);
    }
}
