package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.view.View;
import com.sec.chaton.R;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1231aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4771a;

    /* renamed from: b */
    final /* synthetic */ ActivityPasswordLockSet f4772b;

    ViewOnClickListenerC1231aj(ActivityPasswordLockSet activityPasswordLockSet, String str) {
        this.f4772b = activityPasswordLockSet;
        this.f4771a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4772b.f4535q != null) {
            new AlertDialogBuilderC2120a(this.f4772b.f4535q).setTitle(this.f4772b.getResources().getString(R.string.settings_delete)).setMessage(this.f4771a).setPositiveButton(R.string.setting_delete_account_cancel, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1232ak(this)).create().show();
        }
    }
}
