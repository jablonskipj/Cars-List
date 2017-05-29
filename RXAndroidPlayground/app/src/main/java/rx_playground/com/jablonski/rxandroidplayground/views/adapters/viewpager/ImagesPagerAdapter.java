package rx_playground.com.jablonski.rxandroidplayground.views.adapters.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import rx_playground.com.jablonski.rxandroidplayground.contracts.ModelDetailsContract;
import rx_playground.com.jablonski.rxandroidplayground.fragments.ImageFragment;

/**
 * Created by yabol on 27.05.2017.
 */

public class ImagesPagerAdapter extends FragmentStatePagerAdapter {
    private ModelDetailsContract.ImagesProvider provider;


    public ImagesPagerAdapter(FragmentManager fm, ModelDetailsContract.ImagesProvider provider) {
        super(fm);
        this.provider = provider;
    }

    @Override
    public Fragment getItem(int position) {
        if(provider != null){
            return ImageFragment.getInstance(this.provider.getImage(position));
        }
        return null;
    }

    @Override
    public int getCount() {
        if(this.provider != null){
            return this.provider.getPhotosCount();
        }
        return 0;
    }
}
