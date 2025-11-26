package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.util.EnumC3186ba;
import com.sec.chaton.util.InterfaceC3187bb;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.iw */
/* loaded from: classes.dex */
class C0793iw implements InterfaceC3187bb {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f3085a;

    C0793iw(ViewProfileImage viewProfileImage) {
        this.f3085a = viewProfileImage;
    }

    @Override // com.sec.chaton.util.InterfaceC3187bb
    /* renamed from: a */
    public void mo4324a(String str, Bitmap bitmap, EnumC3186ba enumC3186ba) {
        this.f3085a.runOnUiThread(new RunnableC0794ix(this, enumC3186ba, bitmap));
    }
}
