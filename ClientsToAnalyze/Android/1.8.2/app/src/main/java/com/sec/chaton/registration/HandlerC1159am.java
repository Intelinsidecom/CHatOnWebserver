package com.sec.chaton.registration;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.registration.ActivityRegistPushName;
import com.sec.chaton.util.C1786r;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.am */
/* loaded from: classes.dex */
class HandlerC1159am extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f4361a;

    HandlerC1159am(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f4361a = registPushNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!((Boolean) message.obj).booleanValue() && !((Boolean) message.obj).booleanValue() && this.f4361a.getActivity() != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f4361a.getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            C1786r.m6061b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), "ActivityProvisioning");
        }
        this.f4361a.f4269m.m2809a(this.f4361a.f4267k, this.f4361a.f4257a.getText().toString(), this.f4361a.f4265i == null ? null : this.f4361a.f4265i, this.f4361a.f4266j);
        this.f4361a.f4259c.setEnabled(true);
    }
}
