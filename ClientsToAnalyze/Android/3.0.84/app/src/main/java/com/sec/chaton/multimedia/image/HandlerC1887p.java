package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.p */
/* loaded from: classes.dex */
class HandlerC1887p extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f7170a;

    HandlerC1887p(ImagePagerActivity imagePagerActivity) {
        this.f7170a = imagePagerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        if (message.what == 1) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            this.f7170a.finish();
            return;
        }
        String string = message.getData().getString("download_uri");
        long j = Long.parseLong(message.obj.toString());
        if (C3250y.f11734b) {
            C3250y.m11450b("messageId : " + j + ", uri: " + string, ImagePagerActivity.f6898b);
        }
        this.f7170a.m7580a(j, string);
        if (this.f7170a.f6922p.containsKey(Long.valueOf(j))) {
            ((ImagePagerFragment) this.f7170a.f6922p.get(Long.valueOf(j))).m7628a(string);
        }
    }
}
