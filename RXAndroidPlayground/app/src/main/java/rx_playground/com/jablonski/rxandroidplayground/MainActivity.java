package rx_playground.com.jablonski.rxandroidplayground;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx_playground.com.jablonski.rxandroidplayground.fragments.CarsListFragment;
import rx_playground.com.jablonski.rxandroidplayground.presenters.MainViewPresenter;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarsListFragment fragment = new CarsListFragment();

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(fragment, null).commit();
    }
}
