package com.sec.vip.amschaton;

import android.net.Uri;
import java.io.File;

/* compiled from: AMSImageEditorActivity.java */
/* renamed from: com.sec.vip.amschaton.t */
/* loaded from: classes.dex */
class C1555t extends Thread {

    /* renamed from: a */
    final /* synthetic */ AMSImageEditorActivity f5411a;

    C1555t(AMSImageEditorActivity aMSImageEditorActivity) {
        this.f5411a = aMSImageEditorActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f5411a.m4834b(Uri.fromFile(new File(AMSActivity.f4628j)));
    }
}
