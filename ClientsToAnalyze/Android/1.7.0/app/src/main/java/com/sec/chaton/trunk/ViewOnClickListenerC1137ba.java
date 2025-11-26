package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.util.C1346u;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ba */
/* loaded from: classes.dex */
class ViewOnClickListenerC1137ba implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f3967a;

    ViewOnClickListenerC1137ba(TrunkCommentView trunkCommentView) {
        this.f3967a = trunkCommentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            this.f3967a.f3764l.mo4180a(this.f3967a.f3757e.getText().toString());
            this.f3967a.f3756d.hideSoftInputFromWindow(this.f3967a.f3757e.getWindowToken(), 0);
            this.f3967a.m3974b();
        }
    }
}
