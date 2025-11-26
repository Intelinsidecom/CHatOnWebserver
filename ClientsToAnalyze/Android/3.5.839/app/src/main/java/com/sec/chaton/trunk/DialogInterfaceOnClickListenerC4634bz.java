package com.sec.chaton.trunk;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4634bz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f16811a;

    DialogInterfaceOnClickListenerC4634bz(TrunkPageActivity trunkPageActivity) {
        this.f16811a = trunkPageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (C4859bx.m18396c()) {
                this.f16811a.startActivity(C2921a.m12141i(this.f16811a.getBaseContext()));
            } else {
                this.f16811a.startActivity(C2921a.m12142j(this.f16811a.getBaseContext()));
            }
        } catch (ActivityNotFoundException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, TrunkPageActivity.f16577s);
            }
        }
    }
}
