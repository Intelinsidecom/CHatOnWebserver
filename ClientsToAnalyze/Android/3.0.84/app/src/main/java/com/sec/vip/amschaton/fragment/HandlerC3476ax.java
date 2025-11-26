package com.sec.vip.amschaton.fragment;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ax */
/* loaded from: classes.dex */
class HandlerC3476ax extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12839a;

    HandlerC3476ax(AMSListFragment aMSListFragment) {
        this.f12839a = aMSListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                if (this.f12839a.f12728a == 2002) {
                    if (message.arg1 == 1) {
                        this.f12839a.f12743y = true;
                    } else {
                        this.f12839a.f12743y = false;
                    }
                    this.f12839a.getActivity().supportInvalidateOptionsMenu();
                    if (this.f12839a.f12733o != null) {
                        this.f12839a.f12733o.setChecked(message.arg2 == 1);
                        this.f12839a.f12744z = message.arg2 == 1;
                        break;
                    }
                }
                break;
            case 1001:
                if (message.arg1 <= 0 || this.f12839a.f12728a == 2001) {
                }
                break;
        }
    }
}
