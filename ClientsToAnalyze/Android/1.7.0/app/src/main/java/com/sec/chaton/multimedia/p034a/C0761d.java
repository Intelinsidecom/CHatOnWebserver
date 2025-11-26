package com.sec.chaton.multimedia.p034a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: EmoticonUsage.java */
/* renamed from: com.sec.chaton.multimedia.a.d */
/* loaded from: classes.dex */
public class C0761d implements Serializable {

    /* renamed from: a */
    ArrayList f2594a;

    public C0761d() {
        this.f2594a = new ArrayList(C0760c.m3192a());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < C0760c.m3192a()) {
                this.f2594a.add(new C0762e(this, C0760c.m3193a(i2), C0760c.m3196b(i2), 0L));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public C0761d(int i) {
        this.f2594a = new ArrayList(1);
    }

    /* renamed from: a */
    public ArrayList m3203a() {
        return this.f2594a;
    }

    /* renamed from: b */
    public void m3205b() {
        if (this.f2594a != null) {
            Iterator it = this.f2594a.iterator();
            while (it.hasNext()) {
                C0762e c0762e = (C0762e) it.next();
                int iIntValue = C0760c.m3197b(c0762e.f2595a).intValue();
                if (iIntValue != 0) {
                    c0762e.f2596b = iIntValue;
                }
            }
        }
    }

    /* renamed from: a */
    public void m3204a(String str, int i, int i2) {
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f2594a.size()) {
                break;
            }
            if (!((C0762e) this.f2594a.get(i3)).f2595a.equals(str)) {
                i3++;
            } else {
                z = true;
                ((C0762e) this.f2594a.get(i3)).f2597c = System.currentTimeMillis();
                break;
            }
        }
        if (!z) {
            this.f2594a.add(new C0762e(this, str, i, System.currentTimeMillis()));
        }
    }
}
