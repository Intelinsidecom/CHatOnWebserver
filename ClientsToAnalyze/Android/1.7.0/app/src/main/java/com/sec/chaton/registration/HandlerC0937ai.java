package com.sec.chaton.registration;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.registration.ActivityRegistPushName;
import com.sec.chaton.util.C1341p;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ai */
/* loaded from: classes.dex */
class HandlerC0937ai extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f3324a;

    HandlerC0937ai(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f3324a = registPushNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!((Boolean) message.obj).booleanValue() && !((Boolean) message.obj).booleanValue()) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3324a.getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            C1341p.m4658b("[Dev]Push registration failed. Network is " + (activeNetworkInfo == null ? "unavailable" : activeNetworkInfo.getTypeName()), "ActivityProvisioning");
        }
        this.f3324a.f3243l.m774a(this.f3324a.f3241j, this.f3324a.f3232a.getText().toString(), this.f3324a.f3239h == null ? null : this.f3324a.f3239h, this.f3324a.f3240i);
        this.f3324a.f3233b.setEnabled(true);
        this.f3324a.f3246o.setButtonEnabled(true);
    }
}
