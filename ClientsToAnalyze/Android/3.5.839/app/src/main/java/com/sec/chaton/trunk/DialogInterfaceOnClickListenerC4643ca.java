package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4643ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f16825a;

    /* renamed from: b */
    final /* synthetic */ TrunkPageActivity f16826b;

    DialogInterfaceOnClickListenerC4643ca(TrunkPageActivity trunkPageActivity, String str) {
        this.f16826b = trunkPageActivity;
        this.f16825a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f16826b.m17446e(this.f16825a);
    }
}
