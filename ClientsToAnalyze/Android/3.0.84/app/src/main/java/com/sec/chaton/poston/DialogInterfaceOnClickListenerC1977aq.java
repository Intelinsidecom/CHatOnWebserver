package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.common.util.p070a.C3332a;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1977aq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7674a;

    DialogInterfaceOnClickListenerC1977aq(PostONDetailFragment postONDetailFragment) {
        this.f7674a = postONDetailFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3332a.m11750a().m11756a(this.f7674a.f7548au, this.f7674a.f7513K + this.f7674a.f7547at);
    }
}
