package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmdelsListFragment extends Fragment implements SubmodelsViewContract.View{
    private SubmodelsListPresenter presenter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

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
        View view = inflater.inflate(R.layout.fragment_cars_list, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if(savedInstanceState == null){
            String name = args.getString("ModelNiceName");
            String year = args.getString("year");
            presenter.loadElements(name, year);
        }else{
            //todo restore data from savedInstanceState;
        }
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
