package com.sec.chaton.chat.p054a;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.multimedia.image.C2844d;
import com.sec.chaton.util.C4904y;

/* compiled from: ImageBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ad */
/* loaded from: classes.dex */
class HandlerC1510ad extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1509ac f5892a;

    HandlerC1510ad(C1509ac c1509ac) {
        this.f5892a = c1509ac;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        if (!this.f5892a.f5884N) {
            switch (message.what) {
                case 0:
                    if (message.obj != null) {
                        this.f5892a.m8376a(message.obj.toString());
                        this.f5892a.m8379b(message.obj.toString());
                        if (this.f5892a.f5886P) {
                            this.f5892a.f5863j.m19023b(this.f5892a.f5885O, new C2844d(this.f5892a.f5887Q + this.f5892a.f5886P, this.f5892a.f5876w, true, true, this.f5892a.f5874u, true, this.f5892a.f5886P, this.f5892a.f5891U, this.f5892a.m8404s(), this.f5892a.f5867n, this.f5892a.m8404s() ? this.f5892a.f5868o : this.f5892a.f5866m, this.f5892a.f5875v, this.f5892a.f5877x));
                            break;
                        }
                    }
                    break;
                case 2:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("play done", C1509ac.f5882L);
                    }
                    if (this.f5892a.f5890T != null) {
                        this.f5892a.f5890T.cancel(true);
                        this.f5892a.f5890T.m11937a();
                    }
                    this.f5892a.f5885O.setVisibility(0);
                    this.f5892a.f5889S.setVisibility(0);
                    this.f5892a.f5889S.bringToFront();
                    break;
            }
        }
    }
}
