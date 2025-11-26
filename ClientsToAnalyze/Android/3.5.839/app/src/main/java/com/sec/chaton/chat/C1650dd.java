package com.sec.chaton.chat;

import com.sec.chaton.R;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dd */
/* loaded from: classes.dex */
class C1650dd implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6182a;

    C1650dd(ChatFragment chatFragment) {
        this.f6182a = chatFragment;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        if (!z) {
            if (this.f6182a.f5624cN != null && this.f6182a.getResources() != null) {
                C5179v.m19811a(CommonApplication.m18732r(), this.f6182a.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                return;
            }
            return;
        }
        if (i != 1 || this.f6182a.f5624cN == null || this.f6182a.getResources() == null) {
            return;
        }
        C5179v.m19811a(CommonApplication.m18732r(), this.f6182a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f6182a.f5600bp), 0).show();
    }
}
