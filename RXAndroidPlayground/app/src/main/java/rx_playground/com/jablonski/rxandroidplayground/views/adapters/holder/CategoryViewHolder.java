package rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 18.05.2017.
 */

public class CategoryViewHolder extends BaseDetailViewHolder {
    private Context context;

    @BindView(R.id.vehicleSize)
    TextView vehicleSize;
    @BindView(R.id.primaryBodyType)
    TextView primaryBodyType;
    @BindView(R.id.vehicleStyle)
    TextView vehicleStyle;
    @BindView(R.id.vehicleType)
    TextView vehicleType;

    public CategoryViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;

    }

    @Override
    public void setUp(RowConfig config) {
        this.vehicleSize.setText(this.context.getString(R.string.details_vehicle_size, config.getValue("vehicleSize")));
        this.primaryBodyType.setText(this.context.getString(R.string.details_vehicle_primary_body_type, config.getValue("primaryBodyType")));
        this.vehicleStyle.setText(this.context.getString(R.string.details_vehicle_style, config.getValue("vehicleStyle")));
        this.vehicleType.setText(this.context.getString(R.string.details_vehicle_type, config.getValue("vehicleType")));
    }
}
