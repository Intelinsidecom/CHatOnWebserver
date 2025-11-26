package com.sec.vip.amschaton.fragment;

import android.content.Intent;
import android.view.View;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.df */
/* loaded from: classes.dex */
class ViewOnClickListenerC3539df implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSViewerFragment f12965a;

    ViewOnClickListenerC3539df(AMSViewerFragment aMSViewerFragment) {
        this.f12965a = aMSViewerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f12965a.f12805u) {
            Intent intent = new Intent();
            intent.putExtra("AMS_SAVE", true);
            this.f12965a.getActivity().setResult(-1, intent);
            this.f12965a.getActivity().finish();
        }
    }
}
