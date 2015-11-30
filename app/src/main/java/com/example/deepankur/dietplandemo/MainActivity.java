package com.example.deepankur.dietplandemo;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragment.DietPlanCreateFragment;

public class MainActivity extends AppCompatActivity {

    private boolean mOnStopCalled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchNextFragment();
    }

    private void launchNextFragment() {

        Fragment fragment;
        fragment = new DietPlanCreateFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }

    public void pushFragment(android.app.Fragment fragment, String tag) {
        if (!mOnStopCalled) {
            pushFragment(fragment, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
    }

    public int pushFragment(android.app.Fragment fragment, String tag, int transition) {
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.setTransition(transition);
        if (tag == null || tag.isEmpty()) {
            tag = fragment.getClass().getSimpleName();
        }

        trans.replace(R.id.content_frame, fragment, tag);
        trans.addToBackStack(tag);
        return trans.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mOnStopCalled = true;
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        mOnStopCalled = true;
        super.onPause();
    }
}
