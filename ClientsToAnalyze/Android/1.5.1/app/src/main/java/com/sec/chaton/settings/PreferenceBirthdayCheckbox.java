package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class PreferenceBirthdayCheckbox extends CheckBoxPreference {

    /* renamed from: a */
    Context f3090a;

    /* renamed from: b */
    SharedPreferences.Editor f3091b;

    /* renamed from: c */
    private SharedPreferences f3092c;

    /* renamed from: d */
    private boolean f3093d;

    public PreferenceBirthdayCheckbox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3092c = null;
        this.f3093d = true;
        this.f3091b = null;
        this.f3090a = context;
        ChatONLogWriter.m3506b("PreferenceBirthdayCheckbox...", getClass().getSimpleName());
        setLayoutResource(C0062R.layout.my_pref_item_birthday_checkbox);
        this.f3092c = ChatONPref.m3519a();
        this.f3091b = this.f3092c.edit();
        if (this.f3092c.getBoolean("Profile Birth Chk", true)) {
            this.f3093d = true;
        } else {
            this.f3093d = false;
        }
        setChecked(this.f3093d);
    }

    @Override // android.preference.CheckBoxPreference, android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        ChatONLogWriter.m3506b("onBindView...", getClass().getSimpleName());
        ((LinearLayout) view.findViewById(C0062R.id.linear_item)).setOnClickListener(new ViewOnClickListenerC0463al(this));
    }
}
