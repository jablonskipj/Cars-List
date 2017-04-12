package rx_playground.com.jablonski.rxandroidplayground.presenters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx_playground.com.jablonski.rxandroidplayground.contracts.MainViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

/**
 * Created by yabol on 06.04.2017.
 */

public class MainViewPresenter implements MainViewContract.Presenter, MainViewContract.Provider<Concern>{
    MainViewContract.View view;
    MainViewContract.Repository dataFetcher;
    List<Concern> concerns;

    public MainViewPresenter(MainViewContract.View view, MainViewContract.Repository dataFetcher){
        this.view = view;
        this.dataFetcher = dataFetcher;
    }
    @Override
    public void loadElemetnts(String year) {
        dataFetcher.getConcerns(year).
        subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Result>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("Subscribe", "hello");
            }

            @Override
            public void onNext(Result concern) {
                setConcerns(concern.makes);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Excepion", e.getMessage());
            }

            @Override
            public void onComplete() {
                displayView();
            }
        });

        //todo find out how to fetch each list elemetn and finally build it please!

    }

    public void setConcerns(List<Concern> concerns){
        if(concerns == null)
            concerns = new ArrayList<>();
        this.concerns.addAll(concerns);
    }

    public void addConcern(Concern concern){
        this.concerns.add(concern);
    }
    public void displayView(){
        view.showView();
    }

    @Override
    public int getCount() {
        if(this.concerns != null)
            return this.concerns.size();
        else
            return 0;
    }

    @Override
    public int getId(int position) {
        return position;
    }

    @Override
    public Concern getObject(int position) {
        if(this.concerns != null)
            return this.concerns.get(position);
        return null;
    }
}
