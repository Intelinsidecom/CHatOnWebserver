package com.sec.chaton.userprofile;

import android.widget.DatePicker;
import com.sec.chaton.util.C1786r;
import java.text.SimpleDateFormat;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ci */
/* loaded from: classes.dex */
class C1686ci implements InterfaceC1698h {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6183a;

    C1686ci(UserProfileDetail userProfileDetail) {
        this.f6183a = userProfileDetail;
    }

    @Override // com.sec.chaton.userprofile.InterfaceC1698h
    /* renamed from: a */
    public void mo5805a(DatePicker datePicker, int i, int i2, int i3) {
        String str;
        this.f6183a.f6044aa.set(1, i);
        this.f6183a.f6044aa.set(2, i2);
        this.f6183a.f6044aa.set(5, i3);
        C1786r.m6061b("onDateSet::year" + i + " onDateSet::month=" + i2 + " onDateSet::dayOfMonth=" + i3, getClass().getSimpleName());
        if ("FULL".equals(this.f6183a.f6031N)) {
            String str2 = new SimpleDateFormat("yyyy-MM-DD").format(this.f6183a.f6044aa.getTime());
            if (i3 < 10) {
                str = "0" + i3;
            } else {
                str = i3 + "";
            }
            String str3 = str2.substring(0, 7) + "-" + str;
            C1786r.m6061b("temp_full =" + str3, getClass().getSimpleName());
            this.f6183a.f6046ac = MyPageFragment.m5579a(str3);
            this.f6183a.f6045ab = str3;
            C1786r.m6061b("onDateSet::mBirthDay" + this.f6183a.f6045ab + " onDateSet::displayTime=" + this.f6183a.f6046ac, getClass().getSimpleName());
            this.f6183a.f6021D.setText(this.f6183a.f6046ac);
            return;
        }
        if ("SHORT".equals(this.f6183a.f6031N)) {
            String str4 = new SimpleDateFormat("yyyy-MM-dd").format(this.f6183a.f6044aa.getTime());
            this.f6183a.f6046ac = MyPageFragment.m5579a(new SimpleDateFormat("MM-dd").format(this.f6183a.f6044aa.getTime()));
            this.f6183a.f6045ab = str4;
            this.f6183a.f6021D.setText(this.f6183a.f6046ac);
        }
    }

    @Override // com.sec.chaton.userprofile.InterfaceC1698h
    /* renamed from: a */
    public void mo5806a(boolean z) {
        if (z) {
            this.f6183a.m5775a();
        } else {
            this.f6183a.m5777b();
        }
    }
}
