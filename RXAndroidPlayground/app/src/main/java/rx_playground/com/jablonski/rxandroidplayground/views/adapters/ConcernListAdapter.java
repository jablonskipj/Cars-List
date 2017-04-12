package rx_playground.com.jablonski.rxandroidplayground.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;

/**
 * Created by yabol on 12.04.2017.
 */

public class ConcernListAdapter extends RecyclerView.Adapter<ConcernListAdapter.ViewHolder> {
    private ViewContract.Provider<Concern> provider;
    private Context context;
    public ConcernListAdapter(Context context, ViewContract.Provider<Concern> provider){
        this.provider = provider;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.concern_list_row, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder != null){
            Concern concern = provider.getObject(position);
            if(concern != null){
                holder.concernName.setText(concern.getNiceName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return provider.getCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.concernLogo)
        ImageView concernLogo;

        @BindView(R.id.concernName)
        TextView concernName;
        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
