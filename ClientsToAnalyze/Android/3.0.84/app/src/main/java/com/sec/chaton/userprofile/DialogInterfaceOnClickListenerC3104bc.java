package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3104bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3098ax f11317a;

    DialogInterfaceOnClickListenerC3104bc(HandlerC3098ax handlerC3098ax) {
        this.f11317a = handlerC3098ax;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f11317a.f11311a.f11182n.m5759a(this.f11317a.f11311a.f11131aI.f11324a, this.f11317a.f11311a.f11131aI.f11325b);
            this.f11317a.f11311a.f11179k.show();
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }
}
