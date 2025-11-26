package com.sec.chaton.poston;

import android.net.Uri;
import android.view.View;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.as */
/* loaded from: classes.dex */
class ViewOnClickListenerC2974as implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11071a;

    ViewOnClickListenerC2974as(PostONDetailFragment postONDetailFragment) {
        this.f11071a = postONDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            if (this.f11071a.f10941aw.exists() && this.f11071a.f10941aw.length() > 0) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Video tmpFile exists : " + this.f11071a.f10941aw.getAbsolutePath(), PostONDetailFragment.f10885r);
                }
                ((InterfaceC2979ax) this.f11071a.getActivity()).mo12198a(Uri.fromFile(this.f11071a.f10941aw));
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Video tmpFile not exist", PostONDetailFragment.f10885r);
                }
                this.f11071a.m12254i();
            }
        }
    }
}
