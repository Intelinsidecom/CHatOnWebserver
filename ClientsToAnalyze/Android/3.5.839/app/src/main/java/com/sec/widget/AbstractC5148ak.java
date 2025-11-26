package com.sec.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import java.text.Collator;
import java.util.ArrayList;

/* compiled from: TwAbstractIndexer.java */
/* renamed from: com.sec.widget.ak */
/* loaded from: classes.dex */
public abstract class AbstractC5148ak extends DataSetObserver {

    /* renamed from: a */
    protected CharSequence f18844a;

    /* renamed from: b */
    protected CharSequence f18845b;

    /* renamed from: c */
    protected int f18846c;

    /* renamed from: d */
    protected int f18847d;

    /* renamed from: e */
    protected SparseIntArray f18848e;

    /* renamed from: f */
    protected Collator f18849f;

    /* renamed from: g */
    protected String[] f18850g;

    /* renamed from: h */
    private final DataSetObservable f18851h;

    /* renamed from: a */
    protected abstract String m19714a(int i);

    /* renamed from: d */
    protected abstract int m19722d();

    /* renamed from: e */
    protected abstract boolean m19723e();

    /* renamed from: a */
    String[] m19717a() {
        return this.f18850g;
    }

    /* renamed from: a */
    protected int m19712a(String str, String str2) {
        return this.f18849f.compare(str, str2);
    }

    /* renamed from: a */
    public ArrayList<C5149al> m19715a(String str, boolean z) {
        boolean z2;
        C5150am c5150amM19713a;
        C5150am c5150amM19713a2;
        int i;
        boolean z3;
        if (!m19723e()) {
            return null;
        }
        int iM19722d = m19722d();
        if (iM19722d == 0) {
            Log.v("TwAbstractIndexer", "getIndexInfo() return null: mData.size() ==" + iM19722d);
            return null;
        }
        if (str == null) {
            str = "";
        }
        ArrayList<C5149al> arrayList = new ArrayList<>();
        m19718b();
        for (int i2 = 1; i2 < this.f18846c; i2++) {
            String str2 = str + this.f18844a.charAt(i2);
            if (m19712a(str2, "A") < 0 || m19712a(str2, "Z") > 0) {
                z2 = false;
                break;
            }
        }
        z2 = true;
        for (int i3 = 0; i3 < this.f18846c; i3++) {
            String str3 = str + this.f18844a.charAt(i3);
            if (z2) {
                c5150amM19713a = m19713a(str3);
            } else if (m19712a(str3, "A") == 0) {
                c5150amM19713a2 = null;
                for (int i4 = 0; i4 < this.f18847d; i4++) {
                    c5150amM19713a2 = m19713a(Character.toString(this.f18845b.charAt(i4)));
                    if (c5150amM19713a2.f18856b) {
                        c5150amM19713a = c5150amM19713a2;
                        break;
                    }
                }
                c5150amM19713a = c5150amM19713a2;
            } else if (m19712a(str3, "Z") == 0) {
                c5150amM19713a2 = null;
                for (int i5 = this.f18847d - 1; i5 > 0; i5--) {
                    c5150amM19713a2 = m19713a(Character.toString(this.f18845b.charAt(i5)));
                    if (c5150amM19713a2.f18856b) {
                        c5150amM19713a = c5150amM19713a2;
                        break;
                    }
                }
                c5150amM19713a = c5150amM19713a2;
            } else {
                c5150amM19713a = m19713a(str3);
            }
            if (c5150amM19713a != null) {
                i = c5150amM19713a.f18855a;
                z3 = c5150amM19713a.f18856b;
            } else {
                i = -1;
                z3 = false;
            }
            if (i < 0) {
                i = -i;
            }
            if (!z || z3) {
                C5149al c5149al = new C5149al();
                c5149al.f18853b = z3;
                if (z3) {
                    c5149al.f18854c = i;
                } else {
                    c5149al.f18854c = -1;
                }
                c5149al.f18852a = this.f18850g[i3];
                arrayList.add(c5149al);
            }
        }
        m19721c();
        return arrayList;
    }

    /* renamed from: a */
    C5150am m19713a(String str) {
        int iAbs;
        int i;
        int i2;
        int i3;
        String strM19714a;
        int i4;
        boolean zM19720b = false;
        SparseIntArray sparseIntArray = this.f18848e;
        int iM19722d = m19722d();
        if (iM19722d == 0 || this.f18844a == null) {
            return new C5150am(iM19722d);
        }
        if (str == null || str.length() == 0) {
            return new C5150am(iM19722d);
        }
        char cCharAt = str.charAt(0);
        int i5 = sparseIntArray.get(cCharAt, Integer.MIN_VALUE);
        if (Integer.MIN_VALUE != i5) {
            iAbs = Math.abs(i5);
            i = iM19722d;
        } else {
            int iIndexOf = this.f18844a.toString().indexOf(cCharAt);
            int iAbs2 = (iIndexOf <= 0 || cCharAt <= this.f18844a.charAt(iIndexOf + (-1)) || (i3 = sparseIntArray.get(this.f18844a.charAt(iIndexOf + (-1)), Integer.MIN_VALUE)) == Integer.MIN_VALUE) ? 0 : Math.abs(i3);
            if (iIndexOf >= this.f18844a.length() - 1 || cCharAt >= this.f18844a.charAt(iIndexOf + 1) || (i2 = sparseIntArray.get(this.f18844a.charAt(iIndexOf + 1), Integer.MIN_VALUE)) == Integer.MIN_VALUE) {
                iAbs = iAbs2;
                i = iM19722d;
            } else {
                int iAbs3 = Math.abs(i2);
                iAbs = iAbs2;
                i = iAbs3;
            }
        }
        int i6 = iAbs;
        int i7 = (i + iAbs) / 2;
        while (true) {
            if (i7 >= i) {
                break;
            }
            String strM19714a2 = m19714a(i7);
            if (TextUtils.isEmpty(strM19714a2)) {
                if (i7 == 0) {
                    break;
                }
                i7--;
            } else {
                int iM19712a = m19712a(strM19714a2, str);
                if (iM19712a == 0) {
                    break;
                }
                if (iM19712a < 0) {
                    i4 = i7 + 1;
                    if (i4 >= iM19722d) {
                        i7 = iM19722d;
                        break;
                    }
                } else {
                    i = i7;
                    i4 = i6;
                }
                i6 = i4;
                i7 = (i4 + i) / 2;
            }
        }
        if (str.length() == 1) {
            sparseIntArray.put(cCharAt, i7);
        }
        if (i7 < iM19722d && (strM19714a = m19714a(i7)) != null) {
            zM19720b = m19720b(strM19714a, str);
        }
        return new C5150am(i7, zM19720b);
    }

    /* renamed from: b */
    protected boolean m19720b(String str, String str2) {
        if (str.length() > str2.length()) {
            str = str.substring(0, str2.length());
        }
        return m19712a(str, str2) == 0;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f18848e.clear();
        this.f18851h.notifyChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f18848e.clear();
        this.f18851h.notifyInvalidated();
    }

    /* renamed from: a */
    public void m19716a(DataSetObserver dataSetObserver) {
        this.f18851h.registerObserver(dataSetObserver);
    }

    /* renamed from: b */
    public void m19719b(DataSetObserver dataSetObserver) {
        this.f18851h.unregisterObserver(dataSetObserver);
    }

    /* renamed from: b */
    protected void m19718b() {
        Log.v("TwAbstractIndexer", "TwAbstractIndexer.onBeginTransaction is now being called !! ");
    }

    /* renamed from: c */
    protected void m19721c() {
        Log.v("TwAbstractIndexer", "TwAbstractIndexer.onEndTransaction  is now being called !! ");
    }
}
