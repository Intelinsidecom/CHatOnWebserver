package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0693fd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0691fb f2916a;

    DialogInterfaceOnClickListenerC0693fd(MenuItemOnMenuItemClickListenerC0691fb menuItemOnMenuItemClickListenerC0691fb) {
        this.f2916a = menuItemOnMenuItemClickListenerC0691fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f2916a.f2914b.f2041Z.m5923c(this.f2916a.f2914b.f2117t, this.f2916a.f2913a);
            this.f2916a.f2914b.m3683l();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }
}
