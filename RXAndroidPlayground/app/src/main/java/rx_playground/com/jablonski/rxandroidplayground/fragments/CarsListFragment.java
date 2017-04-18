package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.CarsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Car;
import rx_playground.com.jablonski.rxandroidplayground.presenters.CarsListPresenter;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.CarsListAdapter;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.ConcernListAdapter;

/**
 * Created by yabol on 14.04.2017.
 */

public class CarsListFragment extends Fragment implements CarsViewContract.View<Car>{
    CarsListPresenter presenter;
    CarsListAdapter adapter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

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

        presenter = new CarsListPresenter(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(cars != null){
            presenter.displayElements(cars);
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

    @Override
    public void openDetails(Car car) {
        //todo implement open details and load images, informations and so on
    }

    @Override
    public void showView(List<Car> elements) {
        if(this.adapter == null){
            this.adapter = new CarsListAdapter(getContext(), this.presenter);
            this.adapter.setOnItemCLickListener(this.presenter);
        }
        if(this.recyclerView.getAdapter() == null){
            this.recyclerView.setAdapter(this.adapter);
        }
        this.adapter.notifyDataSetChanged();
    }
}
