package com.sec.chaton.userprofile;

import android.graphics.Color;
import android.widget.CompoundButton;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.j */
/* loaded from: classes.dex */
class C1260j implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f4357a;

    C1260j(BirthdayActivity birthdayActivity) {
        this.f4357a = birthdayActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!z) {
            this.f4357a.f4085e = "DONT";
            this.f4357a.f4088i.setTextColor(Color.parseColor("#9A9A9A"));
            return;
        }
        C1341p.m4658b("is Checked", getClass().getSimpleName());
        if (C1323bs.m4575a().getBoolean("birthday_year_show", false)) {
            this.f4357a.f4085e = "FULL";
        } else {
            this.f4357a.f4085e = "SHORT";
        }
        this.f4357a.f4088i.setTextColor(this.f4357a.getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }
}
