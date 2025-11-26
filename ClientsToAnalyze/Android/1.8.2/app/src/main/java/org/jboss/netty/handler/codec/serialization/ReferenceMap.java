package org.jboss.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
abstract class ReferenceMap implements Map {
    private final Map delegate;

    abstract Reference fold(Object obj);

    protected ReferenceMap(Map map) {
        this.delegate = map;
    }

    private Object unfold(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return unfold((Reference) this.delegate.get(obj));
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return unfold((Reference) this.delegate.put(obj, fold(obj2)));
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return unfold((Reference) this.delegate.remove(obj));
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.delegate.put(entry.getKey(), fold(entry.getValue()));
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.delegate.keySet();
    }

    @Override // java.util.Map
    public Collection values() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Set entrySet() {
        throw new UnsupportedOperationException();
    }
}
