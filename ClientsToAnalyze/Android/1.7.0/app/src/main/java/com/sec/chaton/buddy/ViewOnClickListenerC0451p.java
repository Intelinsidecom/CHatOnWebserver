package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.buddy.p017a.C0365c;
import java.util.HashMap;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.p */
/* loaded from: classes.dex */
class ViewOnClickListenerC0451p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0370ae f1444a;

    ViewOnClickListenerC0451p(C0370ae c0370ae) {
        this.f1444a = c0370ae;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0363a c0363a = (C0363a) view.getTag();
        if (c0363a.m2336v()) {
            HashMap mapM2337w = c0363a.m2337w();
            C0365c c0365c = new C0365c(Integer.parseInt(c0363a.m2308a()), c0363a.m2314b(), mapM2337w == null ? 0 : mapM2337w.size(), 2);
            Intent intent = new Intent(this.f1444a.f1326c, (Class<?>) BuddyGroupProfileActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 18);
            intent.putExtra("groupInfo", c0365c);
            this.f1444a.f1326c.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f1444a.f1326c, (Class<?>) BuddyProfileActivity.class);
        intent2.putExtra("PROFILE_BUDDY_NO", c0363a.m2308a());
        intent2.putExtra("PROFILE_BUDDY_NAME", c0363a.m2314b());
        intent2.setFlags(268435456);
        this.f1444a.f1326c.startActivity(intent2);
    }
}
