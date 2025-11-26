package com.sec.chaton.multimedia.video;

import android.view.View;

/* renamed from: com.sec.chaton.multimedia.video.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0330d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f2419a;

    ViewOnClickListenerC0330d(VideoRecordActivity videoRecordActivity) {
        this.f2419a = videoRecordActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2419a.m2679f();
        this.f2419a.m2670a((String) null);
        this.f2419a.finish();
    }
}
