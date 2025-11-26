package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.z */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3031z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11221a;

    DialogInterfaceOnClickListenerC3031z(PostONDetailFragment postONDetailFragment) {
        this.f11221a = postONDetailFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f11221a.f10890E.equals(this.f11221a.f10889D)) {
                this.f11221a.f10906U.m9295b(this.f11221a.f10889D, this.f11221a.f10896K);
            } else {
                this.f11221a.f10906U.m9298c(this.f11221a.f10890E, this.f11221a.f10896K);
            }
            this.f11221a.f10910Y.show();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }
}
