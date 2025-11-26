package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: SpecialBuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fp */
/* loaded from: classes.dex */
class HandlerC0412fp extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyProfileFragment f1571a;

    HandlerC0412fp(SpecialBuddyProfileFragment specialBuddyProfileFragment) {
        this.f1571a = specialBuddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 319) {
            this.f1571a.f1276f.dismiss();
            return;
        }
        if (message.what == 320) {
            this.f1571a.f1276f.dismiss();
            return;
        }
        if (message.what == 321) {
            if (c0101b.m664a() && c0101b.m665b() == EnumC0803m.SUCCESS) {
                this.f1571a.f1274d.startQuery(1, null, C0704s.f2647a, null, "buddy_no = ? ", new String[]{this.f1571a.f1278h}, null);
                C1786r.m6061b("Get Following buddy's info isConnectionSuccess()=" + c0101b.m664a() + ", result=" + c0101b.m665b() + ", fault=" + c0101b.m673f(), "BUDDY PROFILE");
                return;
            } else {
                if (!this.f1571a.isDetached()) {
                    C2153y.m7536a(this.f1571a.f1277g, this.f1571a.getResources().getString(R.string.dev_network_error), 0).show();
                    return;
                }
                return;
            }
        }
        if (message.what == 318) {
            if (c0101b.m664a() && c0101b.m665b() == EnumC0803m.SUCCESS) {
                this.f1571a.f1282l = false;
                this.f1571a.m2276a(this.f1571a.f1282l);
                this.f1571a.getActivity().finish();
            } else if (!this.f1571a.isDetached()) {
                C2153y.m7536a(this.f1571a.f1277g, this.f1571a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
            }
        }
    }
}
