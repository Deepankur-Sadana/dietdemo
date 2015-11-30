package fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deepankur.dietplandemo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapters.FoodAdapter;
import floatingButton.FloatingActionButton;
import models.DietPlanFoodEntity;
import models.FoodEntity;

public class FoodListFragment extends BaseFragment {


    private ListView foodListView;
    private FloatingActionButton addFoodBtn;
    //private ArrayList<DietPlanFoodEntity> foodListData;
    private ArrayList<FoodEntity> foodListData=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_list, container, false);
        String type = getArguments().getString("type");

        //Fixing Toolbar.
  foodListView = (ListView) view.findViewById(R.id.foodLV);
        addFoodBtn = (FloatingActionButton) view.findViewById(R.id.addFoodBtn);
        addFoodBtn.setVisibility(View.GONE);
        showFoods();

        return view;
    }

    String unit;

        public void showFoods() {
            final Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);
            dialog.setContentView(R.layout.add_food_popup);
            final EditText foodSearchET = (EditText) dialog.findViewById(R.id.foodSearchET);
            ListView foodList = (ListView) dialog.findViewById(R.id.foodList);


            Resources res = getResources();
            String[] foods = res.getStringArray(R.array.foods);
            ArrayList<String> foodEntityList = new ArrayList<String>(Arrays.asList(foods));


            LayoutInflater inflater = LayoutInflater.from(getActivity());

            final FoodAdapter adapter = new FoodAdapter(getActivity(), foodListData);
            foodList.setAdapter(adapter);
            foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    final FoodEntity entity = (FoodEntity) adapterView.getAdapter().getItem(i);
                    final Dialog dialog1 = new Dialog(getActivity());
                    dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog1.setContentView(R.layout.health_food_popup);
                    dialog1.setCancelable(false);
                    ((EditText) dialog1.findViewById(R.id.foodNameET)).setText(entity.getFood());
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
                                adapter.notifyDataSetChanged();
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
            foodSearchET.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    adapter.filter(s.toString());
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            dialog.show();
        }



    public static FoodListFragment newInstance() {
        FoodListFragment fragment = new FoodListFragment();

        return fragment;
    }

    @Override
    protected boolean loadContent() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
