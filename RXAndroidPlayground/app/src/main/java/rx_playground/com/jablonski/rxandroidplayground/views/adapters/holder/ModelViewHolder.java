package rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 17.05.2017.
 */

public class ModelViewHolder extends BaseDetailViewHolder {
    @BindView(R.id.modelTitle)
    TextView modelTile;
    public ModelViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setUp(RowConfig config) {
        this.modelTile.setText(config.getValue("modelName"));
    }
}
