package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deepankur.dietplandemo.R;

import java.util.ArrayList;

import models.FoodEntity;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FoodEntity> foodList;
    private ArrayList<FoodEntity> foodListTemp;
    public FoodAdapter(Context context, ArrayList<FoodEntity> foodList) {
        this.context = context;
        this.foodList = foodList;
        this.foodListTemp = new ArrayList<>();
//        this.foodListTemp.addAll(foodList);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.food_row, viewGroup, false);
        TextView foodNameTV = (TextView) view.findViewById(R.id.foodNameTV);
        FoodEntity entity = getItem(i);
        if(entity!=null) {
            foodNameTV.setText(entity.getFood());
        }
        return view;
    }
    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public FoodEntity getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    public void filter(String charText) {
        charText = charText.toLowerCase();
        foodList.clear();
        if (charText.isEmpty()) {
            foodList.addAll(foodListTemp);
        } else {
            for (FoodEntity entity : foodListTemp) {
                if (entity.getFood().toLowerCase().contains(charText)) {
                    foodList.add(entity);
                }
            }
        }
        notifyDataSetChanged();
    }
}
