package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2003bp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1999bl f7718a;

    DialogInterfaceOnClickListenerC2003bp(HandlerC1999bl handlerC1999bl) {
        this.f7718a = handlerC1999bl;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f7718a.f7714a.m7992a((ArrayList<PreviewData>) this.f7718a.f7714a.f7591Q);
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }
}
