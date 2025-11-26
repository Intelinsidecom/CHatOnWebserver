package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.view.View;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bp */
/* loaded from: classes.dex */
class ViewOnClickListenerC1388bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1387bo f5239a;

    ViewOnClickListenerC1388bp(C1387bo c1387bo) {
        this.f5239a = c1387bo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String unused = TWFollowingsListActivity.f5009B = ((C1383bk) this.f5239a.f5236c.get(((Integer) view.getTag()).intValue())).f5224b;
        if (TWFollowingsListActivity.f5009B != null) {
            Intent intent = new Intent(this.f5239a.f5238e.f5023j, (Class<?>) TwitterMessageActivity.class);
            intent.putExtra("following_name", TWFollowingsListActivity.f5009B);
            this.f5239a.f5238e.startActivity(intent);
        }
    }
}
