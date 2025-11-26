package org.jboss.netty.util.internal;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final int RETRIES_BEFORE_LOCK = 2;
    Set<Map.Entry<K, V>> entrySet;
    Set<K> keySet;
    final int segmentMask;
    final int segmentShift;
    final Segment<K, V>[] segments;
    Collection<V> values;

    private static int hash(int i) {
        int i2 = ((i << 15) ^ (-12931)) + i;
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    final Segment<K, V> segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    private int hashOf(Object obj) {
        return hash(obj.hashCode());
    }

    final class HashEntry<K, V> {
        final int hash;
        final Object key;
        final HashEntry<K, V> next;
        volatile Object value;

        HashEntry(K k, int i, HashEntry<K, V> hashEntry, V v) {
            this.hash = i;
            this.next = hashEntry;
            this.key = k;
            this.value = v;
        }

        final K key() {
            return (K) this.key;
        }

        final V value() {
            return (V) this.value;
        }

        final void setValue(V v) {
            this.value = v;
        }

        static final <K, V> HashEntry<K, V>[] newArray(int i) {
            return new HashEntry[i];
        }
    }

    final class Segment<K, V> extends ReentrantLock {
        private static final long serialVersionUID = -2001752926705396395L;
        volatile transient int count;
        final float loadFactor;
        int modCount;
        volatile transient HashEntry<K, V>[] table;
        int threshold;

        Segment(int i, float f) {
            this.loadFactor = f;
            setTable(HashEntry.newArray(i));
        }

        static final <K, V> Segment<K, V>[] newArray(int i) {
            return new Segment[i];
        }

        private boolean keyEq(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        void setTable(HashEntry<K, V>[] hashEntryArr) {
            this.threshold = (int) (hashEntryArr.length * this.loadFactor);
            this.table = hashEntryArr;
        }

        HashEntry<K, V> getFirst(int i) {
            return this.table[(r0.length - 1) & i];
        }

        HashEntry<K, V> newHashEntry(K k, int i, HashEntry<K, V> hashEntry, V v) {
            return new HashEntry<>(k, i, hashEntry, v);
        }

        V readValueUnderLock(HashEntry<K, V> hashEntry) {
            lock();
            try {
                return hashEntry.value();
            } finally {
                unlock();
            }
        }

        V get(Object obj, int i) {
            if (this.count != 0) {
                for (HashEntry<K, V> first = getFirst(i); first != null; first = first.next) {
                    if (first.hash == i && keyEq(obj, first.key())) {
                        V vValue = first.value();
                        if (vValue == null) {
                            return readValueUnderLock(first);
                        }
                        return vValue;
                    }
                }
            }
            return null;
        }

        boolean containsKey(Object obj, int i) {
            if (this.count != 0) {
                for (HashEntry<K, V> first = getFirst(i); first != null; first = first.next) {
                    if (first.hash == i && keyEq(obj, first.key())) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean containsValue(Object obj) {
            if (this.count != 0) {
                for (HashEntry<K, V> hashEntry : this.table) {
                    for (; hashEntry != null; hashEntry = hashEntry.next) {
                        V vValue = hashEntry.value();
                        if (vValue == null) {
                            vValue = readValueUnderLock(hashEntry);
                        }
                        if (obj.equals(vValue)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                HashEntry<K, V> first = getFirst(i);
                while (first != null && (first.hash != i || !keyEq(k, first.key()))) {
                    first = first.next;
                }
                boolean z = false;
                if (first != null && v.equals(first.value())) {
                    z = true;
                    first.setValue(v2);
                }
                return z;
            } finally {
                unlock();
            }
        }

        V replace(K k, int i, V v) {
            lock();
            try {
                HashEntry<K, V> first = getFirst(i);
                while (first != null && (first.hash != i || !keyEq(k, first.key()))) {
                    first = first.next;
                }
                V vValue = null;
                if (first != null) {
                    vValue = first.value();
                    first.setValue(v);
                }
                return vValue;
            } finally {
                unlock();
            }
        }

        V put(K k, int i, V v, boolean z) {
            V vValue;
            int iRehash;
            lock();
            try {
                int i2 = this.count;
                int i3 = i2 + 1;
                if (i2 > this.threshold && (iRehash = rehash()) > 0) {
                    i3 -= iRehash;
                    this.count = i3 - 1;
                }
                int i4 = i3;
                HashEntry<K, V>[] hashEntryArr = this.table;
                int length = i & (hashEntryArr.length - 1);
                HashEntry<K, V> hashEntry = hashEntryArr[length];
                HashEntry<K, V> hashEntry2 = hashEntry;
                while (hashEntry2 != null && (hashEntry2.hash != i || !keyEq(k, hashEntry2.key()))) {
                    hashEntry2 = hashEntry2.next;
                }
                if (hashEntry2 != null) {
                    vValue = hashEntry2.value();
                    if (!z) {
                        hashEntry2.setValue(v);
                    }
                } else {
                    vValue = null;
                    this.modCount++;
                    hashEntryArr[length] = newHashEntry(k, i, hashEntry, v);
                    this.count = i4;
                }
                return vValue;
            } finally {
                unlock();
            }
        }

        int rehash() {
            int i;
            HashEntry<K, V> hashEntry;
            int i2 = 0;
            HashEntry<K, V>[] hashEntryArr = this.table;
            int length = hashEntryArr.length;
            if (length < ConcurrentHashMap.MAXIMUM_CAPACITY) {
                HashEntry<K, V>[] hashEntryArrNewArray = HashEntry.newArray(length << 1);
                this.threshold = (int) (hashEntryArrNewArray.length * this.loadFactor);
                int length2 = hashEntryArrNewArray.length - 1;
                int i3 = 0;
                while (i3 < length) {
                    HashEntry<K, V> hashEntry2 = hashEntryArr[i3];
                    if (hashEntry2 != null) {
                        HashEntry<K, V> hashEntry3 = hashEntry2.next;
                        int i4 = hashEntry2.hash & length2;
                        if (hashEntry3 == null) {
                            hashEntryArrNewArray[i4] = hashEntry2;
                            i = i2;
                        } else {
                            HashEntry<K, V> hashEntry4 = hashEntry2;
                            while (hashEntry3 != null) {
                                int i5 = hashEntry3.hash & length2;
                                if (i5 != i4) {
                                    hashEntry = hashEntry3;
                                } else {
                                    i5 = i4;
                                    hashEntry = hashEntry4;
                                }
                                hashEntry3 = hashEntry3.next;
                                hashEntry4 = hashEntry;
                                i4 = i5;
                            }
                            hashEntryArrNewArray[i4] = hashEntry4;
                            i = i2;
                            for (HashEntry<K, V> hashEntry5 = hashEntry2; hashEntry5 != hashEntry4; hashEntry5 = hashEntry5.next) {
                                K kKey = hashEntry5.key();
                                if (kKey == null) {
                                    i++;
                                } else {
                                    int i6 = hashEntry5.hash & length2;
                                    hashEntryArrNewArray[i6] = newHashEntry(kKey, hashEntry5.hash, hashEntryArrNewArray[i6], hashEntry5.value());
                                }
                            }
                        }
                    } else {
                        i = i2;
                    }
                    i3++;
                    i2 = i;
                }
                this.table = hashEntryArrNewArray;
            }
            return i2;
        }

        V remove(Object obj, int i, Object obj2, boolean z) {
            lock();
            try {
                int i2 = this.count - 1;
                HashEntry<K, V>[] hashEntryArr = this.table;
                int length = i & (hashEntryArr.length - 1);
                HashEntry<K, V> hashEntry = hashEntryArr[length];
                HashEntry<K, V> hashEntry2 = hashEntry;
                while (hashEntry2 != null && obj != hashEntry2.key && (z || i != hashEntry2.hash || !keyEq(obj, hashEntry2.key()))) {
                    hashEntry2 = hashEntry2.next;
                }
                V v = null;
                if (hashEntry2 != null) {
                    V vValue = hashEntry2.value();
                    if (obj2 == null || obj2.equals(vValue)) {
                        this.modCount++;
                        HashEntry<K, V> hashEntryNewHashEntry = hashEntry2.next;
                        int i3 = i2;
                        for (HashEntry<K, V> hashEntry3 = hashEntry; hashEntry3 != hashEntry2; hashEntry3 = hashEntry3.next) {
                            K kKey = hashEntry3.key();
                            if (kKey == null) {
                                i3--;
                            } else {
                                hashEntryNewHashEntry = newHashEntry(kKey, hashEntry3.hash, hashEntryNewHashEntry, hashEntry3.value());
                            }
                        }
                        hashEntryArr[length] = hashEntryNewHashEntry;
                        this.count = i3;
                        v = vValue;
                    }
                }
                return v;
            } finally {
                unlock();
            }
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    HashEntry<K, V>[] hashEntryArr = this.table;
                    for (int i = 0; i < hashEntryArr.length; i++) {
                        hashEntryArr[i] = null;
                    }
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }
    }

    public ConcurrentHashMap(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        int i3 = 1;
        int i4 = 0;
        while (i3 < (i2 > 65536 ? 65536 : i2)) {
            i3 <<= 1;
            i4++;
        }
        this.segmentShift = 32 - i4;
        this.segmentMask = i3 - 1;
        this.segments = Segment.newArray(i3);
        i = i > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : i;
        int i5 = i / i3;
        int i6 = 1;
        while (i6 < (i5 * i3 < i ? i5 + 1 : i5)) {
            i6 <<= 1;
        }
        for (int i7 = 0; i7 < this.segments.length; i7++) {
            this.segments[i7] = new Segment<>(i6, f);
        }
    }

    public ConcurrentHashMap(int i, float f) {
        this(i, f, 16);
    }

    public ConcurrentHashMap(int i) {
        this(i, DEFAULT_LOAD_FACTOR, 16);
    }

    public ConcurrentHashMap() {
        this(16, DEFAULT_LOAD_FACTOR, 16);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (map.size() / DEFAULT_LOAD_FACTOR)) + 1, 16), DEFAULT_LOAD_FACTOR, 16);
        putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
        int[] iArr = new int[segmentArr.length];
        int i = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            int i3 = segmentArr[i2].modCount;
            iArr[i2] = i3;
            i += i3;
        }
        if (i != 0) {
            for (int i4 = 0; i4 < segmentArr.length; i4++) {
                if (segmentArr[i4].count != 0 || iArr[i4] != segmentArr[i4].modCount) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005f A[LOOP:0: B:3:0x000f->B:26:0x005f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0046 A[SYNTHETIC] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int size() {
        /*
            r15 = this;
            org.jboss.netty.util.internal.ConcurrentHashMap$Segment<K, V>[] r7 = r15.segments
            r3 = 0
            r1 = 0
            int r0 = r7.length
            int[] r8 = new int[r0]
            r0 = 0
            r6 = r0
            r11 = r1
            r0 = r11
            r13 = r3
            r2 = r13
        Lf:
            r4 = 2
            if (r6 >= r4) goto L8b
            r4 = 0
            r2 = 0
            r1 = 0
            r0 = 0
        L18:
            int r9 = r7.length
            if (r0 >= r9) goto L2b
            r9 = r7[r0]
            int r9 = r9.count
            long r9 = (long) r9
            long r2 = r2 + r9
            r9 = r7[r0]
            int r9 = r9.modCount
            r8[r0] = r9
            int r1 = r1 + r9
            int r0 = r0 + 1
            goto L18
        L2b:
            if (r1 == 0) goto L89
            r0 = 0
        L2e:
            int r1 = r7.length
            if (r0 >= r1) goto L89
            r1 = r7[r0]
            int r1 = r1.count
            long r9 = (long) r1
            long r4 = r4 + r9
            r1 = r8[r0]
            r9 = r7[r0]
            int r9 = r9.modCount
            if (r1 == r9) goto L5c
            r4 = -1
            r0 = r4
        L42:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L5f
            r11 = r0
            r13 = r2
            r1 = r13
            r3 = r11
        L4a:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L7c
            r1 = 0
            r0 = 0
        L51:
            int r3 = r7.length
            if (r0 >= r3) goto L63
            r3 = r7[r0]
            r3.lock()
            int r0 = r0 + 1
            goto L51
        L5c:
            int r0 = r0 + 1
            goto L2e
        L5f:
            int r4 = r6 + 1
            r6 = r4
            goto Lf
        L63:
            r0 = 0
        L64:
            int r3 = r7.length
            if (r0 >= r3) goto L70
            r3 = r7[r0]
            int r3 = r3.count
            long r3 = (long) r3
            long r1 = r1 + r3
            int r0 = r0 + 1
            goto L64
        L70:
            r0 = 0
        L71:
            int r3 = r7.length
            if (r0 >= r3) goto L7c
            r3 = r7[r0]
            r3.unlock()
            int r0 = r0 + 1
            goto L71
        L7c:
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L87
            r0 = 2147483647(0x7fffffff, float:NaN)
        L86:
            return r0
        L87:
            int r0 = (int) r1
            goto L86
        L89:
            r0 = r4
            goto L42
        L8b:
            r11 = r0
            r13 = r2
            r1 = r13
            r3 = r11
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.ConcurrentHashMap.size():int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).get(obj, iHashOf);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).containsKey(obj, iHashOf);
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z;
        boolean z2;
        int i = 0;
        if (obj == null) {
            throw new NullPointerException();
        }
        Segment<K, V>[] segmentArr = this.segments;
        int[] iArr = new int[segmentArr.length];
        for (int i2 = 0; i2 < 2; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < segmentArr.length; i4++) {
                int i5 = segmentArr[i4].modCount;
                iArr[i4] = i5;
                i3 += i5;
                if (segmentArr[i4].containsValue(obj)) {
                    return true;
                }
            }
            if (i3 != 0) {
                for (int i6 = 0; i6 < segmentArr.length; i6++) {
                    if (iArr[i6] != segmentArr[i6].modCount) {
                        z2 = false;
                        break;
                    }
                }
                z2 = true;
            } else {
                z2 = true;
            }
            if (z2) {
                return false;
            }
        }
        for (Segment<K, V> segment : segmentArr) {
            segment.lock();
        }
        int i7 = 0;
        while (true) {
            try {
                if (i7 >= segmentArr.length) {
                    z = false;
                    break;
                }
                if (segmentArr[i7].containsValue(obj)) {
                    z = true;
                    break;
                }
                i7++;
            } catch (Throwable th) {
                while (i < segmentArr.length) {
                    segmentArr[i].unlock();
                    i++;
                }
                throw th;
            }
        }
        while (i < segmentArr.length) {
            segmentArr[i].unlock();
            i++;
        }
        return z;
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (v == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).put(k, iHashOf, v, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        if (v == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).put(k, iHashOf, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).remove(obj, iHashOf, null, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        int iHashOf = hashOf(obj);
        return (obj2 == null || segmentFor(iHashOf).remove(obj, iHashOf, obj2, false) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        if (v == null || v2 == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).replace(k, iHashOf, v, v2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        if (v == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).replace(k, iHashOf, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (int i = 0; i < this.segments.length; i++) {
            this.segments[i].clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    public Enumeration<K> keys() {
        return new KeyIterator();
    }

    public Enumeration<V> elements() {
        return new ValueIterator();
    }

    abstract class HashIterator {
        K currentKey;
        HashEntry<K, V>[] currentTable;
        HashEntry<K, V> lastReturned;
        HashEntry<K, V> nextEntry;
        int nextSegmentIndex;
        int nextTableIndex = -1;

        HashIterator() {
            this.nextSegmentIndex = ConcurrentHashMap.this.segments.length - 1;
            advance();
        }

        public void rewind() {
            this.nextSegmentIndex = ConcurrentHashMap.this.segments.length - 1;
            this.nextTableIndex = -1;
            this.currentTable = null;
            this.nextEntry = null;
            this.lastReturned = null;
            this.currentKey = null;
            advance();
        }

        public boolean hasMoreElements() {
            return hasNext();
        }

        final void advance() {
            if (this.nextEntry != null) {
                HashEntry<K, V> hashEntry = this.nextEntry.next;
                this.nextEntry = hashEntry;
                if (hashEntry != null) {
                    return;
                }
            }
            while (this.nextTableIndex >= 0) {
                HashEntry<K, V>[] hashEntryArr = this.currentTable;
                int i = this.nextTableIndex;
                this.nextTableIndex = i - 1;
                HashEntry<K, V> hashEntry2 = hashEntryArr[i];
                this.nextEntry = hashEntry2;
                if (hashEntry2 != null) {
                    return;
                }
            }
            while (this.nextSegmentIndex >= 0) {
                Segment<K, V>[] segmentArr = ConcurrentHashMap.this.segments;
                int i2 = this.nextSegmentIndex;
                this.nextSegmentIndex = i2 - 1;
                Segment<K, V> segment = segmentArr[i2];
                if (segment.count != 0) {
                    this.currentTable = segment.table;
                    for (int length = this.currentTable.length - 1; length >= 0; length--) {
                        HashEntry<K, V> hashEntry3 = this.currentTable[length];
                        this.nextEntry = hashEntry3;
                        if (hashEntry3 != null) {
                            this.nextTableIndex = length - 1;
                            return;
                        }
                    }
                }
            }
        }

        public boolean hasNext() {
            while (this.nextEntry != null) {
                if (this.nextEntry.key() != null) {
                    return true;
                }
                advance();
            }
            return false;
        }

        HashEntry<K, V> nextEntry() {
            while (this.nextEntry != null) {
                this.lastReturned = this.nextEntry;
                this.currentKey = this.lastReturned.key();
                advance();
                if (this.currentKey != null) {
                    return this.lastReturned;
                }
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            ConcurrentHashMap.this.remove(this.currentKey);
            this.lastReturned = null;
        }
    }

    final class KeyIterator extends ConcurrentHashMap<K, V>.HashIterator implements Enumeration<K>, ReusableIterator<K> {
        KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().key();
        }

        @Override // java.util.Enumeration
        public K nextElement() {
            return super.nextEntry().key();
        }
    }

    final class ValueIterator extends ConcurrentHashMap<K, V>.HashIterator implements Enumeration<V>, ReusableIterator<V> {
        ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().value();
        }

        @Override // java.util.Enumeration
        public V nextElement() {
            return super.nextEntry().value();
        }
    }

    class SimpleEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public SimpleEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public SimpleEntry(Map.Entry<? extends K, ? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return m13381eq(this.key, entry.getKey()) && m13381eq(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        /* renamed from: eq */
        private static boolean m13381eq(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }
    }

    final class WriteThroughEntry extends SimpleEntry<K, V> {
        WriteThroughEntry(K k, V v) {
            super(k, v);
        }

        @Override // org.jboss.netty.util.internal.ConcurrentHashMap.SimpleEntry, java.util.Map.Entry
        public V setValue(V v) {
            if (v == null) {
                throw new NullPointerException();
            }
            V v2 = (V) super.setValue(v);
            ConcurrentHashMap.this.put(getKey(), v);
            return v2;
        }
    }

    final class EntryIterator extends ConcurrentHashMap<K, V>.HashIterator implements ReusableIterator<Map.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            HashEntry<K, V> hashEntryNextEntry = super.nextEntry();
            return new WriteThroughEntry(hashEntryNextEntry.key(), hashEntryNextEntry.value());
        }
    }

    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ConcurrentHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return ConcurrentHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentHashMap.this.clear();
        }
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ConcurrentHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ConcurrentHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ConcurrentHashMap.this.clear();
        }
    }

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = ConcurrentHashMap.this.get(entry.getKey());
            return obj2 != null && obj2.equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return ConcurrentHashMap.this.remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentHashMap.this.clear();
        }
    }
}
