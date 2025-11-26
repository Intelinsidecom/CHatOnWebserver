package com.sec.chaton.smsplugin.p111h;

import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: DownloadManager.java */
/* renamed from: com.sec.chaton.smsplugin.h.g */
/* loaded from: classes.dex */
class RunnableC3884g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3881d f13980a;

    RunnableC3884g(C3881d c3881d) {
        this.f13980a = c3881d;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f13980a.f13972a, R.string.service_message_not_found, 1).show();
    }
}
