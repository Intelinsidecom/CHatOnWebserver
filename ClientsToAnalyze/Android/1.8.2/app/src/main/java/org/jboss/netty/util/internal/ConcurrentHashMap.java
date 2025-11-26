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

    private static int hash(int i) {
        int i2 = ((i << 15) ^ (-12931)) + i;
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    final Segment segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    private int hashOf(Object obj) {
        return hash(obj.hashCode());
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

        final Object key() {
            return this.key;
        }

        final Object value() {
            return this.value;
        }

        final void setValue(Object obj) {
            this.value = obj;
        }

        static final HashEntry[] newArray(int i) {
            return new HashEntry[i];
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

        static final Segment[] newArray(int i) {
            return new Segment[i];
        }

        private boolean keyEq(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        void setTable(HashEntry[] hashEntryArr) {
            this.threshold = (int) (hashEntryArr.length * this.loadFactor);
            this.table = hashEntryArr;
        }

        HashEntry getFirst(int i) {
            return this.table[(r0.length - 1) & i];
        }

        HashEntry newHashEntry(Object obj, int i, HashEntry hashEntry, Object obj2) {
            return new HashEntry(obj, i, hashEntry, obj2);
        }

        Object readValueUnderLock(HashEntry hashEntry) {
            lock();
            try {
                return hashEntry.value();
            } finally {
                unlock();
            }
        }

        Object get(Object obj, int i) {
            if (this.count != 0) {
                for (HashEntry first = getFirst(i); first != null; first = first.next) {
                    if (first.hash == i && keyEq(obj, first.key())) {
                        Object objValue = first.value();
                        if (objValue == null) {
                            return readValueUnderLock(first);
                        }
                        return objValue;
                    }
                }
            }
            return null;
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

        Object replace(Object obj, int i, Object obj2) {
            lock();
            try {
                HashEntry first = getFirst(i);
                while (first != null && (first.hash != i || !keyEq(obj, first.key()))) {
                    first = first.next;
                }
                Object objValue = null;
                if (first != null) {
                    objValue = first.value();
                    first.setValue(obj2);
                }
                return objValue;
            } finally {
                unlock();
            }
        }

        Object put(Object obj, int i, Object obj2, boolean z) {
            Object objValue;
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
                HashEntry[] hashEntryArr = this.table;
                int length = i & (hashEntryArr.length - 1);
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
                    objValue = null;
                    this.modCount++;
                    hashEntryArr[length] = newHashEntry(obj, i, hashEntry, obj2);
                    this.count = i4;
                }
                return objValue;
            } finally {
                unlock();
            }
        }

        int rehash() {
            int i;
            HashEntry hashEntry;
            int i2 = 0;
            HashEntry[] hashEntryArr = this.table;
            int length = hashEntryArr.length;
            if (length < ConcurrentHashMap.MAXIMUM_CAPACITY) {
                HashEntry[] hashEntryArrNewArray = HashEntry.newArray(length << 1);
                this.threshold = (int) (hashEntryArrNewArray.length * this.loadFactor);
                int length2 = hashEntryArrNewArray.length - 1;
                int i3 = 0;
                while (i3 < length) {
                    HashEntry hashEntry2 = hashEntryArr[i3];
                    if (hashEntry2 != null) {
                        HashEntry hashEntry3 = hashEntry2.next;
                        int i4 = hashEntry2.hash & length2;
                        if (hashEntry3 == null) {
                            hashEntryArrNewArray[i4] = hashEntry2;
                            i = i2;
                        } else {
                            HashEntry hashEntry4 = hashEntry2;
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
                            for (HashEntry hashEntry5 = hashEntry2; hashEntry5 != hashEntry4; hashEntry5 = hashEntry5.next) {
                                Object objKey = hashEntry5.key();
                                if (objKey == null) {
                                    i++;
                                } else {
                                    int i6 = hashEntry5.hash & length2;
                                    hashEntryArrNewArray[i6] = newHashEntry(objKey, hashEntry5.hash, hashEntryArrNewArray[i6], hashEntry5.value());
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

        Object remove(Object obj, int i, Object obj2, boolean z) {
            lock();
            try {
                int i2 = this.count - 1;
                HashEntry[] hashEntryArr = this.table;
                int length = i & (hashEntryArr.length - 1);
                HashEntry hashEntry = hashEntryArr[length];
                HashEntry hashEntry2 = hashEntry;
                while (hashEntry2 != null && obj != hashEntry2.key && (z || i != hashEntry2.hash || !keyEq(obj, hashEntry2.key()))) {
                    hashEntry2 = hashEntry2.next;
                }
                Object obj3 = null;
                if (hashEntry2 != null) {
                    Object objValue = hashEntry2.value();
                    if (obj2 == null || obj2.equals(objValue)) {
                        this.modCount++;
                        HashEntry hashEntryNewHashEntry = hashEntry2.next;
                        int i3 = i2;
                        for (HashEntry hashEntry3 = hashEntry; hashEntry3 != hashEntry2; hashEntry3 = hashEntry3.next) {
                            Object objKey = hashEntry3.key();
                            if (objKey == null) {
                                i3--;
                            } else {
                                hashEntryNewHashEntry = newHashEntry(objKey, hashEntry3.hash, hashEntryNewHashEntry, hashEntry3.value());
                            }
                        }
                        hashEntryArr[length] = hashEntryNewHashEntry;
                        this.count = i3;
                        obj3 = objValue;
                    }
                }
                return obj3;
            } finally {
                unlock();
            }
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
    }

    public ConcurrentHashMap(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        int i3 = 1;
        int i4 = 0;
        while (i3 < (i2 > MAX_SEGMENTS ? MAX_SEGMENTS : i2)) {
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
            this.segments[i7] = new Segment(i6, f);
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

    public ConcurrentHashMap(Map map) {
        this(Math.max(((int) (map.size() / DEFAULT_LOAD_FACTOR)) + 1, 16), DEFAULT_LOAD_FACTOR, 16);
        putAll(map);
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
            org.jboss.netty.util.internal.ConcurrentHashMap$Segment[] r7 = r15.segments
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
    public Object get(Object obj) {
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
        Segment[] segmentArr = this.segments;
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
        for (Segment segment : segmentArr) {
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
    public Object put(Object obj, Object obj2) {
        if (obj2 == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).put(obj, iHashOf, obj2, false);
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
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
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
    public boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj2 == null || obj3 == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).replace(obj, iHashOf, obj2, obj3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        if (obj2 == null) {
            throw new NullPointerException();
        }
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).replace(obj, iHashOf, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (int i = 0; i < this.segments.length; i++) {
            this.segments[i].clear();
        }
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

    public Enumeration keys() {
        return new KeyIterator();
    }

    public Enumeration elements() {
        return new ValueIterator();
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

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return m7538eq(this.key, entry.getKey()) && m7538eq(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        /* renamed from: eq */
        private static boolean m7538eq(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
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

    final class KeySet extends AbstractSet {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return ConcurrentHashMap.this.new KeyIterator();
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

    final class Values extends AbstractCollection {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return ConcurrentHashMap.this.new ValueIterator();
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

    final class EntrySet extends AbstractSet {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return ConcurrentHashMap.this.new EntryIterator();
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
