package com.sec.chaton.multimedia.video;

import android.content.DialogInterface;

/* compiled from: VideoPreviewActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1054a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f3941a;

    DialogInterfaceOnClickListenerC1054a(VideoPreviewActivity videoPreviewActivity) {
        this.f3941a = videoPreviewActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3941a.finish();
    }
}
