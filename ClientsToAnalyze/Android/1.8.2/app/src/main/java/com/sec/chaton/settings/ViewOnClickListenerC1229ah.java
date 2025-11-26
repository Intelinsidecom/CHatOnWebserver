package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.view.View;
import com.sec.chaton.R;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.ah */
/* loaded from: classes.dex */
class ViewOnClickListenerC1229ah implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4768a;

    /* renamed from: b */
    final /* synthetic */ ActivityPasswordLockSet f4769b;

    ViewOnClickListenerC1229ah(ActivityPasswordLockSet activityPasswordLockSet, String str) {
        this.f4769b = activityPasswordLockSet;
        this.f4768a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4769b.f4535q != null) {
            new AlertDialogBuilderC2120a(this.f4769b.f4535q).setTitle(this.f4769b.getResources().getString(R.string.settings_delete)).setMessage(this.f4768a).setPositiveButton(R.string.setting_delete_account_cancel, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1230ai(this)).create().show();
        }
    }
}
