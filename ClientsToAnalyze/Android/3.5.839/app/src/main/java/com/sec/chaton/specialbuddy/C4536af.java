package com.sec.chaton.specialbuddy;

import android.text.TextUtils;
import com.sec.chaton.C1066bf;
import com.sec.chaton.util.C4904y;
import com.sec.common.p130e.InterfaceC4995d;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.af */
/* loaded from: classes.dex */
class C4536af {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16396a;

    private C4536af(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f16396a = specialBuddyChatFragment;
    }

    /* synthetic */ C4536af(SpecialBuddyChatFragment specialBuddyChatFragment, HandlerC4550o handlerC4550o) {
        this(specialBuddyChatFragment);
    }

    @InterfaceC4995d
    public void onUnreadMessageChanged(C1066bf c1066bf) {
        if (!TextUtils.isEmpty(this.f16396a.f16376u) && this.f16396a.f16376u.equals(c1066bf.f3360a)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("UnreadMessageCountChanged, inboxNo:" + c1066bf.f3360a + ", unreadCount:" + c1066bf.f3361b, SpecialBuddyChatFragment.f16299l);
            }
            this.f16396a.f16359ay = c1066bf.f3361b;
            if (this.f16396a.f16359ay > 0) {
                this.f16396a.m17193m();
            }
        }
    }
}
