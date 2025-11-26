package com.sec.chaton.chat.notification;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.w */
/* loaded from: classes.dex */
public class C1127w extends FragmentStatePagerAdapter {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4537a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1127w(ScreenNotification2 screenNotification2, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f4537a = screenNotification2;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        C1111g c1111g = this.f4537a.f4410k.f4462l.get(i);
        FragmentScreenNotification fragmentScreenNotification = new FragmentScreenNotification();
        Bundle bundle = new Bundle();
        bundle.putString("message", c1111g.f4500c);
        bundle.putInt("msgType", c1111g.f4504g);
        bundle.putString("no", c1111g.f4498a);
        bundle.putString("name", c1111g.f4499b);
        bundle.putString("truncated", c1111g.f4510m);
        bundle.putString("msgID", c1111g.f4511n);
        bundle.putString("inboxNO", c1111g.f4502e);
        bundle.putInt("chatType", c1111g.f4503f);
        fragmentScreenNotification.setArguments(bundle);
        return fragmentScreenNotification;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.f4537a.f4410k.f4463m < 99) {
            return this.f4537a.f4410k.f4463m;
        }
        return 99;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }
}
