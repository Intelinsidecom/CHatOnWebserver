package com.sec.vip.amschaton.fragment;

import android.view.View;
import com.sec.vip.amschaton.DialogC3435bj;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.dj */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3543dj implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ DialogC3435bj f12970a;

    /* renamed from: b */
    final /* synthetic */ AMSViewerFragment f12971b;

    ViewOnFocusChangeListenerC3543dj(AMSViewerFragment aMSViewerFragment, DialogC3435bj dialogC3435bj) {
        this.f12971b = aMSViewerFragment;
        this.f12970a = dialogC3435bj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f12970a.getWindow().setSoftInputMode(5);
        }
    }
}
