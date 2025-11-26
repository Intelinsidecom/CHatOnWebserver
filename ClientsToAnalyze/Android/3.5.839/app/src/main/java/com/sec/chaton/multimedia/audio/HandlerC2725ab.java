package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;

/* compiled from: VoiceRecordDialog.java */
/* renamed from: com.sec.chaton.multimedia.audio.ab */
/* loaded from: classes.dex */
class HandlerC2725ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ DialogC2747w f9762a;

    HandlerC2725ab(DialogC2747w dialogC2747w) {
        this.f9762a = dialogC2747w;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9762a.isShowing() && this.f9762a.getContext() != null && message.obj != null) {
            this.f9762a.f9871t = message.obj.toString();
            this.f9762a.f9872u = message.arg1;
            if (message.arg1 < 13) {
                this.f9762a.f9852a.setText(this.f9762a.getContext().getString(R.string.button_record));
                this.f9762a.f9867p.setProgress(0);
                this.f9762a.m11515a(2, 0, 0, 0);
                this.f9762a.m11527e();
                return;
            }
            this.f9762a.m11539b();
            if (this.f9762a.f9873v) {
                this.f9762a.f9873v = false;
            }
        }
    }
}
