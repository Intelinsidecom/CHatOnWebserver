package com.sec.chaton.settings;

import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.HandlerC3176ar;
import com.sec.common.CommonApplication;

/* compiled from: DeregisterFragment.java */
/* renamed from: com.sec.chaton.settings.dh */
/* loaded from: classes.dex */
class HandlerC2501dh extends HandlerC3176ar {

    /* renamed from: a */
    final /* synthetic */ DeregisterFragment f9391a;

    HandlerC2501dh(DeregisterFragment deregisterFragment) {
        this.f9391a = deregisterFragment;
    }

    @Override // com.sec.chaton.util.HandlerC3176ar
    /* renamed from: a */
    public void mo3031a(Message message) {
        if (this.f9391a.getActivity() != null) {
            if (((Boolean) message.obj).booleanValue()) {
                C3250y.m11450b("Push deregistration is success. execute chaton deregistration.", DeregisterFragment.f9115l);
                if (!C3223ck.m11330d()) {
                    this.f9391a.m9089c();
                    Toast.makeText(CommonApplication.m11493l(), R.string.popup_not_enough_memory, 0).show();
                    return;
                } else {
                    this.f9391a.f9123h = this.f9391a.f9124i.m5596a();
                    return;
                }
            }
            C3250y.m11442a("Push deregistration is fail.", DeregisterFragment.f9115l);
            this.f9391a.m9089c();
            this.f9391a.m9091d();
        }
    }
}
