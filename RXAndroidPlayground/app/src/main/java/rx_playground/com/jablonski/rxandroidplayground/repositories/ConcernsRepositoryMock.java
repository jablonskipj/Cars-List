package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.ConcernsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;

/**
 * Created by yabol on 13.04.2017.
 */

public class ConcernsRepositoryMock implements ConcernsViewContract.Repository {
    private ConcernsViewContract.Presenter presenter;

    public ConcernsRepositoryMock(ConcernsViewContract.Presenter presenter){
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
