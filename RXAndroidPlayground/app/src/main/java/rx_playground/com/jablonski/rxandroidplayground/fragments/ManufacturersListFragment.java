package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.os.Bundle;
import android.os.Parcelable;
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
import rx_playground.com.jablonski.rxandroidplayground.contracts.ManufacturersViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;
import rx_playground.com.jablonski.rxandroidplayground.presenters.ManufacturersListPresenter;
import rx_playground.com.jablonski.rxandroidplayground.repositories.ManufacturersRepository;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.ManufacturersListAdapter;

/**
 * Created by yabol on 06.04.2017.
 */

public class ManufacturersListFragment extends Fragment implements ManufacturersViewContract.View{
    private ManufacturersListPresenter presenter;
    private ManufacturersListAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        activity = (MainActivity) getActivity();
        if(this.presenter == null){
            this.presenter = new ManufacturersListPresenter(this);
            ManufacturersRepository repository = new ManufacturersRepository(this.presenter);
            //ManufacturersRepositoryMock repository = new ManufacturersRepositoryMock(presenter);
            this.presenter.setRepository(repository);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars_list, container, false);
        ButterKnife.bind(this, view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    public void showLoadingIndicator(){
        this.refreshLayout.setEnabled(true);
        this.refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoadingIndicator() {
        this.refreshLayout.setEnabled(false);
        this.refreshLayout.setRefreshing(false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.getParcelableArrayList("Concerns") != null){
            presenter.displayElements(savedInstanceState.<Manufacturer>getParcelableArrayList("Concerns"));
        }else {
            presenter.loadElements("2017");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("Concerns", (ArrayList<? extends Parcelable>) presenter.getElements());
    }

    @Override
    public void showView(List<Manufacturer> manufacturers) {
        if(this.adapter == null){
            this.adapter = new ManufacturersListAdapter(getContext(), this.presenter);
            this.adapter.setOnClickListener(this.presenter);
        }
        if(this.recyclerView.getAdapter() == null){
            this.recyclerView.setAdapter(this.adapter);
        }
        this.adapter.notifyDataSetChanged();

    }



    @Override
    public void showListFragment(List<Model> models) {
        ModelsListFragment fragment = new ModelsListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("Cars", (ArrayList<? extends Parcelable>) models);
        fragment.setArguments(bundle);
        activity.startFragment(fragment, true);
    }

}
