package com.sec.chaton.userprofile;

import android.widget.DatePicker;
import com.sec.chaton.util.C1786r;
import java.text.SimpleDateFormat;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.e */
/* loaded from: classes.dex */
class C1695e implements InterfaceC1698h {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f6192a;

    C1695e(BirthdayActivity birthdayActivity) {
        this.f6192a = birthdayActivity;
    }

    @Override // com.sec.chaton.userprofile.InterfaceC1698h
    /* renamed from: a */
    public void mo5805a(DatePicker datePicker, int i, int i2, int i3) {
        String str;
        this.f6192a.f5783n.set(1, i);
        this.f6192a.f5783n.set(2, i2);
        this.f6192a.f5783n.set(5, i3);
        C1786r.m6061b("onDateSet::year" + i + " onDateSet::month=" + i2 + " onDateSet::dayOfMonth=" + i3, getClass().getSimpleName());
        if ("FULL".equals(this.f6192a.f5778i)) {
            String str2 = new SimpleDateFormat("yyyy-MM-DD").format(this.f6192a.f5783n.getTime());
            if (i3 < 10) {
                str = "0" + i3;
            } else {
                str = i3 + "";
            }
            String str3 = str2.substring(0, 7) + "-" + str;
            C1786r.m6061b("temp_full =" + str3, getClass().getSimpleName());
            this.f6192a.f5787r = MyPageFragment.m5579a(str3);
            this.f6192a.f5779j = str3;
            C1786r.m6061b("onDateSet::mBirthDay" + this.f6192a.f5779j + " onDateSet::displayTime=" + this.f6192a.f5787r, getClass().getSimpleName());
            this.f6192a.f5781l.setText(this.f6192a.f5787r);
            return;
        }
        if ("SHORT".equals(this.f6192a.f5778i)) {
            String str4 = new SimpleDateFormat("yyyy-MM-dd").format(this.f6192a.f5783n.getTime());
            this.f6192a.f5787r = MyPageFragment.m5579a(new SimpleDateFormat("MM-dd").format(this.f6192a.f5783n.getTime()));
            this.f6192a.f5779j = str4;
            this.f6192a.f5781l.setText(this.f6192a.f5787r);
        }
    }

    @Override // com.sec.chaton.userprofile.InterfaceC1698h
    /* renamed from: a */
    public void mo5806a(boolean z) {
        if (z) {
            this.f6192a.m5558b();
        } else {
            this.f6192a.m5559c();
        }
    }
}
