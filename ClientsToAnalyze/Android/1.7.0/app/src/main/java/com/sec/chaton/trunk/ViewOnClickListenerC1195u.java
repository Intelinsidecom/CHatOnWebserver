package com.sec.chaton.trunk;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.widget.C1619g;

/* compiled from: ContentAdapter.java */
/* renamed from: com.sec.chaton.trunk.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC1195u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1108af f4065a;

    /* renamed from: b */
    final /* synthetic */ C1183i f4066b;

    ViewOnClickListenerC1195u(C1183i c1183i, C1108af c1108af) {
        this.f4066b = c1183i;
        this.f4065a = c1108af;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.f4065a.f3903e;
        String str2 = this.f4065a.f3904f;
        if (str == null || str.trim().equals("")) {
            C1619g.m5889a(this.f4066b.f4053a, String.format(this.f4066b.f4053a.getString(R.string.toast_deleted_account), str2), 0).show();
            return;
        }
        if (!"ME".equals(str)) {
            Intent intent = new Intent(this.f4066b.f4053a, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", str);
            intent.putExtra("PROFILE_BUDDY_NAME", str2);
            intent.setFlags(268435456);
            this.f4066b.f4053a.startActivity(intent);
        }
    }
}
