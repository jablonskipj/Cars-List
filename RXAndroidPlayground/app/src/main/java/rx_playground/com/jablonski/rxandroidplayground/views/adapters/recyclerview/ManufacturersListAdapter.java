package rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer;
import rx_playground.com.jablonski.rxandroidplayground.utils.images.ResourcesUtils;

/**
 * Created by yabol on 12.04.2017.
 */

public class ManufacturersListAdapter extends RecyclerView.Adapter<ManufacturersListAdapter.ViewHolder> {
    private BaseViewCotract.BaseProvider<Manufacturer> provider;
    private BaseViewCotract.BaseOnItemCLickListener<Manufacturer> onClickListener;
    private Context context;

    public ManufacturersListAdapter(Context context, BaseViewCotract.BaseProvider<Manufacturer> provider) {
        this.provider = provider;
        this.context = context;
    }

    public void setOnClickListener(BaseViewCotract.BaseOnItemCLickListener<Manufacturer> onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.manufacturer_list_row, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder != null) {
            final Manufacturer manufacturer = provider.getObject(position);
            holder.manufacturerName.setText(manufacturer.getName());
            Picasso.with(context).
                    load(ResourcesUtils.getDrawableIDByName(context, manufacturer.getManufactureName())).
                    memoryPolicy(MemoryPolicy.NO_STORE).
                    fit().centerInside().
                    into(holder.manufacturerLogo);
            holder.manufacturerFullName.setText(manufacturer.getManufactureName());

            holder.rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null) {
                        onClickListener.performClick(manufacturer);
                    }
                }
            });


        }
    }

    @Override
    public int getItemCount() {
        return provider.getCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.manufacturerLogo)
        ImageView manufacturerLogo;

        @BindView(R.id.manufacturerName)
        TextView manufacturerName;
        @BindView(R.id.manufacturerFullName)
        TextView manufacturerFullName;
        View rowView;

        public ViewHolder(View view) {
            super(view);
            this.rowView = view;
            ButterKnife.bind(this, view);
        }
    }
}
