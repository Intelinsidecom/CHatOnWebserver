package com.sec.chaton;

import java.util.ArrayList;
import java.util.List;

/* compiled from: EventBusManager.java */
/* renamed from: com.sec.chaton.an */
/* loaded from: classes.dex */
public final class C1015an {

    /* renamed from: a */
    public List<String> f3296a;

    public C1015an(String[] strArr) {
        this.f3296a = new ArrayList(strArr.length);
        for (String str : strArr) {
            this.f3296a.add(str);
        }
    }

    /* renamed from: a */
    public boolean m6091a(String str) {
        if (this.f3296a == null) {
            return false;
        }
        return this.f3296a.contains(str);
    }
}
