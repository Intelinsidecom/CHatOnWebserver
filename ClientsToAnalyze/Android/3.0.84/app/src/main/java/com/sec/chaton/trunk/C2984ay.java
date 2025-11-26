package com.sec.chaton.trunk;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.multimedia.image.InterfaceC1869at;
import com.sec.chaton.multimedia.image.ViewOnTouchListenerC1868as;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.ay */
/* loaded from: classes.dex */
public class C2984ay extends ViewOnTouchListenerC1868as {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f10783a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2984ay(TrunkFullView trunkFullView, InterfaceC1869at interfaceC1869at) {
        super(interfaceC1869at);
        this.f10783a = trunkFullView;
    }

    @Override // com.sec.chaton.multimedia.image.ViewOnTouchListenerC1868as, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f10783a.m10223h() != null && this.f10783a.m10223h().m10364d() != null) {
            this.f10783a.m10223h().m10364d().setEnabled(this.f10783a.m10246b().m7706b());
        }
        return super.onTouch(view, motionEvent);
    }
}
