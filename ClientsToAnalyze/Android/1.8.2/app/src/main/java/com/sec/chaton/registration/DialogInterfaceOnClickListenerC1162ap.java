package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1162ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1160an f4364a;

    DialogInterfaceOnClickListenerC1162ap(HandlerC1160an handlerC1160an) {
        this.f4364a = handlerC1160an;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C1789u.m6075a().edit().putString("provisioning_pushname_status", "").commit();
        this.f4364a.f4362a.f4269m.m2809a(this.f4364a.f4362a.f4267k, this.f4364a.f4362a.f4257a.getText().toString(), this.f4364a.f4362a.f4265i == null ? null : this.f4364a.f4362a.f4265i, this.f4364a.f4362a.f4266j);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.f4364a.f4362a.f4270n = ProgressDialogC1806j.m6141a(this.f4364a.f4362a.f4261e, null, this.f4364a.f4362a.getResources().getString(R.string.please_wait), true);
    }
}
