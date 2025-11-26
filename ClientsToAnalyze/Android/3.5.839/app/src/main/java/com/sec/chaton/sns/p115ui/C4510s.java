package com.sec.chaton.sns.p115ui;

import android.widget.ImageView;
import com.facebook.p033c.C0514k;
import com.facebook.p033c.InterfaceC0513j;

/* compiled from: SnsFriendsAdapter.java */
/* renamed from: com.sec.chaton.sns.ui.s */
/* loaded from: classes.dex */
class C4510s implements InterfaceC0513j {

    /* renamed from: a */
    final /* synthetic */ String f16244a;

    /* renamed from: b */
    final /* synthetic */ ImageView f16245b;

    /* renamed from: c */
    final /* synthetic */ C4504q f16246c;

    C4510s(C4504q c4504q, String str, ImageView imageView) {
        this.f16246c = c4504q;
        this.f16244a = str;
        this.f16245b = imageView;
    }

    @Override // com.facebook.p033c.InterfaceC0513j
    /* renamed from: a */
    public void mo1876a(C0514k c0514k) {
        this.f16246c.m17048a(c0514k, this.f16244a, this.f16245b);
    }
}
