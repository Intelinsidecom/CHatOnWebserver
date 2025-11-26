package com.sec.chaton.buddy.dialog;

import android.graphics.Bitmap;
import com.sec.chaton.util.EnumC3186ba;
import com.sec.chaton.util.InterfaceC3187bb;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ad */
/* loaded from: classes.dex */
class C0610ad implements InterfaceC3187bb {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f2826a;

    C0610ad(SpecialBuddyDialog specialBuddyDialog) {
        this.f2826a = specialBuddyDialog;
    }

    @Override // com.sec.chaton.util.InterfaceC3187bb
    /* renamed from: a */
    public void mo4324a(String str, Bitmap bitmap, EnumC3186ba enumC3186ba) {
        this.f2826a.runOnUiThread(new RunnableC0611ae(this, enumC3186ba, bitmap));
    }
}
