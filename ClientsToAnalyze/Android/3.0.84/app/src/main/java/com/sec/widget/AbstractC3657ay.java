package com.sec.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.Log;
import android.util.SparseIntArray;
import java.text.Collator;
import java.util.ArrayList;

/* compiled from: TwAbstractIndexer.java */
/* renamed from: com.sec.widget.ay */
/* loaded from: classes.dex */
public abstract class AbstractC3657ay extends DataSetObserver {

    /* renamed from: a */
    protected CharSequence f13540a;

    /* renamed from: b */
    protected CharSequence f13541b;

    /* renamed from: c */
    protected int f13542c;

    /* renamed from: d */
    protected int f13543d;

    /* renamed from: e */
    protected SparseIntArray f13544e;

    /* renamed from: f */
    protected Collator f13545f;

    /* renamed from: g */
    protected String[] f13546g;

    /* renamed from: h */
    private final DataSetObservable f13547h;

    /* renamed from: a */
    protected abstract String m13227a(int i);

    /* renamed from: d */
    protected abstract int m13235d();

    /* renamed from: e */
    protected abstract boolean m13236e();

    /* renamed from: a */
    String[] m13230a() {
        return this.f13546g;
    }

    /* renamed from: a */
    protected int m13225a(String str, String str2) {
        return this.f13545f.compare(str, str2);
    }

    /* renamed from: a */
    public ArrayList<C3658az> m13228a(String str, boolean z) {
        boolean z2;
        C3660ba c3660baM13226a;
        C3660ba c3660baM13226a2;
        int i;
        boolean z3;
        if (!m13236e()) {
            return null;
        }
        int iM13235d = m13235d();
        if (iM13235d == 0) {
            Log.v("TwAbstractIndexer", "getIndexInfo() return null: mData.size() ==" + iM13235d);
            return null;
        }
        if (str == null) {
            str = "";
        }
        ArrayList<C3658az> arrayList = new ArrayList<>();
        m13231b();
        for (int i2 = 1; i2 < this.f13542c; i2++) {
            String str2 = str + this.f13540a.charAt(i2);
            if (m13225a(str2, "A") < 0 || m13225a(str2, "Z") > 0) {
                z2 = false;
                break;
            }
        }
        z2 = true;
        for (int i3 = 0; i3 < this.f13542c; i3++) {
            String str3 = str + this.f13540a.charAt(i3);
            if (z2) {
                c3660baM13226a = m13226a(str3);
            } else if (m13225a(str3, "A") == 0) {
                c3660baM13226a2 = null;
                for (int i4 = 0; i4 < this.f13543d; i4++) {
                    c3660baM13226a2 = m13226a(Character.toString(this.f13541b.charAt(i4)));
                    if (c3660baM13226a2.f13552b) {
                        c3660baM13226a = c3660baM13226a2;
                        break;
                    }
                }
                c3660baM13226a = c3660baM13226a2;
            } else if (m13225a(str3, "Z") == 0) {
                c3660baM13226a2 = null;
                for (int i5 = this.f13543d - 1; i5 > 0; i5--) {
                    c3660baM13226a2 = m13226a(Character.toString(this.f13541b.charAt(i5)));
                    if (c3660baM13226a2.f13552b) {
                        c3660baM13226a = c3660baM13226a2;
                        break;
                    }
                }
                c3660baM13226a = c3660baM13226a2;
            } else {
                c3660baM13226a = m13226a(str3);
            }
            if (c3660baM13226a != null) {
                i = c3660baM13226a.f13551a;
                z3 = c3660baM13226a.f13552b;
            } else {
                i = -1;
                z3 = false;
            }
            if (i < 0) {
                i = -i;
            }
            if (!z || z3) {
                C3658az c3658az = new C3658az();
                c3658az.f13549b = z3;
                if (z3) {
                    c3658az.f13550c = i;
                } else {
                    c3658az.f13550c = -1;
                }
                c3658az.f13548a = this.f13546g[i3];
                arrayList.add(c3658az);
            }
        }
        m13234c();
        return arrayList;
    }

    /* renamed from: a */
    C3660ba m13226a(String str) {
        int iAbs;
        int i;
        int i2;
        int i3;
        String strM13227a;
        int i4;
        boolean zM13233b = false;
        SparseIntArray sparseIntArray = this.f13544e;
        int iM13235d = m13235d();
        if (iM13235d == 0 || this.f13540a == null) {
            return new C3660ba(iM13235d);
        }
        if (str == null || str.length() == 0) {
            return new C3660ba(iM13235d);
        }
        char cCharAt = str.charAt(0);
        int i5 = sparseIntArray.get(cCharAt, Integer.MIN_VALUE);
        if (Integer.MIN_VALUE != i5) {
            iAbs = Math.abs(i5);
            i = iM13235d;
        } else {
            int iIndexOf = this.f13540a.toString().indexOf(cCharAt);
            int iAbs2 = (iIndexOf <= 0 || cCharAt <= this.f13540a.charAt(iIndexOf + (-1)) || (i3 = sparseIntArray.get(this.f13540a.charAt(iIndexOf + (-1)), Integer.MIN_VALUE)) == Integer.MIN_VALUE) ? 0 : Math.abs(i3);
            if (iIndexOf >= this.f13540a.length() - 1 || cCharAt >= this.f13540a.charAt(iIndexOf + 1) || (i2 = sparseIntArray.get(this.f13540a.charAt(iIndexOf + 1), Integer.MIN_VALUE)) == Integer.MIN_VALUE) {
                iAbs = iAbs2;
                i = iM13235d;
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
            String strM13227a2 = m13227a(i7);
            if (strM13227a2 == null || strM13227a2 == "") {
                if (i7 == 0) {
                    break;
                }
                i7--;
            } else {
                int iM13225a = m13225a(strM13227a2, str);
                if (iM13225a == 0) {
                    break;
                }
                if (iM13225a < 0) {
                    i4 = i7 + 1;
                    if (i4 >= iM13235d) {
                        i7 = iM13235d;
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
        if (i7 < iM13235d && (strM13227a = m13227a(i7)) != null) {
            zM13233b = m13233b(strM13227a, str);
        }
        return new C3660ba(i7, zM13233b);
    }

    /* renamed from: b */
    protected boolean m13233b(String str, String str2) {
        if (str.length() > str2.length()) {
            str = str.substring(0, str2.length());
        }
        return m13225a(str, str2) == 0;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f13544e.clear();
        this.f13547h.notifyChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f13544e.clear();
        this.f13547h.notifyInvalidated();
    }

    /* renamed from: a */
    public void m13229a(DataSetObserver dataSetObserver) {
        this.f13547h.registerObserver(dataSetObserver);
    }

    /* renamed from: b */
    public void m13232b(DataSetObserver dataSetObserver) {
        this.f13547h.unregisterObserver(dataSetObserver);
    }

    /* renamed from: b */
    protected void m13231b() {
        Log.v("TwAbstractIndexer", "TwAbstractIndexer.onBeginTransaction is now being called !! ");
    }

    /* renamed from: c */
    protected void m13234c() {
        Log.v("TwAbstractIndexer", "TwAbstractIndexer.onEndTransaction  is now being called !! ");
    }
}
