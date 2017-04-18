package rx_playground.com.jablonski.rxandroidplayground.presenters;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ConcernsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;

/**
 * Created by yabol on 06.04.2017.
 */

public class ConcernsListPresenter implements ConcernsViewContract.Presenter<Manufacturer>, BaseViewCotract.BaseProvider<Manufacturer>, BaseViewCotract.BaseOnItemCLickListener<Manufacturer>{
    private ConcernsViewContract.View view;
    private ConcernsViewContract.Repository repository;
    private List<Manufacturer> manufacturers;

    public ConcernsListPresenter(ConcernsViewContract.View view){
        this.view = view;
    }
    public void setRepository(ConcernsViewContract.Repository repository){
        this.repository = repository;
    }
    @Override
    public void loadElemetnts(String year) {
        if(this.repository != null) {
            this.repository.getManufacturers(year);
        }
    }

    @Override
    public void displayElements(List<Manufacturer> elements) {
        this.manufacturers = elements;
        this.view.showView(elements);
    }

    @Override
    public List<Manufacturer> getElements() {
        return manufacturers;
    }

    @Override
    public int getCount() {
        if(this.manufacturers != null)
            return this.manufacturers.size();
        else
            return 0;
    }


    public Manufacturer getObject(int position) {
        if(this.manufacturers != null)
            return this.manufacturers.get(position);
        return null;
    }

    @Override
    public void performClick(Manufacturer item) {
        view.showListFragment(item.getModels());
    }
}
