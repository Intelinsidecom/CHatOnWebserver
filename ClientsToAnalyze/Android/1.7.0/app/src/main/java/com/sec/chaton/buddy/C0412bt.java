package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.util.EnumC1304b;
import com.sec.chaton.util.InterfaceC1290am;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.bt */
/* loaded from: classes.dex */
class C0412bt implements InterfaceC1290am {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f1386a;

    C0412bt(ViewProfileImage viewProfileImage) {
        this.f1386a = viewProfileImage;
    }

    @Override // com.sec.chaton.util.InterfaceC1290am
    /* renamed from: a */
    public void mo2368a(String str, Bitmap bitmap, EnumC1304b enumC1304b) {
        this.f1386a.runOnUiThread(new RunnableC0386au(this, enumC1304b, bitmap));
    }
}
