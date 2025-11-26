package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.l */
/* loaded from: classes.dex */
class HandlerC1725l extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6391a;

    HandlerC1725l(MsgboxFragment msgboxFragment) {
        this.f6391a = msgboxFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f6391a.getActivity() != null) {
            C0272i c0272i = (C0272i) ((C1092fg) message.obj).m5376a();
            if (c0272i != null) {
                switch (message.what) {
                    case 8:
                        if (this.f6391a.f6233B.isShowing()) {
                            this.f6391a.f6233B.dismiss();
                        }
                        if (this.f6391a.f6234C != null && this.f6391a.f6234C.isShowing()) {
                            this.f6391a.f6234C.dismiss();
                        }
                        this.f6391a.f6232A.m5887b(false);
                        if (c0272i.f858a || C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.REGARD_SUCCEESS) {
                            this.f6391a.f6232A.m5888b(this.f6391a.f6262ae);
                            C3641ai.m13210a(GlobalApplication.m11493l(), R.string.trunk_toast_deleted, 0).show();
                            break;
                        } else {
                            C3641ai.m13210a(this.f6391a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                            break;
                        }
                        break;
                }
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("resultEntry is null", MsgboxFragment.f6228a);
            }
        }
    }
}
