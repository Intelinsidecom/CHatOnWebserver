package com.sec.chaton.chat.p054a;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.shop.ChatONShopActivity;

/* compiled from: AniconBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC1532e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1530c f5940a;

    ViewOnClickListenerC1532e(C1530c c1530c) {
        this.f5940a = c1530c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f5940a.f5856c, (Class<?>) ChatONShopActivity.class);
        intent.putExtra("page_name", 1);
        intent.putExtra("category_id", 1L);
        intent.putExtra("anicon_id", this.f5940a.f5932Z);
        this.f5940a.f5856c.startActivity(intent);
    }
}
