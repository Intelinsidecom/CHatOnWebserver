package com.sec.chaton.smsplugin.spam;

import com.sec.chaton.smsplugin.p112ui.C4108aq;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: SpamMessageListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bw */
/* loaded from: classes.dex */
class C4019bw extends LinkedHashMap<Long, C4108aq> {

    /* renamed from: a */
    final /* synthetic */ C4018bv f14498a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4019bw(C4018bv c4018bv, int i, float f, boolean z) {
        super(i, f, z);
        this.f14498a = c4018bv;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<Long, C4108aq> entry) {
        return size() > 50;
    }
}
