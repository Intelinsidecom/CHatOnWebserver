package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.buddy.p017a.C0363a;

/* compiled from: RelationHideAdapter.java */
/* renamed from: com.sec.chaton.settings.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC1092x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3737a;

    /* renamed from: b */
    final /* synthetic */ C1038bi f3738b;

    ViewOnClickListenerC1092x(C1038bi c1038bi, int i) {
        this.f3738b = c1038bi;
        this.f3737a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3738b.f3647f = ((C0363a) this.f3738b.f3642a.get(this.f3737a)).m2308a();
        this.f3738b.f3646e = ((C0363a) this.f3738b.f3642a.get(this.f3737a)).m2314b();
    }
}
