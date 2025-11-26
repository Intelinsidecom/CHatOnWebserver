package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0678e;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.widget.C2153y;

/* compiled from: SpecialBuddyInfo.java */
/* renamed from: com.sec.chaton.specialbuddy.f */
/* loaded from: classes.dex */
class HandlerC1509f extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyInfo f5427a;

    HandlerC1509f(SpecialBuddyInfo specialBuddyInfo) {
        this.f5427a = specialBuddyInfo;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 602) {
            if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                this.f5427a.m5211g();
                C2153y.m7536a(this.f5427a.f5404a, this.f5427a.getResources().getString(R.string.buddy_list_block_toast_failed), 0).show();
                return;
            } else {
                C0668l.m3077a(new C0668l(), 2, new C0678e(this.f5427a.f5414n, new C0257c(this.f5427a.f5411k, this.f5427a.f5412l, "", "", "", "", false, -1, "", false), 2, false));
                return;
            }
        }
        if (message.what == 603) {
            this.f5427a.m5211g();
            if (c0101b.m664a() && c0101b.m665b() == EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f5427a.f5404a, this.f5427a.f5404a.getResources().getString(R.string.setting_buddy_unblocked, this.f5427a.f5412l), 0).show();
                this.f5427a.f5405b.setVisibility(0);
                this.f5427a.f5406c.setVisibility(8);
            }
        }
    }
}
