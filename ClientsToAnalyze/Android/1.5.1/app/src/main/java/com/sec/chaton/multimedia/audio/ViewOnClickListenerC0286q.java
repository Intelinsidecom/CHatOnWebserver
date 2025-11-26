package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.multimedia.audio.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC0286q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlayAudio f2096a;

    ViewOnClickListenerC0286q(PlayAudio playAudio) {
        this.f2096a = playAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2096a.setResult(0, new Intent());
        this.f2096a.finish();
    }
}
