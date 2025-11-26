package com.sec.chaton.settings;

import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.cm */
/* loaded from: classes.dex */
class ViewOnClickListenerC1288cm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f4834a;

    ViewOnClickListenerC1288cm(FragmentSkinChange2 fragmentSkinChange2) {
        this.f4834a = fragmentSkinChange2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4834a.f4678p != null) {
            Drawable drawable = ((C1290co) this.f4834a.f4661S.get(view.getTag().toString())).f4841b;
            if (drawable != null) {
                this.f4834a.f4675m = view.getTag().toString();
                this.f4834a.f4678p.setBackgroundDrawable(drawable.getConstantState().newDrawable());
            } else {
                return;
            }
        }
        if (this.f4834a.f4687y != null) {
            this.f4834a.f4687y.setSelection(this.f4834a.f4675m);
        }
        this.f4834a.m4669e();
    }
}
