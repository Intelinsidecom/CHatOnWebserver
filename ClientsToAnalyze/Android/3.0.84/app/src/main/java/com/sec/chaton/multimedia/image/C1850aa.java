package com.sec.chaton.multimedia.image;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.aa */
/* loaded from: classes.dex */
public class C1850aa extends ViewOnTouchListenerC1868as {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f7072a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1850aa(ImagePagerFragment imagePagerFragment, InterfaceC1869at interfaceC1869at) {
        super(interfaceC1869at);
        this.f7072a = imagePagerFragment;
    }

    @Override // com.sec.chaton.multimedia.image.ViewOnTouchListenerC1868as, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f7072a.m7630e() != null && this.f7072a.m7630e().m7607a() != null) {
            this.f7072a.m7630e().m7607a().setEnabled(this.f7072a.m7629d().m7706b());
        }
        return super.onTouch(view, motionEvent);
    }
}
