package com.sec.chaton.multimedia.audio;

import android.os.Message;
import android.view.View;

/* compiled from: VoiceRecordDialog.java */
/* renamed from: com.sec.chaton.multimedia.audio.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC2749y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2747w f9878a;

    ViewOnClickListenerC2749y(DialogC2747w dialogC2747w) {
        this.f9878a = dialogC2747w;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        if (this.f9878a.f9856e != null) {
            this.f9878a.f9856e.m11507a();
        }
        Message.obtain(this.f9878a.f9865n, 0, this.f9878a.f9872u, 0, this.f9878a.f9871t).sendToTarget();
        this.f9878a.dismiss();
    }
}
