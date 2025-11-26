package com.sec.chaton.poston;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bj */
/* loaded from: classes.dex */
class HandlerC1997bj extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7712a;

    HandlerC1997bj(PostONWriteFragment postONWriteFragment) {
        this.f7712a = postONWriteFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 2:
                    int i = message.arg1;
                    this.f7712a.f7577C.m11483a(i);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("FileUploadTask.MSG_TYPE_UPLOAD_PROGRESS nProgress: " + i, "PostONWriteFragment");
                        break;
                    }
                    break;
            }
        }
    }
}
