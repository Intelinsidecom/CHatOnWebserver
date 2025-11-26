package com.sec.chaton.settings.downloads;

import android.text.TextUtils;
import android.view.View;

/* compiled from: FontListAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.bp */
/* loaded from: classes.dex */
class ViewOnClickListenerC2576bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2573bm f9766a;

    ViewOnClickListenerC2576bp(ViewOnClickListenerC2573bm viewOnClickListenerC2573bm) {
        this.f9766a = viewOnClickListenerC2573bm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = ((C2579bs) view.getTag()).f9770a;
        if (!TextUtils.isEmpty(str) && this.f9766a.f9760h != null) {
            this.f9766a.f9760h.mo9360a(str);
        }
    }
}
