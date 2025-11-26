package com.samsung.sdraw;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SettingView extends AbstractSettingView {
    public SettingView(Context context) {
        super(context);
    }

    public SettingView(Context context, HashMap<String, Integer> resourceIds) {
        super(context, resourceIds);
    }

    public SettingView(Context context, HashMap<String, Integer> resourceIds, HashMap<String, String> fontname) {
        super(context, resourceIds, fontname);
    }

    public SettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SettingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
