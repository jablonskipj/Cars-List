package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.ImageLink;
import rx_playground.com.jablonski.rxandroidplayground.model.ImageSource;

/**
 * Created by yabol on 27.05.2017.
 */

public class ImageFragment extends Fragment {
    private ImageSource source;

    @BindView(R.id.carImage)
    ImageView image;

    public static ImageFragment getInstance(ImageSource image){
        Bundle extras = new Bundle();
        extras.putParcelable("Image", image);
        ImageFragment framgnet = new ImageFragment();
        framgnet.setArguments(extras);
        return framgnet;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null){
            this.source = args.getParcelable("Image");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_page_fragment, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Picasso.with(getContext()).load(this.source.getImageLink().getHref()).fit().centerCrop().into(this.image);
    }
}
