package com.sec.chaton.userprofile;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: BirthdayFragment.java */
/* renamed from: com.sec.chaton.userprofile.g */
/* loaded from: classes.dex */
class C4788g implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayFragment f17508a;

    C4788g(BirthdayFragment birthdayFragment) {
        this.f17508a = birthdayFragment;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        String str;
        this.f17508a.f17091p.set(1, i);
        this.f17508a.f17091p.set(2, i2);
        this.f17508a.f17091p.set(5, i3);
        if (C4904y.f17872b) {
            C4904y.m18639b("onDateSet::year" + i + " onDateSet::month=" + i2 + " onDateSet::dayOfMonth=" + i3, getClass().getSimpleName());
        }
        if ("FULL".equals(this.f17508a.f17079d) || "FULL_HIDE".equals(this.f17508a.f17079d)) {
            String str2 = new SimpleDateFormat("yyyy-MM-DD", Locale.US).format(this.f17508a.f17091p.getTime());
            if (i3 < 10) {
                str = Spam.ACTIVITY_CANCEL + i3;
            } else {
                str = i3 + "";
            }
            String str3 = str2.substring(0, 7) + "-" + str;
            C4904y.m18639b("temp_full =" + str3, getClass().getSimpleName());
            this.f17508a.f17081f = MyInfoFragment.m17841a(str3);
            this.f17508a.f17080e = str3;
            C4904y.m18639b("onDateSet::mBirthDay" + this.f17508a.f17080e + " onDateSet::displayTime=" + this.f17508a.f17081f, getClass().getSimpleName());
        } else if ("SHORT".equals(this.f17508a.f17079d) || "SHORT_HIDE".equals(this.f17508a.f17079d)) {
            String str4 = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(this.f17508a.f17091p.getTime());
            this.f17508a.f17081f = MyInfoFragment.m17841a(new SimpleDateFormat("MM-dd", Locale.US).format(this.f17508a.f17091p.getTime()));
            this.f17508a.f17080e = str4;
        }
        this.f17508a.m17801a(this.f17508a.f17079d);
    }
}
