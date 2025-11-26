package com.sec.chaton;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetVersion3;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.g */
/* loaded from: classes.dex */
class HandlerC0236g extends Handler {

    /* renamed from: a */
    final /* synthetic */ HomeActivity f1893a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0236g(HomeActivity homeActivity, Looper looper) {
        super(looper);
        this.f1893a = homeActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        GetVersion3 getVersion3;
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR || (getVersion3 = (GetVersion3) httpEntry.m1955d()) == null) {
            return;
        }
        if (!getVersion3.uptodate.booleanValue()) {
            this.f1893a.m361a(getVersion3, true);
            return;
        }
        ChatONPref.m3519a().edit().remove("UpdateIsCritical").commit();
        ChatONPref.m3519a().edit().remove("UpdateTargetVersion").commit();
        ChatONPref.m3519a().edit().remove("UpdateUrl").commit();
        ChatONPref.m3519a().edit().remove("SamsungappsUrl").commit();
        this.f1893a.m377m();
    }
}
