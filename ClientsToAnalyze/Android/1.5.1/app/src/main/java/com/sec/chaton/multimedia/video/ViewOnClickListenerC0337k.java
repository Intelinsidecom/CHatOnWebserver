package com.sec.chaton.multimedia.video;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.StorageStateInfoUtil;

/* renamed from: com.sec.chaton.multimedia.video.k */
/* loaded from: classes.dex */
class ViewOnClickListenerC0337k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f2426a;

    ViewOnClickListenerC0337k(VideoPreviewActivity videoPreviewActivity) {
        this.f2426a = videoPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StorageStateInfoUtil.m3677a()) {
            Toast.makeText(this.f2426a.f2388b, C0062R.string.toast_cannot_play_video, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(this.f2426a.f2387a), "video/*");
        intent.putExtra("android.intent.extra.finishOnCompletion", false);
        this.f2426a.startActivity(intent);
    }
}
