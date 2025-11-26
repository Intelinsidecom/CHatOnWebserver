package com.sec.chaton.userprofile;

import android.graphics.Color;
import android.widget.CompoundButton;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.cj */
/* loaded from: classes.dex */
class C1687cj implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6184a;

    C1687cj(UserProfileDetail userProfileDetail) {
        this.f6184a = userProfileDetail;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f6184a.f6033P != this.f6184a.f6041X.isChecked()) {
            this.f6184a.f6049af = true;
        } else {
            this.f6184a.f6049af = false;
        }
        if (this.f6184a.f6045ab == null || "".equals(this.f6184a.f6045ab) || "0000-12-31".equals(this.f6184a.f6045ab)) {
            this.f6184a.f6049af = false;
        }
        this.f6184a.invalidateOptionsMenu();
        if (!z) {
            this.f6184a.f6031N = "DONT";
            this.f6184a.f6021D.setTextColor(Color.parseColor("#9A9A9A"));
            return;
        }
        C1786r.m6061b("is Checked", getClass().getSimpleName());
        if (C1789u.m6075a().getBoolean("birthday_year_show", false)) {
            this.f6184a.f6031N = "FULL";
        } else {
            this.f6184a.f6031N = "SHORT";
        }
        this.f6184a.f6021D.setTextColor(this.f6184a.getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }
}
