package com.sec.chaton.userprofile;

import android.graphics.Color;
import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC0582f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f3564a;

    ViewOnClickListenerC0582f(BirthdayActivity birthdayActivity) {
        this.f3564a = birthdayActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.full_date_type /* 2131427931 */:
                this.f3564a.f3319e.setChecked(true);
                this.f3564a.f3320f.setChecked(false);
                this.f3564a.f3321g.setChecked(false);
                this.f3564a.f3322h = "FULL";
                this.f3564a.f3325l.setTextColor(this.f3564a.getApplicationContext().getResources().getColor(C0062R.color.blue_color_021));
                if (BirthdayActivity.f3314i.equals("")) {
                    String unused = BirthdayActivity.f3314i = this.f3564a.m3319a();
                }
                ChatONLogWriter.m3506b("onClick::mBirthDay" + BirthdayActivity.f3314i, getClass().getSimpleName());
                this.f3564a.f3331r = UserProfileDetail.m3354a(BirthdayActivity.f3314i);
                this.f3564a.f3325l.setText(this.f3564a.f3331r);
                break;
            case C0062R.id.short_text /* 2131427932 */:
            case C0062R.id.dont_text /* 2131427934 */:
            default:
                this.f3564a.f3319e.setChecked(false);
                this.f3564a.f3320f.setChecked(false);
                this.f3564a.f3321g.setChecked(true);
                this.f3564a.f3322h = "DONT";
                break;
            case C0062R.id.short_date_type /* 2131427933 */:
                this.f3564a.f3319e.setChecked(false);
                this.f3564a.f3320f.setChecked(true);
                this.f3564a.f3321g.setChecked(false);
                this.f3564a.f3322h = "SHORT";
                this.f3564a.f3325l.setTextColor(this.f3564a.getApplicationContext().getResources().getColor(C0062R.color.blue_color_021));
                if (BirthdayActivity.f3314i.equals("")) {
                    String unused2 = BirthdayActivity.f3314i = this.f3564a.m3319a();
                }
                this.f3564a.f3331r = UserProfileDetail.m3354a(BirthdayActivity.f3314i.substring(5, 10));
                this.f3564a.f3325l.setText(this.f3564a.f3331r);
                break;
            case C0062R.id.dont_show_type /* 2131427935 */:
                this.f3564a.f3319e.setChecked(false);
                this.f3564a.f3320f.setChecked(false);
                this.f3564a.f3321g.setChecked(true);
                this.f3564a.f3322h = "DONT";
                this.f3564a.f3325l.setTextColor(Color.parseColor("#9A9A9A"));
                break;
        }
    }
}
