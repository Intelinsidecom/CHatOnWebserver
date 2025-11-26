package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ba */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3102ba implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3098ax f11315a;

    DialogInterfaceOnClickListenerC3102ba(HandlerC3098ax handlerC3098ax) {
        this.f11315a = handlerC3098ax;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f11315a.f11311a.f11155al = true;
            this.f11315a.f11311a.f11181m.m5929a(this.f11315a.f11311a.f11156am.getPath());
            this.f11315a.f11311a.f11179k.show();
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
            this.f11315a.f11311a.m10702a(0);
        }
    }
}
