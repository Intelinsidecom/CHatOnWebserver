package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.util.C1786r;

/* compiled from: ViewOriginalImage.java */
/* renamed from: com.sec.chaton.multimedia.image.d */
/* loaded from: classes.dex */
class HandlerC0986d extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOriginalImage f3645a;

    HandlerC0986d(ViewOriginalImage viewOriginalImage) {
        this.f3645a = viewOriginalImage;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str = (String) message.obj;
        if (C1786r.f6452b) {
            C1786r.m6061b("messageId : " + this.f3645a.f3607f + ", uri: " + str, ViewOriginalImage.f3603e);
        }
        this.f3645a.f3611j.setVisibility(4);
        if (!TextUtils.isEmpty(str) && !C0452a.f1724c.equals(str)) {
            this.f3645a.f3612k.setEnabled(true);
            this.f3645a.f3605c = str;
            if (this.f3645a.f3605c.startsWith("file:")) {
                this.f3645a.f3605c = this.f3645a.f3605c.substring(6);
            }
            this.f3645a.m3858a(this.f3645a.f3605c);
        }
    }
}
