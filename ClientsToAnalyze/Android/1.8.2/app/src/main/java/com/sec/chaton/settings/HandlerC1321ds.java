package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.widget.C2153y;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.ds */
/* loaded from: classes.dex */
class HandlerC1321ds extends Handler {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f4896a;

    HandlerC1321ds(SuggestionsActivity suggestionsActivity) {
        this.f4896a = suggestionsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4896a.f4744b != null) {
            C0101b c0101b = (C0101b) message.obj;
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                if (this.f4896a.f4748f.getBoolean("recomned_receive", true)) {
                    this.f4896a.f4745c = true;
                    this.f4896a.f4743a.putBoolean("recomned_receive", true);
                } else {
                    this.f4896a.f4745c = false;
                    this.f4896a.f4743a.putBoolean("recomned_receive", false);
                }
                C2153y.m7536a(this.f4896a.f4744b, this.f4896a.getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
                this.f4896a.f4750h.setChecked(this.f4896a.f4745c);
                this.f4896a.f4753k.dismiss();
            } else {
                if (message.what == 316) {
                    if (this.f4896a.f4748f.getBoolean("recomned_receive", true)) {
                        this.f4896a.f4745c = false;
                        this.f4896a.f4743a.putBoolean("recomned_receive", false);
                    } else {
                        this.f4896a.f4745c = true;
                        this.f4896a.f4743a.putBoolean("recomned_receive", true);
                    }
                    this.f4896a.f4750h.setChecked(this.f4896a.f4745c);
                } else if (message.what == 315) {
                    if (this.f4896a.f4748f.getBoolean("exclude_me", true)) {
                        this.f4896a.f4747e = false;
                        this.f4896a.f4743a.putBoolean("exclude_me", false);
                    } else {
                        this.f4896a.f4747e = true;
                        this.f4896a.f4743a.putBoolean("exclude_me", true);
                    }
                    this.f4896a.f4752j.setChecked(this.f4896a.f4747e);
                }
                this.f4896a.f4753k.dismiss();
                int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
                if (-3 == iM3420a || -2 == iM3420a) {
                    C2153y.m7535a(this.f4896a.f4744b, R.string.popup_no_network_connection, 0).show();
                } else {
                    C2153y.m7535a(this.f4896a.f4744b, R.string.toast_network_unable, 0).show();
                }
            }
            this.f4896a.f4743a.commit();
        }
    }
}
