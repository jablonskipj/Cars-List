package rx_playground.com.jablonski.rxandroidplayground.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.modeldetails.ModelDetailsFragment;

/**
 * Created by yabol on 09.05.2017.
 */

public class DetailsActivity extends AppCompatActivity {
    private static final String EXTRA_STYLE_ID = "StyleId";
    FragmentManager manager;

    public static Intent createDeafaultIntent(Context context, String styleId){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_STYLE_ID, styleId);
        return intent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Intent intent = getIntent();
        String styleId = intent.getStringExtra(EXTRA_STYLE_ID);


        if(styleId != null && savedInstanceState == null) {
            Log.e("DetailsActivity", styleId);
            this.manager = getSupportFragmentManager();

            showFragment(ModelDetailsFragment.createInstance(styleId));
        }

    }

    private void showFragment(Fragment fragment){
        this.manager.beginTransaction().add(R.id.fragmentContainer, fragment, null).commitAllowingStateLoss();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
