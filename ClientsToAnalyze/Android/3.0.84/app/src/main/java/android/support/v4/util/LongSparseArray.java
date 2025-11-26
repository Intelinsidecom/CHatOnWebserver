package android.support.v4.util;

/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.mGarbage = false;
        int iIdealLongArraySize = idealLongArraySize(i);
        this.mKeys = new long[iIdealLongArraySize];
        this.mValues = new Object[iIdealLongArraySize];
        this.mSize = 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m13385clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.mKeys = (long[]) this.mKeys.clone();
                longSparseArray.mValues = (Object[]) this.mValues.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E get(long j) {
        return get(j, null);
    }

    public E get(long j, E e) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, j);
        return (iBinarySearch < 0 || this.mValues[iBinarySearch] == DELETED) ? e : (E) this.mValues[iBinarySearch];
    }

    public void delete(long j) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, j);
        if (iBinarySearch >= 0 && this.mValues[iBinarySearch] != DELETED) {
            this.mValues[iBinarySearch] = DELETED;
            this.mGarbage = true;
        }
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    /* renamed from: gc */
    private void m25gc() {
        int i = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void put(long j, E e) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, j);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = e;
            return;
        }
        int iBinarySearch2 = iBinarySearch ^ (-1);
        if (iBinarySearch2 < this.mSize && this.mValues[iBinarySearch2] == DELETED) {
            this.mKeys[iBinarySearch2] = j;
            this.mValues[iBinarySearch2] = e;
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m25gc();
            iBinarySearch2 = binarySearch(this.mKeys, 0, this.mSize, j) ^ (-1);
        }
        if (this.mSize >= this.mKeys.length) {
            int iIdealLongArraySize = idealLongArraySize(this.mSize + 1);
            long[] jArr = new long[iIdealLongArraySize];
            Object[] objArr = new Object[iIdealLongArraySize];
            System.arraycopy(this.mKeys, 0, jArr, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        if (this.mSize - iBinarySearch2 != 0) {
            System.arraycopy(this.mKeys, iBinarySearch2, this.mKeys, iBinarySearch2 + 1, this.mSize - iBinarySearch2);
            System.arraycopy(this.mValues, iBinarySearch2, this.mValues, iBinarySearch2 + 1, this.mSize - iBinarySearch2);
        }
        this.mKeys[iBinarySearch2] = j;
        this.mValues[iBinarySearch2] = e;
        this.mSize++;
    }

    public int size() {
        if (this.mGarbage) {
            m25gc();
        }
        return this.mSize;
    }

    public long keyAt(int i) {
        if (this.mGarbage) {
            m25gc();
        }
        return this.mKeys[i];
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            m25gc();
        }
        return (E) this.mValues[i];
    }

    public void setValueAt(int i, E e) {
        if (this.mGarbage) {
            m25gc();
        }
        this.mValues[i] = e;
    }

    public int indexOfKey(long j) {
        if (this.mGarbage) {
            m25gc();
        }
        return binarySearch(this.mKeys, 0, this.mSize, j);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            m25gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(long j, E e) {
        if (this.mSize != 0 && j <= this.mKeys[this.mSize - 1]) {
            put(j, e);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m25gc();
        }
        int i = this.mSize;
        if (i >= this.mKeys.length) {
            int iIdealLongArraySize = idealLongArraySize(i + 1);
            long[] jArr = new long[iIdealLongArraySize];
            Object[] objArr = new Object[iIdealLongArraySize];
            System.arraycopy(this.mKeys, 0, jArr, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        this.mKeys[i] = j;
        this.mValues[i] = e;
        this.mSize = i + 1;
    }

    private static int binarySearch(long[] jArr, int i, int i2, long j) {
        int i3 = i - 1;
        int i4 = i + i2;
        while (i4 - i3 > 1) {
            int i5 = (i4 + i3) / 2;
            if (jArr[i5] < j) {
                i3 = i5;
            } else {
                i4 = i5;
            }
        }
        if (i4 == i + i2) {
            return (i + i2) ^ (-1);
        }
        return jArr[i4] != j ? i4 ^ (-1) : i4;
    }

    public static int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    public static int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }
}
