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


public class CardViewTitleAdapter extends RecyclerView.Adapter<CardViewTitleAdapter.ViewHolder> {

	private Context context;
	private RecyleViewItemClickInterface clickInterface;
	String items[];
	String time[];

	public CardViewTitleAdapter(Context context, RecyleViewItemClickInterface clickInterface) {
		this.context = context;
		this.clickInterface = clickInterface;


	}

	public CardViewTitleAdapter(Context context, RecyleViewItemClickInterface clickInterface,
								ArrayList<String> fooditem,ArrayList<String> foodTime) {
		this.context = context;
		this.clickInterface = clickInterface;
		items = fooditem.toArray( new String[fooditem.size()]);

		time = foodTime.toArray( new String[foodTime.size()]);

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
		viewHolder.itemView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				clickInterface.onItemClicked(i);
			}
		});

	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup,int i) {
		View itemView = LayoutInflater.
				from(viewGroup.getContext()).
				inflate(R.layout.row_diet_plan_recycle_view, viewGroup, false);


		return new ViewHolder(itemView);
	}


	public static class ViewHolder extends RecyclerView.ViewHolder {

		protected TextView vItem;
		protected TextView vTime;
		protected ImageView vImage;

		public ViewHolder(View v) {
			super(v);

			vItem = (TextView) v.findViewById(R.id.card_title);
			vTime = (TextView) v.findViewById(R.id.card_time);
			vImage = (ImageView) v.findViewById(R.id.card_image);
		}

	}
}