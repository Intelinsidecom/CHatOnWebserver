package com.sec.chaton.smsplugin.p112ui;

import android.app.Dialog;
import android.content.DialogInterface;
import com.sec.chaton.smsplugin.p110g.C3855a;
import java.util.ArrayList;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bu */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC4139bu implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C4132bn f15412a;

    DialogInterfaceOnDismissListenerC4139bu(C4132bn c4132bn) {
        this.f15412a = c4132bn;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Dialog unused = C4132bn.f15384p = null;
        if (!this.f15412a.f15392l.isEmpty()) {
            if (!C4132bn.f15383i) {
                int i = 0;
                while (true) {
                    if (i >= this.f15412a.f15393m.size()) {
                        break;
                    }
                    if (((C3855a) this.f15412a.f15393m.get(i)).m14748d().equals(this.f15412a.f15392l.get(0))) {
                        this.f15412a.f15393m.remove(i);
                        break;
                    }
                    i++;
                }
            }
            this.f15412a.f15392l.remove(0);
            C4132bn.f15383i = false;
        }
        if (!this.f15412a.f15393m.isEmpty()) {
            this.f15412a.m16364a((ArrayList<C3855a>) this.f15412a.f15393m, this.f15412a.f15395o);
        }
    }
}
