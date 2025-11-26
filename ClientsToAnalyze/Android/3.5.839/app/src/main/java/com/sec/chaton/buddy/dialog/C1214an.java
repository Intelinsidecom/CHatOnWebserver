package com.sec.chaton.buddy.dialog;

import android.graphics.Bitmap;
import com.sec.chaton.util.EnumC4836ba;
import com.sec.chaton.util.InterfaceC4837bb;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.an */
/* loaded from: classes.dex */
class C1214an implements InterfaceC4837bb {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f4710a;

    C1214an(SpecialBuddyDialog specialBuddyDialog) {
        this.f4710a = specialBuddyDialog;
    }

    @Override // com.sec.chaton.util.InterfaceC4837bb
    /* renamed from: a */
    public void mo7395a(String str, Bitmap bitmap, EnumC4836ba enumC4836ba) {
        this.f4710a.runOnUiThread(new RunnableC1215ao(this, enumC4836ba, bitmap));
    }
}
