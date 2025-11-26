package com.vlingo.sdk.internal.util;

/* loaded from: classes.dex */
public class ToIntHashtableFactory {
    public static ToIntHashtable createNewHashtable() {
        return new AndroidToIntHashtable();
    }

    public static ToIntHashtable createNewHashtable(int initialCapacity) {
        return new AndroidToIntHashtable(initialCapacity);
    }
}
