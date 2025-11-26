package com.sec.chaton.userprofile;

import android.widget.DatePicker;
import com.sec.chaton.util.C1341p;
import java.text.SimpleDateFormat;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.k */
/* loaded from: classes.dex */
class C1261k implements InterfaceC1250bt {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f4358a;

    C1261k(BirthdayActivity birthdayActivity) {
        this.f4358a = birthdayActivity;
    }

    @Override // com.sec.chaton.userprofile.InterfaceC1250bt
    /* renamed from: a */
    public void mo4426a(DatePicker datePicker, int i, int i2, int i3) {
        String str;
        this.f4358a.f4090k.set(1, i);
        this.f4358a.f4090k.set(2, i2);
        this.f4358a.f4090k.set(5, i3);
        C1341p.m4658b("onDateSet::year" + i + " onDateSet::month=" + i2 + " onDateSet::dayOfMonth=" + i3, getClass().getSimpleName());
        if ("FULL".equals(this.f4358a.f4085e)) {
            String str2 = new SimpleDateFormat("yyyy-MM-DD").format(this.f4358a.f4090k.getTime());
            if (i3 < 10) {
                str = "0" + i3;
            } else {
                str = i3 + "";
            }
            String str3 = str2.substring(0, 7) + "-" + str;
            C1341p.m4658b("temp_full =" + str3, getClass().getSimpleName());
            this.f4358a.f4094o = MyPageFragment.m4289a(str3);
            this.f4358a.f4086f = str3;
            C1341p.m4658b("onDateSet::mBirthDay" + this.f4358a.f4086f + " onDateSet::displayTime=" + this.f4358a.f4094o, getClass().getSimpleName());
            this.f4358a.f4088i.setText(this.f4358a.f4094o);
            return;
        }
        if ("SHORT".equals(this.f4358a.f4085e)) {
            String str4 = new SimpleDateFormat("yyyy-MM-dd").format(this.f4358a.f4090k.getTime());
            this.f4358a.f4094o = MyPageFragment.m4289a(new SimpleDateFormat("MM-dd").format(this.f4358a.f4090k.getTime()));
            this.f4358a.f4086f = str4;
            this.f4358a.f4088i.setText(this.f4358a.f4094o);
        }
    }

    @Override // com.sec.chaton.userprofile.InterfaceC1250bt
    /* renamed from: a */
    public void mo4427a(boolean z) {
        if (z) {
            this.f4358a.m4285b();
        } else {
            this.f4358a.m4286c();
        }
    }
}
