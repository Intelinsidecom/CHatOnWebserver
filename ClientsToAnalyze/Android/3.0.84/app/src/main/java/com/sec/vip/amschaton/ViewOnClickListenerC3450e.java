package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSBgColorSelectionDialog.java */
/* renamed from: com.sec.vip.amschaton.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC3450e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC3449d f12625a;

    ViewOnClickListenerC3450e(DialogInterfaceOnClickListenerC3449d dialogInterfaceOnClickListenerC3449d) {
        this.f12625a = dialogInterfaceOnClickListenerC3449d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 14; i++) {
            if (this.f12625a.f12618f[i] == view) {
                this.f12625a.m12341a(this.f12625a.m12345c(this.f12625a.f12617e), false);
                this.f12625a.m12351a(this.f12625a.f12614b.getResources().getColor(this.f12625a.f12621i[i]));
                if (this.f12625a.f12622j != null) {
                    this.f12625a.f12622j.mo12235b();
                }
                this.f12625a.f12616d.dismiss();
                return;
            }
        }
    }
}
