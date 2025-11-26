package com.sec.chaton.memo;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: MemoAdapter.java */
/* renamed from: com.sec.chaton.memo.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC0730c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f2472a;

    /* renamed from: b */
    final /* synthetic */ C0729b f2473b;

    ViewOnClickListenerC0730c(C0729b c0729b, int i) {
        this.f2473b = c0729b;
        this.f2472a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!((C0734g) this.f2473b.f2469b.get(this.f2472a)).m3138a().equals(C0729b.f2467e)) {
            Intent intent = new Intent(this.f2473b.f2468a, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", ((C0734g) this.f2473b.f2469b.get(this.f2472a)).m3138a());
            intent.putExtra("PROFILE_BUDDY_NAME", ((C0734g) this.f2473b.f2469b.get(this.f2472a)).m3139b());
            if (this.f2473b.f2468a instanceof Activity) {
                intent.setFlags(67108864);
            } else {
                intent.setFlags(335544320);
            }
            this.f2473b.f2468a.startActivity(intent);
        }
    }
}
