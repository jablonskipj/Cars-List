package rx_playground.com.jablonski.rxandroidplayground.modellist;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseListFragment;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.submodels.SubmdelsListFragment;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.CarsListAdapter;

/**
 * Created by yabol on 14.04.2017.
 */

public class ModelsListFragment extends BaseListFragment implements ModelsViewContract.View{
    private static final String EXTRA_CARS = "Cars";
    private static final String EXTRA_MANUFACTURER = "Manufacturer";
    private ModelsListPresenter presenter;
    private CarsListAdapter adapter;
    private ArrayList<Model> models;
    private String manufacturer;


    public static ModelsListFragment createInstance(String manufacturer, List<Model> models){
        ModelsListFragment fragment = new ModelsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_MANUFACTURER, manufacturer);
        bundle.putParcelableArrayList(EXTRA_CARS, (ArrayList<? extends Parcelable>) models);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        proceedBundle(bundle);
        if(savedInstanceState != null){
            proceedBundle(savedInstanceState);
        }

        this.presenter = new ModelsListPresenter(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.refreshLayout.setEnabled(false);
        this.refreshLayout.setRefreshing(false);
        this.activity.setTitle(getString(R.string.models_fragment_title));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        processInstanceState(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        processInstanceState(savedInstanceState);
    }

    private void processInstanceState(Bundle instanceState){
        proceedBundle(instanceState);
        this.presenter.displayElements(this.models);
    }
    private void proceedBundle(@Nullable Bundle bundle){
        if(bundle != null) {
            this.models = bundle.getParcelableArrayList(EXTRA_CARS);
            this.manufacturer = bundle.getString(EXTRA_MANUFACTURER);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(outState == null){
            outState = new Bundle();
        }
        outState.putParcelableArrayList(EXTRA_CARS, this.models);
        outState.putString(EXTRA_MANUFACTURER, this.manufacturer);
    }


    @Override
    public void showView(List<Model> elements) {
        if(this.adapter == null){
            this.adapter = new CarsListAdapter(getContext(), this.presenter);
            this.adapter.setOnItemCLickListener(this.presenter);
        }
        if(this.recyclerView.getAdapter() == null){
            this.recyclerView.setAdapter(this.adapter);
        }
        if(presenter.getCount() > 0) {
            this.adapter.notifyItemRangeInserted(0, this.presenter.getCount() - 1);
        }
    }

    @Override
    public void openSubmodelsList(String modelNiceName) {
        activity.startFragment(SubmdelsListFragment.createInstance(manufacturer, modelNiceName, "2017"), true);
    }
}
