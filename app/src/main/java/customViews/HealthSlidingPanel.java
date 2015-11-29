package customViews;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class HealthSlidingPanel extends SlidingPaneLayout {

    private boolean enabled = true;

    public HealthSlidingPanel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public HealthSlidingPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HealthSlidingPanel(Context context) {
        super(context);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if(isOpen() || enabled){
            return super.onInterceptTouchEvent(arg0);
        }
        else
            return false;
    }
    public void setSlidingEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
