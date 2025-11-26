package com.sec.chaton.sns.p114b;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.sns.p113a.C4368e;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: SnsHelper.java */
/* renamed from: com.sec.chaton.sns.b.w */
/* loaded from: classes.dex */
public abstract class AbstractC4439w {
    /* renamed from: a */
    public abstract String mo16638a(boolean z);

    /* renamed from: a */
    public abstract void mo16639a();

    /* renamed from: a */
    public abstract void mo16641a(InterfaceC4376ab interfaceC4376ab);

    /* renamed from: a */
    public abstract void mo16642a(InterfaceC4377ac interfaceC4377ac);

    /* renamed from: a */
    public abstract void mo16643a(InterfaceC4441y interfaceC4441y);

    /* renamed from: a */
    public abstract void mo16644a(InterfaceC4442z interfaceC4442z);

    /* renamed from: b */
    public abstract String mo16647b();

    /* renamed from: c */
    public abstract String mo16648c();

    /* renamed from: d */
    public abstract String mo16649d();

    /* renamed from: e */
    public abstract boolean mo16650e();

    /* renamed from: a */
    public void mo16640a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public static AbstractC4439w m16816a(String str, Context context) {
        if (C4368e.f15815a.equals(str)) {
            return new C4380af(context);
        }
        if (C4368e.f15817c.equals(str)) {
            return new C4392ar(context);
        }
        if (C4368e.f15819e.equals(str)) {
            return new C4384aj(context);
        }
        if (C4368e.f15816b.equals(str)) {
            return new C4386al(context);
        }
        if (C4368e.f15820f.equals(str)) {
            return new C4388an(context);
        }
        if (C4368e.f15818d.equals(str)) {
            return new C4382ah(context);
        }
        return null;
    }

    /* renamed from: a */
    public static ArrayList<C4379ae> m16817a(ArrayList<C4379ae> arrayList) {
        Collections.sort(arrayList, new C4440x());
        return arrayList;
    }
}
