package rx_playground.com.jablonski.rxandroidplayground.manufacturers;

import android.content.Context;
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
import rx_playground.com.jablonski.rxandroidplayground.activities.MainActivity;
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseListFragment;
import rx_playground.com.jablonski.rxandroidplayground.modellist.ModelsListFragment;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.ManufacturersListAdapter;

/**
 * Created by yabol on 06.04.2017.
 */

public class ManufacturersListFragment extends BaseListFragment implements ManufacturersViewContract.View{
    private static final String EXTRA_CONCERNS = "Concerns";
    private ManufacturersListPresenter presenter;
    private ManufacturersListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        if(this.presenter == null){
            this.presenter = new ManufacturersListPresenter(this);
            ManufacturersRepositoryMock repository = new ManufacturersRepositoryMock(this.presenter);
            this.presenter.setRepository(repository);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        activity.setTitle(getString(R.string.manufacturers_fragment_title));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
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
        if(instanceState != null && instanceState.getParcelableArrayList(EXTRA_CONCERNS) != null){
            presenter.displayElements(instanceState.<Manufacturer>getParcelableArrayList(EXTRA_CONCERNS));
        }else {
            showLoadingIndicator();
            presenter.loadElements("2017");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_CONCERNS, (ArrayList<? extends Parcelable>) presenter.getElements());
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
        hideLoadingIndicator();
    }



    @Override
    public void showListFragment(String manufacturer, List<Model> models) {
        activity.startFragment(ModelsListFragment.createInstance(manufacturer, models), false);
    }

}
