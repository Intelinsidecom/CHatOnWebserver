package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: SnsHelper.java */
/* renamed from: com.sec.chaton.settings.tellfriends.aa */
/* loaded from: classes.dex */
public abstract class AbstractC2724aa {
    /* renamed from: a */
    public abstract String mo9766a(boolean z);

    /* renamed from: a */
    public abstract void mo9767a();

    /* renamed from: a */
    public abstract void mo9769a(InterfaceC2726ac interfaceC2726ac);

    /* renamed from: a */
    public abstract void mo9770a(InterfaceC2727ad interfaceC2727ad);

    /* renamed from: a */
    public abstract void mo9771a(InterfaceC2729af interfaceC2729af);

    /* renamed from: b */
    public abstract String mo9772b();

    /* renamed from: c */
    public abstract String mo9773c();

    /* renamed from: d */
    public abstract boolean mo9774d();

    /* renamed from: a */
    public void mo9768a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public static ArrayList<C2732ai> m9765a(ArrayList<C2732ai> arrayList) {
        Collections.sort(arrayList, new C2725ab());
        return arrayList;
    }
}
