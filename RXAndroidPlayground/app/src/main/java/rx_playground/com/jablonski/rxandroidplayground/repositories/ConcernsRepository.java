package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.List;

import io.reactivex.Observable;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 10.04.2017.
 */

public class ConcernsRepository implements ViewContract.Repository {
    private NetworkConnector connector;

    public ConcernsRepository(){
        this.connector = new NetworkConnector();
    }
    @Override
    public Observable<Result> getConcerns(String year) {

        return this.connector.getCarsByProductionYear(year);
    }
}
