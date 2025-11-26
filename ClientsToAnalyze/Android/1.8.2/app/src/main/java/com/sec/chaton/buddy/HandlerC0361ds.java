package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendActivity;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.widget.C2153y;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.ds */
/* loaded from: classes.dex */
class HandlerC0361ds extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1505a;

    HandlerC0361ds(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1505a = buddyRecommendFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (this.f1505a.getActivity() != null) {
            if (this.f1505a.f1169e != null) {
                this.f1505a.f1169e.dismiss();
            }
            if (message.what == 100) {
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    C2153y.m7536a(this.f1505a.getActivity(), this.f1505a.getResources().getString(R.string.done), 0).show();
                    if (this.f1505a.f1166b != null) {
                        this.f1505a.f1166b.setEmptyView(this.f1505a.f1167c);
                        return;
                    }
                    return;
                }
                C2153y.m7535a(this.f1505a.getActivity(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                return;
            }
            if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1505a.getActivity(), this.f1505a.getResources().getString(R.string.done), 0).show();
                if (this.f1505a.f1166b != null) {
                    this.f1505a.f1166b.setEmptyView(this.f1505a.f1167c);
                    return;
                }
                return;
            }
            C2153y.m7535a(this.f1505a.getActivity(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
        }
    }
}
