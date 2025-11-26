package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.au */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3095au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC3093as f11308a;

    DialogInterfaceOnClickListenerC3095au(MenuItemOnMenuItemClickListenerC3093as menuItemOnMenuItemClickListenerC3093as) {
        this.f11308a = menuItemOnMenuItemClickListenerC3093as;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f11308a.f11306b.f11192x.m5921b(this.f11308a.f11306b.f11102E, this.f11308a.f11305a);
            this.f11308a.f11306b.f11180l.show();
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }
}
