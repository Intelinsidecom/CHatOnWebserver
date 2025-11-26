package com.sec.chaton.multimedia.video;

import android.content.DialogInterface;

/* compiled from: VideoPreviewActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0845b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f2933a;

    DialogInterfaceOnClickListenerC0845b(VideoPreviewActivity videoPreviewActivity) {
        this.f2933a = videoPreviewActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2933a.finish();
    }
}
