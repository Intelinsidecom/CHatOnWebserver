package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.shop.ChatONShopActivity;
import com.sec.common.CommonApplication;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.fq */
/* loaded from: classes.dex */
class ViewOnClickListenerC3634fq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f13195a;

    ViewOnClickListenerC3634fq(RingtonePreference2 ringtonePreference2) {
        this.f13195a = ringtonePreference2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(CommonApplication.m18732r(), (Class<?>) ChatONShopActivity.class);
        intent.putExtra("page_name", 2);
        intent.putExtra("category_id", 6L);
        this.f13195a.getContext().startActivity(intent);
        if (this.f13195a.f12819c != null) {
            this.f13195a.f12819c.dismiss();
        }
    }
}
