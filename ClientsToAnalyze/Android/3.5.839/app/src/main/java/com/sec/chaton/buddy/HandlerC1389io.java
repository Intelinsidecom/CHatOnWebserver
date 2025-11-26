package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.io */
/* loaded from: classes.dex */
class HandlerC1389io extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyRecommendListFragment f4995a;

    HandlerC1389io(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment) {
        this.f4995a = specialBuddyRecommendListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        if (this.f4995a.f4182o != null) {
            this.f4995a.f4175h.setVisibility(0);
            if (message.what == 301) {
                if (!c0778b.m18954n()) {
                    this.f4995a.f4180m.setVisibility(8);
                } else if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    this.f4995a.f4170c.notifyDataSetChanged();
                }
            }
        }
    }
}
