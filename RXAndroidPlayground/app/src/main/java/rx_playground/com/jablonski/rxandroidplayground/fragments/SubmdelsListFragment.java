package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.SubmodelsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmdelsListFragment extends Fragment implements SubmodelsViewContract.View{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void openModelDetails() {

    }

    @Override
    public void showView(List<Model> elements) {

    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }
}
