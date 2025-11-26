package com.sec.chaton.memo;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: MemoAdapter.java */
/* renamed from: com.sec.chaton.memo.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0838b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3081a;

    /* renamed from: b */
    final /* synthetic */ C0837a f3082b;

    ViewOnClickListenerC0838b(C0837a c0837a, int i) {
        this.f3082b = c0837a;
        this.f3081a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!((C0839c) this.f3082b.f3078b.get(this.f3081a)).m3495a().equals(C0837a.f3076e)) {
            if (GlobalApplication.m3265f()) {
                Intent intent = new Intent(this.f3082b.f3077a, (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", ((C0839c) this.f3082b.f3078b.get(this.f3081a)).m3495a());
                intent.putExtra("PROFILE_BUDDY_NAME", ((C0839c) this.f3082b.f3078b.get(this.f3081a)).m3496b());
                if (this.f3082b.f3077a instanceof Activity) {
                    intent.setFlags(67108864);
                } else {
                    intent.setFlags(268435456);
                }
                this.f3082b.f3077a.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this.f3082b.f3077a, (Class<?>) BuddyProfileActivity.class);
            intent2.putExtra("PROFILE_BUDDY_NO", ((C0839c) this.f3082b.f3078b.get(this.f3081a)).m3495a());
            intent2.putExtra("PROFILE_BUDDY_NAME", ((C0839c) this.f3082b.f3078b.get(this.f3081a)).m3496b());
            if (this.f3082b.f3077a instanceof Activity) {
                intent2.setFlags(67108864);
            } else {
                intent2.setFlags(335544320);
            }
            this.f3082b.f3077a.startActivity(intent2);
        }
    }
}
