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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.SubmodelsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.presenters.SubmodelsListPresenter;
import rx_playground.com.jablonski.rxandroidplayground.repositories.SubmodelsRepository;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.CarsListAdapter;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.SubmodelsListAdapter;

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmdelsListFragment extends BaseListFragment implements SubmodelsViewContract.View{
    private SubmodelsListPresenter presenter;
    private SubmodelsListAdapter adapter;

    /*@BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;*/

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if(savedInstanceState == null){
            String manufacturer = args.getString("Manufacturer");
            String name = args.getString("ModelNiceName");
            String year = args.getString("year");
            presenter.loadElements(manufacturer, name, year);
        }else{
            //todo restore data from savedInstanceState;
        }
    }

    @Override
    public void openModelDetails() {

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
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }
}
