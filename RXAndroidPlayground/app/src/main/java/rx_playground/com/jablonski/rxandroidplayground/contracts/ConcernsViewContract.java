package rx_playground.com.jablonski.rxandroidplayground.contracts;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.model.Car;

/**
 * Created by yabol on 06.04.2017.
 */

public class ConcernsViewContract {

    public interface View<T> extends BaseViewCotract.BaseView<T>{
        void loadElements();
        void showListFragment(List<Car> elements);
    }

    public interface Presenter<T> extends BaseViewCotract.BasePresenter<T>{
        void loadElemetnts(String year);

    }
    public interface Repository{
        void getManufacturers(String year);
    }
}
