package com.sec.chaton.multimedia.audio;

import android.content.DialogInterface;
import android.os.Message;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1782n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6608a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1779k f6609b;

    DialogInterfaceOnClickListenerC1782n(AsyncTaskC1779k asyncTaskC1779k, String str) {
        this.f6609b = asyncTaskC1779k;
        this.f6608a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6609b.m7353b(this.f6609b.f6592f);
        Message messageObtainMessage = this.f6609b.f6599m.obtainMessage();
        messageObtainMessage.obj = this.f6608a;
        this.f6609b.m7346a(messageObtainMessage);
    }
}
