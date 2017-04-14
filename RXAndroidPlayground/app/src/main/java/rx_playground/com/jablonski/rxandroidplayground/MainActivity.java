package rx_playground.com.jablonski.rxandroidplayground;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx_playground.com.jablonski.rxandroidplayground.fragments.ConcernsListFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConcernsListFragment fragment = new ConcernsListFragment();

        manager = getSupportFragmentManager();
        startFragment(fragment);
    }

    public void startFragment(Fragment fragment){
        manager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}
