package rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 26.04.2017.
 */

public class SubmodelsListAdapter extends RecyclerView.Adapter<SubmodelsListAdapter.ViewHolder> {
    private Context context;
    private BaseViewCotract.BaseProvider<Model> provider;
    private BaseViewCotract.BaseOnItemCLickListener<Model> onClickListener;

    public SubmodelsListAdapter(Context context, BaseViewCotract.BaseProvider<Model> provider){
        this.context = context;
        this.provider = provider;
    }

    public void setOnClickListener(BaseViewCotract.BaseOnItemCLickListener<Model> listener){
        this.onClickListener = listener;
    }
    @Override
    public SubmodelsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.submodel_list_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubmodelsListAdapter.ViewHolder holder, int position) {

        final Model model = provider.getObject(position);
        if(model != null){
            holder.title.setText(model.getSubmodelName());
            holder.description.setText(model.getName());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.performClick(model);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return provider.getCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.submodel_full_name)
        TextView title;
        @BindView(R.id.submodel_short_name)
        TextView description;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }
    }
}
