package com.sec.vip.amschaton;

import android.net.Uri;
import java.io.File;

/* compiled from: AMSImageEditorActivity.java */
/* renamed from: com.sec.vip.amschaton.t */
/* loaded from: classes.dex */
class C3587t extends Thread {

    /* renamed from: a */
    final /* synthetic */ AMSImageEditorActivity f13055a;

    C3587t(AMSImageEditorActivity aMSImageEditorActivity) {
        this.f13055a = aMSImageEditorActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f13055a.m12065a(Uri.fromFile(new File(AMSActivity.f12275h)));
    }
}
