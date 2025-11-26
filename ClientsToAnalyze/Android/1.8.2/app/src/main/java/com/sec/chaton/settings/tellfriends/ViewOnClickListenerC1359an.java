package com.sec.chaton.settings.tellfriends;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0633e;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.an */
/* loaded from: classes.dex */
class ViewOnClickListenerC1359an implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f5181a;

    /* renamed from: b */
    final /* synthetic */ C1358am f5182b;

    ViewOnClickListenerC1359an(C1358am c1358am, int i) {
        this.f5182b = c1358am;
        this.f5181a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5182b.f5176a.m4855i();
        this.f5182b.f5176a.f4987e.setMessage(this.f5182b.f5176a.getResources().getString(R.string.wait_sending));
        new C0633e(this.f5182b.f5176a.f4983B).m2868b(((C1342a) this.f5182b.f5178c.get(this.f5181a)).m5069c());
    }
}
