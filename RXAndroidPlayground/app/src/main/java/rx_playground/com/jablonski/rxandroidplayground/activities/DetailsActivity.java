package rx_playground.com.jablonski.rxandroidplayground.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import rx_playground.com.jablonski.rxandroidplayground.R;

/**
 * Created by yabol on 09.05.2017.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Log.e("DetailsActivity", intent.getStringExtra("StyleId"));
    }

}
