package com.sec.chaton;

import android.support.v4.view.InterfaceC0196cc;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.util.C4904y;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.br */
/* loaded from: classes.dex */
class C1099br implements InterfaceC0196cc {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f3498a;

    C1099br(PlusFragment plusFragment) {
        this.f3498a = plusFragment;
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo619a(int i) {
        C4904y.m18639b("onPageSelected : " + i, PlusFragment.f1956a);
        for (int i2 = 0; i2 < this.f3498a.f1966J; i2++) {
            ImageView imageView = (ImageView) ((View) this.f3498a.f1965I.get(i2)).findViewById(R.id.banner_indcator);
            if (i2 == i) {
                imageView.setSelected(true);
            } else {
                imageView.setSelected(false);
            }
        }
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo620a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: b */
    public void mo622b(int i) {
    }
}
