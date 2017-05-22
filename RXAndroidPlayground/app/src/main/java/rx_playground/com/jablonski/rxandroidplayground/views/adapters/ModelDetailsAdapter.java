package rx_playground.com.jablonski.rxandroidplayground.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ModelDetailsContract;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder.BaseDetailViewHolder;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder.CategoryViewHolder;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder.DetailHolder;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder.EngineViewHolder;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder.ModelViewHolder;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.holder.TransmissionViewHolder;

/**
 * Created by yabol on 15.05.2017.
 */

public class ModelDetailsAdapter extends RecyclerView.Adapter<BaseDetailViewHolder> {
    private ModelDetailsContract.Provider provider;
    private Context context;
    private LayoutInflater inflater;

    public ModelDetailsAdapter(Context context, ModelDetailsContract.Provider provider){
        this.provider = provider;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public BaseDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseDetailViewHolder holder = null;
        View view = null;
        switch (viewType){
            case 0:
                view = this.inflater.inflate(R.layout.model_list_row, null);
                holder = new ModelViewHolder(view, this.context);
                break;
            case 1:
                view = this.inflater.inflate(R.layout.category_list_row, null);
                holder = new CategoryViewHolder(view, this.context);
                break;
            case 2:
                view = this.inflater.inflate(R.layout.engine_list_row, null);
                holder = new EngineViewHolder(view, this.context);
                break;
            case 3:
                view = this.inflater.inflate(R.layout.transmission_list_row, null);
                holder = new TransmissionViewHolder(view, this.context);
                break;
            default:
                //this should not appear
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseDetailViewHolder holder, int position) {
        RowConfig config = this.provider.getObject(position);

        holder.setUp(config);

    }

    @Override
    public int getItemViewType(int position) {
        return this.provider.getPositionType(position);
    }

    @Override
    public int getItemCount() {
        return this.provider.getCount();
    }
}
