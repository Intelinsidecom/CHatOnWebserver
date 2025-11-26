package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ay */
/* loaded from: classes.dex */
class HandlerC1127ay extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f3937a;

    HandlerC1127ay(TrunkCommentView trunkCommentView) {
        this.f3937a = trunkCommentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f3937a.isDetached()) {
            if (C1341p.f4580d) {
                C1341p.m4661d("Fragment had been detached.", TrunkCommentView.f3753a);
            }
            return;
        }
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 904:
                if (C1341p.f4579c) {
                    C1341p.m4660c("[TRUNK] Received METHOD_ADD_COMMENT", TrunkCommentView.f3753a);
                }
                if (this.f3937a.f3760h != null) {
                    this.f3937a.f3760h.dismiss();
                }
                if (c0259g.m928b() == EnumC0518y.SUCCESS) {
                    this.f3937a.f3757e.setText("");
                    C1619g.m5888a(this.f3937a.f3754b, R.string.facebook_post_completed, 1).show();
                    if (this.f3937a.f3755c != null) {
                        this.f3937a.f3755c.mo3959b();
                        break;
                    }
                } else if (c0259g.m928b() == EnumC0518y.ERROR) {
                    if (c0259g.m934f() == 89411) {
                        this.f3937a.m3978d();
                        break;
                    } else {
                        this.f3937a.m3976c();
                        break;
                    }
                }
                break;
        }
    }
}
