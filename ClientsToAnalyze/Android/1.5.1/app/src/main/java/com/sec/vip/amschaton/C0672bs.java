package com.sec.vip.amschaton;

import android.net.Uri;
import java.io.File;

/* renamed from: com.sec.vip.amschaton.bs */
/* loaded from: classes.dex */
class C0672bs extends Thread {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4293a;

    C0672bs(AMSComposerActivity aMSComposerActivity) {
        this.f4293a = aMSComposerActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f4293a.m3762b(Uri.fromFile(new File(AMSActivity.f3814k)));
    }
}
