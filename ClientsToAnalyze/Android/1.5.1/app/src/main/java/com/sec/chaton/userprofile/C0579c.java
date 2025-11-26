package com.sec.chaton.userprofile;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.sec.chaton.util.ChatONLogWriter;
import java.text.SimpleDateFormat;

/* renamed from: com.sec.chaton.userprofile.c */
/* loaded from: classes.dex */
class C0579c implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f3561a;

    C0579c(BirthdayActivity birthdayActivity) {
        this.f3561a = birthdayActivity;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.f3561a.f3327n.set(1, i);
        this.f3561a.f3327n.set(2, i2);
        this.f3561a.f3327n.set(5, i3);
        ChatONLogWriter.m3506b("onDateSet::year" + i + " onDateSet::month=" + i2 + " onDateSet::dayOfMonth=" + i3, getClass().getSimpleName());
        if (this.f3561a.f3322h.equals("FULL")) {
            String str = new SimpleDateFormat("yyyy-MM-DD").format(this.f3561a.f3327n.getTime()).substring(0, 7) + "-" + (i3 < 10 ? "0" + i3 : i3 + "");
            ChatONLogWriter.m3506b("temp_full =" + str, getClass().getSimpleName());
            this.f3561a.f3331r = UserProfileDetail.m3354a(str);
            String unused = BirthdayActivity.f3314i = str;
            ChatONLogWriter.m3506b("onDateSet::mBirthDay" + BirthdayActivity.f3314i + " onDateSet::displayTime=" + this.f3561a.f3331r, getClass().getSimpleName());
            this.f3561a.f3325l.setText(this.f3561a.f3331r);
            return;
        }
        if (this.f3561a.f3322h.equals("SHORT")) {
            String str2 = new SimpleDateFormat("yyyy-MM-dd").format(this.f3561a.f3327n.getTime());
            this.f3561a.f3331r = UserProfileDetail.m3354a(new SimpleDateFormat("MM-dd").format(this.f3561a.f3327n.getTime()));
            String unused2 = BirthdayActivity.f3314i = str2;
            this.f3561a.f3325l.setText(this.f3561a.f3331r);
        }
    }
}
