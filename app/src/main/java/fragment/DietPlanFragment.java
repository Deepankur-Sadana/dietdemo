package fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepankur.dietplandemo.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import adapters.CardViewTitleAdapter;
import floatingButton.FloatingActionButton;
import interfaces.RecyleViewItemClickInterface;
import models.FoodEntity;
import models.FoodWithImage;


public class DietPlanFragment extends BaseFragment implements RecyleViewItemClickInterface, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match

    private RecyclerView mContentView;
    private RecyclerView.LayoutManager mLayoutManager;
    String mealType;
    String time;
    String unit;
    ArrayList<FoodWithImage> foodData = new ArrayList<>();



    private ArrayList<FoodEntity> foodListData = null;
    private FloatingActionButton create;

    public DietPlanFragment(String mealType, String time) {
        this.mealType = mealType;
        this.time = time;
    }

    public static DietPlanFragment newInstance() {
        DietPlanFragment fragment = new DietPlanFragment();
        return fragment;
    }

    public DietPlanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plan, container, false);
        create = (FloatingActionButton) view.findViewById(R.id.create_fab);

        create.setOnClickListener(this);


        mealType = getArguments().getString("mealtype");


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContentView = (RecyclerView) view.findViewById(R.id.rv_diet_content);
        mContentView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mContentView.setLayoutManager(mLayoutManager);
        refreshRecyclerView();

    }

    @Override
    protected boolean loadContent() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_diet_plan;
    }

    @Override
    public String getTitle() {
        return null;
    }


    @Override
    public void onItemClicked(int position) {
        switch (position) {


        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.create_fab) {

            showAddFoodDialog();

        }
    }


    public void showAddFoodDialog() {
        final Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);
        dialog.setContentView(R.layout.add_food_popup);

        Resources res = getResources();
        String[] foods = res.getStringArray(R.array.foods);
        ArrayList<String> foodEntityList = new ArrayList<String>(Arrays.asList(foods));


        LayoutInflater inflater = LayoutInflater.from(getActivity());
        EditText foodName;
        final TextView foodTime;
        Button done, cancel;
        foodName = (EditText) dialog.findViewById(R.id.foodNameET);
        foodTime = (TextView) dialog.findViewById(R.id.foodTimeTV);
        foodTime.setOnClickListener(timePickerListener);
        foodName = (EditText) dialog.findViewById(R.id.foodNameET);
        done = (Button) dialog.findViewById(R.id.done);


        final EditText finalFoodName = foodName;
        final TextView finalFoodTime = foodTime;
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(getActivity());
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.health_food_popup);
                dialog1.setCancelable(false);
                ((EditText) dialog1.findViewById(R.id.foodNameET)).setText(finalFoodName.getText().toString());
                final EditText quantityET = (EditText) dialog1.findViewById(R.id.quantityET);
                Spinner unitSpinner = (Spinner) dialog1.findViewById(R.id.unitSpinner);
                Button cancelBtn = (Button) dialog1.findViewById(R.id.cancelBtn);

                String[] list = getActivity().getResources().getStringArray(R.array.unit_array);

                ArrayAdapter<String> spinnerDataAdapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item, list);
                spinnerDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                unitSpinner.setAdapter(spinnerDataAdapter);

                unitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        unit = adapterView.getAdapter().getItem(i).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });
                Button addBtn = (Button) dialog1.findViewById(R.id.addBtn);
                addBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String quantity = quantityET.getText().toString();
                        if (!quantity.isEmpty() && !unit.equals("choose unit")) {
                            //   foodListData.add(new DietPlanFoodEntity(entity.getFood(), entity.getFood_id(), quantity, unit));
                            //  adapter.notifyDataSetChanged();

                            FoodWithImage foodWithImage=new FoodWithImage(finalFoodName.getText().toString(),
                                    foodTime.getText().toString(),quantityET.getText().toString(),unit,null);
                            foodData.add(foodWithImage);
                            refreshRecyclerView();
                            dialog1.dismiss();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(getActivity(), "Please fill and choose unit", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog1.show();
            }


        });

        dialog.show();
    }

    private void refreshRecyclerView() {
        final CardViewTitleAdapter adapter = new CardViewTitleAdapter(getActivity(), this, foodData);
        mContentView.setAdapter(adapter);
    }

    @Override
    public void onDetach() {
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        super.onDetach();
    }
}
