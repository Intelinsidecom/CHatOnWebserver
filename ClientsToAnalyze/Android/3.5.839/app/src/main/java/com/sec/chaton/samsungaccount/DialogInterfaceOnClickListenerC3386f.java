package com.sec.chaton.samsungaccount;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.f */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC3386f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f12346a;

    /* renamed from: b */
    final /* synthetic */ Context f12347b;

    DialogInterfaceOnClickListenerC3386f(boolean z, Context context) {
        this.f12346a = z;
        this.f12347b = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12346a && (this.f12347b instanceof Activity)) {
            ((Activity) this.f12347b).finish();
        }
    }
}
