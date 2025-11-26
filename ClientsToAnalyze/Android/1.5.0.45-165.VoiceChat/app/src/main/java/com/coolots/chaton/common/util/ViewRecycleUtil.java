package com.coolots.chaton.common.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class ViewRecycleUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static void recurisveRecycle(View view) {
        if (view != 0) {
            if (view instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) view;
                int childCount = group.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    recurisveRecycle(group.getChildAt(i));
                }
                if (!(view instanceof AdapterView) && childCount > 0) {
                    group.removeAllViews();
                }
            }
            if (view instanceof DisposeInterface) {
                ((DisposeInterface) view).dispose();
            }
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(null);
            }
            view.setBackgroundDrawable(null);
        }
    }
}
