package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.view.View;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.w */
/* loaded from: classes.dex */
class ViewOnClickListenerC0786w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlayAudio f2684a;

    ViewOnClickListenerC0786w(PlayAudio playAudio) {
        this.f2684a = playAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2684a.setResult(0, new Intent());
        this.f2684a.finish();
    }
}
