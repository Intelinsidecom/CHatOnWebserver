package com.sec.chaton.settings.tellfriends.common;

import android.widget.ImageView;
import com.facebook.p009c.C0143k;
import com.facebook.p009c.InterfaceC0142j;

/* compiled from: SnsFriendsAdapter.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.f */
/* loaded from: classes.dex */
class C2790f implements InterfaceC0142j {

    /* renamed from: a */
    final /* synthetic */ String f10279a;

    /* renamed from: b */
    final /* synthetic */ ImageView f10280b;

    /* renamed from: c */
    final /* synthetic */ C2788d f10281c;

    C2790f(C2788d c2788d, String str, ImageView imageView) {
        this.f10281c = c2788d;
        this.f10279a = str;
        this.f10280b = imageView;
    }

    @Override // com.facebook.p009c.InterfaceC0142j
    /* renamed from: a */
    public void mo433a(C0143k c0143k) {
        this.f10281c.m9996a(c0143k, this.f10279a, this.f10280b);
    }
}
