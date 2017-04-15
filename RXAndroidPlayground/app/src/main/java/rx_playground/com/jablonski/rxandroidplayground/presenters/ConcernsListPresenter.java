package rx_playground.com.jablonski.rxandroidplayground.presenters;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.ViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;

/**
 * Created by yabol on 06.04.2017.
 */

public class ConcernsListPresenter implements ViewContract.Presenter<Concern>, ViewContract.Provider<Concern>, ViewContract.ListItemClickListener<Concern>{
    private ViewContract.View view;
    private ViewContract.Repository repository;
    private List<Concern> concerns;

    public ConcernsListPresenter(ViewContract.View view){
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
    public List<Concern> getElements() {
        return concerns;
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

    @Override
    public void performClick(Concern item) {
        view.showListFragment(item.getModels());
    }
}
