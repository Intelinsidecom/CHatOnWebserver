package com.sec.chaton.multimedia.video;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1346u;
import com.sec.widget.C1619g;

/* compiled from: VideoPreviewActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC0844a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f2932a;

    ViewOnClickListenerC0844a(VideoPreviewActivity videoPreviewActivity) {
        this.f2932a = videoPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_button1 /* 2131427690 */:
                this.f2932a.m3413a();
                break;
            case R.id.video_play_button /* 2131428113 */:
                if (!C1346u.m4676a()) {
                    if (!C1327bw.m4595a()) {
                        C1619g.m5888a(this.f2932a.f2930c, R.string.sdcard_not_found, 0).show();
                        break;
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.parse("file://" + this.f2932a.f2929b), "video/*");
                        intent.putExtra("android.intent.extra.finishOnCompletion", false);
                        this.f2932a.startActivity(intent);
                        break;
                    }
                }
                break;
        }
    }
}
