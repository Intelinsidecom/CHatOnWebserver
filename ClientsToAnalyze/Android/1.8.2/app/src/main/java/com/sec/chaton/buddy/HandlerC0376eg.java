package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendListActivity;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.widget.C2153y;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.eg */
/* loaded from: classes.dex */
class HandlerC0376eg extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListActivity.BuddyRecommendListFragment f1527a;

    HandlerC0376eg(BuddyRecommendListActivity.BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f1527a = buddyRecommendListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        if (this.f1527a.getActivity() != null) {
            if (this.f1527a.f1186d != null) {
                this.f1527a.f1186d.dismiss();
            }
            if (message.what == 103) {
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    this.f1527a.f1193k.setVisibility(8);
                    if (this.f1527a.getActivity() != null) {
                        C2153y.m7536a(this.f1527a.getActivity(), this.f1527a.getResources().getString(R.string.done), 0).show();
                    }
                    this.f1527a.getActivity().finish();
                    return;
                }
                C2153y.m7535a(this.f1527a.getActivity(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                return;
            }
            if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1527a.getActivity(), this.f1527a.getResources().getString(R.string.done), 0).show();
            } else {
                C2153y.m7535a(this.f1527a.getActivity(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            }
        }
    }
}
