package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.samsung.sdraw.bz */
/* loaded from: classes.dex */
class C1040bz extends TypefaceSpan {

    /* renamed from: a */
    public static HashMap<String, Typeface> f1671a = new HashMap<>();

    /* renamed from: b */
    public static HashMap<String, String> f1672b = new HashMap<>();

    /* renamed from: c */
    public static ArrayList<String> f1673c = new ArrayList<>();

    /* renamed from: d */
    private String f1674d;

    /* renamed from: e */
    private Typeface f1675e;

    /* renamed from: f */
    private String f1676f;

    /* renamed from: g */
    private String f1677g;

    /* renamed from: h */
    private String f1678h;

    /* renamed from: i */
    private Context f1679i;

    public C1040bz(Context context, String str) {
        super(str);
        this.f1676f = "/system/fonts/";
        this.f1677g = "fonts/";
        this.f1678h = ".ttf";
        this.f1674d = str;
        this.f1679i = context;
        this.f1675e = null;
        m1515a();
    }

    /* renamed from: a */
    private void m1515a() {
        Typeface typefaceCreate;
        if (f1671a.isEmpty() && !f1673c.isEmpty()) {
            Iterator<String> it = f1673c.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    typefaceCreate = Typeface.createFromFile(f1672b.get(next));
                } catch (Exception e) {
                    typefaceCreate = Typeface.create(Typeface.SANS_SERIF, 0);
                }
                f1671a.put(next, typefaceCreate);
            }
        }
    }

    @Override // android.text.style.TypefaceSpan, android.text.ParcelableSpan
    public int getSpanTypeId() {
        return super.getSpanTypeId();
    }

    @Override // android.text.style.TypefaceSpan, android.os.Parcelable
    public int describeContents() {
        return super.describeContents();
    }

    @Override // android.text.style.TypefaceSpan, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f1674d);
    }

    @Override // android.text.style.TypefaceSpan
    public String getFamily() {
        if (this.f1674d != null) {
            return this.f1674d;
        }
        return Setting.f1240l;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        m1516a(ds, this.f1674d);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        super.updateMeasureState(paint);
        m1516a(paint, this.f1674d);
    }

    /* renamed from: a */
    private void m1516a(Paint paint, String str) {
        if (this.f1675e == null) {
            if (!f1671a.containsKey(str)) {
                try {
                    this.f1675e = Typeface.createFromFile(f1672b.get(str));
                } catch (Exception e) {
                    this.f1675e = Typeface.create(Typeface.SANS_SERIF, 0);
                }
                f1671a.put(str, this.f1675e);
            } else {
                this.f1675e = f1671a.get(str);
            }
        }
        Typeface typeface = paint.getTypeface();
        int style = typeface == null ? 0 : typeface.getStyle();
        paint.setTypeface(this.f1675e);
        int style2 = style & (this.f1675e.getStyle() ^ (-1));
        if ((style2 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style2 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
    }
}
