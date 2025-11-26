package com.sec.chaton.chat;

import com.sec.chaton.R;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cf */
/* loaded from: classes.dex */
class C1010cf implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4084a;

    C1010cf(ChatFragment chatFragment) {
        this.f4084a = chatFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (!z) {
            if (this.f4084a.f3672cr != null && this.f4084a.getResources() != null) {
                C3641ai.m13211a(CommonApplication.m11493l(), this.f4084a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                return;
            }
            return;
        }
        if (i != 1 || this.f4084a.f3672cr == null || this.f4084a.getResources() == null) {
            return;
        }
        C3641ai.m13211a(CommonApplication.m11493l(), this.f4084a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f4084a.f3545aU), 0).show();
    }
}
