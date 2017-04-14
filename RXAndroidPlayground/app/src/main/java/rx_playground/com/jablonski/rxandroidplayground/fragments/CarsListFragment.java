package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.model.Car;

/**
 * Created by yabol on 14.04.2017.
 */

public class CarsListFragment extends Fragment{

    ArrayList<Car> cars;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        setRetainInstance(true);

        proceedBundle(bundle);
        if(savedInstanceState != null){
            this.cars = savedInstanceState.getParcelableArrayList("Cars");
        }
    }

    private void proceedBundle(@Nullable Bundle bundle){
        if(bundle != null) {
            this.cars = bundle.getParcelableArrayList("Cars");
            if(this.cars != null) {
                Log.e("CarsListFragment", "Cars list size = " + this.cars.size());
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(outState == null){
            outState = new Bundle();
        }
        outState.putParcelableArrayList("Cars", this.cars);
    }
}
