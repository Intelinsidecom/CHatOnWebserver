package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.il */
/* loaded from: classes.dex */
class HandlerC0782il extends Handler {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyRecommendListFragment f3054a;

    HandlerC0782il(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment) {
        this.f3054a = specialBuddyRecommendListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        if (this.f3054a.f2337p != null) {
            this.f3054a.f2330i.setVisibility(0);
            if (message.what == 301) {
                if (!c0267d.m11704n()) {
                    this.f3054a.f2335n.setVisibility(8);
                } else if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    this.f3054a.f2325d.notifyDataSetChanged();
                }
            }
        }
    }
}
