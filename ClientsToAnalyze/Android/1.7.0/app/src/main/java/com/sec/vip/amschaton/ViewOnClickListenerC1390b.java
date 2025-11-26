package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSBgColorSelectionDialog.java */
/* renamed from: com.sec.vip.amschaton.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC1390b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1548m f4882a;

    ViewOnClickListenerC1390b(DialogC1548m dialogC1548m) {
        this.f4882a = dialogC1548m;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 15; i++) {
            if (this.f4882a.f5378b[i] == view) {
                this.f4882a.m5616a(this.f4882a.m5619b(this.f4882a.f5377a), false);
                this.f4882a.m5624a(this.f4882a.getContext().getResources().getColor(this.f4882a.f5380d[i]));
                if (this.f4882a.f5381e != null) {
                    this.f4882a.f5381e.mo4927b();
                }
                this.f4882a.dismiss();
                return;
            }
        }
    }
}
