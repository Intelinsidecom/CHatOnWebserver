package com.sec.chaton.multimedia.video;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: VideoRecordActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.h */
/* loaded from: classes.dex */
class HandlerC1061h extends Handler {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f3948a;

    HandlerC1061h(VideoRecordActivity videoRecordActivity) {
        this.f3948a = videoRecordActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 0 && this.f3948a.f3935p != null) {
            C1786r.m6067f("" + (this.f3948a.f3935p.length() / 1024) + "K", VideoRecordActivity.f3920a);
            this.f3948a.f3937r.setText("  " + (this.f3948a.f3935p.length() / 1024) + "K / " + AMSLibs.ENUM_VIP_AMS_WQVGA_SAVE_USER_STAMPIMAGE_SIZE + "K  ");
            if (this.f3948a.f3935p.length() > 9332326.4d) {
                Toast.makeText(this.f3948a.f3933n, R.string.duration_2min_orver, 1).show();
                this.f3948a.m4072d();
                this.f3948a.m4075f();
            }
            if (this.f3948a.f3938s.isEnabled()) {
                this.f3948a.f3938s.setEnabled(false);
            } else {
                this.f3948a.f3938s.setEnabled(true);
            }
        }
    }
}
