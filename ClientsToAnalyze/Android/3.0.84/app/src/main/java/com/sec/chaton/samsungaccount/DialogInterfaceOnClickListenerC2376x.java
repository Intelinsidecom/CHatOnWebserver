package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.util.C3159aa;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2376x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2337az f8834a;

    /* renamed from: b */
    final /* synthetic */ MainActivity f8835b;

    DialogInterfaceOnClickListenerC2376x(MainActivity mainActivity, EnumC2337az enumC2337az) {
        this.f8835b = mainActivity;
        this.f8834a = enumC2337az;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8834a.equals(EnumC2337az.mapping)) {
            C3159aa.m10963a("account_mapping_fail", (Boolean) true);
            this.f8835b.f8679aa.setVisibility(8);
            this.f8835b.f8680ab.setVisibility(0);
            return;
        }
        this.f8835b.finish();
    }
}
