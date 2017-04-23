package rx_playground.com.jablonski.rxandroidplayground.contracts;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;

/**
 * Created by yabol on 06.04.2017.
 */

public class ManufacturersViewContract {

    public interface View extends BaseViewCotract.BaseView<Manufacturer>{
        void showListFragment(List<Model> models);
    }
    public interface Presenter extends BaseViewCotract.BasePresenter<Manufacturer>{
        void loadElements(String year);
    }
    public interface Repository{
        void getManufacturers(String year);
    }

}
