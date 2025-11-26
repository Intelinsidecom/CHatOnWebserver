package com.sec.chaton.chat;

import com.sec.chaton.C1015an;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.util.C4904y;
import com.sec.common.p130e.InterfaceC4995d;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.fk */
/* loaded from: classes.dex */
class C1711fk {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f6315a;

    private C1711fk(ChatInfoFragment chatInfoFragment) {
        this.f6315a = chatInfoFragment;
    }

    /* synthetic */ C1711fk(ChatInfoFragment chatInfoFragment, C1696ew c1696ew) {
        this(chatInfoFragment);
    }

    @InterfaceC4995d
    public void onInboxTableChanged(C1015an c1015an) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onInboxTableChanged - ChatInfoFragment", ChatInfoFragment.f5755a);
        }
        if (!this.f6315a.f5788ag) {
            if (c1015an.m6091a(this.f6315a.f5799j)) {
                this.f6315a.f5756A.startQuery(3, null, C2299s.f8209a, new String[]{"inbox_title"}, "inbox_no=?", new String[]{this.f6315a.f5799j}, null);
            } else if (C4904y.f17872b) {
                C4904y.m18639b("A data of another room is changed", ChatInfoFragment.f5755a);
            }
        }
    }
}
