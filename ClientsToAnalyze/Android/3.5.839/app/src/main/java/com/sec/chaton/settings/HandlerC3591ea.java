package com.sec.chaton.settings;

import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.common.CommonApplication;

/* compiled from: DeregisterFragment.java */
/* renamed from: com.sec.chaton.settings.ea */
/* loaded from: classes.dex */
class HandlerC3591ea extends HandlerC4826ar {

    /* renamed from: a */
    final /* synthetic */ DeregisterFragment f13112a;

    HandlerC3591ea(DeregisterFragment deregisterFragment) {
        this.f13112a = deregisterFragment;
    }

    @Override // com.sec.chaton.util.HandlerC4826ar
    /* renamed from: a */
    public void mo6050a(Message message) {
        if (this.f13112a.getActivity() != null) {
            if (((Boolean) message.obj).booleanValue()) {
                C4904y.m18639b("Push deregistration is success. execute chaton deregistration.", DeregisterFragment.f12663p);
            } else {
                C4904y.m18634a("Push deregistration is fail.", DeregisterFragment.f12663p);
            }
            if (!C4873ck.m18503d()) {
                this.f13112a.m13549c();
                Toast.makeText(CommonApplication.m18732r(), R.string.popup_not_enough_memory, 0).show();
            } else {
                this.f13112a.f12673j = this.f13112a.f12674k.m9348a();
            }
        }
    }
}
