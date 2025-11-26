package com.sec.chaton.smsplugin.spam;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.R;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.ac */
/* loaded from: classes.dex */
class ViewOnClickListenerC3972ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4017bu f14406a;

    /* renamed from: b */
    final /* synthetic */ C3971ab f14407b;

    ViewOnClickListenerC3972ac(C3971ab c3971ab, C4017bu c4017bu) {
        this.f14407b = c3971ab;
        this.f14406a = c4017bu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14407b.f14402a.f14305f == 0) {
            this.f14407b.f14402a.m15329b("id = " + this.f14406a.m15454a() + " string = " + this.f14406a.m15458c());
            this.f14407b.f14402a.m15329b("View id : " + String.format("%08X", Integer.valueOf(view.getId())));
            this.f14406a.m15456a(this.f14406a.m15457b() ? false : true);
            ((CheckBox) view.findViewById(R.id.autoreject_item_checkbox)).setChecked(this.f14406a.m15457b());
            this.f14407b.f14402a.m15321a(this.f14406a);
        }
    }
}
