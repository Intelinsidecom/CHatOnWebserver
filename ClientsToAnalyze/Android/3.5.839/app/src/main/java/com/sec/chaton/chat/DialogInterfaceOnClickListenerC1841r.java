package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1841r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Bitmap f6963a;

    /* renamed from: b */
    final /* synthetic */ C1840q f6964b;

    DialogInterfaceOnClickListenerC1841r(C1840q c1840q, Bitmap bitmap) {
        this.f6964b = c1840q;
        this.f6963a = bitmap;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6964b.f6962a.f5677dP = this.f6963a;
        this.f6964b.f6962a.f5676dO = new AsyncTaskC1687en(this.f6964b.f6962a, false);
        if (this.f6964b.f6962a.f5676dO != null) {
            this.f6964b.f6962a.m8274s();
            if (Build.VERSION.SDK_INT < 11) {
                this.f6964b.f6962a.f5676dO.execute(this.f6964b.f6962a.f5677dP);
            } else {
                this.f6964b.f6962a.f5676dO.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f6964b.f6962a.f5677dP);
            }
        }
    }
}
