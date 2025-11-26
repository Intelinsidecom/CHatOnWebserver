package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.util.EnumC4836ba;
import com.sec.chaton.util.InterfaceC4837bb;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.jb */
/* loaded from: classes.dex */
class C1403jb implements InterfaceC4837bb {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f5034a;

    C1403jb(ViewProfileImage viewProfileImage) {
        this.f5034a = viewProfileImage;
    }

    @Override // com.sec.chaton.util.InterfaceC4837bb
    /* renamed from: a */
    public void mo7395a(String str, Bitmap bitmap, EnumC4836ba enumC4836ba) {
        this.f5034a.runOnUiThread(new RunnableC1404jc(this, enumC4836ba, bitmap));
    }
}
