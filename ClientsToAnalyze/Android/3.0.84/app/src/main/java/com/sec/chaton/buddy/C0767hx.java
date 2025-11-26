package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.Handler;
import com.sec.chaton.util.EnumC3186ba;
import com.sec.chaton.util.InterfaceC3187bb;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hx */
/* loaded from: classes.dex */
class C0767hx implements InterfaceC3187bb {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3035a;

    C0767hx(SpecialBuddyFragment specialBuddyFragment) {
        this.f3035a = specialBuddyFragment;
    }

    @Override // com.sec.chaton.util.InterfaceC3187bb
    /* renamed from: a */
    public void mo4324a(String str, Bitmap bitmap, EnumC3186ba enumC3186ba) {
        new Handler();
        if (this.f3035a.f2288Y != null) {
            this.f3035a.f2288Y.runOnUiThread(new RunnableC0768hy(this, enumC3186ba, bitmap));
        }
    }
}
