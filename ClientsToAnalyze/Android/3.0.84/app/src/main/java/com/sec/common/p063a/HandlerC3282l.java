package com.sec.common.p063a;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.l */
/* loaded from: classes.dex */
final class HandlerC3282l extends Handler {

    /* renamed from: a */
    private WeakReference<DialogInterface> f11885a;

    public HandlerC3282l(DialogInterface dialogInterface) {
        this.f11885a = new WeakReference<>(dialogInterface);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case -3:
            case -2:
            case -1:
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f11885a.get(), message.what);
                break;
            case 1:
                ((DialogInterface) message.obj).dismiss();
                break;
        }
    }
}
