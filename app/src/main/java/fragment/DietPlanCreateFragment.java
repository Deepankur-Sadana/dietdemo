package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.deepankur.dietplandemo.R;

/**
 * Created by deepankur on 29-11-2015.
 */
public class DietPlanCreateFragment extends BaseFragment {
    public DietPlanCreateFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Fragment fragment;
        fragment = new DietPlanCreateFragmentTwo();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    protected boolean loadContent() {
        return false;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();


    }
}
