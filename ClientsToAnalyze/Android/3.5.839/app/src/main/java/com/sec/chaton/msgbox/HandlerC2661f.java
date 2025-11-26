package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import java.util.ArrayList;

/* compiled from: MsgboxClose.java */
/* renamed from: com.sec.chaton.msgbox.f */
/* loaded from: classes.dex */
class HandlerC2661f extends Handler {

    /* renamed from: a */
    final /* synthetic */ String f9553a;

    /* renamed from: b */
    final /* synthetic */ EnumC2300t f9554b;

    /* renamed from: c */
    final /* synthetic */ String f9555c;

    /* renamed from: d */
    final /* synthetic */ EnumC2301u f9556d;

    /* renamed from: e */
    final /* synthetic */ boolean f9557e;

    /* renamed from: f */
    final /* synthetic */ ArrayList f9558f;

    /* renamed from: g */
    final /* synthetic */ boolean f9559g;

    /* renamed from: h */
    final /* synthetic */ C2660e f9560h;

    HandlerC2661f(C2660e c2660e, String str, EnumC2300t enumC2300t, String str2, EnumC2301u enumC2301u, boolean z, ArrayList arrayList, boolean z2) {
        this.f9560h = c2660e;
        this.f9553a = str;
        this.f9554b = enumC2300t;
        this.f9555c = str2;
        this.f9556d = enumC2301u;
        this.f9557e = z;
        this.f9558f = arrayList;
        this.f9559g = z2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z = message.what == 1;
        if (this.f9560h.f9546j != 6 || this.f9560h.f9548l == null) {
            this.f9560h.m11217a(this.f9559g, z, new RunnableC2662g(this), new RunnableC2663h(this));
            return;
        }
        Message message2 = new Message();
        message2.what = 6;
        message2.obj = new C2680y(new C2679x(this.f9553a, this.f9554b, this.f9555c, this.f9556d, Boolean.valueOf(this.f9557e)), this.f9558f, z);
        this.f9560h.f9548l.sendMessage(message2);
    }
}
