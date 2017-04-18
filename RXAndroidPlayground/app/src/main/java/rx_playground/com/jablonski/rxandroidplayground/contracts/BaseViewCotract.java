package rx_playground.com.jablonski.rxandroidplayground.contracts;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.model.Concern;

/**
 * Created by yabol on 18.04.2017.
 */

public class BaseViewCotract {
    public interface BasePresenter<T>{
        void displayElements(List<T> elements);
        List<T> getElements();
    }
    public interface BaseProvider<T>{
        T getObject(int position);
        int getCount();
    }
    public interface BaseOnItemCLickListener<T>{
        void performClick(T object);
    }
    public interface BaseView<T>{
        void showView(List<T> elements);
    }
}
