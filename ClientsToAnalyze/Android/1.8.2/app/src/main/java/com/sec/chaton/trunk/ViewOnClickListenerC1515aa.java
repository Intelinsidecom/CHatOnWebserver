package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1739av;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC1515aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f5543a;

    ViewOnClickListenerC1515aa(TrunkCommentView trunkCommentView) {
        this.f5543a = trunkCommentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1739av.m5927a()) {
            this.f5543a.f5446l.mo5491a(this.f5543a.f5439e.getText().toString());
            if (GlobalApplication.m3265f()) {
                this.f5543a.f5438d.hideSoftInputFromWindow(this.f5543a.f5439e.getWindowToken(), 0);
            }
            this.f5543a.m5237b();
        }
    }
}
