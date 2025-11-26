package com.sec.chaton.poston;

import android.view.View;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ao */
/* loaded from: classes.dex */
class ViewOnClickListenerC1975ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7672a;

    ViewOnClickListenerC1975ao(PostONDetailFragment postONDetailFragment) {
        this.f7672a = postONDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7672a.f7531ac.getText().toString() != null) {
            C3250y.m11456e("PostONCommentItem: " + this.f7672a.f7531ac.getText().toString(), getClass().getSimpleName());
            if (!C3197bl.m11159a()) {
                this.f7672a.f7522T.m5914a(this.f7672a.f7505C, new C2025p(this.f7672a.f7506D, this.f7672a.f7507E, this.f7672a.f7531ac.getText().toString(), this.f7672a.f7508F, "-1", null), this.f7672a.f7512J);
                this.f7672a.f7532ad.hideSoftInputFromWindow(this.f7672a.f7531ac.getWindowToken(), 0);
                this.f7672a.f7525W.show();
            }
        }
    }
}
