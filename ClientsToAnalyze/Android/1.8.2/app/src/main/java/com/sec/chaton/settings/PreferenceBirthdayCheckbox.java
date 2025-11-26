package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* loaded from: classes.dex */
public class PreferenceBirthdayCheckbox extends CheckBoxPreference {

    /* renamed from: a */
    Context f4697a;

    /* renamed from: b */
    SharedPreferences.Editor f4698b;

    /* renamed from: c */
    private SharedPreferences f4699c;

    /* renamed from: d */
    private boolean f4700d;

    public PreferenceBirthdayCheckbox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4699c = null;
        this.f4700d = true;
        this.f4698b = null;
        this.f4697a = context;
        C1786r.m6061b("PreferenceBirthdayCheckbox...", getClass().getSimpleName());
        setLayoutResource(R.layout.my_pref_item_birthday_checkbox);
        this.f4699c = C1789u.m6075a();
        this.f4698b = this.f4699c.edit();
        if (this.f4699c.getBoolean("Profile Birth Chk", true)) {
            this.f4700d = true;
        } else {
            this.f4700d = false;
        }
        setChecked(this.f4700d);
    }

    @Override // android.preference.CheckBoxPreference, android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        C1786r.m6061b("onBindView...", getClass().getSimpleName());
        ((LinearLayout) view.findViewById(R.id.linear_item)).setOnClickListener(new ViewOnClickListenerC1297cv(this));
    }
}
