package rx_playground.com.jablonski.rxandroidplayground;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx_playground.com.jablonski.rxandroidplayground.fragments.ConcernsListFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            ConcernsListFragment fragment = new ConcernsListFragment();

            manager = getSupportFragmentManager();
            startFragment(fragment, true);
        }

    }


    public void startFragment(Fragment fragment, boolean replace) {
        FragmentTransaction transaction = manager.beginTransaction();
        if(replace){
            transaction.replace(R.id.fragmentContainer, fragment);
        }else{
            transaction.add(R.id.fragmentContainer, fragment);
        }
        transaction.commit();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }
}
