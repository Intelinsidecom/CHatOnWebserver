package com.sec.chaton.userprofile;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.common.entry.UserProfileEntry;
import com.sec.chaton.network.HttpResultCode;

/* renamed from: com.sec.chaton.userprofile.g */
/* loaded from: classes.dex */
class HandlerC0583g extends Handler {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f3565a;

    HandlerC0583g(BirthdayActivity birthdayActivity) {
        this.f3565a = birthdayActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f3565a.f3329p.dismiss();
        switch (message.what) {
            case 401:
                HttpEntry httpEntry = (HttpEntry) message.obj;
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    if (((UserProfileEntry) httpEntry.m1956e()).m1968c() != null) {
                        if (this.f3565a.f3330q) {
                            this.f3565a.f3325l.setText(UserProfileDetail.m3354a(this.f3565a.f3331r));
                        } else {
                            this.f3565a.f3325l.setTextColor(Color.parseColor("#9A9A9A"));
                            this.f3565a.f3323j.setClickable(false);
                            this.f3565a.f3323j.setBackgroundResource(C0062R.drawable.ic_btn_round_more_pressed);
                        }
                    }
                    this.f3565a.m3307d();
                    this.f3565a.finish();
                    break;
                } else {
                    Toast.makeText(this.f3565a.f3317c, C0062R.string.toast_setting_profile_update_failed, 0).show();
                    break;
                }
                break;
        }
    }
}
