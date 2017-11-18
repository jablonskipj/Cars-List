package rx_playground.com.jablonski.rxandroidplayground.modellist;

import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 18.04.2017.
 */

public class ModelsViewContract {
    public interface View extends BaseViewCotract.BaseView<Model> {
        void openSubmodelsList(String modelNiceName);
    }


}
