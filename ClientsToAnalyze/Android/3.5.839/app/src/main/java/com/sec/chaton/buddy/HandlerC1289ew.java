package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.p065io.entry.inner.SnsInfoEntry;
import com.sec.chaton.p067j.EnumC2464o;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ew */
/* loaded from: classes.dex */
class HandlerC1289ew extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4822a;

    HandlerC1289ew(BuddyInfoFragment buddyInfoFragment) {
        this.f4822a = buddyInfoFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        BuddyProfile buddyProfile;
        if (this.f4822a.f3845O != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 415:
                    if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS && (buddyProfile = (BuddyProfile) c0778b.m3110e()) != null) {
                        for (SnsInfoEntry snsInfoEntry : buddyProfile.snsid) {
                            if (snsInfoEntry != null) {
                                this.f4822a.f3853W = snsInfoEntry.f8582sp;
                                this.f4822a.f3854X = snsInfoEntry.name;
                            }
                        }
                    }
                    this.f4822a.f3852V.startQuery(3, null, C2289i.m10166d(), null, "buddy_no = ? ", new String[]{this.f4822a.f3866l}, null);
                    break;
            }
        }
    }
}
