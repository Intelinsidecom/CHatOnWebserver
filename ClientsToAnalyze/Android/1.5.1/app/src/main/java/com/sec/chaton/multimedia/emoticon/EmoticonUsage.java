package com.sec.chaton.multimedia.emoticon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class EmoticonUsage implements Serializable {

    /* renamed from: a */
    ArrayList f2125a;

    public class EmoticonUsageItem implements Serializable, Comparable {

        /* renamed from: a */
        public String f2126a;

        /* renamed from: b */
        public int f2127b;

        /* renamed from: c */
        public long f2128c;

        public EmoticonUsageItem(String str, int i, long j) {
            this.f2126a = str;
            this.f2127b = i;
            this.f2128c = j;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(EmoticonUsageItem emoticonUsageItem) {
            if (this.f2128c > emoticonUsageItem.f2128c) {
                return -1;
            }
            return this.f2128c < emoticonUsageItem.f2128c ? 1 : 0;
        }
    }

    public EmoticonUsage() {
        this.f2125a = new ArrayList(RichString.m2523a());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= RichString.m2523a()) {
                return;
            }
            this.f2125a.add(new EmoticonUsageItem(RichString.m2525a(i2), RichString.m2527b(i2), 0L));
            i = i2 + 1;
        }
    }

    public EmoticonUsage(int i) {
        this.f2125a = new ArrayList(1);
    }

    /* renamed from: a */
    public ArrayList m2511a() {
        return this.f2125a;
    }

    /* renamed from: a */
    public void m2512a(String str, int i, int i2) {
        boolean z;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f2125a.size()) {
                z = false;
                break;
            } else {
                if (((EmoticonUsageItem) this.f2125a.get(i3)).f2126a.equals(str)) {
                    ((EmoticonUsageItem) this.f2125a.get(i3)).f2128c = System.currentTimeMillis();
                    z = true;
                    break;
                }
                i3++;
            }
        }
        if (z) {
            return;
        }
        this.f2125a.add(new EmoticonUsageItem(str, i, System.currentTimeMillis()));
    }

    /* renamed from: b */
    public void m2513b() {
        if (this.f2125a != null) {
            Iterator it = this.f2125a.iterator();
            while (it.hasNext()) {
                EmoticonUsageItem emoticonUsageItem = (EmoticonUsageItem) it.next();
                int iIntValue = RichString.m2524a(emoticonUsageItem.f2126a).intValue();
                if (iIntValue != 0) {
                    emoticonUsageItem.f2127b = iIntValue;
                }
            }
        }
    }
}
