package com.sec.chaton.msgbox;

import com.sec.chaton.C0992ab;
import com.sec.chaton.C1006ae;
import com.sec.chaton.C1015an;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.util.C4904y;
import com.sec.common.p130e.InterfaceC4995d;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.bg */
/* loaded from: classes.dex */
class C2642bg {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9493a;

    private C2642bg(MsgboxFragment msgboxFragment) {
        this.f9493a = msgboxFragment;
    }

    /* synthetic */ C2642bg(MsgboxFragment msgboxFragment, C2610ab c2610ab) {
        this(msgboxFragment);
    }

    @InterfaceC4995d
    public void onChatProfileImageChanged(C1006ae c1006ae) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onChatProfileImageChanged", MsgboxFragment.f9318i);
        }
        if (this.f9493a.f9324C != null) {
            this.f9493a.f9324C.notifyDataSetChanged();
        }
    }

    @InterfaceC4995d
    public void onBuddyProfileImageChanged(C0992ab c0992ab) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onBuddyProfileImageChanged", MsgboxFragment.f9318i);
        }
        if (this.f9493a.f9324C != null) {
            this.f9493a.f9324C.notifyDataSetChanged();
        }
    }

    @InterfaceC4995d
    public void onInboxTableChanged(C1015an c1015an) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onInboxTableChanged", MsgboxFragment.f9318i);
        }
        if (this.f9493a.f9338Q || this.f9493a.f9346Y || this.f9493a.isDetached() || this.f9493a.f9364s == null) {
            this.f9493a.f9341T = true;
            if (this.f9493a.isDetached() && C4904y.f17872b) {
                C4904y.m18639b("onInboxTableChanged - but the Fragment is detached.", MsgboxFragment.f9318i);
                return;
            }
            return;
        }
        this.f9493a.f9325D.startQuery(1, null, C2299s.m10188b(), null, null, null, null);
    }
}
