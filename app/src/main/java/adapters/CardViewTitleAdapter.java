package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.deepankur.dietplandemo.R;

import interfaces.RecyleViewItemClickInterface;


public class CardViewTitleAdapter extends RecyclerView.Adapter<CardViewTitleAdapter.ViewHolder> {

	private Context context;
	private String[] title;
	private RecyleViewItemClickInterface clickInterface;

	public CardViewTitleAdapter(Context context, RecyleViewItemClickInterface clickInterface) {
		this.context = context;
		this.clickInterface = clickInterface;
		title = context.getResources().getStringArray(R.array.dummy123);


	}

	@Override
	public int getItemCount() {
		return title.length;
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, final int i) {

		viewHolder.vTitle.setText(title[i]);
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

		protected TextView vTitle;

		public ViewHolder(View v) {
			super(v);

			vTitle = (TextView) v.findViewById(R.id.card_title);
		}

	}
}