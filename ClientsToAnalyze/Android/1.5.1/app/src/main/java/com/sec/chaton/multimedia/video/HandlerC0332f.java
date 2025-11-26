package com.sec.chaton.multimedia.video;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.multimedia.video.f */
/* loaded from: classes.dex */
class HandlerC0332f extends Handler {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f2421a;

    HandlerC0332f(VideoRecordActivity videoRecordActivity) {
        this.f2421a = videoRecordActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 0 || this.f2421a.f2404p == null) {
            return;
        }
        ChatONLogWriter.m3512f("" + (this.f2421a.f2404p.length() / 1024) + "K", VideoRecordActivity.f2389a);
        this.f2421a.f2406r.setText("  " + (this.f2421a.f2404p.length() / 1024) + "K / " + AMSLibs.ENUM_VIP_AMS_WQVGA_SAVE_USER_STAMPIMAGE_SIZE + "K  ");
        if (this.f2421a.f2404p.length() > 9332326.4d) {
            Toast.makeText(this.f2421a.f2402n, C0062R.string.duration_2min_orver, 1).show();
            this.f2421a.m2677e();
            this.f2421a.m2681g();
        }
        if (this.f2421a.f2407s.isEnabled()) {
            this.f2421a.f2407s.setEnabled(false);
        } else {
            this.f2421a.f2407s.setEnabled(true);
        }
    }
}
