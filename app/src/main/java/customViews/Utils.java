package customViews;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class Utils {
    private static String TAG="Utils";


	public static int getDIP(Context context, int value) {
		Resources r = context.getResources();
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, r.getDisplayMetrics());
		return px;
	}


}
