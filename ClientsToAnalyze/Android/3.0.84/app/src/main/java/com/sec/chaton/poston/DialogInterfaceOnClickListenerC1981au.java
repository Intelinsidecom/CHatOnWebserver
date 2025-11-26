package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.au */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1981au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7678a;

    DialogInterfaceOnClickListenerC1981au(PostONDetailFragment postONDetailFragment) {
        this.f7678a = postONDetailFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f7678a.f7505C.equals(this.f7678a.f7504B)) {
                this.f7678a.f7522T.m5921b(this.f7678a.f7504B, this.f7678a.f7512J);
            } else {
                this.f7678a.f7522T.m5923c(this.f7678a.f7505C, this.f7678a.f7512J);
            }
            this.f7678a.f7525W.show();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }
}
