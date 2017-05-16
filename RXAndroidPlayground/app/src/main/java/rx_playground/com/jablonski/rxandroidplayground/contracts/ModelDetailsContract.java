package rx_playground.com.jablonski.rxandroidplayground.contracts;

import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 15.05.2017.
 */

public class ModelDetailsContract {
    public interface Provider{
        RowConfig getObject(int position);
        int getCount();
        int getPositionType(int position);
    }

    public interface Presenter{
        void displayModel(Model model);
        Model getModel();
    }

    public interface View{
        void displayModelDetails();
    }
}
