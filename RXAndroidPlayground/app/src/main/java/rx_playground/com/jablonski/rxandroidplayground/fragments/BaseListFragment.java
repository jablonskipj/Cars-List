package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.activities.MainActivity;
import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;

/**
 * Created by yabol on 26.04.2017.
 */

public abstract class BaseListFragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        Log.e("onCreate", this.getClass().getName());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("onAttach", this.getClass().getName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars_list, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("OnSavedInstanceState", this.getClass().getName());
    }

    protected void showLoadingIndicator(){
        this.refreshLayout.setEnabled(true);
        this.refreshLayout.setRefreshing(true);
    }

    protected void hideLoadingIndicator() {
        this.refreshLayout.setEnabled(false);
        this.refreshLayout.setRefreshing(false);
    }
}
