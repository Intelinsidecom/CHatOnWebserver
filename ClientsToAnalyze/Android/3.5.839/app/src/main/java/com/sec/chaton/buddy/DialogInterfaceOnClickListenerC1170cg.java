package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.buddy.p050a.C1106c;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1170cg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4393a;

    /* renamed from: b */
    final /* synthetic */ int f4394b;

    /* renamed from: c */
    final /* synthetic */ BuddyFragment f4395c;

    DialogInterfaceOnClickListenerC1170cg(BuddyFragment buddyFragment, C1106c c1106c, int i) {
        this.f4395c = buddyFragment;
        this.f4393a = c1106c;
        this.f4394b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f4395c.m6367a(this.f4393a, this.f4394b, i);
                break;
            case 1:
                this.f4395c.m6367a(this.f4393a, this.f4394b, i);
                break;
        }
    }
}
