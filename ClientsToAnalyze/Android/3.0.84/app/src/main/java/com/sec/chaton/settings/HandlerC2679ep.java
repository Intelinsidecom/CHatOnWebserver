package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.widget.C3641ai;

/* compiled from: PostONHideFragment.java */
/* renamed from: com.sec.chaton.settings.ep */
/* loaded from: classes.dex */
class HandlerC2679ep extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONHideFragment f9965a;

    HandlerC2679ep(PostONHideFragment postONHideFragment) {
        this.f9965a = postONHideFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f9965a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (message.what == 905) {
                if (PostONHideFragment.f9221a != null) {
                    PostONHideFragment.f9221a.dismiss();
                }
                this.f9965a.m9166a(c0267d);
            }
            if (message.what == 904) {
                if (PostONHideFragment.f9221a != null) {
                    PostONHideFragment.f9221a.dismiss();
                }
                if (c0267d.m11704n()) {
                    this.f9965a.m9166a(c0267d);
                } else {
                    C3641ai.m13210a(this.f9965a.getActivity(), R.string.popup_no_network_connection, 0).show();
                }
            }
        }
    }
}
