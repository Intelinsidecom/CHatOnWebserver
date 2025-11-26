package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.widget.C5179v;

/* compiled from: PostONHideFragment.java */
/* renamed from: com.sec.chaton.settings.fn */
/* loaded from: classes.dex */
class HandlerC3631fn extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONHideFragment f13185a;

    HandlerC3631fn(PostONHideFragment postONHideFragment) {
        this.f13185a = postONHideFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f13185a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (message.what == 905) {
                if (PostONHideFragment.f12795a != null) {
                    PostONHideFragment.f12795a.dismiss();
                }
                this.f13185a.m13651a(c0778b);
            }
            if (message.what == 904) {
                if (PostONHideFragment.f12795a != null) {
                    PostONHideFragment.f12795a.dismiss();
                }
                if (c0778b.m18954n()) {
                    this.f13185a.m13651a(c0778b);
                } else {
                    C5179v.m19810a(this.f13185a.getActivity(), R.string.popup_no_network_connection, 0).show();
                }
            }
        }
    }
}
