package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.widget.ProgressDialogC1354a;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ay */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0953ay implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0935ag f3344a;

    DialogInterfaceOnClickListenerC0953ay(HandlerC0935ag handlerC0935ag) {
        this.f3344a = handlerC0935ag;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C1323bs.m4575a().edit().putString("provisioning_pushname_status", "").commit();
        this.f3344a.f3322a.f3243l.m774a(this.f3344a.f3322a.f3241j, this.f3344a.f3322a.f3232a.getText().toString(), this.f3344a.f3322a.f3239h == null ? null : this.f3344a.f3322a.f3239h, this.f3344a.f3322a.f3240i);
        dialogInterface.dismiss();
        if (this.f3344a.f3322a.f3235d != null) {
            this.f3344a.f3322a.f3244m = ProgressDialogC1354a.m4724a(this.f3344a.f3322a.f3235d, null, this.f3344a.f3322a.getResources().getString(R.string.please_wait), true);
        }
    }
}
