package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import com.example.deepankur.dietplandemo.R;

public class DietPlanFragment extends BaseFragment {

    private String meal;
    private int mealid;
    private Button submitBtn;
    private String mealtime;
    private RecyclerView mContentView;
    public DietPlanFragment(String meal, int mealid,String mealtime) {
        this.meal = meal;
        this.mealid = mealid;
        this.mealtime=mealtime;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plan, container, false);
 /*       day = getArguments().getString("day");
        ListView list = (ListView) view.findViewById(R.id.list);
        DietPlanDetailAdapter detailAdapter = new DietPlanDetailAdapter(getActivity(), dietPlanData, day);
        list.setAdapter(detailAdapter);
        list.setOnItemClickListener(itemClickListener);*/
        return view;
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

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        }
    };
}
