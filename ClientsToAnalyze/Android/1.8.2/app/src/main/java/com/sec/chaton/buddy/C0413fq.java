package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.util.EnumC1730am;
import com.sec.chaton.util.InterfaceC1731an;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.fq */
/* loaded from: classes.dex */
class C0413fq implements InterfaceC1731an {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f1572a;

    C0413fq(ViewProfileImage viewProfileImage) {
        this.f1572a = viewProfileImage;
    }

    @Override // com.sec.chaton.util.InterfaceC1731an
    /* renamed from: a */
    public void mo2412a(String str, Bitmap bitmap, EnumC1730am enumC1730am) {
        this.f1572a.runOnUiThread(new RunnableC0414fr(this, enumC1730am, bitmap));
    }
}
