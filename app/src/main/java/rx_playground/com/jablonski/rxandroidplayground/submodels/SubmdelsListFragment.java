package rx_playground.com.jablonski.rxandroidplayground.submodels;

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

import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.activities.DetailsActivity;
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseListFragment;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.SubmodelsListAdapter;

/**
 * Created by yabol on 23.04.2017.
 */

public class SubmdelsListFragment extends BaseListFragment implements SubmodelsViewContract.View{
    private static final String EXTRA_SUBMODELS = "Submodels";
    private static final String EXTRA_MANUFACTURER = "Manufacturer";
    private static final String EXTRA_MODEL_NICE_NAME = "ModelNiceName";
    private static final String EXTRA_YEAR = "year";
    private SubmodelsListPresenter presenter;
    private SubmodelsListAdapter adapter;

    public static SubmdelsListFragment createInstance(String manufacturer, String modelNiceName, String year){
        SubmdelsListFragment fragment = new SubmdelsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_MANUFACTURER, manufacturer);
        bundle.putString(EXTRA_MODEL_NICE_NAME, modelNiceName);
        bundle.putString(EXTRA_YEAR, year);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new SubmodelsListPresenter(this);
        SubmodelsRepository repository = new SubmodelsRepository(presenter);
        //SubmodelReposioryMock repository = new SubmodelReposioryMock(presenter);
        presenter.setRepository(repository);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        this.activity.setTitle(R.string.models_fragment_title);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_SUBMODELS, (ArrayList<? extends Parcelable>) presenter.getElements());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if(savedInstanceState == null){
            String manufacturer = args.getString(EXTRA_MANUFACTURER);
            String name = args.getString(EXTRA_MODEL_NICE_NAME);
            String year = args.getString(EXTRA_YEAR);
            showLoadingIndicator();
            presenter.loadElements(manufacturer, name, year);
        }else{
            List<Model> models = savedInstanceState.getParcelableArrayList(EXTRA_SUBMODELS);
            presenter.displayElements(models);
        }
    }

    @Override
    public void openModelDetails(String styleId) {
        getContext().startActivity(DetailsActivity.createDeafaultIntent(getContext(), styleId));
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
