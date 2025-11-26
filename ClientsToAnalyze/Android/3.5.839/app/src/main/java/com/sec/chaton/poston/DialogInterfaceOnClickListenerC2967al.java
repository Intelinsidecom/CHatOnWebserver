package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2967al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC2965aj f11062a;

    DialogInterfaceOnClickListenerC2967al(MenuItemOnMenuItemClickListenerC2965aj menuItemOnMenuItemClickListenerC2965aj) {
        this.f11062a = menuItemOnMenuItemClickListenerC2965aj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f11062a.f11057a.equals(this.f11062a.f11060d.f10889D)) {
                this.f11062a.f11060d.f10906U.m9292a(this.f11062a.f11060d.f10890E, this.f11062a.f11058b, this.f11062a.f11060d.f10896K, this.f11062a.f11059c);
            } else {
                this.f11062a.f11060d.f10906U.m9292a(this.f11062a.f11060d.f10890E, this.f11062a.f11058b, this.f11062a.f11060d.f10896K, this.f11062a.f11059c);
            }
            this.f11062a.f11060d.f10910Y.show();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }
}
