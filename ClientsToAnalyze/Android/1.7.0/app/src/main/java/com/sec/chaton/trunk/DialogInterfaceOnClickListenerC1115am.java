package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.am */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1115am implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3925a;

    /* renamed from: b */
    final /* synthetic */ TrunkItemView f3926b;

    DialogInterfaceOnClickListenerC1115am(TrunkItemView trunkItemView, String str) {
        this.f3926b = trunkItemView;
        this.f3925a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 == iM2526a || -2 == iM2526a) {
            this.f3926b.m4023l();
        } else {
            this.f3926b.m4024m();
            this.f3926b.f3795ab.mo4190a(this.f3925a);
        }
    }
}
