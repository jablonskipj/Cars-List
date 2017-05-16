package rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 15.05.2017.
 */

public class EngineViewHolder extends BaseDetailViewHolder  {
    @BindView(R.id.engineName)
    TextView engineName;
    @BindView(R.id.engineCompression)
    TextView engineCompression;
    @BindView(R.id.engineCylindersCount)
    TextView engineCylindersCount;
    @BindView(R.id.engineSize)
    TextView engineSize;
    @BindView(R.id.engineDisplacement)
    TextView engineDisplacement;
    @BindView(R.id.engineConfiguration)
    TextView engineConfiguration;
    @BindView(R.id.engineHorsePower)
    TextView engineHorsePower;
    @BindView(R.id.engineTorque)
    TextView engineTorque;

    public EngineViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setUp(RowConfig config) {

    }
}
