package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC0444t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0442r f1693a;

    ViewOnClickListenerC0444t(C0442r c0442r) {
        this.f1693a = c0442r;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0257c c0257c = (C0257c) view.getTag();
        if (c0257c.m2350v()) {
            String[] strArr = (String[]) c0257c.m2351w().keySet().toArray(new String[0]);
            Intent intentM585a = HomeActivity.m585a(this.f1693a.f1671f, true);
            intentM585a.setFlags(67108864);
            if (c0257c.m2351w().size() == 1) {
                intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
            } else {
                intentM585a.putExtra("chatType", EnumC0695j.GROUPCHAT.m3146a());
            }
            intentM585a.putExtra("receivers", strArr);
            intentM585a.putExtra("ACTION_PURPOSE_ARG1", c0257c.m2337i());
            this.f1693a.f1671f.startActivity(intentM585a);
            return;
        }
        String[] strArr2 = {c0257c.m2318a()};
        Intent intentM585a2 = HomeActivity.m585a(this.f1693a.f1671f, true);
        intentM585a2.setFlags(67108864);
        intentM585a2.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
        intentM585a2.putExtra("receivers", strArr2);
        this.f1693a.f1671f.startActivity(intentM585a2);
    }
}
