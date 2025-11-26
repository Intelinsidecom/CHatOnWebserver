package com.sec.chaton.multimedia.vcard;

import android.view.View;

/* compiled from: VCardReadContactActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC0838o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f2918a;

    ViewOnClickListenerC0838o(VCardReadContactActivity vCardReadContactActivity) {
        this.f2918a = vCardReadContactActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        for (int i2 = 0; this.f2918a.f2846k.size() > i2; i2++) {
            if (((C0834k) this.f2918a.f2846k.get(i2)).f2910d == 9 && !((C0834k) this.f2918a.f2846k.get(i2)).f2912f) {
                this.f2918a.f2847l.f2898d = null;
            }
            if (((C0834k) this.f2918a.f2846k.get(i2)).f2912f) {
                i++;
                if (((C0834k) this.f2918a.f2846k.get(i2)).f2910d == 5) {
                    this.f2918a.f2847l.m3406a(((C0834k) this.f2918a.f2846k.get(i2)).f2907a, ((C0834k) this.f2918a.f2846k.get(i2)).f2908b, ((C0834k) this.f2918a.f2846k.get(i2)).f2909c, true);
                } else if (((C0834k) this.f2918a.f2846k.get(i2)).f2910d == 1) {
                    this.f2918a.f2847l.m3407b(((C0834k) this.f2918a.f2846k.get(i2)).f2907a, ((C0834k) this.f2918a.f2846k.get(i2)).f2908b, ((C0834k) this.f2918a.f2846k.get(i2)).f2909c, true);
                }
            }
        }
        if (i <= 0) {
            this.f2918a.finish();
        } else {
            this.f2918a.showDialog(0);
            new Thread((ThreadGroup) null, this.f2918a.f2855t).start();
        }
    }
}
