package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.bh */
/* loaded from: classes.dex */
class HandlerC2643bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9494a;

    private HandlerC2643bh(MsgboxFragment msgboxFragment) {
        this.f9494a = msgboxFragment;
    }

    /* synthetic */ HandlerC2643bh(MsgboxFragment msgboxFragment, C2610ab c2610ab) {
        this(msgboxFragment);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            if (this.f9494a.getActivity() == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("ignore handleMessage getActivity() == null", MsgboxFragment.f9318i);
                    return;
                }
                return;
            }
            if (this.f9494a.isDetached()) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("ignore handleMessage isDetached()", MsgboxFragment.f9318i);
                    return;
                }
                return;
            }
            switch (message.what) {
                case 4:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("uiHandler [SYNC_BUTTON_UPDATE]", MsgboxFragment.f9318i);
                    }
                    this.f9494a.m11063h();
                    break;
                case 5:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("uiHandler [SYNC_DIALOG_SHOW]", MsgboxFragment.f9318i);
                    }
                    this.f9494a.m11069k();
                    break;
                case 6:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("uiHandler [SYNC_DIALOG_DISMISS]", MsgboxFragment.f9318i);
                    }
                    this.f9494a.m11071l();
                    break;
                case 7:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("uiHandler [SYNC_UPDATE_MSGBOX]", MsgboxFragment.f9318i);
                    }
                    C0991aa.m6037a().m18961c(new C1015an(new String[0]));
                    C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
                    C1813b.m8906b().m8920a(C1813b.f6835d, false, true);
                    break;
            }
            super.handleMessage(message);
        }
    }
}
