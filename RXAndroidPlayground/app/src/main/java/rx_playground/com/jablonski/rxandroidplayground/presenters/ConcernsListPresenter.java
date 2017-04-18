package rx_playground.com.jablonski.rxandroidplayground.presenters;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ConcernsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;

/**
 * Created by yabol on 06.04.2017.
 */

public class ConcernsListPresenter implements ConcernsViewContract.Presenter<Concern>, BaseViewCotract.BaseProvider<Concern>, BaseViewCotract.BaseOnItemCLickListener<Concern>{
    private ConcernsViewContract.View view;
    private ConcernsViewContract.Repository repository;
    private List<Concern> concerns;

    public ConcernsListPresenter(ConcernsViewContract.View view){
        this.view = view;
    }
    public void setRepository(ConcernsViewContract.Repository repository){
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
