package rx_playground.com.jablonski.rxandroidplayground.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 18.04.2017.
 */

public class CarsListAdapter extends RecyclerView.Adapter<CarsListAdapter.ViewHolder> {
    private Context context;
    private BaseViewCotract.BaseProvider<Model> provider;
    private BaseViewCotract.BaseOnItemCLickListener<Model> onItemCLickListener;

    public CarsListAdapter(Context context, BaseViewCotract.BaseProvider<Model> provider){
        this.context = context;
        this.provider = provider;
    }

    public void setOnItemCLickListener(BaseViewCotract.BaseOnItemCLickListener<Model> onItemCLickListener){
        this.onItemCLickListener = onItemCLickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(this.context).inflate(R.layout.car_list_row, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder != null) {
            Model model = provider.getObject(position);
            if (model != null) {
                holder.carName.setText(model.getName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return provider.getCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.carName)
        TextView carName;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
