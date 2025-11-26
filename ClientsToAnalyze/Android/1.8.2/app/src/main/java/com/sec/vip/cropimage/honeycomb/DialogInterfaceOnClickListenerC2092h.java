package com.sec.vip.cropimage.honeycomb;

import android.content.DialogInterface;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2092h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f7615a;

    DialogInterfaceOnClickListenerC2092h(CropImage cropImage) {
        this.f7615a = cropImage;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
