package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.fz */
/* loaded from: classes.dex */
class HandlerC0715fz extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2956a;

    HandlerC0715fz(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2956a = buddyRecommendFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        if (this.f2956a.f2178J != null) {
            if (this.f2956a.f2193f != null) {
                this.f2956a.f2193f.dismiss();
            }
            if (message.what == 100) {
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    C3641ai.m13211a(this.f2956a.f2178J, this.f2956a.getResources().getString(R.string.buddy_suggestion_popup_ignored, this.f2956a.f2199l), 0).show();
                    if (this.f2956a.f2191d != null) {
                        this.f2956a.f2191d.setEmptyView(this.f2956a.f2192e);
                        return;
                    }
                    return;
                }
                C3641ai.m13210a(this.f2956a.f2178J, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                return;
            }
            if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                C3641ai.m13211a(this.f2956a.f2178J, this.f2956a.getResources().getString(R.string.done), 0).show();
                if (this.f2956a.f2191d != null) {
                    this.f2956a.f2191d.setEmptyView(this.f2956a.f2192e);
                    return;
                }
                return;
            }
            C3641ai.m13210a(this.f2956a.f2178J, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
        }
    }
}
