package rx_playground.com.jablonski.rxandroidplayground.contracts;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.model.Car;

/**
 * Created by yabol on 18.04.2017.
 */

public class CarsViewContract {
    public interface View<T> extends BaseViewCotract.BaseView<T>{
        void openDetails(T object);
    }

}
