package com.sec.chaton.multimedia.video;

import android.view.View;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.multimedia.video.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC0329c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f2418a;

    ViewOnClickListenerC0329c(VideoRecordActivity videoRecordActivity) {
        this.f2418a = videoRecordActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.f2418a.f2391c.m2692a()) {
            case BEFORE_START:
                ChatONLogWriter.m3512f("mVideoRecordManager.getState() : BEFORE_START", VideoRecordActivity.f2389a);
                break;
            case READY_TO_START:
                ChatONLogWriter.m3512f("mVideoRecordManager.getState() : READY_TO_START", VideoRecordActivity.f2389a);
                this.f2418a.f2399k.setVisibility(8);
                this.f2418a.f2400l.setVisibility(8);
                this.f2418a.m2675d();
                break;
            case RECORDING:
                ChatONLogWriter.m3512f("mVideoRecordManager.getState() : RECORDING", VideoRecordActivity.f2389a);
                this.f2418a.m2677e();
                this.f2418a.m2681g();
                break;
            case TERMINATED:
                ChatONLogWriter.m3512f("mVideoRecordManager.getState() : TERMINATED", VideoRecordActivity.f2389a);
                if (!this.f2418a.f2394f) {
                    this.f2418a.f2395g.setEnabled(false);
                    break;
                } else {
                    this.f2418a.f2399k.setVisibility(8);
                    this.f2418a.f2400l.setVisibility(8);
                    this.f2418a.m2674c();
                    this.f2418a.m2675d();
                    break;
                }
        }
    }
}
