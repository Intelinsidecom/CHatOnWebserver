package com.sec.chaton.settings;

import android.app.AlertDialog;
import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.an */
/* loaded from: classes.dex */
class ViewOnClickListenerC0465an implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityDeleteAccount f3157a;

    ViewOnClickListenerC0465an(ActivityDeleteAccount activityDeleteAccount) {
        this.f3157a = activityDeleteAccount;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f3157a.f2986a);
        builder.setMessage(C0062R.string.dialog_relrase).setCancelable(true).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0500k(this)).setNegativeButton(C0062R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC0499j(this));
        builder.create().show();
    }
}
