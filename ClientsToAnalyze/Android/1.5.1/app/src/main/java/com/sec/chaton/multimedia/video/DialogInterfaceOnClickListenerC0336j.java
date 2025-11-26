package com.sec.chaton.multimedia.video;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.multimedia.video.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0336j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f2425a;

    DialogInterfaceOnClickListenerC0336j(VideoPreviewActivity videoPreviewActivity) {
        this.f2425a = videoPreviewActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2425a.finish();
    }
}
