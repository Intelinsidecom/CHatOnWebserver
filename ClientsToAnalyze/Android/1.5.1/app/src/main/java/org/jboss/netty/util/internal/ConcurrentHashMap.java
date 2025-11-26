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
public final class ConcurrentHashMap extends AbstractMap implements ConcurrentMap {
    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final int RETRIES_BEFORE_LOCK = 2;
    Set entrySet;
    Set keySet;
    final int segmentMask;
    final int segmentShift;
    final Segment[] segments;
    Collection values;

    final class EntryIterator extends HashIterator implements ReusableIterator {
        EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry next() {
            HashEntry hashEntryNextEntry = super.nextEntry();
            return ConcurrentHashMap.this.new WriteThroughEntry(hashEntryNextEntry.key(), hashEntryNextEntry.value());
        }
    }

    final class EntrySet extends AbstractSet {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentHashMap.this.clear();
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
        public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return ConcurrentHashMap.this.new EntryIterator();
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
    }

    final class HashEntry {
        final int hash;
        final Object key;
        final HashEntry next;
        volatile Object value;

        HashEntry(Object obj, int i, HashEntry hashEntry, Object obj2) {
            this.hash = i;
            this.next = hashEntry;
            this.key = obj;
            this.value = obj2;
        }

        static final HashEntry[] newArray(int i) {
            return new HashEntry[i];
        }

        final Object key() {
            return this.key;
        }

        final void setValue(Object obj) {
            this.value = obj;
        }

        final Object value() {
            return this.value;
        }
    }

    abstract class HashIterator {
        Object currentKey;
        HashEntry[] currentTable;
        HashEntry lastReturned;
        HashEntry nextEntry;
        int nextSegmentIndex;
        int nextTableIndex = -1;

        HashIterator() {
            this.nextSegmentIndex = ConcurrentHashMap.this.segments.length - 1;
            advance();
        }

        final void advance() {
            if (this.nextEntry != null) {
                HashEntry hashEntry = this.nextEntry.next;
                this.nextEntry = hashEntry;
                if (hashEntry != null) {
                    return;
                }
            }
            while (this.nextTableIndex >= 0) {
                HashEntry[] hashEntryArr = this.currentTable;
                int i = this.nextTableIndex;
                this.nextTableIndex = i - 1;
                HashEntry hashEntry2 = hashEntryArr[i];
                this.nextEntry = hashEntry2;
                if (hashEntry2 != null) {
                    return;
                }
            }
            while (this.nextSegmentIndex >= 0) {
                Segment[] segmentArr = ConcurrentHashMap.this.segments;
                int i2 = this.nextSegmentIndex;
                this.nextSegmentIndex = i2 - 1;
                Segment segment = segmentArr[i2];
                if (segment.count != 0) {
                    this.currentTable = segment.table;
                    for (int length = this.currentTable.length - 1; length >= 0; length--) {
                        HashEntry hashEntry3 = this.currentTable[length];
                        this.nextEntry = hashEntry3;
                        if (hashEntry3 != null) {
                            this.nextTableIndex = length - 1;
                            return;
                        }
                    }
                }
            }
        }

        public boolean hasMoreElements() {
            return hasNext();
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

        HashEntry nextEntry() {
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

        public void rewind() {
            this.nextSegmentIndex = ConcurrentHashMap.this.segments.length - 1;
            this.nextTableIndex = -1;
            this.currentTable = null;
            this.nextEntry = null;
            this.lastReturned = null;
            this.currentKey = null;
            advance();
        }
    }

    final class KeyIterator extends HashIterator implements Enumeration, ReusableIterator {
        KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return super.nextEntry().key();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return super.nextEntry().key();
        }
    }

    final class KeySet extends AbstractSet {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ConcurrentHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return ConcurrentHashMap.this.new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return ConcurrentHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentHashMap.this.size();
        }
    }

    final class Segment extends ReentrantLock {
        private static final long serialVersionUID = -2001752926705396395L;
        volatile transient int count;
        final float loadFactor;
        int modCount;
        volatile transient HashEntry[] table;
        int threshold;

        Segment(int i, float f) {
            this.loadFactor = f;
            setTable(HashEntry.newArray(i));
        }

        private boolean keyEq(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        static final Segment[] newArray(int i) {
            return new Segment[i];
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    HashEntry[] hashEntryArr = this.table;
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

        boolean containsKey(Object obj, int i) {
            if (this.count != 0) {
                for (HashEntry first = getFirst(i); first != null; first = first.next) {
                    if (first.hash == i && keyEq(obj, first.key())) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean containsValue(Object obj) {
            if (this.count != 0) {
                for (HashEntry hashEntry : this.table) {
                    for (; hashEntry != null; hashEntry = hashEntry.next) {
                        Object objValue = hashEntry.value();
                        if (objValue == null) {
                            objValue = readValueUnderLock(hashEntry);
                        }
                        if (obj.equals(objValue)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        Object get(Object obj, int i) {
            if (this.count != 0) {
                for (HashEntry first = getFirst(i); first != null; first = first.next) {
                    if (first.hash == i && keyEq(obj, first.key())) {
                        Object objValue = first.value();
                        return objValue != null ? objValue : readValueUnderLock(first);
                    }
                }
            }
            return null;
        }

        HashEntry getFirst(int i) {
            HashEntry[] hashEntryArr = this.table;
            return hashEntryArr[(hashEntryArr.length - 1) & i];
        }

        HashEntry newHashEntry(Object obj, int i, HashEntry hashEntry, Object obj2) {
            return new HashEntry(obj, i, hashEntry, obj2);
        }

        Object put(Object obj, int i, Object obj2, boolean z) {
            int i2;
            Object objValue;
            int iRehash;
            lock();
            try {
                int i3 = this.count;
                int i4 = i3 + 1;
                if (i3 <= this.threshold || (iRehash = rehash()) <= 0) {
                    i2 = i4;
                } else {
                    i2 = i4 - iRehash;
                    this.count = i2 - 1;
                }
                HashEntry[] hashEntryArr = this.table;
                int length = (hashEntryArr.length - 1) & i;
                HashEntry hashEntry = hashEntryArr[length];
                HashEntry hashEntry2 = hashEntry;
                while (hashEntry2 != null && (hashEntry2.hash != i || !keyEq(obj, hashEntry2.key()))) {
                    hashEntry2 = hashEntry2.next;
                }
                if (hashEntry2 != null) {
                    objValue = hashEntry2.value();
                    if (!z) {
                        hashEntry2.setValue(obj2);
                    }
                } else {
                    this.modCount++;
                    hashEntryArr[length] = newHashEntry(obj, i, hashEntry, obj2);
                    this.count = i2;
                    objValue = null;
                }
                return objValue;
            } finally {
                unlock();
            }
        }

        Object readValueUnderLock(HashEntry hashEntry) {
            lock();
            try {
                return hashEntry.value();
            } finally {
                unlock();
            }
        }

        int rehash() {
            int i = 0;
            HashEntry[] hashEntryArr = this.table;
            int length = hashEntryArr.length;
            if (length >= ConcurrentHashMap.MAXIMUM_CAPACITY) {
                return 0;
            }
            HashEntry[] hashEntryArrNewArray = HashEntry.newArray(length << 1);
            this.threshold = (int) (hashEntryArrNewArray.length * this.loadFactor);
            int length2 = hashEntryArrNewArray.length - 1;
            for (HashEntry hashEntry : hashEntryArr) {
                if (hashEntry != null) {
                    HashEntry hashEntry2 = hashEntry.next;
                    int i2 = hashEntry.hash & length2;
                    if (hashEntry2 == null) {
                        hashEntryArrNewArray[i2] = hashEntry;
                    } else {
                        HashEntry hashEntry3 = hashEntry;
                        while (hashEntry2 != null) {
                            int i3 = hashEntry2.hash & length2;
                            if (i3 != i2) {
                                i2 = i3;
                                hashEntry3 = hashEntry2;
                            }
                            hashEntry2 = hashEntry2.next;
                        }
                        hashEntryArrNewArray[i2] = hashEntry3;
                        int i4 = i;
                        for (HashEntry hashEntry4 = hashEntry; hashEntry4 != hashEntry3; hashEntry4 = hashEntry4.next) {
                            Object objKey = hashEntry4.key();
                            if (objKey == null) {
                                i4++;
                            } else {
                                int i5 = hashEntry4.hash & length2;
                                hashEntryArrNewArray[i5] = newHashEntry(objKey, hashEntry4.hash, hashEntryArrNewArray[i5], hashEntry4.value());
                            }
                        }
                        i = i4;
                    }
                }
            }
            this.table = hashEntryArrNewArray;
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0069  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object remove(java.lang.Object r12, int r13, java.lang.Object r14, boolean r15) {
            /*
                r11 = this;
                r3 = 1
                r11.lock()
                int r0 = r11.count     // Catch: java.lang.Throwable -> L64
                int r0 = r0 - r3
                org.jboss.netty.util.internal.ConcurrentHashMap$HashEntry[] r1 = r11.table     // Catch: java.lang.Throwable -> L64
                int r2 = r1.length     // Catch: java.lang.Throwable -> L64
                int r2 = r2 - r3
                r2 = r2 & r13
                r3 = r1[r2]     // Catch: java.lang.Throwable -> L64
                r4 = r3
            Lf:
                if (r4 == 0) goto L28
                java.lang.Object r5 = r4.key     // Catch: java.lang.Throwable -> L64
                if (r12 == r5) goto L28
                if (r15 != 0) goto L25
                int r5 = r4.hash     // Catch: java.lang.Throwable -> L64
                if (r13 != r5) goto L25
                java.lang.Object r5 = r4.key()     // Catch: java.lang.Throwable -> L64
                boolean r5 = r11.keyEq(r12, r5)     // Catch: java.lang.Throwable -> L64
                if (r5 != 0) goto L28
            L25:
                org.jboss.netty.util.internal.ConcurrentHashMap$HashEntry r4 = r4.next     // Catch: java.lang.Throwable -> L64
                goto Lf
            L28:
                r5 = 0
                if (r4 == 0) goto L69
                java.lang.Object r6 = r4.value()     // Catch: java.lang.Throwable -> L64
                if (r14 == 0) goto L37
                boolean r7 = r14.equals(r6)     // Catch: java.lang.Throwable -> L64
                if (r7 == 0) goto L69
            L37:
                int r5 = r11.modCount     // Catch: java.lang.Throwable -> L64
                int r5 = r5 + 1
                r11.modCount = r5     // Catch: java.lang.Throwable -> L64
                org.jboss.netty.util.internal.ConcurrentHashMap$HashEntry r5 = r4.next     // Catch: java.lang.Throwable -> L64
                r10 = r3
                r3 = r5
                r5 = r0
                r0 = r10
            L43:
                if (r0 == r4) goto L5b
                java.lang.Object r7 = r0.key()     // Catch: java.lang.Throwable -> L64
                if (r7 != 0) goto L50
                int r5 = r5 + (-1)
            L4d:
                org.jboss.netty.util.internal.ConcurrentHashMap$HashEntry r0 = r0.next     // Catch: java.lang.Throwable -> L64
                goto L43
            L50:
                int r8 = r0.hash     // Catch: java.lang.Throwable -> L64
                java.lang.Object r9 = r0.value()     // Catch: java.lang.Throwable -> L64
                org.jboss.netty.util.internal.ConcurrentHashMap$HashEntry r3 = r11.newHashEntry(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L64
                goto L4d
            L5b:
                r1[r2] = r3     // Catch: java.lang.Throwable -> L64
                r11.count = r5     // Catch: java.lang.Throwable -> L64
                r0 = r6
            L60:
                r11.unlock()
                return r0
            L64:
                r0 = move-exception
                r11.unlock()
                throw r0
            L69:
                r0 = r5
                goto L60
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.ConcurrentHashMap.Segment.remove(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        Object replace(Object obj, int i, Object obj2) {
            Object obj3;
            lock();
            try {
                HashEntry first = getFirst(i);
                while (first != null && (first.hash != i || !keyEq(obj, first.key()))) {
                    first = first.next;
                }
                if (first != null) {
                    Object objValue = first.value();
                    first.setValue(obj2);
                    obj3 = objValue;
                } else {
                    obj3 = null;
                }
                return obj3;
            } finally {
                unlock();
            }
        }

        boolean replace(Object obj, int i, Object obj2, Object obj3) {
            lock();
            try {
                HashEntry first = getFirst(i);
                while (first != null && (first.hash != i || !keyEq(obj, first.key()))) {
                    first = first.next;
                }
                boolean z = false;
                if (first != null && obj2.equals(first.value())) {
                    z = true;
                    first.setValue(obj3);
                }
                return z;
            } finally {
                unlock();
            }
        }

        void setTable(HashEntry[] hashEntryArr) {
            this.threshold = (int) (hashEntryArr.length * this.loadFactor);
            this.table = hashEntryArr;
        }
    }

    class SimpleEntry implements Map.Entry {
        private final Object key;
        private Object value;

        public SimpleEntry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }

        public SimpleEntry(Map.Entry entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        /* renamed from: eq */
        private static boolean m4392eq(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return m4392eq(this.key, entry.getKey()) && m4392eq(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    final class ValueIterator extends HashIterator implements Enumeration, ReusableIterator {
        ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return super.nextEntry().value();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return super.nextEntry().value();
        }
    }

    final class Values extends AbstractCollection {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ConcurrentHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ConcurrentHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return ConcurrentHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return ConcurrentHashMap.this.new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ConcurrentHashMap.this.size();
        }
    }

    final class WriteThroughEntry extends SimpleEntry {
        WriteThroughEntry(Object obj, Object obj2) {
            super(obj, obj2);
        }

        @Override // org.jboss.netty.util.internal.ConcurrentHashMap.SimpleEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null) {
                throw new NullPointerException();
            }
            Object value = super.setValue(obj);
            ConcurrentHashMap.this.put(getKey(), obj);
            return value;
        }
    }

    public ConcurrentHashMap() {
        this(16, DEFAULT_LOAD_FACTOR, 16);
    }

    public ConcurrentHashMap(int i) {
        this(i, DEFAULT_LOAD_FACTOR, 16);
    }

    public ConcurrentHashMap(int i, float f) {
        this(i, f, 16);
    }

    public ConcurrentHashMap(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        int i3 = 1;
        int i4 = 0;
        while (i3 < (i2 > MAX_SEGMENTS ? MAX_SEGMENTS : i2)) {
            i4++;
            i3 <<= 1;
        }
        this.segmentShift = 32 - i4;
        this.segmentMask = i3 - 1;
        this.segments = Segment.newArray(i3);
        int i5 = i > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : i;
        int i6 = i5 / i3;
        int i7 = i3 * i6 < i5 ? i6 + 1 : i6;
        int i8 = 1;
        while (i8 < i7) {
            i8 <<= 1;
        }
        for (int i9 = 0; i9 < this.segments.length; i9++) {
            this.segments[i9] = new Segment(i8, f);
        }
    }

    public ConcurrentHashMap(Map map) {
        this(Math.max(((int) (map.size() / DEFAULT_LOAD_FACTOR)) + 1, 16), DEFAULT_LOAD_FACTOR, 16);
        putAll(map);
    }

    private static int hash(int i) {
        int i2 = ((i << 15) ^ (-12931)) + i;
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    private int hashOf(Object obj) {
        return hash(obj.hashCode());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (int i = 0; i < this.segments.length; i++) {
            this.segments[i].clear();
        }
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).containsKey(obj, iHashOf);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z;
        boolean z2;
        if (obj == null) {
            throw new NullPointerException();
        }
        Segment[] segmentArr = this.segments;
        int[] iArr = new int[segmentArr.length];
        for (int i = 0; i < 2; i++) {
            int i2 = 0;
            for (int i3 = 0; i3 < segmentArr.length; i3++) {
                int i4 = segmentArr[i3].modCount;
                iArr[i3] = i4;
                i2 += i4;
                if (segmentArr[i3].containsValue(obj)) {
                    return true;
                }
            }
            if (i2 != 0) {
                for (int i5 = 0; i5 < segmentArr.length; i5++) {
                    if (iArr[i5] != segmentArr[i5].modCount) {
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
        for (Segment segment : segmentArr) {
            segment.lock();
        }
        int i6 = 0;
        while (true) {
            try {
                if (i6 >= segmentArr.length) {
                    z = false;
                    break;
                }
                if (segmentArr[i6].containsValue(obj)) {
                    z = true;
                    break;
                }
                i6++;
            } finally {
                for (Segment segment2 : segmentArr) {
                    segment2.unlock();
                }
            }
        }
        return z;
    }

    public Enumeration elements() {
        return new ValueIterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).get(obj, iHashOf);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment[] segmentArr = this.segments;
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

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    public Enumeration keys() {
        return new KeyIterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj2 == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).put(obj, iHashOf, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        if (obj2 == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).put(obj, iHashOf, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).remove(obj, iHashOf, null, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        int iHashOf = hashOf(obj);
        return (obj2 == null || segmentFor(iHashOf).remove(obj, iHashOf, obj2, false) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        if (obj2 == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).replace(obj, iHashOf, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj2 == null || obj3 == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).replace(obj, iHashOf, obj2, obj3);
    }

    final Segment segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j;
        long j2;
        long j3;
        Segment[] segmentArr = this.segments;
        int[] iArr = new int[segmentArr.length];
        int i = 0;
        long j4 = 0;
        long j5 = 0;
        while (true) {
            if (i >= 2) {
                j = j4;
                j2 = j5;
                break;
            }
            int i2 = 0;
            j5 = 0;
            for (int i3 = 0; i3 < segmentArr.length; i3++) {
                j5 += segmentArr[i3].count;
                int i4 = segmentArr[i3].modCount;
                iArr[i3] = i4;
                i2 += i4;
            }
            if (i2 != 0) {
                int i5 = 0;
                long j6 = 0;
                while (true) {
                    if (i5 >= segmentArr.length) {
                        j4 = j6;
                        break;
                    }
                    j6 += segmentArr[i5].count;
                    if (iArr[i5] != segmentArr[i5].modCount) {
                        j4 = -1;
                        break;
                    }
                    i5++;
                }
            } else {
                j4 = 0;
            }
            if (j4 == j5) {
                j = j4;
                j2 = j5;
                break;
            }
            i++;
        }
        if (j != j2) {
            for (Segment segment : segmentArr) {
                segment.lock();
            }
            long j7 = 0;
            for (Segment segment2 : segmentArr) {
                j7 += segment2.count;
            }
            for (Segment segment3 : segmentArr) {
                segment3.unlock();
            }
            j3 = j7;
        } else {
            j3 = j2;
        }
        if (j3 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }
}
