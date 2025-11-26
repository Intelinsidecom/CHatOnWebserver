package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.view.View;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC0880j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlayAudio f3274a;

    ViewOnClickListenerC0880j(PlayAudio playAudio) {
        this.f3274a = playAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3274a.setResult(0, new Intent());
        this.f3274a.finish();
    }
}
