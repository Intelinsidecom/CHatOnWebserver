package com.sec.chaton.poston;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bk */
/* loaded from: classes.dex */
class HandlerC2993bk extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11108a;

    HandlerC2993bk(PostONWriteFragment postONWriteFragment) {
        this.f11108a = postONWriteFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 2:
                    int i = message.arg1;
                    this.f11108a.f10973E.m18719a(i);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("FileUploadTask.MSG_TYPE_UPLOAD_PROGRESS nProgress: " + i, "PostONWriteFragment");
                        break;
                    }
                    break;
            }
        }
    }
}
