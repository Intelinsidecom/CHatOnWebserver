package com.vlingo.sdk.internal.util;

import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class AndroidToIntHashtable implements ToIntHashtable {
    private final Hashtable<Object, Integer> hash;

    public AndroidToIntHashtable() {
        this.hash = new Hashtable<>();
    }

    public AndroidToIntHashtable(int initialCapacity) {
        this.hash = new Hashtable<>(initialCapacity);
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public void clear() {
        this.hash.clear();
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public boolean contains(int value) {
        return this.hash.contains(new Integer(value));
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public boolean containsKey(Object key) {
        return this.hash.containsKey(key);
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public int get(Object key) {
        Integer i = this.hash.get(key);
        if (i != null) {
            return i.intValue();
        }
        return -1;
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public boolean isEmpty() {
        return this.hash.isEmpty();
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public Enumeration<?> keys() {
        return this.hash.keys();
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public int put(Object key, int value) {
        Integer i = this.hash.put(key, new Integer(value));
        if (i != null) {
            return i.intValue();
        }
        return -1;
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public int remove(Object key) {
        Integer i = this.hash.remove(key);
        if (i != null) {
            return i.intValue();
        }
        return -1;
    }

    @Override // com.vlingo.sdk.internal.util.ToIntHashtable
    public int size() {
        return this.hash.size();
    }
}
