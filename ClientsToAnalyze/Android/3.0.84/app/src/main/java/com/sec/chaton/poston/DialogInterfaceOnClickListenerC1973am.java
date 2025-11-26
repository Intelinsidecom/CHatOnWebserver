package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.am */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1973am implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1971ak f7670a;

    DialogInterfaceOnClickListenerC1973am(MenuItemOnMenuItemClickListenerC1971ak menuItemOnMenuItemClickListenerC1971ak) {
        this.f7670a = menuItemOnMenuItemClickListenerC1971ak;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f7670a.f7668c.f7522T.m5917a(this.f7670a.f7668c.f7505C, this.f7670a.f7668c.f7506D, this.f7670a.f7668c.f7508F, this.f7670a.f7666a, this.f7670a.f7668c.f7512J, this.f7670a.f7667b);
            this.f7670a.f7668c.f7525W.show();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }
}
