package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ct */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0335ct implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1477a;

    /* renamed from: b */
    final /* synthetic */ ViewOnClickListenerC0334cs f1478b;

    DialogInterfaceOnClickListenerC0335ct(ViewOnClickListenerC0334cs viewOnClickListenerC0334cs, String str) {
        this.f1478b = viewOnClickListenerC0334cs;
        this.f1477a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC0349dg(this.f1478b.f1476a).execute(this.f1477a);
    }
}
