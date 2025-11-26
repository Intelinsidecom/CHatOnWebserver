package com.sec.widget;

import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.at */
/* loaded from: classes.dex */
class C5157at {

    /* renamed from: a */
    final /* synthetic */ TwIndexScrollView f18870a;

    /* renamed from: b */
    private int f18871b;

    /* renamed from: d */
    private Rect f18873d;

    /* renamed from: e */
    private String f18874e;

    /* renamed from: f */
    private ArrayList<C5149al> f18875f;

    /* renamed from: g */
    private int f18876g;

    /* renamed from: h */
    private int f18877h;

    /* renamed from: j */
    private int f18879j;

    /* renamed from: l */
    private float f18881l;

    /* renamed from: m */
    private float f18882m;

    /* renamed from: c */
    private float f18872c = 1.0f;

    /* renamed from: i */
    private int f18878i = 0;

    /* renamed from: k */
    private int f18880k = 1;

    /* renamed from: a */
    public int m19732a() {
        return this.f18879j;
    }

    public C5157at(TwIndexScrollView twIndexScrollView, String str, ArrayList<C5149al> arrayList, float f, int i, Rect rect, int i2) {
        this.f18870a = twIndexScrollView;
        this.f18877h = -1;
        this.f18871b = i2;
        this.f18877h = 0;
        if (arrayList == null || arrayList.size() == 0 || i < 1) {
            throw new IllegalArgumentException("NDepthScroll( " + str + ", ," + f + "," + i + "," + rect);
        }
        this.f18874e = str == null ? "" : str;
        this.f18875f = arrayList;
        this.f18876g = i;
        f = f < 0.0f ? 0.0f : f;
        this.f18881l = f;
        this.f18882m = f;
        this.f18882m -= (int) twIndexScrollView.getResources().getDimension(R.dimen.tw_indexview_second_handle_toppading);
        this.f18879j = this.f18875f.size() + 1;
        this.f18873d = new Rect();
        this.f18873d.top = rect.top;
        this.f18873d.bottom = rect.bottom;
        this.f18873d.right = rect.right;
        this.f18873d.left = rect.left;
    }

    /* renamed from: h */
    private void m19731h() {
        int i;
        Rect rect = new Rect();
        int size = this.f18875f.size();
        int size2 = this.f18875f.size() + 1;
        this.f18875f.size();
        float f = this.f18876g;
        Paint.FontMetrics fontMetrics = this.f18870a.f18813i.getFontMetrics();
        if (this.f18878i != 0) {
            for (int i2 = 1; i2 <= size; i2++) {
                int size3 = this.f18875f.size();
                for (int i3 = size + 1; i3 > 2; i3--) {
                    int i4 = (i3 - 1) * (size3 / ((i3 + i2) - 1));
                    int i5 = size3 % ((i3 + i2) - 1);
                    if (i5 != 0) {
                        if (i3 - 1 < i5) {
                            i5 = i3;
                        }
                        i = i5 + i4;
                    } else {
                        i = i4;
                    }
                    float f2 = size3 / ((i3 - 1) + i2);
                    rect.bottom = (int) ((i * f) + (this.f18872c * f2 * f));
                    if (this.f18875f.size() % ((i3 - 1) + i2) >= i3 - 1) {
                        rect.bottom = (int) (rect.bottom + f);
                    }
                    if (rect.bottom < this.f18878i + ((int) fontMetrics.ascent)) {
                        this.f18880k = i2;
                        this.f18879j = i3;
                        this.f18870a.f18805N = (int) f2;
                        return;
                    }
                }
            }
            this.f18880k = size;
            this.f18879j = 2;
        }
    }

    /* renamed from: b */
    public ArrayList<C5149al> m19737b() {
        return this.f18875f;
    }

    /* renamed from: c */
    public int m19738c() {
        return this.f18877h;
    }

    /* renamed from: a */
    public C5149al m19733a(int i) {
        if (this.f18875f == null) {
            return null;
        }
        return this.f18875f.get(i);
    }

    /* renamed from: d */
    public C5149al m19740d() {
        if (this.f18875f == null || this.f18877h >= this.f18875f.size()) {
            return null;
        }
        return this.f18875f.get(this.f18877h);
    }

    /* renamed from: b */
    public String m19736b(int i) {
        C5149al c5149alM19733a = m19733a(i);
        return c5149alM19733a == null ? "" : c5149alM19733a.f18852a;
    }

    /* renamed from: e */
    public String m19741e() {
        return m19736b(this.f18877h);
    }

    /* renamed from: f */
    public String m19742f() {
        return this.f18874e + m19741e();
    }

    /* renamed from: g */
    public Rect m19743g() {
        return this.f18873d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19730b(float f) {
        float f2;
        float f3 = f - (this.f18876g / 2);
        if (this.f18875f.size() < 2) {
            return false;
        }
        int i = this.f18877h;
        float f4 = 0.0f;
        if (this.f18873d != null) {
            f4 = this.f18873d.top + (this.f18876g / 2);
        }
        int i2 = this.f18879j;
        int i3 = 0;
        while ((this.f18876g / 6) + f4 < f3) {
            if (i3 % i2 == i2 - 2) {
                f2 = this.f18876g * this.f18872c;
            } else {
                f2 = this.f18876g;
            }
            f4 += f2;
            i3++;
        }
        int size = (((i2 + this.f18880k) - 1) * (i3 / i2)) + (i3 % i2);
        if (!this.f18870a.f18810f && i3 % this.f18879j == this.f18879j - 1) {
            size += (int) (((this.f18876g * this.f18872c) - (((this.f18876g / 6) + f4) - f3)) / ((this.f18876g * this.f18872c) / this.f18880k));
        }
        if (size >= this.f18875f.size()) {
            size = this.f18875f.size() - 1;
        } else if (size < 0) {
            size = 0;
        }
        this.f18881l = f4;
        if (this.f18870a.f18810f && i3 % this.f18879j == this.f18879j - 1) {
            this.f18877h = this.f18880k + size;
            if (this.f18877h >= this.f18875f.size()) {
                this.f18877h = this.f18875f.size() - 1;
                return false;
            }
            if (this.f18877h >= 0) {
                return false;
            }
            this.f18877h = 0;
            return false;
        }
        this.f18877h = size;
        return size != i;
    }

    /* renamed from: a */
    public boolean m19735a(float f) {
        float f2;
        float f3 = f - (this.f18876g / 2);
        if (this.f18875f.size() < 2) {
            return false;
        }
        int i = this.f18877h;
        float f4 = 0.0f;
        if (this.f18873d != null) {
            f4 = this.f18873d.top + (this.f18876g / 2);
        }
        int i2 = this.f18879j;
        int i3 = 0;
        while ((this.f18876g / 6) + f4 < f3) {
            if (i3 % i2 == i2 - 2) {
                f2 = this.f18876g * this.f18872c;
            } else {
                f2 = this.f18876g;
            }
            f4 += f2;
            i3++;
        }
        int size = (((i2 + this.f18880k) - 1) * (i3 / i2)) + (i3 % i2);
        if (!this.f18870a.f18810f && i3 % this.f18879j == this.f18879j - 1) {
            size += (int) (((this.f18876g * this.f18872c) - (((this.f18876g / 6) + f4) - f3)) / ((this.f18876g * this.f18872c) / this.f18880k));
        }
        if (size >= this.f18875f.size()) {
            size = this.f18875f.size() - 1;
        } else if (size < 0) {
            size = 0;
        }
        if (this.f18870a.f18810f && i3 % this.f18879j == this.f18879j - 1) {
            return false;
        }
        this.f18877h = size;
        if (size == i) {
            return false;
        }
        this.f18881l = f4;
        return true;
    }

    /* renamed from: c */
    public void m19739c(int i) {
        this.f18878i = 0;
        Log.d("TwIndexScrollView", "NdepthScroll:: onSizeChanged() / awakenScrollBar() is now being called!");
        this.f18870a.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m19734a(android.graphics.Canvas r21, android.graphics.drawable.Drawable r22, android.graphics.Paint r23, int r24, int r25, int r26) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.widget.C5157at.m19734a(android.graphics.Canvas, android.graphics.drawable.Drawable, android.graphics.Paint, int, int, int):void");
    }
}
