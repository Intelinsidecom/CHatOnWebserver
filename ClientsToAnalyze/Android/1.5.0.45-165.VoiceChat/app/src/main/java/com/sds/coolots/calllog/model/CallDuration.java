package com.sds.coolots.calllog.model;

import java.util.HashMap;

/* loaded from: classes.dex */
public class CallDuration {

    /* renamed from: a */
    private final HashMap f2899a;

    /* renamed from: b */
    private final HashMap f2900b;

    public CallDuration(HashMap map, HashMap map2) {
        this.f2899a = map;
        this.f2900b = map2;
    }

    public HashMap getCallDuration() {
        return this.f2899a;
    }

    public HashMap getStartTime() {
        return this.f2900b;
    }
}
