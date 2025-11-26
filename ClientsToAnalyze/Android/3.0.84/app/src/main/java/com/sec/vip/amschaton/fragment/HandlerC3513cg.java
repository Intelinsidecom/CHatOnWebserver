package com.sec.vip.amschaton.fragment;

import android.os.Handler;
import android.os.Message;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cg */
/* loaded from: classes.dex */
class HandlerC3513cg extends Handler {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12910a;

    HandlerC3513cg(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12910a = aMSStampSelectionFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                if (this.f12910a.f12754m == 2002) {
                    if (message.arg1 == 1) {
                        this.f12910a.f12767z = true;
                    } else {
                        this.f12910a.f12767z = false;
                    }
                    this.f12910a.getActivity().supportInvalidateOptionsMenu();
                    if (this.f12910a.f12755n != null) {
                        this.f12910a.f12755n.setChecked(message.arg2 == 1);
                        break;
                    }
                }
                break;
        }
    }
}
