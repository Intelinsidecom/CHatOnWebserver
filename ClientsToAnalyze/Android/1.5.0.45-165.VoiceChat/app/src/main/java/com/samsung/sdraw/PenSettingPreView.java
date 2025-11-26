package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.samsung.sdraw.StrokeSprite;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class PenSettingPreView extends ImageView {

    /* renamed from: a */
    String f1117a;

    /* renamed from: b */
    PointF[] f1118b;

    /* renamed from: c */
    private StrokeSprite f1119c;

    /* renamed from: d */
    private C1054j f1120d;

    /* renamed from: e */
    private Setting f1121e;

    /* renamed from: f */
    private int f1122f;

    /* renamed from: g */
    private int f1123g;

    /* renamed from: h */
    private Bitmap f1124h;

    /* renamed from: i */
    private Bitmap f1125i;

    /* renamed from: j */
    private boolean f1126j;

    /* renamed from: k */
    private boolean f1127k;

    public PenSettingPreView(Context context) {
        super(context);
        this.f1117a = Build.VERSION.RELEASE;
        this.f1126j = false;
        this.f1127k = false;
        m1032a(context);
    }

    public PenSettingPreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1117a = Build.VERSION.RELEASE;
        this.f1126j = false;
        this.f1127k = false;
        m1032a(context);
    }

    /* renamed from: a */
    private void m1032a(Context context) {
        this.f1120d = new C1054j(context);
        this.f1121e = new Setting(getContext());
        this.f1125i = null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.f1124h == null && w > 0 && h > 0) {
            this.f1124h = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        }
        float f = (h / 2.0f) + 10.0f;
        float f2 = (w / 2.0f) + 10.0f;
        if (!this.f1126j) {
            this.f1118b = new PointF[5];
            this.f1118b[0] = new PointF(f2 - ((3.0f * f2) / 4.0f), f + 10.0f);
            this.f1118b[1] = new PointF(f2 - (f2 / 3.0f), f - (h / 3.0f));
            this.f1118b[2] = new PointF((f2 / 3.0f) + f2, (h / 3.0f) + f);
            this.f1118b[3] = new PointF(((3.0f * f2) / 4.0f) + f2, f - 10.0f);
            this.f1118b[4] = new PointF(f2 + ((3.0f * f2) / 4.0f) + 1.0f, f - 9.0f);
        }
        this.f1119c = m1031a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f1124h, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
    }

    public void setType(int type) {
        this.f1121e.setStrokeType(PenSettingInfo.m1020a(type));
        if (this.f1119c != null) {
            this.f1119c.dispose();
        }
        this.f1119c = m1031a();
        invalidate();
    }

    public void setPenWidth(int width) {
        this.f1121e.setStrokeWidth(width);
        if (this.f1119c != null) {
            this.f1119c.dispose();
        }
        this.f1119c = m1031a();
        invalidate();
    }

    public void setPenAlpha(int alpha) {
        this.f1123g = alpha & 255;
        if (this.f1119c != null) {
            this.f1119c.dispose();
        }
        this.f1119c = m1031a();
        invalidate();
    }

    public void setPenColor(int color) {
        this.f1122f = color;
        if (this.f1119c != null) {
            this.f1119c.dispose();
        }
        this.f1119c = m1031a();
        invalidate();
    }

    /* renamed from: a */
    private StrokeSprite m1031a() throws Throwable {
        StrokeSprite strokeSpriteM1557a;
        if (this.f1118b == null) {
            return null;
        }
        if (!this.f1127k) {
            strokeSpriteM1557a = this.f1120d.m1557a(this.f1121e.getStrokeType(), StrokeSprite.ThicknessParameter.lookup(StrokeSprite.ThicknessParameter.Constant.name()), StrokeSprite.InputMethod.lookup(StrokeSprite.InputMethod.Hand.name()), this.f1121e.getStrokeWidth(), ((this.f1123g & 255) << 24) | (this.f1122f & 16777215));
        } else {
            strokeSpriteM1557a = this.f1120d.m1557a(StrokeSprite.Type.Eraser, StrokeSprite.ThicknessParameter.lookup(StrokeSprite.ThicknessParameter.Constant.name()), StrokeSprite.InputMethod.lookup(StrokeSprite.InputMethod.Hand.name()), this.f1121e.getStrokeWidth(), ((this.f1123g & 255) << 24) | (this.f1122f & 16777215));
        }
        strokeSpriteM1557a.setVisible(true);
        strokeSpriteM1557a.m1144a(this.f1121e.m1108b());
        strokeSpriteM1557a.m1149b(this.f1121e.m1113d());
        if (this.f1121e.getStrokeType() == StrokeSprite.Type.Hightlighter) {
            for (int i = 0; i < this.f1118b.length; i++) {
                PointF pointF = this.f1118b[i];
                if (i == 3 || i == 4) {
                    if (strokeSpriteM1557a.m1145a(pointF.x - 34.0f, pointF.y - 10.0f, 255.0f, 1L)) {
                        strokeSpriteM1557a.m1147b(true);
                    }
                } else if (this.f1117a.startsWith("4.1")) {
                    if (strokeSpriteM1557a.m1145a(pointF.x - 25.0f, pointF.y - 13.0f, 255.0f, 1L)) {
                        strokeSpriteM1557a.m1147b(true);
                    }
                } else if (strokeSpriteM1557a.m1145a(pointF.x - 20.0f, pointF.y - 13.0f, 255.0f, 1L)) {
                    strokeSpriteM1557a.m1147b(true);
                }
            }
        } else {
            for (int i2 = 0; i2 < this.f1118b.length; i2++) {
                PointF pointF2 = this.f1118b[i2];
                if (this.f1117a.startsWith("4.1")) {
                    if (strokeSpriteM1557a.m1145a(pointF2.x - 5.0f, pointF2.y - 13.0f, 255.0f, 1L)) {
                        strokeSpriteM1557a.m1147b(true);
                    }
                } else if (strokeSpriteM1557a.m1145a(pointF2.x, pointF2.y - 13.0f, 255.0f, 1L)) {
                    strokeSpriteM1557a.m1147b(true);
                }
            }
        }
        if (strokeSpriteM1557a.getType() != StrokeSprite.Type.Brush && strokeSpriteM1557a.getType() != StrokeSprite.Type.Zenbrush) {
            strokeSpriteM1557a.m1164i();
        }
        strokeSpriteM1557a.m1157d(true);
        if (this.f1124h != null) {
            Canvas canvas = new Canvas(this.f1124h);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            if (strokeSpriteM1557a.getType() == StrokeSprite.Type.Eraser && this.f1125i != null && this.f1127k) {
                canvas.drawBitmap(this.f1125i, (this.f1124h.getWidth() - this.f1125i.getWidth()) / 2.0f, (this.f1124h.getHeight() - this.f1125i.getHeight()) / 2.0f, (Paint) null);
            }
            strokeSpriteM1557a.mo1139a(canvas, strokeSpriteM1557a.getBounds());
            return strokeSpriteM1557a;
        }
        return strokeSpriteM1557a;
    }

    public void setStrokePoint(android.graphics.PointF[] points) {
        this.f1126j = true;
        PointF[] pointFArr = new PointF[points.length];
        for (int i = 0; i < points.length; i++) {
            pointFArr[i] = new PointF(points[i]);
        }
        this.f1118b = pointFArr;
        this.f1119c = m1031a();
        invalidate();
    }

    public void setEraserBackground(Bitmap image) {
        this.f1125i = image;
        invalidate();
    }

    public void setEraserMode(boolean eraser_mode) {
        this.f1127k = eraser_mode;
        invalidate();
    }

    public void setDescription(String format, String solidDesc, String brushDesc, String zenBrushDesc, String pencilDesc, String marker) {
        StrokeSprite.Type strokeType = this.f1121e.getStrokeType();
        if (strokeType != StrokeSprite.Type.Solid) {
            if (strokeType == StrokeSprite.Type.Brush) {
                solidDesc = brushDesc;
            } else if (strokeType == StrokeSprite.Type.Zenbrush) {
                solidDesc = zenBrushDesc;
            } else if (strokeType == StrokeSprite.Type.Pencil) {
                solidDesc = pencilDesc;
            } else {
                solidDesc = strokeType == StrokeSprite.Type.Hightlighter ? marker : "pen";
            }
        }
        setContentDescription(String.format(format, solidDesc, Integer.valueOf((int) ((this.f1121e.getStrokeWidth() / 72.0f) * 100.0f)), Integer.valueOf((this.f1123g * 100) / 255)));
    }
}
