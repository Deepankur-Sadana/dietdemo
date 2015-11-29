package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.deepankur.dietplandemo.R;

import java.util.ArrayList;

import adapters.HealthPagerAdapter;
import customViews.HealthPagerTab;

public class DietPlanCreateFragmentTwo extends BaseFragment {

    private ArrayList<BaseFragment> fragmentList;
    private String[] titleArray = { "Breakfast", "Morning snack", "Lunch", "Evening snack", "Dinner"};
    private Boolean editMode;
    Boolean oncreate = false;
    private String startTime, endTime;
    private static String TAG = "doctordebug";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plan_two, container, false);

        Bundle bundle = this.getArguments();
        HealthPagerTab pagerTab = (HealthPagerTab) view.findViewById(R.id.pagerTab);
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
    //    view.findViewById(R.id.submitBtn).setOnClickListener(submitListener);
        HealthPagerAdapter pagerAdapter = new HealthPagerAdapter(getChildFragmentManager(), getActivity());
        fragmentList = new ArrayList<>();
        for(int i=0;i<5;i++){
            fragmentList.add(getFragment(titleArray[i]));
        }
        pagerAdapter.setFragmentList(fragmentList);
        pagerAdapter.setTitleArray(titleArray);
        pager.setAdapter(pagerAdapter);
        pagerTab.setViewPager(pager);
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
        if (!editMode)
            return "Create Diet Plan";
        else return "Assign Diet Plan";
    }

    private DietPlanFragment getFragment(String day) {
        DietPlanFragment dietPlan = new DietPlanFragment(null,0,null);
        Bundle bundle = new Bundle();
        bundle.putString("day", day);
        dietPlan.setArguments(bundle);
        return dietPlan;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oncreate = true;

    }


    public static DietPlanCreateFragmentTwo newInstance() {
        DietPlanCreateFragmentTwo fragment = new DietPlanCreateFragmentTwo();
        return fragment;
    }

}