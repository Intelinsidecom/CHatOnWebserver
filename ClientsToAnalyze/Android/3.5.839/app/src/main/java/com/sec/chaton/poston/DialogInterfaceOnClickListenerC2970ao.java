package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2970ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC2968am f11067a;

    DialogInterfaceOnClickListenerC2970ao(MenuItemOnMenuItemClickListenerC2968am menuItemOnMenuItemClickListenerC2968am) {
        this.f11067a = menuItemOnMenuItemClickListenerC2968am;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f11067a.f11065c.f10906U.m9296b(this.f11067a.f11065c.f10890E, this.f11067a.f11063a, this.f11067a.f11065c.f10896K, this.f11067a.f11064b);
            this.f11067a.f11065c.f10910Y.show();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }
}
