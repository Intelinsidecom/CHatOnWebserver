package com.sec.chaton.p021g;

import android.content.Intent;
import com.sec.chaton.EnumC0836m;
import com.sec.chaton.p017e.EnumC0699n;

/* compiled from: InterlockedText.java */
/* renamed from: com.sec.chaton.g.h */
/* loaded from: classes.dex */
public class C0759h implements InterfaceC0752a {

    /* renamed from: a */
    private Intent f2773a;

    public C0759h(Intent intent) {
        this.f2773a = intent;
    }

    @Override // com.sec.chaton.p021g.InterfaceC0752a
    /* renamed from: a */
    public EnumC0836m mo3250a() {
        this.f2773a.putExtra("callForward", true);
        if (!this.f2773a.getExtras().containsKey("android.intent.extra.TEXT")) {
            return EnumC0836m.HOME;
        }
        this.f2773a.putExtra("download_uri", this.f2773a.getExtras().getString("android.intent.extra.TEXT"));
        this.f2773a.putExtra("content_type", EnumC0699n.TEXT.m3162a());
        return EnumC0836m.FORWARD;
    }
}
