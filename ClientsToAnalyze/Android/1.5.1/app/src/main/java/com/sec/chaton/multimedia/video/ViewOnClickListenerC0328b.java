package com.sec.chaton.multimedia.video;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.StorageStateInfoUtil;

/* renamed from: com.sec.chaton.multimedia.video.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0328b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f2417a;

    ViewOnClickListenerC0328b(VideoRecordActivity videoRecordActivity) {
        this.f2417a = videoRecordActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strValueOf = String.valueOf(this.f2417a.f2399k.getTag());
        if (!StorageStateInfoUtil.m3677a()) {
            Toast.makeText(this.f2417a.f2402n, C0062R.string.toast_cannot_play_video, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(strValueOf), "video/*");
        intent.putExtra("android.intent.extra.finishOnCompletion", false);
        this.f2417a.startActivity(intent);
    }
}
