package com.sec.widget;

import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.bh */
/* loaded from: classes.dex */
class C3667bh {

    /* renamed from: a */
    final /* synthetic */ TwIndexScrollView f13566a;

    /* renamed from: b */
    private int f13567b;

    /* renamed from: d */
    private Rect f13569d;

    /* renamed from: e */
    private String f13570e;

    /* renamed from: f */
    private ArrayList<C3658az> f13571f;

    /* renamed from: g */
    private int f13572g;

    /* renamed from: h */
    private int f13573h;

    /* renamed from: j */
    private int f13575j;

    /* renamed from: l */
    private float f13577l;

    /* renamed from: m */
    private float f13578m;

    /* renamed from: c */
    private float f13568c = 1.0f;

    /* renamed from: i */
    private int f13574i = 0;

    /* renamed from: k */
    private int f13576k = 1;

    /* renamed from: a */
    public int m13247a() {
        return this.f13575j;
    }

    public C3667bh(TwIndexScrollView twIndexScrollView, String str, ArrayList<C3658az> arrayList, float f, int i, Rect rect, int i2) {
        this.f13566a = twIndexScrollView;
        this.f13573h = -1;
        this.f13567b = i2;
        this.f13573h = 0;
        if (arrayList == null || arrayList.size() == 0 || i < 1) {
            throw new IllegalArgumentException("NDepthScroll( " + str + ", ," + f + "," + i + "," + rect);
        }
        this.f13570e = str == null ? "" : str;
        this.f13571f = arrayList;
        this.f13572g = i;
        f = f < 0.0f ? 0.0f : f;
        this.f13577l = f;
        this.f13578m = f;
        this.f13578m -= (int) twIndexScrollView.getResources().getDimension(R.dimen.tw_indexview_second_handle_toppading);
        this.f13575j = this.f13571f.size() + 1;
        this.f13569d = new Rect();
        this.f13569d.top = rect.top;
        this.f13569d.bottom = rect.bottom;
        this.f13569d.right = rect.right;
        this.f13569d.left = rect.left;
    }

    /* renamed from: h */
    private void m13246h() {
        int i;
        Rect rect = new Rect();
        int size = this.f13571f.size();
        int size2 = this.f13571f.size() + 1;
        this.f13571f.size();
        float f = this.f13572g;
        Paint.FontMetrics fontMetrics = this.f13566a.f13446i.getFontMetrics();
        if (this.f13574i != 0) {
            for (int i2 = 1; i2 <= size; i2++) {
                int size3 = this.f13571f.size();
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
                    rect.bottom = (int) ((i * f) + (this.f13568c * f2 * f));
                    if (this.f13571f.size() % ((i3 - 1) + i2) >= i3 - 1) {
                        rect.bottom = (int) (rect.bottom + f);
                    }
                    if (rect.bottom < this.f13574i + ((int) fontMetrics.ascent)) {
                        this.f13576k = i2;
                        this.f13575j = i3;
                        this.f13566a.f13438N = (int) f2;
                        return;
                    }
                }
            }
            this.f13576k = size;
            this.f13575j = 2;
        }
    }

    /* renamed from: b */
    public ArrayList<C3658az> m13252b() {
        return this.f13571f;
    }

    /* renamed from: c */
    public int m13253c() {
        return this.f13573h;
    }

    /* renamed from: a */
    public C3658az m13248a(int i) {
        if (this.f13571f == null) {
            return null;
        }
        return this.f13571f.get(i);
    }

    /* renamed from: d */
    public C3658az m13255d() {
        if (this.f13571f == null || this.f13573h >= this.f13571f.size()) {
            return null;
        }
        return this.f13571f.get(this.f13573h);
    }

    /* renamed from: b */
    public String m13251b(int i) {
        C3658az c3658azM13248a = m13248a(i);
        return c3658azM13248a == null ? "" : c3658azM13248a.f13548a;
    }

    /* renamed from: e */
    public String m13256e() {
        return m13251b(this.f13573h);
    }

    /* renamed from: f */
    public String m13257f() {
        return this.f13570e + m13256e();
    }

    /* renamed from: g */
    public Rect m13258g() {
        return this.f13569d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m13245b(float f) {
        float f2;
        float f3 = f - (this.f13572g / 2);
        if (this.f13571f.size() < 2) {
            return false;
        }
        int i = this.f13573h;
        float f4 = 0.0f;
        if (this.f13569d != null) {
            f4 = this.f13569d.top + (this.f13572g / 2);
        }
        int i2 = this.f13575j;
        int i3 = 0;
        while ((this.f13572g / 6) + f4 < f3) {
            if (i3 % i2 == i2 - 2) {
                f2 = this.f13572g * this.f13568c;
            } else {
                f2 = this.f13572g;
            }
            f4 += f2;
            i3++;
        }
        int size = (((i2 + this.f13576k) - 1) * (i3 / i2)) + (i3 % i2);
        if (!this.f13566a.f13443f && i3 % this.f13575j == this.f13575j - 1) {
            size += (int) (((this.f13572g * this.f13568c) - (((this.f13572g / 6) + f4) - f3)) / ((this.f13572g * this.f13568c) / this.f13576k));
        }
        if (size >= this.f13571f.size()) {
            size = this.f13571f.size() - 1;
        } else if (size < 0) {
            size = 0;
        }
        this.f13577l = f4;
        if (this.f13566a.f13443f && i3 % this.f13575j == this.f13575j - 1) {
            this.f13573h = this.f13576k + size;
            if (this.f13573h >= this.f13571f.size()) {
                this.f13573h = this.f13571f.size() - 1;
                return false;
            }
            if (this.f13573h >= 0) {
                return false;
            }
            this.f13573h = 0;
            return false;
        }
        this.f13573h = size;
        return size != i;
    }

    /* renamed from: a */
    public boolean m13250a(float f) {
        float f2;
        float f3 = f - (this.f13572g / 2);
        if (this.f13571f.size() < 2) {
            return false;
        }
        int i = this.f13573h;
        float f4 = this.f13569d.top + (this.f13572g / 2);
        int i2 = this.f13575j;
        int i3 = 0;
        while ((this.f13572g / 6) + f4 < f3) {
            if (i3 % i2 == i2 - 2) {
                f2 = this.f13572g * this.f13568c;
            } else {
                f2 = this.f13572g;
            }
            f4 += f2;
            i3++;
        }
        int size = (((i2 + this.f13576k) - 1) * (i3 / i2)) + (i3 % i2);
        if (!this.f13566a.f13443f && i3 % this.f13575j == this.f13575j - 1) {
            size += (int) (((this.f13572g * this.f13568c) - (((this.f13572g / 6) + f4) - f3)) / ((this.f13572g * this.f13568c) / this.f13576k));
        }
        if (size >= this.f13571f.size()) {
            size = this.f13571f.size() - 1;
        } else if (size < 0) {
            size = 0;
        }
        if (this.f13566a.f13443f && i3 % this.f13575j == this.f13575j - 1) {
            return false;
        }
        this.f13573h = size;
        if (size == i) {
            return false;
        }
        this.f13577l = f4;
        return true;
    }

    /* renamed from: c */
    public void m13254c(int i) {
        this.f13574i = 0;
        Log.d("TwIndexScrollView", "NdepthScroll:: onSizeChanged() / awakenScrollBar() is now being called!");
        this.f13566a.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x034b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m13249a(android.graphics.Canvas r21, android.graphics.drawable.Drawable r22, android.graphics.Paint r23, int r24, int r25, int r26) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.widget.C3667bh.m13249a(android.graphics.Canvas, android.graphics.drawable.Drawable, android.graphics.Paint, int, int, int):void");
    }
}
