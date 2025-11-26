package com.sec.chaton;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.AboutFragment;
import com.sec.chaton.util.C1323bs;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC0244ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f591a;

    ViewOnClickListenerC0244ag(UpgradeDialog upgradeDialog) {
        this.f591a = upgradeDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f591a.finish();
        GlobalApplication.m3102a(this.f591a);
        C1323bs.m4575a().getString("UpdateUrl", "");
        AboutFragment.m3776a(this.f591a);
    }
}
