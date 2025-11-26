package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.p055d.C2134o;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.gw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1750gw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1747gt f6578a;

    DialogInterfaceOnClickListenerC1750gw(AlertDialogC1747gt alertDialogC1747gt) {
        this.f6578a = alertDialogC1747gt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6578a.f6571h = this.f6578a.f6569f.m18658a().toString().trim();
        if (this.f6578a.f6574k == null || this.f6578a.f6574k.equals("")) {
            this.f6578a.m8693b();
            return;
        }
        C2134o.m9576c(this.f6578a.f6566c, this.f6578a.f6574k, this.f6578a.f6571h);
        if (this.f6578a.f6565b != null && !this.f6578a.f6565b.isShowing()) {
            this.f6578a.f6565b.show();
        }
    }
}
