package com.sec.chaton.buddy;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.settings.moreapps.EventActivity;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.dj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1249dj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4749a;

    /* renamed from: b */
    final /* synthetic */ String f4750b;

    /* renamed from: c */
    final /* synthetic */ BuddyFragment f4751c;

    ViewOnClickListenerC1249dj(BuddyFragment buddyFragment, String str, String str2) {
        this.f4751c = buddyFragment;
        this.f4749a = str;
        this.f4750b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4751c.getActivity(), (Class<?>) EventActivity.class);
        if (!TextUtils.isEmpty(this.f4749a)) {
            intent.putExtra("event_url", this.f4749a);
        }
        if (!TextUtils.isEmpty(this.f4750b)) {
            intent.putExtra("event_id", this.f4750b);
        }
        this.f4751c.startActivity(intent);
        this.f4751c.m6534h(true);
    }
}
