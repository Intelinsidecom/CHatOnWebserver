package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.localbackup.p045a.C1613d;
import com.sec.common.util.p070a.C3338g;
import com.sec.common.util.p070a.C3339h;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.q */
/* loaded from: classes.dex */
class HandlerC1888q extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f7171a;

    HandlerC1888q(ImagePagerActivity imagePagerActivity) {
        this.f7171a = imagePagerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 2:
                C3338g c3338g = (C3338g) message.obj;
                C1613d c1613d = (C1613d) c3338g.m11768a();
                this.f7171a.m7580a(c1613d.m6854a(), c3338g.m11772b().getAbsolutePath());
                if (this.f7171a.f6922p.containsKey(Long.valueOf(c1613d.m6854a()))) {
                    ((ImagePagerFragment) this.f7171a.f6922p.get(Long.valueOf(c1613d.m6854a()))).m7628a(c3338g.m11772b().getAbsolutePath());
                    break;
                }
                break;
            case 3:
            case 4:
                C1613d c1613d2 = (C1613d) ((C3339h) message.obj).m11768a();
                if (this.f7171a.f6922p.containsKey(Long.valueOf(c1613d2.m6854a()))) {
                    ((ImagePagerFragment) this.f7171a.f6922p.get(Long.valueOf(c1613d2.m6854a()))).m7628a((String) null);
                    break;
                }
                break;
        }
        super.handleMessage(message);
    }
}
