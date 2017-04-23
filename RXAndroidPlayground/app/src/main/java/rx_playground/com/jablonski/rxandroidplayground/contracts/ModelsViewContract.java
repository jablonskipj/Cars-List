package rx_playground.com.jablonski.rxandroidplayground.contracts;

/**
 * Created by yabol on 18.04.2017.
 */

public class ModelsViewContract {
    public interface View<T> extends BaseViewCotract.BaseView<T>{
        void openSubmodelsList(String modelNiceName);
    }


}
