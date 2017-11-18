package rx_playground.com.jablonski.rxandroidplayground.submodels;

import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 23.04.2017.
 */

public interface SubmodelsViewContract {
    interface View extends BaseViewCotract.BaseView<Model> {
        void openModelDetails(String styleId);
    }

    interface Presenter extends BaseViewCotract.BasePresenter<Model>{
        void loadElements(String manufacturer, String niceName, String year);
    }

    interface Repository{
        void loadElements(String manufacturer, String modelNiceName, String year);
    }
}
