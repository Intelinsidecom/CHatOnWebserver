package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2999bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2995bm f11114a;

    DialogInterfaceOnClickListenerC2999bq(HandlerC2995bm handlerC2995bm) {
        this.f11114a = handlerC2995bm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(this.f11114a.f11110a.getActivity());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f11114a.f11110a.f10977I.show();
        } else if (!C4847bl.m18333a()) {
            this.f11114a.f11110a.m12305a((ArrayList<PreviewData>) this.f11114a.f11110a.f10987S);
        } else {
            C4904y.m18646e("MultiClickBlocker", getClass().getSimpleName());
        }
    }
}
