package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 19.04.2017.
 */

public class CarsRepository {

    private NetworkConnector connector;
    private BaseViewCotract.BasePresenter presenter;
    private List<Model> models;

    public CarsRepository(BaseViewCotract.BasePresenter presenter){
        this.connector = new NetworkConnector();
        this.presenter = presenter;
    }
    /*@Override
    public void getCars(String manufacturerName) {
        this.connector.getCarsByManufacturerName(manufacturerName).
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CarsResult>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("Subscribe", "hello");
            }

            @Override
            public void onNext(CarsResult result) {
                models = result.getResult();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Excepion", e.getMessage());
            }

            @Override
            public void onComplete(){
                presenter.displayElements(models);
            }
        });
    }*/
}
