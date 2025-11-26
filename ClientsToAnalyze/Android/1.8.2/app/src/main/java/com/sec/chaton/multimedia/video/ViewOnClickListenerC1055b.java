package com.sec.chaton.multimedia.video;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C1767bw;

/* compiled from: VideoPreviewActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC1055b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f3942a;

    ViewOnClickListenerC1055b(VideoPreviewActivity videoPreviewActivity) {
        this.f3942a = videoPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1767bw.m6002a()) {
            Toast.makeText(this.f3942a.f3916c, R.string.toast_cannot_play_video, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(this.f3942a.f3915b), "video/*");
        intent.putExtra("android.intent.extra.finishOnCompletion", false);
        this.f3942a.startActivity(intent);
    }
}
