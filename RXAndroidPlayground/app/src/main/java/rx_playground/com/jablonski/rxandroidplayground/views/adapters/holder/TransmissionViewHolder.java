package rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 17.05.2017.
 */

public class TransmissionViewHolder extends BaseDetailViewHolder {
    private Context context;

    @BindView(R.id.transmissionType)
    TextView transmissionType;
    public TransmissionViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
    }

    @Override
    public void setUp(RowConfig config) {
        this.transmissionType.setText(this.context.getString(R.string.details_transmission_type, config.getValue("transmissionType")));
    }
}
