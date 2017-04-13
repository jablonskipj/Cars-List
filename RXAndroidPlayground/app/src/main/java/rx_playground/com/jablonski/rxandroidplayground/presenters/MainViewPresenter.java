package rx_playground.com.jablonski.rxandroidplayground.presenters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

/**
 * Created by yabol on 06.04.2017.
 */

public class MainViewPresenter implements ViewContract.Presenter<Concern>, ViewContract.Provider<Concern>{
    ViewContract.View view;
    private ViewContract.Repository repository;
    List<Concern> concerns;

    public MainViewPresenter(ViewContract.View view){
        this.view = view;
    }
    public void setRepository(ViewContract.Repository repository){
        this.repository = repository;
    }
    @Override
    public void loadElemetnts(String year) {
        if(this.repository != null) {
            this.repository.getConcerns(year);
        }

    }

    @Override
    public void displayElements(List<Concern> elements) {
        this.concerns = elements;
        this.view.showView(elements);
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
