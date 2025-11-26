package com.sec.chaton.multimedia.video;

import android.view.View;

/* renamed from: com.sec.chaton.multimedia.video.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC0327a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f2416a;

    ViewOnClickListenerC0327a(VideoRecordActivity videoRecordActivity) {
        this.f2416a = videoRecordActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2416a.m2670a(this.f2416a.f2403o);
        this.f2416a.finish();
    }
}
