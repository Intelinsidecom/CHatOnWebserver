package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.buddy.p050a.C1106c;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ch */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1171ch implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4396a;

    /* renamed from: b */
    final /* synthetic */ int f4397b;

    /* renamed from: c */
    final /* synthetic */ BuddyFragment f4398c;

    DialogInterfaceOnClickListenerC1171ch(BuddyFragment buddyFragment, C1106c c1106c, int i) {
        this.f4398c = buddyFragment;
        this.f4396a = c1106c;
        this.f4397b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f4398c.m6367a(this.f4396a, this.f4397b, i);
                break;
            case 1:
                this.f4398c.m6367a(this.f4396a, this.f4397b, i);
                break;
            case 2:
                this.f4398c.m6367a(this.f4396a, this.f4397b, i);
                break;
        }
    }
}
