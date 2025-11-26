package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.util.EnumC4836ba;
import com.sec.chaton.util.InterfaceC4837bb;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.if */
/* loaded from: classes.dex */
class C1380if implements InterfaceC4837bb {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4981a;

    C1380if(SpecialBuddyFragment specialBuddyFragment) {
        this.f4981a = specialBuddyFragment;
    }

    @Override // com.sec.chaton.util.InterfaceC4837bb
    /* renamed from: a */
    public void mo7395a(String str, Bitmap bitmap, EnumC4836ba enumC4836ba) {
        if (this.f4981a.f4151j != null) {
            this.f4981a.f4151j.runOnUiThread(new RunnableC1381ig(this, enumC4836ba, bitmap));
        }
    }
}
