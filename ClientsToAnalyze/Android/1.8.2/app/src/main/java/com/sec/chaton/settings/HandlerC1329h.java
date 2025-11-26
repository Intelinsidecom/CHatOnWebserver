package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.widget.C2153y;

/* compiled from: ActivityBuddyView.java */
/* renamed from: com.sec.chaton.settings.h */
/* loaded from: classes.dex */
class HandlerC1329h extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityBuddyView f4905a;

    HandlerC1329h(ActivityBuddyView activityBuddyView) {
        this.f4905a = activityBuddyView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4905a.f4460e != null) {
            C0101b c0101b = (C0101b) message.obj;
            if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                if (this.f4905a.f4463h.getBoolean("recomned_receive", true)) {
                    this.f4905a.f4462g = false;
                    this.f4905a.f4457b.putBoolean("recomned_receive", false);
                } else {
                    this.f4905a.f4462g = true;
                    this.f4905a.f4457b.putBoolean("recomned_receive", true);
                }
                this.f4905a.f4459d.setChecked(this.f4905a.f4462g);
                this.f4905a.f4464i.dismiss();
                int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
                if (-3 == iM3420a || -2 == iM3420a) {
                    C2153y.m7535a(this.f4905a.f4460e, R.string.popup_no_network_connection, 0).show();
                    return;
                } else {
                    C2153y.m7535a(this.f4905a.f4460e, R.string.toast_network_unable, 0).show();
                    return;
                }
            }
            if (this.f4905a.f4463h.getBoolean("recomned_receive", true)) {
                this.f4905a.f4462g = true;
                this.f4905a.f4457b.putBoolean("recomned_receive", true);
            } else {
                this.f4905a.f4462g = false;
                this.f4905a.f4457b.putBoolean("recomned_receive", false);
            }
            C2153y.m7536a(this.f4905a.f4460e, this.f4905a.getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
            this.f4905a.f4459d.setChecked(this.f4905a.f4462g);
            this.f4905a.f4464i.dismiss();
        }
    }
}
