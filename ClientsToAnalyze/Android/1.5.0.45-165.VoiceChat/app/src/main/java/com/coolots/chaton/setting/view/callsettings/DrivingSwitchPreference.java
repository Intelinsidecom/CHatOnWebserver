package com.coolots.chaton.setting.view.callsettings;

import android.R;
import android.content.Context;
import android.preference.SwitchPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public class DrivingSwitchPreference extends SwitchPreference {
    public DrivingSwitchPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrivingSwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrivingSwitchPreference(Context context) {
        super(context);
    }

    @Override // android.preference.SwitchPreference, android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView summaryView = (TextView) view.findViewById(R.id.summary);
        if (summaryView != null) {
            summaryView.setTextColor(-6578011);
            summaryView.setTextSize(17.0f);
        }
    }
}
