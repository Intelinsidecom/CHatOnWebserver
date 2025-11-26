package com.sec.chaton.trunk;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ab */
/* loaded from: classes.dex */
class HandlerC2961ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f10741a;

    HandlerC2961ab(TrunkCommentView trunkCommentView) {
        this.f10741a = trunkCommentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        super.handleMessage(message);
        if (this.f10741a.isDetached()) {
            if (C3250y.f11736d) {
                C3250y.m11455d("Fragment had been detached.", TrunkCommentView.f10502a);
            }
            return;
        }
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 904:
                if (C3250y.f11735c) {
                    C3250y.m11453c("[TRUNK] Received METHOD_ADD_COMMENT", TrunkCommentView.f10502a);
                }
                if (this.f10741a.f10508g != null) {
                    this.f10741a.f10508g.dismiss();
                }
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    this.f10741a.f10506e.setText("");
                    C3641ai.m13210a(this.f10741a.f10503b, R.string.facebook_post_completed, 1).show();
                    if (this.f10741a.f10504c != null) {
                        this.f10741a.f10504c.mo10201a();
                    }
                    this.f10741a.f10511j = false;
                    break;
                } else if (c0267d.m1351b() == EnumC1587o.ERROR) {
                    if (c0267d.m1355f() == 89411) {
                        this.f10741a.m10191c();
                        this.f10741a.f10511j = false;
                        break;
                    } else if (c0267d.m1355f() == 80210) {
                        C3641ai.m13210a(this.f10741a.f10503b, R.string.buddy_information_changed, 1).show();
                        this.f10741a.f10511j = false;
                        this.f10741a.f10512k = false;
                        this.f10741a.f10516o.setVisibility(8);
                        break;
                    } else {
                        this.f10741a.m10184a(c0267d);
                        break;
                    }
                }
                break;
        }
    }
}
