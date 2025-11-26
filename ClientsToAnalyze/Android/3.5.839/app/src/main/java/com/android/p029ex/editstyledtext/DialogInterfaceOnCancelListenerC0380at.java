package com.android.p029ex.editstyledtext;

import android.content.DialogInterface;
import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.at */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0380at implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C0376ap f937a;

    DialogInterfaceOnCancelListenerC0380at(C0376ap c0376ap) {
        this.f937a = c0376ap;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Log.d("EditStyledText", "--- oncancel");
        this.f937a.f933o.m1288b();
    }
}
