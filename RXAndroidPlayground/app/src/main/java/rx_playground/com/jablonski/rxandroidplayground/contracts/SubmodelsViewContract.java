package rx_playground.com.jablonski.rxandroidplayground.contracts;

import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmodelsViewContract {
    public interface View extends BaseViewCotract.BaseView<Model>{
        void openModelDetails(String styleId);
    }
    public interface Presenter extends BaseViewCotract.BasePresenter<Model>{
        void loadElements(String manufacturer, String niceName, String year);
    }
    public interface Repository{
        void loadElements(String manufacturer, String modelNiceName, String year);
    }
}
