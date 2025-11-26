package com.sec.chaton.multimedia.image;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.ad */
/* loaded from: classes.dex */
public class C2819ad extends ViewOnTouchListenerC2837av {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f10383a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2819ad(ImagePagerFragment imagePagerFragment, InterfaceC2838aw interfaceC2838aw) {
        super(interfaceC2838aw);
        this.f10383a = imagePagerFragment;
    }

    @Override // com.sec.chaton.multimedia.image.ViewOnTouchListenerC2837av, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f10383a.m11844d() != null && this.f10383a.m11844d().m11818f() != null) {
            this.f10383a.m11844d().m11818f().setEnabled(this.f10383a.m11843c().m11932b());
        }
        return super.onTouch(view, motionEvent);
    }
}
