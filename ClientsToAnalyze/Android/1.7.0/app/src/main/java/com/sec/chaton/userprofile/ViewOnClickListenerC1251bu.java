package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.buddy.p017a.C0363a;

/* compiled from: InteractionAdapter.java */
/* renamed from: com.sec.chaton.userprofile.bu */
/* loaded from: classes.dex */
class ViewOnClickListenerC1251bu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f4346a;

    /* renamed from: b */
    final /* synthetic */ C1276z f4347b;

    ViewOnClickListenerC1251bu(C1276z c1276z, int i) {
        this.f4347b = c1276z;
        this.f4346a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strM2308a = ((C0363a) this.f4347b.getItem(this.f4346a)).m2308a();
        String strM2314b = ((C0363a) this.f4347b.getItem(this.f4346a)).m2314b();
        if (this.f4347b.f4378b != null) {
            this.f4347b.f4378b.mo4374a(strM2314b, strM2308a);
        }
    }
}
