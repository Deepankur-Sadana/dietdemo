package com.example.deepankur.dietplandemo;

import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

/**
 * Created by deepankur on 29-11-2015.
 */
public class BaseActivity extends AppCompatActivity {
    private FrameLayout mMainLayout;
    public static BaseActivity getInstance() {
        return null;
    }

    public FrameLayout getMainLayout() {
        if (mMainLayout == null) {
            mMainLayout = (FrameLayout) findViewById(R.id.content_frame);
        }

        return mMainLayout;
    }
}
