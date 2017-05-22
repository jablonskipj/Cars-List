package rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 17.05.2017.
 */

public class ModelViewHolder extends BaseDetailViewHolder {
    private Context context;

    @BindView(R.id.modelTitle)
    TextView modelTile;
    @BindView(R.id.numberOfDoors)
    TextView numberOfDoors;
    @BindView(R.id.drivenWheels)
    TextView drivenWheels;
    public ModelViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    @Override
    public void setUp(RowConfig config) {
        this.modelTile.setText(config.getValue(Model.MODEL_NAME));
        this.numberOfDoors.setText(context.getString(R.string.details_vehicle_doors_number, config.getValue(Model.MODEL_NUMBER_OF_DOORS)));
        this.drivenWheels.setText(context.getString(R.string.details_vehicle_driven_wheels, config.getValue(Model.MODEL_DRIVEN_WHEELS)));
    }
}
