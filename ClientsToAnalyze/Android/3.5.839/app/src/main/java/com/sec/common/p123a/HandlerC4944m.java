package com.sec.common.p123a;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.spp.push.dlc.api.IDlcApi;
import java.lang.ref.WeakReference;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.m */
/* loaded from: classes.dex */
final class HandlerC4944m extends Handler {

    /* renamed from: a */
    private WeakReference<DialogInterface> f18084a;

    HandlerC4944m(DialogInterface dialogInterface) {
        this.f18084a = new WeakReference<>(dialogInterface);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
            case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
            case -1:
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f18084a.get(), message.what);
                break;
            case 1:
                ((DialogInterface) message.obj).dismiss();
                break;
        }
    }
}
