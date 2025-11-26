package com.sec.chaton.sharedialog;

import java.text.Collator;
import java.util.Comparator;
import java.util.Map;

/* compiled from: SetAppPreferences.java */
/* renamed from: com.sec.chaton.sharedialog.i */
/* loaded from: classes.dex */
class C3701i implements Comparator<Map.Entry<String, Integer>> {
    C3701i() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
        int iCompareTo = entry2.getValue().compareTo(entry.getValue());
        if (iCompareTo == 0) {
            return Collator.getInstance().compare(entry.getKey(), entry2.getKey());
        }
        return iCompareTo;
    }
}
