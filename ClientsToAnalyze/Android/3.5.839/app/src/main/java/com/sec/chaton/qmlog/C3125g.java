package com.sec.chaton.qmlog;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

/* compiled from: QMLogManager.java */
/* renamed from: com.sec.chaton.qmlog.g */
/* loaded from: classes.dex */
class C3125g extends PhoneStateListener {

    /* renamed from: a */
    final /* synthetic */ C3122d f11498a;

    private C3125g(C3122d c3122d) {
        this.f11498a = c3122d;
    }

    /* synthetic */ C3125g(C3122d c3122d, RunnableC3123e runnableC3123e) {
        this(c3122d);
    }

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        this.f11498a.f11483h = signalStrength.getGsmSignalStrength();
    }
}
