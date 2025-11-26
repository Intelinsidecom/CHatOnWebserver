package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.p025d.C1335m;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.fa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1086fa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1082ex f4348a;

    DialogInterfaceOnClickListenerC1086fa(AlertDialogC1082ex alertDialogC1082ex) {
        this.f4348a = alertDialogC1082ex;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4348a.f4340h = this.f4348a.f4338f.m11463a().toString().trim();
        if (this.f4348a.f4343k == null || this.f4348a.f4343k.equals("")) {
            this.f4348a.m5354b();
            return;
        }
        C1335m.m5789c(this.f4348a.f4335c, this.f4348a.f4343k, this.f4348a.f4340h);
        if (this.f4348a.f4334b != null && !this.f4348a.f4334b.isShowing()) {
            this.f4348a.f4334b.show();
        }
    }
}
