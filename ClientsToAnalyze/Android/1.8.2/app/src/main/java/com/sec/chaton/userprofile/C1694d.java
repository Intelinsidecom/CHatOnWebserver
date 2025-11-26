package com.sec.chaton.userprofile;

import android.graphics.Color;
import android.widget.CompoundButton;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.d */
/* loaded from: classes.dex */
class C1694d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f6191a;

    C1694d(BirthdayActivity birthdayActivity) {
        this.f6191a = birthdayActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f6191a.f5779j == null || "".equals(this.f6191a.f5779j) || "0000-12-31".equals(this.f6191a.f5779j)) {
            this.f6191a.f5776d = false;
            this.f6191a.invalidateOptionsMenu();
        } else {
            this.f6191a.f5776d = true;
            this.f6191a.invalidateOptionsMenu();
        }
        if (!z) {
            this.f6191a.f5778i = "DONT";
            this.f6191a.f5781l.setTextColor(Color.parseColor("#9A9A9A"));
            return;
        }
        C1786r.m6061b("is Checked", getClass().getSimpleName());
        if (C1789u.m6075a().getBoolean("birthday_year_show", false)) {
            this.f6191a.f5778i = "FULL";
        } else {
            this.f6191a.f5778i = "SHORT";
        }
        this.f6191a.f5781l.setTextColor(this.f6191a.getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }
}
