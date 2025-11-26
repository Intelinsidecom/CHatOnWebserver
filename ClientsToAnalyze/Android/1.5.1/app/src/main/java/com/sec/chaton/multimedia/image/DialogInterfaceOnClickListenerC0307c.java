package com.sec.chaton.multimedia.image;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.multimedia.image.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0307c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOriginalImage f2180a;

    DialogInterfaceOnClickListenerC0307c(ViewOriginalImage viewOriginalImage) {
        this.f2180a = viewOriginalImage;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2180a.finish();
    }
}
