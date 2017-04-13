package rx_playground.com.jablonski.rxandroidplayground.repositories;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 10.04.2017.
 */

public class ConcernsRepository implements ViewContract.Repository {
    private NetworkConnector connector;
    private ViewContract.Presenter presenter;
    private List<Concern> concerns;

    public ConcernsRepository(ViewContract.Presenter presenter){
        this.connector = new NetworkConnector();
        this.presenter = presenter;
    }
    @Override
    public void getConcerns(String year) {

        this.connector.getCarsByProductionYear(year).
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Result>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("Subscribe", "hello");
            }

            @Override
            public void onNext(Result concern) {
                concerns = concern.makes;
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Excepion", e.getMessage());
            }

            @Override
            public void onComplete(){
                presenter.displayElements(concerns);
            }
        });
        //return this.connector.getCarsByProductionYear(year);
    }
}
