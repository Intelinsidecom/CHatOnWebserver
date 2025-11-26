package com.sec.chaton.settings.tellfriends;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: TellFriendsImageDownloader.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bu */
/* loaded from: classes.dex */
class C1393bu extends LinkedHashMap {

    /* renamed from: a */
    final /* synthetic */ C1392bt f5253a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1393bu(C1392bt c1392bt, int i, float f, boolean z) {
        super(i, f, z);
        this.f5253a = c1392bt;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry entry) {
        if (size() <= 100) {
            return false;
        }
        C1392bt.f5248d.put(entry.getKey(), new SoftReference(entry.getValue()));
        return true;
    }
}
