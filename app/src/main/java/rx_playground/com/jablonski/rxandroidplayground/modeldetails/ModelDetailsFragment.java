package rx_playground.com.jablonski.rxandroidplayground.modeldetails;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Photo;
import rx_playground.com.jablonski.rxandroidplayground.utils.ResourcesUtils;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.ModelDetailsAdapter;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.viewpager.ImagesPagerAdapter;

/**
 * Created by yabol on 19.05.2017.
 */

public class ModelDetailsFragment extends Fragment implements ModelDetailsContract.View {
    public static final String EXTRA_MODEL_ID = "modelId";
    private static final String EXTRA_MODEL = "model";
    private static final String EXTRA_IMAGE = "imageSource";
    private static final String EXTRA_CURRENT_IMAGE = "displayedImage";
    private ModelDetailsAdapter adapter;
    private ModelDetailsPresenter presenter;
    private ImagesPagerAdapter viewPagerAdapter;
    private String modelId;


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.imagesPager)
    ViewPager imagePager;
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static ModelDetailsFragment createInstance(String modelId){
        ModelDetailsFragment framgnet = new ModelDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ModelDetailsFragment.EXTRA_MODEL_ID, modelId);
        framgnet.setArguments(args);

        return framgnet;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.presenter = new ModelDetailsPresenter(this);
        ModelDetailsRepository repository = new ModelDetailsRepository(this.presenter);
        //ModelDetailsRepositoryMock repository = new ModelDetailsRepositoryMock(this.presenter);
        this.presenter.setRepository(repository);

        Bundle args = getArguments();
        if (args != null) {
            this.modelId = args.getString(EXTRA_MODEL_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_model_details, container, false);

        ButterKnife.bind(this, view);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        this.recyclerView.setLayoutManager(manager);

        setToolbar();

        return view;
    }

    private void setToolbar() {
        Context context = getContext();

        int primaryDark = ResourcesUtils.getColor(context, R.color.colorPrimaryDark);;
        int primary = ResourcesUtils.getColor(context, R.color.colorPrimary);
        int expandedTextColor = ResourcesUtils.getColor(context, android.R.color.transparent);
        int collapsedTextColor = ResourcesUtils.getColor(context, R.color.white);

        this.toolbarLayout.setTitle(ResourcesUtils.getText(context, R.string.details_title));
        this.toolbarLayout.setExpandedTitleColor(expandedTextColor);
        this.toolbarLayout.setContentScrimColor(primary);
        this.toolbarLayout.setStatusBarScrimColor(primaryDark);
        this.toolbarLayout.setCollapsedTitleTextColor(collapsedTextColor);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
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
        this.presenter.loadModelData(this.modelId);
        if (instanceState != null) {
            this.presenter.displayModel((Model) instanceState.getParcelable(EXTRA_MODEL));
            this.presenter.displayPhotos((Photo) instanceState.getParcelable(EXTRA_IMAGE));
            this.imagePager.setCurrentItem(instanceState.getInt(EXTRA_CURRENT_IMAGE));
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState != null) {
            outState.putParcelable(EXTRA_MODEL, this.presenter.getModel());
            outState.putParcelable(EXTRA_IMAGE, this.presenter.getPhoto());
            outState.putInt(EXTRA_CURRENT_IMAGE, imagePager.getCurrentItem());
        }
    }

    @Override
    public void displayModelDetails() {
        if (this.adapter == null) {
            this.adapter = new ModelDetailsAdapter(getContext(), this.presenter);
        }
        if (this.recyclerView.getAdapter() == null) {
            this.recyclerView.setAdapter(this.adapter);
        }
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void displayPhotos() {
        if (this.viewPagerAdapter == null) {
            this.viewPagerAdapter = new ImagesPagerAdapter(getFragmentManager(), this.presenter);
            this.imagePager.setAdapter(this.viewPagerAdapter);
        }
        this.viewPagerAdapter.notifyDataSetChanged();
    }
}
