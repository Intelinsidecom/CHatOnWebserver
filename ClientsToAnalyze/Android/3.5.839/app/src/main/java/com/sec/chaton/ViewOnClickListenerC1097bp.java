package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.shop.ChatONShopActivity;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bp */
/* loaded from: classes.dex */
class ViewOnClickListenerC1097bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f3496a;

    ViewOnClickListenerC1097bp(PlusFragment plusFragment) {
        this.f3496a = plusFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1503cg c1503cg = (C1503cg) view.getTag();
        if (this.f3496a.f1994u != null) {
            this.f3496a.f1994u.moveToPosition(c1503cg.f5450d);
            String string = this.f3496a.f1994u.getString(this.f3496a.f1994u.getColumnIndex("itemtype"));
            String string2 = this.f3496a.f1994u.getString(this.f3496a.f1994u.getColumnIndex("id"));
            Intent intent = new Intent(this.f3496a.f1990q, (Class<?>) ChatONShopActivity.class);
            intent.putExtra("page_name", 1);
            intent.putExtra("item_id", string2);
            intent.putExtra("category_id", Long.parseLong(string));
            this.f3496a.startActivity(intent);
        }
    }
}
