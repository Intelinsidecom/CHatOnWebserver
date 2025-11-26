package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.common.entry.UserProfileEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.ak */
/* loaded from: classes.dex */
class HandlerC0557ak extends Handler {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f3536a;

    HandlerC0557ak(UserProfileDetail userProfileDetail) {
        this.f3536a = userProfileDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (this.f3536a.f3387E != null) {
                this.f3536a.f3387E.dismiss();
            }
        } catch (Exception e) {
            ChatONLogWriter.m3506b("try dismiss dialog, but cannot find activity", "UserProfileDetail");
            e.printStackTrace();
        }
        switch (message.what) {
            case 401:
                HttpEntry httpEntry = (HttpEntry) message.obj;
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    UserProfileEntry userProfileEntry = (UserProfileEntry) httpEntry.m1956e();
                    if (userProfileEntry.m1964a() != null) {
                        this.f3536a.f3383A.setText(userProfileEntry.m1964a());
                    }
                    if (userProfileEntry.m1966b() != null) {
                        this.f3536a.f3432z.setText(userProfileEntry.m1966b());
                    }
                    if (userProfileEntry.m1968c() != null) {
                        if (this.f3536a.f3396N) {
                            this.f3536a.f3384B.setText(UserProfileDetail.m3354a(this.f3536a.f3401S));
                        } else {
                            this.f3536a.f3384B.setText(this.f3536a.getResources().getString(C0062R.string.dont_show_birthday));
                            this.f3536a.f3394L = "";
                        }
                    }
                    this.f3536a.m3366f();
                    break;
                } else {
                    Toast.makeText(this.f3536a.f3412f, C0062R.string.toast_setting_profile_update_failed, 0).show();
                    break;
                }
                break;
            case 402:
                if (!((ResultEntry) message.obj).f1325a) {
                    Toast.makeText(this.f3536a.f3412f, C0062R.string.toast_setting_profile_image_save_failed, 0).show();
                    break;
                } else {
                    this.f3536a.f3402T = true;
                    this.f3536a.m3372i();
                    break;
                }
            case 403:
                HttpEntry httpEntry2 = (HttpEntry) message.obj;
                if (!httpEntry2.m1950a() || !httpEntry2.m1950a()) {
                    Toast.makeText(this.f3536a.f3412f, C0062R.string.toast_setting_profile_image_save_failed, 0).show();
                    break;
                } else {
                    this.f3536a.f3430x.setImageResource(C0062R.drawable.co_default_image_add);
                    break;
                }
                break;
        }
    }
}
