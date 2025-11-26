package com.sec.chaton.trunk;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: ContentAdapter.java */
/* renamed from: com.sec.chaton.trunk.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC1568c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1576d f5647a;

    /* renamed from: b */
    final /* synthetic */ C1541b f5648b;

    ViewOnClickListenerC1568c(C1541b c1541b, C1576d c1576d) {
        this.f5648b = c1541b;
        this.f5647a = c1576d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.f5647a.f5680e;
        String str2 = this.f5647a.f5681f;
        if (str == null || str.trim().equals("")) {
            Toast.makeText(this.f5648b.f5596a, String.format(this.f5648b.f5596a.getString(R.string.toast_deleted_account), str2), 0).show();
            return;
        }
        if (!"ME".equals(str)) {
            Intent intent = new Intent(this.f5648b.f5596a, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", str);
            intent.putExtra("PROFILE_BUDDY_NAME", str2);
            intent.setFlags(268435456);
            this.f5648b.f5596a.startActivity(intent);
        }
    }
}
