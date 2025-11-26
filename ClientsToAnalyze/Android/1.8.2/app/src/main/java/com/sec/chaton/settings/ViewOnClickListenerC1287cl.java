package com.sec.chaton.settings;

import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.cl */
/* loaded from: classes.dex */
class ViewOnClickListenerC1287cl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f4833a;

    ViewOnClickListenerC1287cl(FragmentSkinChange2 fragmentSkinChange2) {
        this.f4833a = fragmentSkinChange2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4833a.f4677o != null) {
            Drawable drawable = ((C1290co) this.f4833a.f4660R.get(view.getTag().toString())).f4841b;
            if (drawable != null) {
                this.f4833a.f4674l = view.getTag().toString();
                this.f4833a.f4677o.setBackgroundDrawable(drawable.getConstantState().newDrawable());
            } else {
                return;
            }
        }
        if (this.f4833a.f4686x != null) {
            this.f4833a.f4686x.setSelection(this.f4833a.f4674l);
        }
        this.f4833a.m4669e();
    }
}
