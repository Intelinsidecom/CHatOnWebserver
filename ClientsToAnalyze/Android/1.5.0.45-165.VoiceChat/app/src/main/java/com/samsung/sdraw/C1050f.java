package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.ImageButton;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.lang.reflect.Array;

/* renamed from: com.samsung.sdraw.f */
/* loaded from: classes.dex */
class C1050f extends ImageButton {

    /* renamed from: a */
    private Bitmap f1723a;

    /* renamed from: b */
    private a f1724b;

    /* renamed from: c */
    private Drawable f1725c;

    /* renamed from: d */
    private Rect f1726d;

    /* renamed from: e */
    private int f1727e;

    /* renamed from: f */
    private int f1728f;

    /* renamed from: g */
    private Paint f1729g;

    /* renamed from: h */
    private int f1730h;

    /* renamed from: com.samsung.sdraw.f$a */
    interface a {
        /* renamed from: a */
        void mo800a(int i, int i2, int i3);
    }

    public C1050f(Context context) {
        super(context);
        m1544a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action != 3) {
            if ((action == 2 || action == 1 || action == 0) && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int pixel = -1;
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (x < 0) {
                x = 0;
            }
            if (y < 0) {
                y = 0;
            }
            if (this.f1723a != null) {
                if (this.f1723a.getWidth() <= x) {
                    x = this.f1723a.getWidth() - 1;
                }
                if (this.f1723a.getHeight() <= y) {
                    y = this.f1723a.getHeight() - 1;
                }
                pixel = this.f1723a.getPixel(x, y);
            }
            this.f1726d.set(x - (this.f1727e / 2), y - (this.f1728f / 2), (this.f1727e / 2) + x, (this.f1728f / 2) + y);
            if (this.f1726d.left < 0) {
                this.f1726d.offset(-this.f1726d.left, 0);
            }
            if (this.f1726d.right > getWidth()) {
                this.f1726d.offset(getWidth() - this.f1726d.right, 0);
            }
            if (this.f1726d.top < 0) {
                this.f1726d.offset(0, -this.f1726d.top);
            }
            if (this.f1726d.bottom > getHeight()) {
                this.f1726d.offset(0, getHeight() - this.f1726d.bottom);
            }
            this.f1725c.setBounds(this.f1726d);
            if (this.f1724b != null) {
                if ((pixel & 16777215) == 16777215) {
                    pixel = 16711422;
                }
                this.f1724b.mo800a((pixel & 16777215) | (-33554432), x, y);
            }
            invalidate();
        }
        return true;
    }

    /* renamed from: a */
    public void m1546a(C1051g c1051g, int i) {
        if (c1051g != null) {
            int[] iArrM1554a = c1051g.m1554a();
            for (int i2 = 0; i2 < iArrM1554a.length - 1; i2++) {
                if (i == (iArrM1554a[i2] & 16777215)) {
                    this.f1730h = i;
                    return;
                }
            }
        }
        if (i == (Color.rgb(0, 0, 255) & 16777215)) {
            this.f1730h = i;
            return;
        }
        if (this.f1723a != null) {
            for (int i3 = 0; i3 < this.f1723a.getWidth(); i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 < this.f1723a.getHeight()) {
                        if (i != (this.f1723a.getPixel(i3, i4) & 16777215)) {
                            i4++;
                        } else {
                            this.f1726d.set(i3 - (this.f1727e / 2), i4 - (this.f1728f / 2), (this.f1727e / 2) + i3, i4 + (this.f1728f / 2));
                            if (this.f1726d.left < 0) {
                                this.f1726d.offset(-this.f1726d.left, 0);
                            }
                            if (this.f1726d.right > getWidth()) {
                                this.f1726d.offset(getWidth() - this.f1726d.right, 0);
                            }
                            if (this.f1726d.top < 0) {
                                this.f1726d.offset(0, -this.f1726d.top);
                            }
                            if (this.f1726d.bottom > getHeight()) {
                                this.f1726d.offset(0, getHeight() - this.f1726d.bottom);
                            }
                            this.f1725c.setBounds(this.f1726d);
                        }
                    }
                }
            }
        }
        this.f1730h = i;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1725c.draw(canvas);
        canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getWidth(), getHeight(), this.f1729g);
    }

    /* renamed from: a */
    public void m1545a(a aVar) {
        this.f1724b = aVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            if (this.f1723a != null) {
                this.f1723a.recycle();
                this.f1723a = null;
            }
            this.f1723a = m1543a(w, h);
            setImageBitmap(this.f1723a);
            m1546a((C1051g) null, this.f1730h);
        }
    }

    /* renamed from: a */
    private Bitmap m1543a(int i, int i2) {
        int[] iArr = {-65536, -256, -16711936, -16711681, -16776961, -65281, -65536};
        float[] fArr = {VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0.16666667f, 0.33333334f, 0.5f, 0.6666667f, 0.8333333f, 1.0f};
        float[] fArr2 = {VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0.5f, 1.0f};
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        LinearGradient linearGradient = new LinearGradient(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = new Paint(1);
        paint.setShader(linearGradient);
        paint.setStyle(Paint.Style.FILL);
        paint.setDither(true);
        canvas.drawRect(new Rect(0, 0, i, 1), paint);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, 3);
        for (int i3 = 0; i3 < i; i3++) {
            iArr2[i3][0] = -1;
            iArr2[i3][1] = bitmapCreateBitmap.getPixel(i3, 0);
            iArr2[i3][2] = -16777216;
        }
        bitmapCreateBitmap.recycle();
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setDither(true);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                return bitmapCreateBitmap2;
            }
            paint2.setShader(new LinearGradient(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, i2, iArr2[i5], fArr2, Shader.TileMode.CLAMP));
            canvas2.drawLine(i5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, i5, i2, paint2);
            i4 = i5 + 1;
        }
    }

    /* renamed from: a */
    private void m1544a() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f1725c = C1042ca.m1517a(C1003ap.f1527c);
        this.f1727e = (int) (this.f1725c.getIntrinsicWidth() * (displayMetrics.density / 2.0f));
        this.f1728f = (int) ((displayMetrics.density / 2.0f) * this.f1725c.getIntrinsicHeight());
        this.f1726d = new Rect(0, 0, this.f1727e, this.f1728f);
        this.f1725c.setBounds(this.f1726d);
        this.f1729g = new Paint(1);
        this.f1729g.setColor(-7566196);
        this.f1729g.setStrokeWidth(2.0f);
        this.f1729g.setStyle(Paint.Style.STROKE);
        setBackgroundColor(0);
    }
}
