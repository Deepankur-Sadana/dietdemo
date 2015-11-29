package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deepankur.dietplandemo.R;

import adapters.CardViewTitleAdapter;
import floatingButton.FloatingActionButton;
import interfaces.RecyleViewItemClickInterface;


public class DietPlanFragment extends BaseFragment implements RecyleViewItemClickInterface, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match

    private RecyclerView mContentView;
    private RecyclerView.LayoutManager mLayoutManager;
    String mealType;
    String time;
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


 /*       day = getArguments().getString("day");
        ListView list = (ListView) view.findViewById(R.id.list);
        DietPlanDetailAdapter detailAdapter = new DietPlanDetailAdapter(getActivity(), dietPlanData, day);
        list.setAdapter(detailAdapter);
        list.setOnItemClickListener(itemClickListener);*/
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

        final CardViewTitleAdapter adapter = new CardViewTitleAdapter(getActivity(), this);
        mContentView.setAdapter(adapter);
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
        return "Practice Management";
    }


    @Override
    public void onItemClicked(int position) {
        switch (position) {
     /*       case 0:
                DietPlanManagementFragment fragment = DietPlanManagementFragment.newInstance();
                ((MainActivity) getActivity()).pushFragment(fragment, fragment.getClass().getSimpleName());
                break;
            case 1:
                DietPlanCreateFragment profileFragment = DietPlanCreateFragment.newInstance();
                ((MainActivity)getActivity()).pushFragment(profileFragment, profileFragment.getClass().getSimpleName());
                break;
            case 2:
                RecipesFoodFragment fragment1 = RecipesFoodFragment.newInstance();
                ((MainActivity) getActivity()).pushFragment(fragment1, fragment1.getClass().getSimpleName());
                break;*/

        }
    }

    @Override
    public void onClick(View v) {
        if(v==create){

        }
    }
}
