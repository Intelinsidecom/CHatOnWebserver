package com.coolots.chaton.common.util;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class BitmapCache {
    private static final String CLASSNAME = "[BitmapCache]";
    private static Entry[] mCache;
    private boolean bRun = false;
    protected static Object mutex = new Object();
    private static BitmapCache mBC = new BitmapCache();
    private static int CurPos = 0;
    private static int size = 30;

    public static class Entry {
        Bitmap mBitmap;
        String mUrl;

        public Entry() {
            clear();
        }

        public boolean clear() {
            this.mUrl = "";
            this.mBitmap = null;
            return true;
        }
    }

    public void setBitmapCacheRunStatus(boolean bSetRun, boolean bClear) {
        if (bClear) {
            clear();
        }
        this.bRun = bSetRun;
    }

    private boolean getBitmapCacheRunStatus() {
        return this.bRun;
    }

    public static BitmapCache getInstance() {
        return mBC;
    }

    public BitmapCache() {
        mCache = new Entry[size];
        for (int i = 0; i < mCache.length; i++) {
            mCache[i] = new Entry();
        }
    }

    private Entry findEntry(String url) {
        for (Entry e : mCache) {
            if (url.equals(e.mUrl)) {
                return e;
            }
        }
        return null;
    }

    public Bitmap getBitmap(String Url) {
        Bitmap bitmap = null;
        if (getBitmapCacheRunStatus()) {
            synchronized (mutex) {
                Entry e = findEntry(Url);
                if (e != null) {
                    bitmap = e.mBitmap;
                }
            }
        }
        return bitmap;
    }

    public void put(String Url, Bitmap bitmap) {
        if (getBitmapCacheRunStatus()) {
            synchronized (mutex) {
                if (bitmap != null && Url != null) {
                    if (findEntry(Url) == null) {
                        Entry best = null;
                        int pos = -1;
                        int i = 0;
                        while (true) {
                            if (i >= mCache.length) {
                                break;
                            }
                            Entry e = mCache[i];
                            if (!e.mUrl.equals("")) {
                                i++;
                            } else {
                                best = e;
                                CurPos = i;
                                pos = i;
                                break;
                            }
                        }
                        if (pos == -1) {
                            int pos2 = (CurPos + 1) % mCache.length;
                            best = mCache[pos2];
                            CurPos = pos2;
                            best.clear();
                        }
                        if (best.mBitmap != null) {
                            best.mBitmap.recycle();
                        }
                        best.mUrl = Url;
                        best.mBitmap = Bitmap.createBitmap(bitmap);
                    }
                }
            }
        }
    }

    public void clear() {
        synchronized (mutex) {
            for (Entry e : mCache) {
                if (e.mBitmap != null) {
                    e.mBitmap.recycle();
                }
                e.clear();
            }
        }
    }

    public synchronized boolean hasBitmap(String Url) {
        Entry e;
        e = findEntry(Url);
        return e != null;
    }

    public synchronized boolean remove(String Url) {
        boolean z = true;
        synchronized (this) {
            synchronized (mutex) {
                Entry e = findEntry(Url);
                if (e != null) {
                    if (!e.clear()) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
    
        r7.recycle();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void recycle(android.graphics.Bitmap r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.coolots.chaton.common.util.BitmapCache$Entry[] r2 = com.coolots.chaton.common.util.BitmapCache.mCache     // Catch: java.lang.Throwable -> L1f
            int r3 = r2.length     // Catch: java.lang.Throwable -> L1f
            r1 = 0
        L5:
            if (r1 < r3) goto Lc
            r7.recycle()     // Catch: java.lang.Throwable -> L1f
        La:
            monitor-exit(r6)
            return
        Lc:
            r0 = r2[r1]     // Catch: java.lang.Throwable -> L1f
            java.lang.String r4 = r0.mUrl     // Catch: java.lang.Throwable -> L1f
            java.lang.String r5 = ""
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L1f
            if (r4 != 0) goto L1c
            android.graphics.Bitmap r4 = r0.mBitmap     // Catch: java.lang.Throwable -> L1f
            if (r4 == r7) goto La
        L1c:
            int r1 = r1 + 1
            goto L5
        L1f:
            r1 = move-exception
            monitor-exit(r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.common.util.BitmapCache.recycle(android.graphics.Bitmap):void");
    }
}
