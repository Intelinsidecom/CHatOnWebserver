package com.vlingo.sdk.internal.util;

import java.util.Enumeration;

/* loaded from: classes.dex */
public interface ToIntHashtable {
    void clear();

    boolean contains(int i);

    boolean containsKey(Object obj);

    int get(Object obj);

    boolean isEmpty();

    Enumeration<?> keys();

    int put(Object obj, int i);

    int remove(Object obj);

    int size();
}
