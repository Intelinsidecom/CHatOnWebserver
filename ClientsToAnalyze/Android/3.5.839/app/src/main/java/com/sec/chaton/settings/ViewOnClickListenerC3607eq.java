package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.eq */
/* loaded from: classes.dex */
class ViewOnClickListenerC3607eq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f13137a;

    /* renamed from: b */
    final /* synthetic */ C3605eo f13138b;

    ViewOnClickListenerC3607eq(C3605eo c3605eo, String str) {
        this.f13138b = c3605eo;
        this.f13137a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f13138b.f13131a.getActivity(), (Class<?>) ActivityDeregister.class);
        intent.putExtra("key_chaton_id", this.f13137a);
        this.f13138b.f13131a.startActivityForResult(intent, 1);
    }
}
