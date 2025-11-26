package com.sec.chaton.samsungaccount;

import android.support.v4.app.AbstractC0018ad;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bs */
/* loaded from: classes.dex */
class C3367bs extends AbstractC0018ad {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12305a;

    /* renamed from: b */
    private boolean f12306b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3367bs(MainActivity mainActivity, AbstractC0069w abstractC0069w, boolean z) {
        super(abstractC0069w);
        this.f12305a = mainActivity;
        this.f12306b = z;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public int mo607a(Object obj) {
        if (GlobalApplication.m10286e()) {
            return -2;
        }
        return super.mo607a(obj);
    }

    @Override // android.support.v4.app.AbstractC0018ad
    /* renamed from: a */
    public Fragment mo75a(int i) {
        switch (i) {
            case 0:
                return new FlickImageLayout(0);
            case 1:
                return new FlickImageLayout(1);
            case 2:
                return new FlickImageLayout(2);
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public int mo612b() {
        return this.f12306b ? 3 : 2;
    }
}
