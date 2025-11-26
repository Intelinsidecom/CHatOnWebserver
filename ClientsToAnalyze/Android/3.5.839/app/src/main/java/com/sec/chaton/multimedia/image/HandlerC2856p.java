package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.p */
/* loaded from: classes.dex */
class HandlerC2856p extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f10490a;

    HandlerC2856p(ImagePagerActivity imagePagerActivity) {
        this.f10490a = imagePagerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        if (message.what == 1) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
            this.f10490a.finish();
            return;
        }
        String string = message.getData().getString("download_uri");
        long j = Long.parseLong(message.obj.toString());
        if (C4904y.f17872b) {
            C4904y.m18639b("messageId : " + j + ", uri: " + string, ImagePagerActivity.f10196o);
        }
        this.f10490a.m11787a(j, string);
        if (this.f10490a.f10200D.containsKey(Long.valueOf(j))) {
            ((ImagePagerFragment) this.f10490a.f10200D.get(Long.valueOf(j))).m11842a(string);
        }
    }
}
