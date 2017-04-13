package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.presenters.MainViewPresenter;
import rx_playground.com.jablonski.rxandroidplayground.repositories.ConcernsRepository;
import rx_playground.com.jablonski.rxandroidplayground.repositories.ConcernsRepositoryMock;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.ConcernListAdapter;

/**
 * Created by yabol on 06.04.2017.
 */

public class CarsListFragment extends Fragment implements ViewContract.View{
    private MainViewPresenter presenter;
    private ConcernListAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(presenter == null){
            this.presenter = new MainViewPresenter(this);
            //ConcernsRepository repository = new ConcernsRepository(this.presenter);
            ConcernsRepositoryMock repository = new ConcernsRepositoryMock(presenter);
            presenter.setRepository(repository);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars_list, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadElements();
    }

    @Override
    public void showView(List<Concern> concerns) {
        if(adapter == null){
            adapter = new ConcernListAdapter(getContext(), this.presenter);
            recyclerView.setAdapter(adapter);
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    public void loadElements() {
        this.presenter.loadElemetnts("2005");
    }

}
