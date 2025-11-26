package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4769ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4766by f17487a;

    DialogInterfaceOnClickListenerC4769ca(HandlerC4766by handlerC4766by) {
        this.f17487a = handlerC4766by;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f17487a.f17484a.f17348p.m9305a(this.f17487a.f17484a.f17352v.getPath());
            this.f17487a.f17484a.f17346n.show();
            this.f17487a.f17484a.m18000l();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            this.f17487a.f17484a.m18007o();
        }
    }
}
