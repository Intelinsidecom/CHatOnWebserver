package com.sec.chaton.registration;

import android.content.Context;
import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC2230e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f8524a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f8525b;

    ViewOnClickListenerC2230e(AbstractUpgradeDialog abstractUpgradeDialog, Context context) {
        this.f8525b = abstractUpgradeDialog;
        this.f8524a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f8525b.finish();
        if (this.f8525b.getIntent().getBooleanExtra("isFromHome", true)) {
            GlobalApplication.m6449a(this.f8524a);
        } else {
            GlobalApplication.m6452b(this.f8524a);
        }
    }
}
