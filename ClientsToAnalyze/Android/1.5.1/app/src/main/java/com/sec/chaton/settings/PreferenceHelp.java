package com.sec.chaton.settings;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class PreferenceHelp extends Preference {

    /* renamed from: a */
    Context f3094a;

    public PreferenceHelp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3094a = context;
        ChatONLogWriter.m3506b("PreferenceHelp...", getClass().getSimpleName());
        setLayoutResource(C0062R.layout.my_pref_item_bg);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        ChatONLogWriter.m3506b("onBindView...", getClass().getSimpleName());
    }
}
