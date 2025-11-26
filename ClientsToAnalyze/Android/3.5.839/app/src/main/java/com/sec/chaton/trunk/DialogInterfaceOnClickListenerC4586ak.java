package com.sec.chaton.trunk;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkDetailActivity.java */
/* renamed from: com.sec.chaton.trunk.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4586ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkDetailActivity f16695a;

    DialogInterfaceOnClickListenerC4586ak(TrunkDetailActivity trunkDetailActivity) {
        this.f16695a = trunkDetailActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (C4859bx.m18396c()) {
                this.f16695a.startActivity(C2921a.m12141i(this.f16695a.getBaseContext()));
            } else {
                this.f16695a.startActivity(C2921a.m12142j(this.f16695a.getBaseContext()));
            }
        } catch (ActivityNotFoundException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, TrunkDetailActivity.f16458p);
            }
        }
    }
}
