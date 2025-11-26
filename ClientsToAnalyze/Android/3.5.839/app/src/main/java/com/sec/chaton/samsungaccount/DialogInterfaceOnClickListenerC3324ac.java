package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.util.C4809aa;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3324ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC3328ag f12242a;

    /* renamed from: b */
    final /* synthetic */ AbstractMultiDeviceActivity f12243b;

    DialogInterfaceOnClickListenerC3324ac(AbstractMultiDeviceActivity abstractMultiDeviceActivity, EnumC3328ag enumC3328ag) {
        this.f12243b = abstractMultiDeviceActivity;
        this.f12242a = enumC3328ag;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12242a.equals(EnumC3328ag.mapping)) {
            C4809aa.m18105a("account_mapping_fail", (Boolean) true);
            this.f12243b.mo12788h();
        } else {
            this.f12243b.finish();
        }
    }
}
