package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class PreferenceBirthdayCheckbox extends CheckBoxPreference {

    /* renamed from: a */
    Context f3569a;

    /* renamed from: b */
    SharedPreferences.Editor f3570b;

    /* renamed from: c */
    private SharedPreferences f3571c;

    /* renamed from: d */
    private boolean f3572d;

    public PreferenceBirthdayCheckbox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3571c = null;
        this.f3572d = true;
        this.f3570b = null;
        this.f3569a = context;
        C1341p.m4658b("PreferenceBirthdayCheckbox...", getClass().getSimpleName());
        setLayoutResource(R.layout.my_pref_item_birthday_checkbox);
        this.f3571c = C1323bs.m4575a();
        this.f3570b = this.f3571c.edit();
        if (this.f3571c.getBoolean("Profile Birth Chk", true)) {
            this.f3572d = true;
        } else {
            this.f3572d = false;
        }
        setChecked(this.f3572d);
    }

    @Override // android.preference.CheckBoxPreference, android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        C1341p.m4658b("onBindView...", getClass().getSimpleName());
        ((LinearLayout) view.findViewById(R.id.linear_item)).setOnClickListener(new ViewOnClickListenerC1093y(this));
    }
}
