package com.sec.chaton.multimedia.image;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.ar */
/* loaded from: classes.dex */
public class C1867ar extends ViewOnTouchListenerC1868as {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f7105a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1867ar(PostONImagePagerFragment postONImagePagerFragment, InterfaceC1869at interfaceC1869at) {
        super(interfaceC1869at);
        this.f7105a = postONImagePagerFragment;
    }

    @Override // com.sec.chaton.multimedia.image.ViewOnTouchListenerC1868as, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f7105a.m7687b() != null && this.f7105a.m7687b().m7654a() != null) {
            this.f7105a.m7687b().m7654a().setEnabled(this.f7105a.m7685a().m7705a());
        }
        return super.onTouch(view, motionEvent);
    }
}
