package com.sec.chaton.settings.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.settings.theme.a */
/* loaded from: classes.dex */
class C0510a extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ Carousel f3284a;

    /* renamed from: b */
    private Context f3285b;

    /* renamed from: c */
    private CarouselImageView[] f3286c;

    public C0510a(Carousel carousel, Context context) {
        this.f3284a = carousel;
        this.f3285b = context;
    }

    /* renamed from: a */
    public void m3280a(TypedArray typedArray, boolean z) {
        Drawable[] drawableArr = new Drawable[typedArray.length()];
        this.f3286c = new CarouselImageView[typedArray.length()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= typedArray.length()) {
                return;
            }
            drawableArr[i2] = typedArray.getDrawable(i2);
            if (drawableArr[i2] instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawableArr[i2]).getBitmap();
                if (z) {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.preScale(1.0f, -1.0f);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, height / 2, width, height / 2, matrix, false);
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width, (height / 8) + height, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap2);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    canvas.drawRect(0.0f, height, width, height + 4, new Paint());
                    canvas.drawBitmap(bitmapCreateBitmap, 0.0f, height + 4, (Paint) null);
                    Paint paint = new Paint();
                    paint.setShader(new LinearGradient(0.0f, bitmap.getHeight(), 0.0f, bitmapCreateBitmap2.getHeight() + 4, 1895825407, 16777215, Shader.TileMode.CLAMP));
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    canvas.drawRect(0.0f, height, width, bitmapCreateBitmap2.getHeight() + 4, paint);
                    bitmap = bitmapCreateBitmap2;
                }
                CarouselImageView carouselImageView = new CarouselImageView(this.f3285b);
                carouselImageView.setImageBitmap(bitmap);
                carouselImageView.setIndex(i2);
                this.f3286c[i2] = carouselImageView;
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f3286c == null) {
            return 0;
        }
        return this.f3286c.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ChatONLogWriter.m3506b("SKIN getItem=" + i, null);
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.f3286c[i];
    }
}
