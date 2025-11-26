package com.sec.chaton.buddy;

import android.content.DialogInterface;
import java.util.ArrayList;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0716g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f2957a;

    /* renamed from: b */
    final /* synthetic */ String f2958b;

    /* renamed from: c */
    final /* synthetic */ AddBuddyFragment f2959c;

    DialogInterfaceOnClickListenerC0716g(AddBuddyFragment addBuddyFragment, ArrayList arrayList, String str) {
        this.f2959c = addBuddyFragment;
        this.f2957a = arrayList;
        this.f2958b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2959c.m3174a((String) this.f2957a.get(i), this.f2958b);
    }
}
