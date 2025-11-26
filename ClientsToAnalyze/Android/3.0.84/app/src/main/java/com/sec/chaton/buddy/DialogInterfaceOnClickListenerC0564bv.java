package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.buddy.p019a.C0513c;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bv */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0564bv implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0513c f2524a;

    /* renamed from: b */
    final /* synthetic */ int f2525b;

    /* renamed from: c */
    final /* synthetic */ BuddyFragment f2526c;

    DialogInterfaceOnClickListenerC0564bv(BuddyFragment buddyFragment, C0513c c0513c, int i) {
        this.f2526c = buddyFragment;
        this.f2524a = c0513c;
        this.f2525b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f2526c.m3282a(this.f2524a, this.f2525b, i);
                break;
            case 1:
                this.f2526c.m3282a(this.f2524a, this.f2525b, i);
                break;
            case 2:
                this.f2526c.m3282a(this.f2524a, this.f2525b, i);
                break;
        }
    }
}
