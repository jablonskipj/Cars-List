package rx_playground.com.jablonski.rxandroidplayground.presenters;

import rx_playground.com.jablonski.rxandroidplayground.contracts.MainViewContract;

/**
 * Created by yabol on 06.04.2017.
 */

public class MainViewPresenter implements MainViewContract.Presenter{
    MainViewContract.View view;

    public MainViewPresenter(MainViewContract.View view){
        this.view = view;
    }
    @Override
    public void loadElemetnts() {

    }
}
