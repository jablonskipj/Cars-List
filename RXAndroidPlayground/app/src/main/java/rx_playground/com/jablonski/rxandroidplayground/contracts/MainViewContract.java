package rx_playground.com.jablonski.rxandroidplayground.contracts;

/**
 * Created by yabol on 06.04.2017.
 */

public class MainViewContract {

    public interface View{
        void showView();
    }

    public interface Presenter{
        void loadElemetnts();
    }
}
