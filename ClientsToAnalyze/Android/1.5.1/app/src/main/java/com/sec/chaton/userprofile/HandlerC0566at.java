package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.at */
/* loaded from: classes.dex */
class HandlerC0566at extends Handler {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView f3546a;

    HandlerC0566at(UserProfileImageView userProfileImageView) {
        this.f3546a = userProfileImageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (this.f3546a.f3512l != null) {
                this.f3546a.f3512l.dismiss();
            }
        } catch (Exception e) {
            ChatONLogWriter.m3506b("try dismiss dialog, but cannot find activity", UserProfileImageView.f3501b);
            e.printStackTrace();
        }
        switch (message.what) {
            case 402:
                if (!((ResultEntry) message.obj).f1325a) {
                    Toast.makeText(this.f3546a.f3504d, C0062R.string.toast_setting_profile_image_save_failed, 0).show();
                    this.f3546a.finish();
                    break;
                } else {
                    this.f3546a.finish();
                    break;
                }
            case 403:
                HttpEntry httpEntry = (HttpEntry) message.obj;
                if (!httpEntry.m1950a() || !httpEntry.m1950a()) {
                    Toast.makeText(this.f3546a.f3504d, C0062R.string.toast_setting_profile_image_save_failed, 0).show();
                    this.f3546a.finish();
                    break;
                } else {
                    this.f3546a.f3508h.setImageResource(C0062R.drawable.co_default_image_add);
                    this.f3546a.finish();
                    break;
                }
                break;
        }
    }
}
