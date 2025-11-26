package com.sec.chaton.chat;

import android.view.View;
import com.sec.widget.InterfaceC1618f;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.af */
/* loaded from: classes.dex */
class C0530af implements InterfaceC1618f {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1880a;

    C0530af(ChatFragment chatFragment) {
        this.f1880a = chatFragment;
    }

    @Override // com.sec.widget.InterfaceC1618f
    /* renamed from: a */
    public void mo2723a(View view, boolean z) {
        if (z && this.f1880a.f1839bk != null && this.f1880a.f1858q) {
            this.f1880a.f1839bk.setVisibility(8);
            this.f1880a.f1858q = false;
        }
        try {
            this.f1880a.f1794ad.setTranscriptMode(2);
            this.f1880a.f1745F = true;
        } catch (NullPointerException e) {
        }
    }
}
