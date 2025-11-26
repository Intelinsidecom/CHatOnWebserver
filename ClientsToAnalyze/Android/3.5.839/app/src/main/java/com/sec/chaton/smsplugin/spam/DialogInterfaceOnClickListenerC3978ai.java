package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: SetupSpamKeywordWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3978ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordWriteForm f14418a;

    DialogInterfaceOnClickListenerC3978ai(SetupSpamKeywordWriteForm setupSpamKeywordWriteForm) {
        this.f14418a = setupSpamKeywordWriteForm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws NumberFormatException {
        String string = this.f14418a.f14330e.getText().toString();
        if (!this.f14418a.f14332g) {
            this.f14418a.m15352a(string);
            Intent intent = this.f14418a.getIntent();
            intent.putExtra("NumberCount", this.f14418a.m15358d());
            this.f14418a.setResult(-1, intent);
            this.f14418a.finish();
            return;
        }
        this.f14418a.m15357c();
        Intent intent2 = this.f14418a.getIntent();
        intent2.putExtra("NumberCount", this.f14418a.m15358d());
        this.f14418a.setResult(-1, intent2);
        this.f14418a.finish();
    }
}
