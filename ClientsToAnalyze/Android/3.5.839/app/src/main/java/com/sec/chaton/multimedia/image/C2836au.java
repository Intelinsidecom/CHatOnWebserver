package com.sec.chaton.multimedia.image;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.au */
/* loaded from: classes.dex */
public class C2836au extends ViewOnTouchListenerC2837av {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f10416a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2836au(PostONImagePagerFragment postONImagePagerFragment, InterfaceC2838aw interfaceC2838aw) {
        super(interfaceC2838aw);
        this.f10416a = postONImagePagerFragment;
    }

    @Override // com.sec.chaton.multimedia.image.ViewOnTouchListenerC2837av, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f10416a.m11910c() != null && this.f10416a.m11910c().m11876f() != null) {
            this.f10416a.m11910c().m11876f().setEnabled(this.f10416a.m11909b().m11931a());
        }
        return super.onTouch(view, motionEvent);
    }
}
