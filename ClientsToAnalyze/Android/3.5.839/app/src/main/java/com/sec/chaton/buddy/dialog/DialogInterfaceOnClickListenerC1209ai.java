package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;
import android.widget.Toast;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0993ac;
import com.sec.chaton.EnumC1005ad;
import com.sec.chaton.R;

/* compiled from: SpamConfirmDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1209ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpamConfirmDialog f4704a;

    DialogInterfaceOnClickListenerC1209ai(SpamConfirmDialog spamConfirmDialog) {
        this.f4704a = spamConfirmDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4704a.m7344a();
        Toast.makeText(this.f4704a.getApplicationContext(), this.f4704a.getResources().getString(R.string.suggestion_spammer_reported_toast, this.f4704a.f4655d), 0).show();
        C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.REPORTED, this.f4704a.f4656e));
        this.f4704a.finish();
    }
}
