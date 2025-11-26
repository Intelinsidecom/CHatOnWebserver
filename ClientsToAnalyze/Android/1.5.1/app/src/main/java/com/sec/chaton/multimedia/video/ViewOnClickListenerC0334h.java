package com.sec.chaton.multimedia.video;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.multimedia.video.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC0334h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f2423a;

    ViewOnClickListenerC0334h(VideoPreviewActivity videoPreviewActivity) {
        this.f2423a = videoPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2423a.setResult(0, new Intent());
        this.f2423a.finish();
    }
}
