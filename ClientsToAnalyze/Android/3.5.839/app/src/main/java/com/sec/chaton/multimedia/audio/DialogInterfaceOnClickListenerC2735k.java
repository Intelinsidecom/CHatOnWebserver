package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;
import android.os.Message;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2735k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Message f9818a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC2731g f9819b;

    DialogInterfaceOnClickListenerC2735k(AsyncTaskC2731g asyncTaskC2731g, Message message) {
        this.f9819b = asyncTaskC2731g;
        this.f9818a = message;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9819b.m11470a(this.f9818a);
    }
}
