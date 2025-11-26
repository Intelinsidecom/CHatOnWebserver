package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.trunk.entry.GetItemEntry;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.ac */
/* loaded from: classes.dex */
class HandlerC2818ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f10382a;

    HandlerC2818ac(ImagePagerFragment imagePagerFragment) {
        this.f10382a = imagePagerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10382a.f10260v != null && this.f10382a.m11844d() != null && !this.f10382a.m11844d().isFinishing()) {
            switch (message.what) {
                case 901:
                    C0778b c0778b = (C0778b) message.obj;
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        GetItemEntry getItemEntry = (GetItemEntry) c0778b.m3110e();
                        this.f10382a.f10235C = getItemEntry.item.totcmtcnt.intValue();
                        this.f10382a.m11844d().m11811a(this.f10382a.f10250l, this.f10382a.f10235C);
                        break;
                    }
                    break;
            }
        }
    }
}
