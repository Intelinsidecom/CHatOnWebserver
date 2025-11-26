package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.gf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1326gf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1324gd f4863a;

    DialogInterfaceOnClickListenerC1326gf(MenuItemOnMenuItemClickListenerC1324gd menuItemOnMenuItemClickListenerC1324gd) {
        this.f4863a = menuItemOnMenuItemClickListenerC1324gd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f4863a.f4861b.f3969aj.m9298c(this.f4863a.f4861b.f4013t, this.f4863a.f4860a);
            this.f4863a.f4861b.m6830i();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }
}
