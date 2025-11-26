package com.sec.chaton.hide;

import android.os.Handler;
import android.os.Message;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.u */
/* loaded from: classes.dex */
class HandlerC2386u extends Handler {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f8473a;

    HandlerC2386u(HideListFragment hideListFragment) {
        this.f8473a = hideListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 704:
                HideListFragment.f8416b.dismiss();
                break;
            case 705:
                HideListFragment.f8416b.dismiss();
                break;
        }
    }
}
