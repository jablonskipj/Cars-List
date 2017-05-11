package rx_playground.com.jablonski.rxandroidplayground.activities;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.fragments.ManufacturersListFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    ActionBar actionBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();

        if(savedInstanceState == null) {
            ManufacturersListFragment fragment = new ManufacturersListFragment();

            manager = getSupportFragmentManager();
            startFragment(fragment, true);

        }

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void startFragment(Fragment fragment, boolean replace) {
        FragmentTransaction transaction = manager.beginTransaction();
        if(replace){
            transaction.replace(R.id.fragmentContainer, fragment).addToBackStack(null);
        }else{
            transaction.add(R.id.fragmentContainer, fragment).addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();

        Log.e("MainActivity", "BackPress fragments count: " + manager.getBackStackEntryCount());

        if(manager.getBackStackEntryCount() > 0){
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    public void onBackPressed() {
        int fragmentsCount = manager.getBackStackEntryCount();

        Log.e("MainActivity", "BackPress fragments count: " + fragmentsCount);
        if(fragmentsCount == 2){
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
        }

        if (fragmentsCount == 1) {
            finish();
        } else {
            manager.popBackStack();
        }

    }
}
