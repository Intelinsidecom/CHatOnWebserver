package com.sec.chaton.memo;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.memo.MemoAdapter;

/* renamed from: com.sec.chaton.memo.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0247b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f1948a;

    /* renamed from: b */
    final /* synthetic */ MemoAdapter f1949b;

    ViewOnClickListenerC0247b(MemoAdapter memoAdapter, int i) {
        this.f1949b = memoAdapter;
        this.f1948a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((MemoAdapter.MemoItem) this.f1949b.f1924b.get(this.f1948a)).m2399a().equals(MemoAdapter.f1922e)) {
            return;
        }
        Intent intent = new Intent(this.f1949b.f1923a, (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", ((MemoAdapter.MemoItem) this.f1949b.f1924b.get(this.f1948a)).m2399a());
        intent.putExtra("PROFILE_BUDDY_NAME", ((MemoAdapter.MemoItem) this.f1949b.f1924b.get(this.f1948a)).m2400b());
        if (this.f1949b.f1923a instanceof Activity) {
            intent.setFlags(67108864);
        } else {
            intent.setFlags(335544320);
        }
        this.f1949b.f1923a.startActivity(intent);
    }
}
