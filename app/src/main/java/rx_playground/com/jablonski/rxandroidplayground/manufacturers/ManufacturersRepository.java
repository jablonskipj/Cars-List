package rx_playground.com.jablonski.rxandroidplayground.manufacturers;

import android.util.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx_playground.com.jablonski.rxandroidplayground.manufacturers.ManufacturersViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 10.04.2017.
 */

public class ManufacturersRepository implements ManufacturersViewContract.Repository {
    private NetworkConnector connector;
    private ManufacturersViewContract.Presenter presenter;
    private List<Manufacturer> manufacturers;

    public ManufacturersRepository(ManufacturersViewContract.Presenter presenter){
        this.connector = new NetworkConnector();
        this.presenter = presenter;
    }
    @Override
    public void getManufacturers(String year) {

        this.connector.getManufacturersByName(year).
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Result>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("Subscribe", "hello");
            }

            @Override
            public void onNext(Result result) {
                manufacturers = result.getManufacturers();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Exception", e.getMessage());
            }

            @Override
            public void onComplete(){
                presenter.displayElements(manufacturers);
            }
        });
        //return this.connector.getAllManufacturers(year);
    }
}
