package com.sec.chaton.multimedia.audio;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.r */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0781r implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2677a;

    ViewOnTouchListenerC0781r(RecordAudio recordAudio) {
        this.f2677a = recordAudio;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f2677a.f2641n;
    }
}
