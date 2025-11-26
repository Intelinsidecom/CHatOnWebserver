package com.sec.chaton.trunk;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.multimedia.image.InterfaceC2838aw;
import com.sec.chaton.multimedia.image.ViewOnTouchListenerC2837av;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.bb */
/* loaded from: classes.dex */
public class C4610bb extends ViewOnTouchListenerC2837av {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f16760a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4610bb(TrunkFullView trunkFullView, InterfaceC2838aw interfaceC2838aw) {
        super(interfaceC2838aw);
        this.f16760a = trunkFullView;
    }

    @Override // com.sec.chaton.multimedia.image.ViewOnTouchListenerC2837av, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f16760a.m17321h() != null && this.f16760a.m17321h().m17463g() != null) {
            this.f16760a.m17321h().m17463g().setEnabled(this.f16760a.m17344b().m11932b());
        }
        return super.onTouch(view, motionEvent);
    }
}
