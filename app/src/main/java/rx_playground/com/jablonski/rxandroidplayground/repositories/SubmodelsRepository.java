package rx_playground.com.jablonski.rxandroidplayground.repositories;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx_playground.com.jablonski.rxandroidplayground.contracts.SubmodelsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult;
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector;

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmodelsRepository implements SubmodelsViewContract.Repository{
    private SubmodelsViewContract.Presenter presenter;
    private NetworkConnector connector;
    private List<Model> elements;

    public SubmodelsRepository(SubmodelsViewContract.Presenter presenter){
        this.presenter = presenter;
        this.connector = new NetworkConnector();
    }
    @Override
    public void loadElements(String manufacturer, String modelNiceName, String year) {
        this.connector.getSubmodels(manufacturer, modelNiceName, year).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<ModelsResult>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ModelsResult modelsResult) {
                if(modelsResult.getModels() != null && modelsResult.getModels().size() > 0) {
                    elements = modelsResult.getModels().get(0).getSubmodels();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                presenter.displayElements(elements);
            }
        });
    }
}
