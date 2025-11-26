package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.localbackup.p075a.C2513d;
import com.sec.common.util.p133a.C5023g;
import com.sec.common.util.p133a.C5024h;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.q */
/* loaded from: classes.dex */
class HandlerC2857q extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f10491a;

    HandlerC2857q(ImagePagerActivity imagePagerActivity) {
        this.f10491a = imagePagerActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 2:
                C5023g c5023g = (C5023g) message.obj;
                C2513d c2513d = (C2513d) c5023g.m19082a();
                this.f10491a.m11787a(c2513d.m10882a(), c5023g.m19086b().getAbsolutePath());
                if (this.f10491a.f10200D.containsKey(Long.valueOf(c2513d.m10882a()))) {
                    ((ImagePagerFragment) this.f10491a.f10200D.get(Long.valueOf(c2513d.m10882a()))).m11842a(c5023g.m19086b().getAbsolutePath());
                    break;
                }
                break;
            case 3:
            case 4:
                C2513d c2513d2 = (C2513d) ((C5024h) message.obj).m19082a();
                if (this.f10491a.f10200D.containsKey(Long.valueOf(c2513d2.m10882a()))) {
                    ((ImagePagerFragment) this.f10491a.f10200D.get(Long.valueOf(c2513d2.m10882a()))).m11842a((String) null);
                    break;
                }
                break;
        }
        super.handleMessage(message);
    }
}
