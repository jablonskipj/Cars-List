package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.support.v4.app.Fragment;

import rx_playground.com.jablonski.rxandroidplayground.contracts.MainViewContract;

/**
 * Created by yabol on 06.04.2017.
 */

public class CarsListFragment extends Fragment implements MainViewContract.View{
    private MainViewContract.Presenter presenter;
    @Override
    public void showView() {

    }

    public void setPresenter(MainViewContract.Presenter presenter){
        this.presenter = presenter;
    }
}
