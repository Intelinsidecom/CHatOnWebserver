package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.settings.FragmentDeleteAccount;
import com.sec.chaton.util.C1346u;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC1004ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount f3608a;

    ViewOnClickListenerC1004ab(FragmentDeleteAccount fragmentDeleteAccount) {
        this.f3608a = fragmentDeleteAccount;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            new FragmentDeleteAccount.DeleteAMSAlertDialog().show(this.f3608a.getFragmentManager(), "delete_dialog");
        }
    }
}
