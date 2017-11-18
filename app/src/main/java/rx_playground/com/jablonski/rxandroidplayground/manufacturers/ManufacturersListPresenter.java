package rx_playground.com.jablonski.rxandroidplayground.manufacturers;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.manufacturers.ManufacturersViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;

/**
 * Created by yabol on 06.04.2017.
 */

public class ManufacturersListPresenter implements ManufacturersViewContract.Presenter, BaseViewCotract.BaseProvider<Manufacturer>, BaseViewCotract.BaseOnItemCLickListener<Manufacturer>{
    private ManufacturersViewContract.View view;
    private ManufacturersViewContract.Repository repository;
    private List<Manufacturer> manufacturers;

    public ManufacturersListPresenter(ManufacturersViewContract.View view){
        this.view = view;
    }
    public void setRepository(ManufacturersViewContract.Repository repository){
        this.repository = repository;
    }
    @Override
    public void loadElements(String year) {
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
        view.showListFragment(item.getName(), item.getModels());
    }
}
