package com.sec.chaton.buddy;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.sec.chaton.buddy.p019a.C0513c;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC0524ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0513c f2465a;

    /* renamed from: b */
    final /* synthetic */ C0522ag f2466b;

    ViewOnClickListenerC0524ai(C0522ag c0522ag, C0513c c0513c) {
        this.f2466b = c0522ag;
        this.f2465a = c0513c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout = (LinearLayout) ((FrameLayout) view).getChildAt(0);
        ((CheckBox) linearLayout.getChildAt(0)).setContentDescription(this.f2465a.m3976c());
        ((CheckBox) linearLayout.getChildAt(0)).performClick();
    }
}
