package com.sec.chaton.multimedia.video;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: VideoPreviewActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.c */
/* loaded from: classes.dex */
class C1056c implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f3943a;

    C1056c(VideoPreviewActivity videoPreviewActivity) {
        this.f3943a = videoPreviewActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            this.f3943a.m4055a();
        } else if (i == 1) {
            this.f3943a.m4057b();
        }
    }
}
