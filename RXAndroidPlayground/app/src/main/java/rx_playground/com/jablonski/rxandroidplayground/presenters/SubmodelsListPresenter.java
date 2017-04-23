package rx_playground.com.jablonski.rxandroidplayground.presenters;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.SubmodelsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmodelsListPresenter implements SubmodelsViewContract.Presenter {
    private SubmodelsViewContract.View view;
    private SubmodelsViewContract.Repository repository;
    private List<Model> submodels;

    public SubmodelsListPresenter(SubmodelsViewContract.View view){
        this.view = view;
    }

    public void setRepository(SubmodelsViewContract.Repository repository){
        this.repository = repository;
    }
    @Override
    public void displayElements(List<Model> elements) {
        this.submodels = elements;
        this.view.showView(elements);
    }

    @Override
    public List<Model> getElements() {
        return this.submodels;
    }

    @Override
    public void loadElements(String niceName, String year) {
        repository.loadElements(niceName, year);
    }
}
