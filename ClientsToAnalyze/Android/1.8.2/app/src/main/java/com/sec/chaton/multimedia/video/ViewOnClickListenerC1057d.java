package com.sec.chaton.multimedia.video;

import android.view.View;
import com.sec.chaton.util.C1786r;

/* compiled from: VideoRecordActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC1057d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f3944a;

    ViewOnClickListenerC1057d(VideoRecordActivity videoRecordActivity) {
        this.f3944a = videoRecordActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1786r.m6067f("onClick() : Clicked", VideoRecordActivity.f3920a);
        if (this.f3944a.f3922c == null) {
            this.f3944a.m4062a(this.f3944a.f3924e);
        }
        if (this.f3944a.f3922c != null) {
            switch (this.f3944a.f3922c.m4087a()) {
                case BEFORE_START:
                    C1786r.m6067f("mVideoRecordManager.getState() : BEFORE_START", VideoRecordActivity.f3920a);
                    break;
                case READY_TO_START:
                    C1786r.m6067f("mVideoRecordManager.getState() : READY_TO_START", VideoRecordActivity.f3920a);
                    this.f3944a.f3930k.setVisibility(8);
                    this.f3944a.f3931l.setVisibility(8);
                    this.f3944a.m4070c();
                    break;
                case RECORDING:
                    C1786r.m6067f("mVideoRecordManager.getState() : RECORDING", VideoRecordActivity.f3920a);
                    this.f3944a.m4072d();
                    this.f3944a.m4075f();
                    break;
                case TERMINATED:
                    C1786r.m6067f("mVideoRecordManager.getState() : TERMINATED", VideoRecordActivity.f3920a);
                    this.f3944a.f3930k.setVisibility(8);
                    this.f3944a.f3931l.setVisibility(8);
                    this.f3944a.m4062a(this.f3944a.f3924e);
                    this.f3944a.m4070c();
                    break;
            }
        }
    }
}
