package rx_playground.com.jablonski.rxandroidplayground.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.fragments.ModelDetailsFragment;

/**
 * Created by yabol on 09.05.2017.
 */

public class DetailsActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Log.e("DetailsActivity", intent.getStringExtra("StyleId"));

        ModelDetailsFragment framgnet = new ModelDetailsFragment();
        Bundle args = new Bundle();
        args.putString("modelId", intent.getStringExtra("StyleId"));
        framgnet.setArguments(args);

        showFragment(framgnet);

        showBackButton();
    }

    private void showFragment(Fragment fragment){
        this.manager.beginTransaction().add(R.id.fragmentContainer, fragment, null).commitAllowingStateLoss();
    }

    private void showBackButton() {
        this.actionBar.setDisplayShowHomeEnabled(true);
        this.actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
