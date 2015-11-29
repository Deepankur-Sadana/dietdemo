package fragment;

import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.deepankur.dietplandemo.BaseActivity;

import java.util.Calendar;

/**
 * Created by deepankur on 27-11-2015.
 */
public abstract class BaseFragment extends android.support.v4.app.Fragment {
    private ViewGroup mRootView;
    private boolean mIsLoaded;
    private BaseActivity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsLoaded = loadContent();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
//            mRootView = (ViewGroup) inflater.inflate(getLayoutId(), container, false);
         /*   if(mIsLoaded)
                getProgressBar().setVisibility(View.VISIBLE);
           */ //todo complete

        } catch (InflateException e) {
            // TODO: handle exception

        }
        return mRootView;
    }
    public ViewGroup getRootView() {
        return mRootView;
    }
    public abstract int getLayoutId();

    protected abstract boolean loadContent();

    public abstract String getTitle();

    @Override
    public void onResume() {
        super.onResume();

        if (!mIsLoaded && loadContent()) {
            if (!isContentLoaded() && null != getMainLayout()) {

            }
        } else {
            //notifyContentLoaded();
        }

        activity = BaseActivity.getInstance();/*
        if(getTitle()!=null)
            activity.setActionBarTitle(getTitle());*/
    }
    protected boolean isContentLoaded() {
        return mIsLoaded;
    }
    private FrameLayout getMainLayout() {
        if (BaseActivity.getInstance() != null) {
            return BaseActivity.getInstance().getMainLayout();
        } else {
            return null;
        }

    }

    protected View.OnClickListener timePickerListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            TimePickerDialog.OnTimeSetListener timePickerListener =
                    new TimePickerDialog.OnTimeSetListener() {
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            String ch="AM";
                            int hour = selectedHour;
                            if(hour>=12) {
                                hour = hour-12;
                                ch="PM";
                            }
                            ((TextView)view).setText(new StringBuilder().append(pad(hour))
                                    .append(":").append(pad(selectedMinute)).append(" " + ch));

                        }
                    };
            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), timePickerListener, hour, minute, false);
            timePickerDialog.show();
        }
    };
    private String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
}
