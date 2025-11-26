package com.sec.chaton.userprofile;

import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.text.SimpleDateFormat;

/* compiled from: BirthdayFragment.java */
/* renamed from: com.sec.chaton.userprofile.e */
/* loaded from: classes.dex */
class C3136e implements InterfaceC3155x {

    /* renamed from: a */
    final /* synthetic */ BirthdayFragment f11371a;

    C3136e(BirthdayFragment birthdayFragment) {
        this.f11371a = birthdayFragment;
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3155x
    /* renamed from: a */
    public void mo10896a(int i, int i2, int i3) {
        String str;
        this.f11371a.f11035k.set(1, i);
        this.f11371a.f11035k.set(2, i2);
        this.f11371a.f11035k.set(5, i3);
        C3250y.m11450b("onDateSet::year" + i + " onDateSet::month=" + i2 + " onDateSet::dayOfMonth=" + i3, getClass().getSimpleName());
        m10895a();
        if ("FULL".equals(this.f11371a.f11028d) || "FULL_HIDE".equals(this.f11371a.f11028d)) {
            String str2 = new SimpleDateFormat("yyyy-MM-DD").format(this.f11371a.f11035k.getTime());
            if (i3 < 10) {
                str = "0" + i3;
            } else {
                str = i3 + "";
            }
            String str3 = str2.substring(0, 7) + "-" + str;
            C3250y.m11450b("temp_full =" + str3, getClass().getSimpleName());
            this.f11371a.f11030f = MyInfoFragment.m10678b(str3);
            this.f11371a.f11029e = str3;
            C3250y.m11450b("onDateSet::mBirthDay" + this.f11371a.f11029e + " onDateSet::displayTime=" + this.f11371a.f11030f, getClass().getSimpleName());
            this.f11371a.f11040p.setText(this.f11371a.f11030f);
        } else if ("SHORT".equals(this.f11371a.f11028d) || "SHORT_HIDE".equals(this.f11371a.f11028d)) {
            String str4 = new SimpleDateFormat("yyyy-MM-dd").format(this.f11371a.f11035k.getTime());
            this.f11371a.f11030f = MyInfoFragment.m10678b(new SimpleDateFormat("MM-dd").format(this.f11371a.f11035k.getTime()));
            this.f11371a.f11029e = str4;
            this.f11371a.f11040p.setText(this.f11371a.f11030f);
        }
        this.f11371a.m10647a(this.f11371a.f11028d);
    }

    /* renamed from: a */
    private void m10895a() {
        if ("FULL".equals(this.f11371a.f11028d)) {
            if (!C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f11371a.f11028d = "SHORT";
            }
        } else if ("FULL_HIDE".equals(this.f11371a.f11028d)) {
            if (!C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f11371a.f11028d = "SHORT_HIDE";
            }
        } else if ("SHORT".equals(this.f11371a.f11028d)) {
            if (C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f11371a.f11028d = "FULL";
            }
        } else if ("SHORT_HIDE".equals(this.f11371a.f11028d) && C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
            this.f11371a.f11028d = "FULL_HIDE";
        }
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3155x
    /* renamed from: a */
    public void mo10897a(boolean z) {
        if (z) {
            this.f11371a.m10648b();
        } else {
            this.f11371a.m10649c();
        }
    }
}
