package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.aw */
/* loaded from: classes.dex */
class ViewOnClickListenerC0649aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BackgroundColorSelectionDialog f4263a;

    ViewOnClickListenerC0649aw(BackgroundColorSelectionDialog backgroundColorSelectionDialog) {
        this.f4263a = backgroundColorSelectionDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4263a.f4114h[14] == view) {
            this.f4263a.f4112f.setVisibility(8);
            this.f4263a.f4113g.setVisibility(0);
            this.f4263a.f4117k.setVisibility(0);
            return;
        }
        for (int i = 0; i < 14; i++) {
            if (this.f4263a.f4114h[i] == view) {
                this.f4263a.m4132a(this.f4263a.m4134b(this.f4263a.f4107a), false);
                this.f4263a.m4142a(this.f4263a.getContext().getResources().getColor(this.f4263a.f4116j[i]));
                return;
            }
        }
    }
}
