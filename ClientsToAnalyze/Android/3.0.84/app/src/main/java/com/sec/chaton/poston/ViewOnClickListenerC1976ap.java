package com.sec.chaton.poston;

import android.net.Uri;
import android.view.View;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ap */
/* loaded from: classes.dex */
class ViewOnClickListenerC1976ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7673a;

    ViewOnClickListenerC1976ap(PostONDetailFragment postONDetailFragment) {
        this.f7673a = postONDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            if (this.f7673a.f7545aq.exists() && this.f7673a.f7545aq.length() > 0) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("Video tmpFile exists : " + this.f7673a.f7545aq.getAbsolutePath(), PostONDetailFragment.f7502p);
                }
                ((InterfaceC1982av) this.f7673a.getActivity()).mo7922a(Uri.fromFile(this.f7673a.f7545aq));
            } else {
                if (C3250y.f11734b) {
                    C3250y.m11450b("Video tmpFile not exist", PostONDetailFragment.f7502p);
                }
                this.f7673a.m7942d();
            }
        }
    }
}
