package com.sec.vip.amschaton.fragment;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.e */
/* loaded from: classes.dex */
class HandlerC3552e extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12982a;

    HandlerC3552e(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f12982a = aMSBgSelectionFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 2000:
                if (this.f12982a.f12646v == 3002) {
                    if (message.arg1 == 1) {
                        this.f12982a.f12629C = true;
                    } else {
                        this.f12982a.f12629C = false;
                    }
                    this.f12982a.getActivity().supportInvalidateOptionsMenu();
                    if (this.f12982a.f12627A != null) {
                        this.f12982a.f12627A.setChecked(message.arg2 == 1);
                        break;
                    }
                }
                break;
        }
    }
}
