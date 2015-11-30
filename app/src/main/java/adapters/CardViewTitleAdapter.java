package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.deepankur.dietplandemo.R;
import java.util.ArrayList;

import interfaces.RecyleViewItemClickInterface;
import models.FoodWithImage;


public class CardViewTitleAdapter extends RecyclerView.Adapter<CardViewTitleAdapter.ViewHolder> {

    private Context context;
    private RecyleViewItemClickInterface clickInterface;
    String items[];
    String time[];
    String quantityUnit[];

    public CardViewTitleAdapter(Context context, RecyleViewItemClickInterface clickInterface,
                                ArrayList<FoodWithImage> fooddata) {
        this.context = context;
        this.clickInterface = clickInterface;
        items = new String[fooddata.size()];
        time = new String[fooddata.size()];
        quantityUnit=new String[fooddata.size()];
        for (int i = 0; i < fooddata.size(); i++) {
            items[i] = fooddata.get(i).getType();
            time[i] = fooddata.get(i).getTime();
            quantityUnit[i] = fooddata.get(i).getQuantity() +"  "+ fooddata.get(i).getUnit();
        }


    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {

        viewHolder.vItem.setText(items[i]);
        viewHolder.vTime.setText(time[i]);
        viewHolder.vImage.setImageResource(R.mipmap.dosa);
        viewHolder.vquantityServing.setText(quantityUnit[i]);
        if (quantityUnit[i].trim().length() < 4)
            viewHolder.vquantityServing.setVisibility(View.GONE);
        viewHolder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickInterface.onItemClicked(i);
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.row_diet_plan_recycle_view, viewGroup, false);


        return new ViewHolder(itemView);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView vItem;
        protected TextView vTime;
        protected ImageView vImage;
        protected TextView vquantityServing;

        public ViewHolder(View v) {
            super(v);

            vItem = (TextView) v.findViewById(R.id.card_title);
            vTime = (TextView) v.findViewById(R.id.card_time);
            vImage = (ImageView) v.findViewById(R.id.card_image);
            vquantityServing = (TextView) v.findViewById(R.id.card_quantity);
        }

    }
}