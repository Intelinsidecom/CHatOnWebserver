package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.bp */
/* loaded from: classes.dex */
class C1030bp extends Paint {

    /* renamed from: a */
    protected boolean f1580a;

    /* renamed from: b */
    protected Bitmap f1581b;

    public C1030bp() {
        setAntiAlias(true);
        setDither(true);
        setStyle(Paint.Style.FILL);
        setStrokeCap(Paint.Cap.ROUND);
        setStrokeJoin(Paint.Join.ROUND);
    }

    public C1030bp(C1030bp c1030bp) {
        this();
        set(c1030bp);
        this.f1580a = c1030bp.f1580a;
        this.f1581b = c1030bp.f1581b;
    }

    /* renamed from: a */
    public boolean m1421a() {
        return this.f1580a;
    }

    /* renamed from: b */
    public Bitmap m1422b() {
        return this.f1581b;
    }

    @Override // android.graphics.Paint
    public void setColor(int color) {
        super.setColor(color);
        if (this.f1581b != null) {
            setColorFilter(new ColorMatrixColorFilter(new float[]{Color.red(color) / 255.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, Color.green(color) / 255.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, Color.blue(color) / 255.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, Color.alpha(color) / 255.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET}));
        }
    }

    @Override // android.graphics.Paint
    public void setAlpha(int alpha) {
        if (this.f1581b != null) {
            super.setAlpha(255);
            int color = getColor();
            setColorFilter(new ColorMatrixColorFilter(new float[]{Color.red(color) / 255.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, Color.green(color) / 255.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, Color.blue(color) / 255.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, Math.max(0.2f, Math.min(0.6f, alpha / 255.0f)), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET}));
            return;
        }
        super.setAlpha(alpha);
    }
}
