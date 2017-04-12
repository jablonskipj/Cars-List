package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ViewContract;
import rx_playground.com.jablonski.rxandroidplayground.presenters.MainViewPresenter;
import rx_playground.com.jablonski.rxandroidplayground.repositories.ConcernsRepository;

/**
 * Created by yabol on 06.04.2017.
 */

public class CarsListFragment extends Fragment implements ViewContract.View{
    private ViewContract.Presenter presenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(presenter == null){
            ConcernsRepository repository = new ConcernsRepository();
            this.presenter = new MainViewPresenter(this, repository);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars_list, null);
        ButterKnife.bind(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showView();
    }

    @Override
    public void showView() {
        this.presenter.loadElemetnts("2005");
    }

}
