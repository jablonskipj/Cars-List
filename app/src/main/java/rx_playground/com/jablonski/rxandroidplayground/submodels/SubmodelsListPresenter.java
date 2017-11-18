package rx_playground.com.jablonski.rxandroidplayground.submodels;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmodelsListPresenter implements SubmodelsViewContract.Presenter, BaseViewCotract.BaseProvider<Model>, BaseViewCotract.BaseOnItemCLickListener<Model> {
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
    public void loadElements(String manufacturer, String niceName, String year) {
        this.repository.loadElements(manufacturer, niceName, year);
    }

    @Override
    public Model getObject(int position) {
        if(this.submodels != null) {
            return this.submodels.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(this.submodels != null){
            return this.submodels.size();
        }
        return 0;
    }

    @Override
    public void performClick(Model object) {
        view.openModelDetails(object.getId());
    }
}
