package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4751bj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC4749bh f17416a;

    DialogInterfaceOnClickListenerC4751bj(MenuItemOnMenuItemClickListenerC4749bh menuItemOnMenuItemClickListenerC4749bh) {
        this.f17416a = menuItemOnMenuItemClickListenerC4749bh;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f17416a.f17414b.f17207L.m9295b(C4809aa.m18104a().m18121a("chaton_id", ""), this.f17416a.f17413a);
            this.f17416a.f17414b.f17221Z.show();
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }
}
