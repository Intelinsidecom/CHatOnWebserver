package com.sec.chaton.trunk;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ab */
/* loaded from: classes.dex */
class HandlerC4577ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f16687a;

    HandlerC4577ab(TrunkCommentView trunkCommentView) {
        this.f16687a = trunkCommentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        super.handleMessage(message);
        if (this.f16687a.isDetached()) {
            if (C4904y.f17874d) {
                C4904y.m18645d("Fragment had been detached.", TrunkCommentView.f16441a);
            }
            return;
        }
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 904:
                if (C4904y.f17873c) {
                    C4904y.m18641c("[TRUNK] Received METHOD_ADD_COMMENT", TrunkCommentView.f16441a);
                }
                if (this.f16687a.f16447g != null) {
                    this.f16687a.f16447g.dismiss();
                }
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    this.f16687a.f16445e.setText("");
                    C5179v.m19810a(this.f16687a.f16442b, R.string.facebook_post_completed, 1).show();
                    if (this.f16687a.f16443c != null) {
                        this.f16687a.f16443c.mo17305c_(false);
                    }
                    this.f16687a.f16450j = false;
                    break;
                } else if (c0778b.m3107b() == EnumC2464o.ERROR) {
                    if (c0778b.m3111f() == 89411) {
                        this.f16687a.m17281c();
                        this.f16687a.f16450j = false;
                        break;
                    } else if (c0778b.m3111f() == 80210) {
                        C5179v.m19810a(this.f16687a.f16442b, R.string.buddy_information_changed, 1).show();
                        this.f16687a.f16450j = false;
                        this.f16687a.f16451k = false;
                        this.f16687a.f16455o.setVisibility(8);
                        break;
                    } else {
                        this.f16687a.m17274a(c0778b);
                        break;
                    }
                }
                break;
        }
    }
}
