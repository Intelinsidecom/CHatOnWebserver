package com.infraware.common.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/* loaded from: classes.dex */
public abstract class Utils {
    public static int getDensityDpi(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi;
    }

    public static int getDensityDpiForEvEngine(Activity activity) {
        int dpi = Math.round(getDensityDpi(activity) * 0.83125f);
        return dpi;
    }
}
