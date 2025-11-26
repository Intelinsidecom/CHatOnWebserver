package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.settings.FragmentDeleteAccount;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.bu */
/* loaded from: classes.dex */
class ViewOnClickListenerC1269bu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount f4816a;

    ViewOnClickListenerC1269bu(FragmentDeleteAccount fragmentDeleteAccount) {
        this.f4816a = fragmentDeleteAccount;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new FragmentDeleteAccount.DeleteAlertDialog().show(this.f4816a.getFragmentManager(), "delete_dialog");
    }
}
