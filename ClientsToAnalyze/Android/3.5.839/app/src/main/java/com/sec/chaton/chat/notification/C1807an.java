package com.sec.chaton.chat.notification;

import android.os.Bundle;
import android.support.v4.app.AbstractC0020af;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import com.p137vk.sdk.api.VKApiConst;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.an */
/* loaded from: classes.dex */
public class C1807an extends AbstractC0020af {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6818a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1807an(ScreenNotification2 screenNotification2, AbstractC0069w abstractC0069w) {
        super(abstractC0069w);
        this.f6818a = screenNotification2;
    }

    @Override // android.support.v4.app.AbstractC0020af
    /* renamed from: a */
    public Fragment mo86a(int i) {
        C1830s c1830sM8958a = this.f6818a.f6735H.m8958a(i);
        FragmentScreenNotification fragmentScreenNotification = new FragmentScreenNotification();
        Bundle bundle = new Bundle();
        bundle.putString(VKApiConst.MESSAGE, c1830sM8958a.f6929c);
        bundle.putInt("msgType", c1830sM8958a.f6933g);
        bundle.putString("no", c1830sM8958a.f6927a);
        bundle.putString("name", c1830sM8958a.f6928b);
        bundle.putString("truncated", c1830sM8958a.f6939m);
        bundle.putLong("msgID", c1830sM8958a.f6940n);
        bundle.putString("inboxNO", c1830sM8958a.f6931e);
        bundle.putInt("chatType", c1830sM8958a.f6932f);
        bundle.putInt("roomType", c1830sM8958a.f6942p.m10212a());
        fragmentScreenNotification.setArguments(bundle);
        return fragmentScreenNotification;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public int mo612b() {
        if (this.f6818a.f6763aj < 99) {
            return this.f6818a.f6763aj;
        }
        return 99;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public int mo607a(Object obj) {
        return -2;
    }
}
