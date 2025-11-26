package com.sec.vip.amschaton;

import android.net.Uri;
import java.io.File;

/* compiled from: AMSImageEditorActivity.java */
/* renamed from: com.sec.vip.amschaton.p */
/* loaded from: classes.dex */
class C2066p extends Thread {

    /* renamed from: a */
    final /* synthetic */ AMSImageEditorActivity f7365a;

    C2066p(AMSImageEditorActivity aMSImageEditorActivity) {
        this.f7365a = aMSImageEditorActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f7365a.m6358b(Uri.fromFile(new File(AMSActivity.f6615h)));
    }
}
