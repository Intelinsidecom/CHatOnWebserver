package org.jboss.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class WeakReferenceMap extends ReferenceMap {
    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return super.get(obj);
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public WeakReferenceMap(Map map) {
        super(map);
    }

    @Override // org.jboss.netty.handler.codec.serialization.ReferenceMap
    Reference fold(Object obj) {
        return new WeakReference(obj);
    }
}
