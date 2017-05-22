package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.activities.MainActivity;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ModelsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.presenters.ModelsListPresenter;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.CarsListAdapter;

/**
 * Created by yabol on 14.04.2017.
 */

public class ModelsListFragment extends BaseListFragment implements ModelsViewContract.View{
    private ModelsListPresenter presenter;
    private CarsListAdapter adapter;
    private ArrayList<Model> models;
    private String manufacturer;


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


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        proceedBundle(savedInstanceState);
        this.presenter.displayElements(this.models);
    }

    private void proceedBundle(@Nullable Bundle bundle){
        if(bundle != null) {
            this.models = bundle.getParcelableArrayList("Cars");
            this.manufacturer = bundle.getString("Manufacturer");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(outState == null){
            outState = new Bundle();
        }
        outState.putParcelableArrayList("Cars", this.models);
        outState.putString("Manufacturer", this.manufacturer);
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
        this.adapter.notifyItemRangeInserted(0, this.presenter.getCount() - 1);
    }

    @Override
    public void openSubmodelsList(String modelNiceName) {
        SubmdelsListFragment fragment = new SubmdelsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Manufacturer", this.manufacturer);
        bundle.putString("ModelNiceName", modelNiceName);
        bundle.putString("year", "2017");
        fragment.setArguments(bundle);
        activity.startFragment(fragment, true);
    }
}
