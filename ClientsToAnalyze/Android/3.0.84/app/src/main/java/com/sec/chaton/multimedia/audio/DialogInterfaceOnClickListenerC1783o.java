package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;
import android.os.Message;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.o */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1783o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Message f6610a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1779k f6611b;

    DialogInterfaceOnClickListenerC1783o(AsyncTaskC1779k asyncTaskC1779k, Message message) {
        this.f6611b = asyncTaskC1779k;
        this.f6610a = message;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6611b.m7346a(this.f6610a);
    }
}
