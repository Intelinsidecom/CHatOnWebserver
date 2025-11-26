package com.sec.vip.amschaton;

import android.net.Uri;
import java.io.File;

/* compiled from: AMSImageEditorActivity.java */
/* renamed from: com.sec.vip.amschaton.s */
/* loaded from: classes.dex */
class C3586s extends Thread {

    /* renamed from: a */
    final /* synthetic */ AMSImageEditorActivity f13054a;

    C3586s(AMSImageEditorActivity aMSImageEditorActivity) {
        this.f13054a = aMSImageEditorActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f13054a.m12070b(Uri.fromFile(new File(AMSActivity.f12275h)));
    }
}
