package com.sec.chaton.multimedia.video;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C1767bw;

/* compiled from: VideoRecordActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC1060g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f3947a;

    ViewOnClickListenerC1060g(VideoRecordActivity videoRecordActivity) {
        this.f3947a = videoRecordActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strValueOf = String.valueOf(this.f3947a.f3930k.getTag());
        if (!C1767bw.m6002a()) {
            Toast.makeText(this.f3947a.f3933n, R.string.toast_cannot_play_video, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(strValueOf), "video/*");
        intent.putExtra("android.intent.extra.finishOnCompletion", false);
        this.f3947a.startActivity(intent);
    }
}
