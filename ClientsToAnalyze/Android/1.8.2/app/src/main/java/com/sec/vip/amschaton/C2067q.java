package com.sec.vip.amschaton;

import android.net.Uri;
import java.io.File;

/* compiled from: AMSImageEditorActivity.java */
/* renamed from: com.sec.vip.amschaton.q */
/* loaded from: classes.dex */
class C2067q extends Thread {

    /* renamed from: a */
    final /* synthetic */ AMSImageEditorActivity f7366a;

    C2067q(AMSImageEditorActivity aMSImageEditorActivity) {
        this.f7366a = aMSImageEditorActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f7366a.m6353a(Uri.fromFile(new File(AMSActivity.f6615h)));
    }
}
