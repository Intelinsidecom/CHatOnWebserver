package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.shop.ChatONShopActivity;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bx */
/* loaded from: classes.dex */
class ViewOnClickListenerC1423bx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f5059a;

    ViewOnClickListenerC1423bx(PlusFragment plusFragment) {
        this.f5059a = plusFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5059a.startActivity(new Intent(this.f5059a.f1990q, (Class<?>) ChatONShopActivity.class));
    }
}
