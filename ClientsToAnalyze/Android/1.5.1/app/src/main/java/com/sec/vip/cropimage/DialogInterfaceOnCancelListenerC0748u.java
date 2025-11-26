package com.sec.vip.cropimage;

import android.content.DialogInterface;

/* renamed from: com.sec.vip.cropimage.u */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0748u implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f4517a;

    DialogInterfaceOnCancelListenerC0748u(CropImage cropImage) {
        this.f4517a = cropImage;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4517a.f4378q = this.f4517a.f4384w;
    }
}
