package rx_playground.com.jablonski.rxandroidplayground.contracts;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import rx_playground.com.jablonski.rxandroidplayground.model.Car;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

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
        void getConcerns(String year);
    }
}
