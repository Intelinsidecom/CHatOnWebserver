package com.sec.chaton.registration;

import android.content.Intent;
import android.support.v4.content.C0096i;
import android.view.View;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1058ba;

/* compiled from: AbstractUpgradeDialog.java */
/* renamed from: com.sec.chaton.registration.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC3239e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12005a;

    /* renamed from: b */
    final /* synthetic */ AbstractUpgradeDialog f12006b;

    ViewOnClickListenerC3239e(AbstractUpgradeDialog abstractUpgradeDialog, int i) {
        this.f12006b = abstractUpgradeDialog;
        this.f12005a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12006b.finish();
        if (this.f12006b.getIntent().getBooleanExtra("isFromHome", true)) {
            C0991aa.m6037a().m18962d(new C1058ba());
            return;
        }
        Intent intent = new Intent("upgrade_cancel");
        intent.putExtra("which_service", this.f12005a);
        intent.putExtra("isCritical", true);
        C0096i.m358a(this.f12006b.getApplicationContext()).m363a(intent);
    }
}
