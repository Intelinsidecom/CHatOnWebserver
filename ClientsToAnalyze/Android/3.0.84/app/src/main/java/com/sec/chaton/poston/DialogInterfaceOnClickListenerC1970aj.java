package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1970aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1968ah f7665a;

    DialogInterfaceOnClickListenerC1970aj(MenuItemOnMenuItemClickListenerC1968ah menuItemOnMenuItemClickListenerC1968ah) {
        this.f7665a = menuItemOnMenuItemClickListenerC1968ah;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f7665a.f7660a.equals(this.f7665a.f7663d.f7504B)) {
                this.f7665a.f7663d.f7522T.m5918a(this.f7665a.f7663d.f7505C, this.f7665a.f7663d.f7506D, this.f7665a.f7663d.f7508F, this.f7665a.f7661b, "false", this.f7665a.f7663d.f7512J, this.f7665a.f7662c);
            } else {
                this.f7665a.f7663d.f7522T.m5918a(this.f7665a.f7663d.f7505C, this.f7665a.f7663d.f7506D, this.f7665a.f7663d.f7508F, this.f7665a.f7661b, "true", this.f7665a.f7663d.f7512J, this.f7665a.f7662c);
            }
            this.f7665a.f7663d.f7525W.show();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }
}
