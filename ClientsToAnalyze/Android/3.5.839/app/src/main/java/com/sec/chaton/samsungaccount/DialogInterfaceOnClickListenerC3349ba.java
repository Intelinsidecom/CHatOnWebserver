package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.p055d.EnumC2111bq;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ba */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3349ba implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12287a;

    DialogInterfaceOnClickListenerC3349ba(MainActivity mainActivity) {
        this.f12287a = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12287a.m13147p();
        if (this.f12287a.f12169w) {
            EnumC2111bq.m9446a(EnumC2111bq.STARTING);
        }
        this.f12287a.f12193C.m9432g();
    }
}
