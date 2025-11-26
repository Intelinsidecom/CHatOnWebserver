package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p037j.C1577e;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.an */
/* loaded from: classes.dex */
class HandlerC1710an extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f6357a;

    HandlerC1710an(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f6357a = msgboxSelectionFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f6357a.getActivity() != null) {
            C0272i c0272i = (C0272i) ((C1092fg) message.obj).m5376a();
            if (c0272i == null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("resultEntry is null", MsgboxSelectionFragment.f6287a);
                    return;
                }
                return;
            }
            switch (message.what) {
                case 2:
                    if (c0272i.f858a || C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.CHANGE_SERVER) {
                        if (!this.f6357a.f6289B.isShowing()) {
                            this.f6357a.f6289B.show();
                        }
                        this.f6357a.f6288A.m5838a(this.f6357a.f6315r, this.f6357a.f6314q, this.f6357a.f6313p);
                        break;
                    } else {
                        this.f6357a.f6288A.m5887b(false);
                        this.f6357a.m7099l();
                        C3641ai.m13210a(this.f6357a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                        C1577e.m6684a().m6691c();
                        this.f6357a.f6288A.m5888b(this.f6357a.f6298K);
                        break;
                    }
                case 8:
                    this.f6357a.m7099l();
                    this.f6357a.f6288A.m5887b(false);
                    C1577e.m6684a().m6691c();
                    if (c0272i.f858a || C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.REGARD_SUCCEESS) {
                        this.f6357a.m7091h();
                        this.f6357a.f6288A.m5901j();
                        this.f6357a.f6288A.m5900i();
                        try {
                            C3044a.m10564a(this.f6357a.getActivity(), C3044a.m10560a(this.f6357a.f6314q));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.f6357a.m7099l();
                        C3641ai.m13210a(this.f6357a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                    }
                    this.f6357a.f6288A.m5888b(this.f6357a.f6298K);
                    break;
                case 25:
                    this.f6357a.m7099l();
                    this.f6357a.f6288A.m5888b(this.f6357a.f6298K);
                    if (c0272i.f858a || C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.REGARD_SUCCEESS) {
                        this.f6357a.f6307j.clearChoices();
                        if (GlobalApplication.m6456e()) {
                            this.f6357a.getActivity().setResult(-1);
                        }
                        this.f6357a.m7105o();
                        break;
                    } else {
                        C3641ai.m13210a(this.f6357a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                        break;
                    }
                    break;
            }
        }
    }
}
