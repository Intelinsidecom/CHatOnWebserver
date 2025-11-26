package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;
import android.os.Message;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2734j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9816a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC2731g f9817b;

    DialogInterfaceOnClickListenerC2734j(AsyncTaskC2731g asyncTaskC2731g, String str) {
        this.f9817b = asyncTaskC2731g;
        this.f9816a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9817b.m11477b(this.f9817b.f9799f);
        Message messageObtainMessage = this.f9817b.f9806m.obtainMessage();
        messageObtainMessage.obj = this.f9816a;
        this.f9817b.m11470a(messageObtainMessage);
    }
}
