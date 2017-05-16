package rx_playground.com.jablonski.rxandroidplayground.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import rx_playground.com.jablonski.rxandroidplayground.contracts.ModelDetailsContract;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder.BaseDetailViewHolder;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder.DetailHolder;

/**
 * Created by yabol on 15.05.2017.
 */

public class ModelDetailsAdapter extends RecyclerView.Adapter<BaseDetailViewHolder> {
    ModelDetailsContract.Provider provider;

    public ModelDetailsAdapter(ModelDetailsContract.Provider provider){
        this.provider = provider;
    }
    @Override
    public BaseDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseDetailViewHolder holder, int position) {
        RowConfig config = provider.getObject(position);

        holder.setUp(config);

    }

    @Override
    public int getItemViewType(int position) {
        return provider.getPositionType(position);
    }

    @Override
    public int getItemCount() {
        return provider.getCount();
    }
}
