package android.support.v4.p008c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* renamed from: android.support.v4.c.a */
/* loaded from: classes.dex */
public class C0078a<K, V> extends C0087m<K, V> implements Map<K, V> {

    /* renamed from: a */
    AbstractC0084g<K, V> f239a;

    /* renamed from: b */
    private AbstractC0084g<K, V> m248b() {
        if (this.f239a == null) {
            this.f239a = new C0079b(this);
        }
        return this.f239a;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m289a(this.f275h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m248b().m278d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m248b().m279e();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m248b().m280f();
    }
}
