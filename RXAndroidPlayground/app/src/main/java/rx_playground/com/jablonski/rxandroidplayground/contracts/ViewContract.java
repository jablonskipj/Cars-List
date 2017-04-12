package rx_playground.com.jablonski.rxandroidplayground.contracts;

import java.util.List;

import io.reactivex.Observable;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

/**
 * Created by yabol on 06.04.2017.
 */

public class ViewContract {

    public interface View{
        void showView();
    }

    public interface Presenter{
        void loadElemetnts(String year);
    }
    public interface Repository{
        Observable<Result> getConcerns(String year);
    }
    public interface Provider<T>{
        int getCount();
        int getId(int position);
        T getObject(int position);
    }
}
