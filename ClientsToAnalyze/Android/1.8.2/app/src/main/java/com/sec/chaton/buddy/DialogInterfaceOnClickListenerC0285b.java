package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.buddy.AddBuddyActivity;
import java.util.ArrayList;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0285b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f1382a;

    /* renamed from: b */
    final /* synthetic */ String f1383b;

    /* renamed from: c */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1384c;

    DialogInterfaceOnClickListenerC0285b(AddBuddyActivity.AddBuddyFragment addBuddyFragment, ArrayList arrayList, String str) {
        this.f1384c = addBuddyFragment;
        this.f1382a = arrayList;
        this.f1383b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1384c.m1871a((String) this.f1382a.get(i), this.f1383b);
    }
}
