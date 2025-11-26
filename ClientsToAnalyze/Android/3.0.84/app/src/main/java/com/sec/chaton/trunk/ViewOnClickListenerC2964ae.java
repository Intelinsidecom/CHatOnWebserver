package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.util.C3197bl;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC2964ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f10744a;

    ViewOnClickListenerC2964ae(TrunkCommentView trunkCommentView) {
        this.f10744a = trunkCommentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            this.f10744a.f10515n.mo10435a(this.f10744a.f10506e.getText().toString());
            this.f10744a.f10505d.hideSoftInputFromWindow(this.f10744a.f10506e.getWindowToken(), 0);
            this.f10744a.m10188b();
        }
    }
}
