package com.sec.chaton.trunk;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.y */
/* loaded from: classes.dex */
class HandlerC1619y extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f5770a;

    HandlerC1619y(TrunkCommentView trunkCommentView) {
        this.f5770a = trunkCommentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f5770a.isDetached()) {
            if (C1786r.f6454d) {
                C1786r.m6065d("Fragment had been detached.", TrunkCommentView.f5435a);
            }
            return;
        }
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 904:
                if (C1786r.f6453c) {
                    C1786r.m6063c("[TRUNK] Received METHOD_ADD_COMMENT", TrunkCommentView.f5435a);
                }
                if (this.f5770a.f5442h != null && this.f5770a.f5442h.isShowing()) {
                    this.f5770a.f5442h.dismiss();
                }
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    this.f5770a.f5439e.setText("");
                    Toast.makeText(this.f5770a.f5436b, R.string.facebook_post_completed, 1).show();
                    if (this.f5770a.f5437c != null) {
                        this.f5770a.f5437c.mo5217c();
                        break;
                    }
                } else if (c0101b.m665b() == EnumC0803m.ERROR) {
                    if (c0101b.m673f() == 89411) {
                        this.f5770a.m5241d();
                        break;
                    } else {
                        this.f5770a.m5239c();
                        break;
                    }
                }
                break;
        }
    }
}
