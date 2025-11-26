package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class PreferenceHelp extends Preference {

    /* renamed from: a */
    Context f9241a;

    public PreferenceHelp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9241a = context;
        C3250y.m11450b("PreferenceHelp...", getClass().getSimpleName());
        setLayoutResource(R.layout.my_pref_item_bg);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        C3250y.m11450b("onBindView...", getClass().getSimpleName());
    }
}
