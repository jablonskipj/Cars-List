package rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;
import rx_playground.com.jablonski.rxandroidplayground.model.Transmission;

/**
 * Created by yabol on 17.05.2017.
 */

public class TransmissionViewHolder extends BaseDetailViewHolder {
    private Context context;

    @BindView(R.id.transmissionName)
    TextView transmissionName;
    public TransmissionViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setUp(RowConfig config) {
        this.transmissionName.setText(this.context.getString(R.string.details_transmission_name, config.getValue(Transmission.TRANSMISSION_NAME)));
    }
}
