package android.support.v4.util;

/* loaded from: classes.dex */
public class LruCache {

    /* renamed from: a */
    private int f138a;

    /* renamed from: b */
    private int f139b;

    /* renamed from: c */
    private int f140c;

    public final synchronized String toString() {
        int i;
        i = this.f139b + this.f140c;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f138a), Integer.valueOf(this.f139b), Integer.valueOf(this.f140c), Integer.valueOf(i != 0 ? (this.f139b * 100) / i : 0));
    }
}
