package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.buddy.p017a.C0363a;

/* compiled from: RelationHideAdapter.java */
/* renamed from: com.sec.chaton.settings.w */
/* loaded from: classes.dex */
class ViewOnClickListenerC1091w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3735a;

    /* renamed from: b */
    final /* synthetic */ C1038bi f3736b;

    ViewOnClickListenerC1091w(C1038bi c1038bi, int i) {
        this.f3736b = c1038bi;
        this.f3735a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3736b.f3647f = ((C0363a) this.f3736b.f3642a.get(this.f3735a)).m2308a();
        this.f3736b.f3646e = ((C0363a) this.f3736b.f3642a.get(this.f3735a)).m2314b();
        if (this.f3736b.f3643b != null) {
            this.f3736b.f3643b.mo3902a(this.f3736b.f3646e, this.f3736b.f3647f);
        }
    }
}
