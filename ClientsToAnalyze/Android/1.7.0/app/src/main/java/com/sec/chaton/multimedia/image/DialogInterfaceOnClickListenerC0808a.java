package com.sec.chaton.multimedia.image;

import android.content.DialogInterface;

/* compiled from: ViewOriginalImage.java */
/* renamed from: com.sec.chaton.multimedia.image.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0808a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOriginalImage f2743a;

    DialogInterfaceOnClickListenerC0808a(ViewOriginalImage viewOriginalImage) {
        this.f2743a = viewOriginalImage;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2743a.finish();
    }
}
