package com.nuance.nmsp.client.sdk.common.util;

/* loaded from: classes.dex */
public abstract class Enum {

    /* renamed from: a */
    private int f70a;

    public Enum(int i) {
        this.f70a = i;
    }

    public boolean equals(Object obj) {
        return obj.getClass().getName().equals(getClass().getName()) && ((Enum) obj).f70a == this.f70a;
    }

    public int getId() {
        return this.f70a;
    }
}
