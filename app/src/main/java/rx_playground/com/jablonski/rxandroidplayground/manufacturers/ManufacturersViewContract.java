package rx_playground.com.jablonski.rxandroidplayground.manufacturers;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;

/**
 * Created by yabol on 06.04.2017.
 */

public interface ManufacturersViewContract {

    interface View extends BaseViewCotract.BaseView<Manufacturer> {
        void showListFragment(String manufacturer, List<Model> models);
    }

    interface Presenter extends BaseViewCotract.BasePresenter<Manufacturer>{
        void loadElements(String year);
    }

    interface Repository{
        void getManufacturers(String year);
    }

}
