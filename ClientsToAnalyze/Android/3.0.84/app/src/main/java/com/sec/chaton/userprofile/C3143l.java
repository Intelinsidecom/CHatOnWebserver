package com.sec.chaton.userprofile;

import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.text.SimpleDateFormat;

/* compiled from: BirthdayImpl.java */
/* renamed from: com.sec.chaton.userprofile.l */
/* loaded from: classes.dex */
class C3143l implements InterfaceC3155x {

    /* renamed from: a */
    final /* synthetic */ C3137f f11399a;

    C3143l(C3137f c3137f) {
        this.f11399a = c3137f;
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3155x
    /* renamed from: a */
    public void mo10896a(int i, int i2, int i3) {
        String str;
        this.f11399a.f11386o.set(1, i);
        this.f11399a.f11386o.set(2, i2);
        this.f11399a.f11386o.set(5, i3);
        C3250y.m11450b("onDateSet::year" + i + " onDateSet::month=" + i2 + " onDateSet::dayOfMonth=" + i3, getClass().getSimpleName());
        m10930a();
        if ("FULL".equals(this.f11399a.f11375d) || "FULL_HIDE".equals(this.f11399a.f11375d)) {
            String str2 = new SimpleDateFormat("yyyy-MM-DD").format(this.f11399a.f11386o.getTime());
            if (i3 < 10) {
                str = "0" + i3;
            } else {
                str = i3 + "";
            }
            String str3 = str2.substring(0, 7) + "-" + str;
            C3250y.m11450b("temp_full =" + str3, getClass().getSimpleName());
            this.f11399a.f11377f = MyInfoFragment.m10678b(str3);
            this.f11399a.f11376e = str3;
            C3250y.m11450b("onDateSet::mBirthDay" + this.f11399a.f11376e + " onDateSet::displayTime=" + this.f11399a.f11377f, getClass().getSimpleName());
            this.f11399a.f11383l.setText(this.f11399a.f11377f);
        } else if ("SHORT".equals(this.f11399a.f11375d) || "SHORT_HIDE".equals(this.f11399a.f11375d)) {
            String str4 = new SimpleDateFormat("yyyy-MM-dd").format(this.f11399a.f11386o.getTime());
            this.f11399a.f11377f = MyInfoFragment.m10678b(new SimpleDateFormat("MM-dd").format(this.f11399a.f11386o.getTime()));
            this.f11399a.f11376e = str4;
            this.f11399a.f11383l.setText(this.f11399a.f11377f);
        }
        this.f11399a.m10923a(this.f11399a.f11375d);
    }

    /* renamed from: a */
    private void m10930a() {
        if ("FULL".equals(this.f11399a.f11375d)) {
            if (!C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f11399a.f11375d = "SHORT";
            }
        } else if ("FULL_HIDE".equals(this.f11399a.f11375d)) {
            if (!C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f11399a.f11375d = "SHORT_HIDE";
            }
        } else if ("SHORT".equals(this.f11399a.f11375d)) {
            if (C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
                this.f11399a.f11375d = "FULL";
            }
        } else if ("SHORT_HIDE".equals(this.f11399a.f11375d) && C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue()) {
            this.f11399a.f11375d = "FULL_HIDE";
        }
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3155x
    /* renamed from: a */
    public void mo10897a(boolean z) {
        if (z) {
            this.f11399a.m10926c();
        } else {
            this.f11399a.m10927d();
        }
    }
}
