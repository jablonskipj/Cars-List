package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.activities.DetailsActivity;
import rx_playground.com.jablonski.rxandroidplayground.contracts.SubmodelsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.presenters.SubmodelsListPresenter;
import rx_playground.com.jablonski.rxandroidplayground.repositories.SubmodelsRepository;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.SubmodelsListAdapter;

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmdelsListFragment extends BaseListFragment implements SubmodelsViewContract.View{
    private SubmodelsListPresenter presenter;
    private SubmodelsListAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        presenter = new SubmodelsListPresenter(this);
        SubmodelsRepository repository = new SubmodelsRepository(presenter);
        presenter.setRepository(repository);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("Submodels", (ArrayList<? extends Parcelable>) presenter.getElements());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if(savedInstanceState == null){
            String manufacturer = args.getString("Manufacturer");
            String name = args.getString("ModelNiceName");
            String year = args.getString("year");
            showLoadingIndicator();
            presenter.loadElements(manufacturer, name, year);
        }else{
            List<Model> models = savedInstanceState.getParcelableArrayList("Submodels");
            presenter.displayElements(models);
        }
    }

    @Override
    public void openModelDetails(String styleId) {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra("StyleId", styleId);
        getContext().startActivity(intent);
    }

    @Override
    public void showView(List<Model> elements) {
        if(this.adapter == null){
            this.adapter = new SubmodelsListAdapter(getContext(), this.presenter);
            this.adapter.setOnClickListener(this.presenter);
        }
        if(this.recyclerView.getAdapter() == null){
            this.recyclerView.setAdapter(this.adapter);
        }
        this.adapter.notifyItemRangeInserted(0, this.presenter.getCount() - 1);
        hideLoadingIndicator();
    }

}
