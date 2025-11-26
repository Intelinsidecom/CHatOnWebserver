package com.sec.chaton.settings.downloads;

import android.text.TextUtils;
import android.view.View;

/* compiled from: FontListAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.bo */
/* loaded from: classes.dex */
class ViewOnLongClickListenerC2575bo implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2573bm f9765a;

    ViewOnLongClickListenerC2575bo(ViewOnClickListenerC2573bm viewOnClickListenerC2573bm) {
        this.f9765a = viewOnClickListenerC2573bm;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        C2579bs c2579bs = (C2579bs) view.getTag();
        if (TextUtils.isEmpty(c2579bs.f9770a)) {
            return false;
        }
        if (c2579bs.f9779j) {
            this.f9765a.m9528a(c2579bs.f9770a, c2579bs.f9778i);
        }
        return true;
    }
}
