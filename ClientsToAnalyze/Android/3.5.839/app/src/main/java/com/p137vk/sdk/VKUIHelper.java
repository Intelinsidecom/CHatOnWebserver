package com.p137vk.sdk;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
public class VKUIHelper {
    private static Activity mTopActivity;

    public static Activity getTopActivity() {
        return mTopActivity;
    }

    public static void onResume(Activity activity) {
        if (mTopActivity != activity) {
            mTopActivity = activity;
        }
    }

    public static void onDestroy(Activity activity) {
        if (mTopActivity == activity) {
            mTopActivity = null;
        }
    }

    public static void onActivityResult(int i, int i2, Intent intent) {
        if (i == 61992) {
            VKSdk.processActivityResult(i2, intent);
        }
    }
}
