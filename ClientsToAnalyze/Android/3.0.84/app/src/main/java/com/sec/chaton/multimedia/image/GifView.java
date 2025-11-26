package com.sec.chaton.multimedia.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.sec.chaton.util.C3250y;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class GifView extends View {

    /* renamed from: a */
    private static final String f6876a = GifView.class.getSimpleName();

    /* renamed from: b */
    private Movie f6877b;

    /* renamed from: c */
    private long f6878c;

    /* renamed from: d */
    private float f6879d;

    /* renamed from: e */
    private float f6880e;

    /* renamed from: f */
    private boolean f6881f;

    /* renamed from: g */
    private boolean f6882g;

    public GifView(Context context, String str) throws IOException {
        super(context);
        this.f6881f = true;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)), 16384);
            if (bufferedInputStream != null) {
                byte[] bArrM7552a = m7552a(bufferedInputStream);
                if (bArrM7552a == null) {
                    this.f6882g = true;
                    return;
                }
                this.f6877b = Movie.decodeByteArray(bArrM7552a, 0, bArrM7552a.length);
                if (this.f6877b == null) {
                    this.f6882g = true;
                    return;
                }
                this.f6879d = this.f6877b.width();
                this.f6880e = this.f6877b.height();
                if (this.f6879d == 0.0f || this.f6880e == 0.0f) {
                    this.f6882g = true;
                }
            }
        } catch (FileNotFoundException e) {
            C3250y.m11443a(e, f6876a);
            this.f6882g = true;
        }
    }

    /* renamed from: a */
    private byte[] m7552a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            C3250y.m11443a(e, f6876a);
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                C3250y.m11443a(e2, f6876a);
                this.f6882g = true;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        C3250y.m11443a(e3, f6876a);
                        return null;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return null;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                C3250y.m11443a(e4, f6876a);
                return byteArray;
            }
        }
        if (byteArrayOutputStream == null) {
            return byteArray;
        }
        byteArrayOutputStream.close();
        return byteArray;
    }

    public GifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6881f = true;
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6881f = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f6877b != null) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (this.f6878c == 0) {
                this.f6878c = jUptimeMillis;
            }
            this.f6877b.setTime((int) ((jUptimeMillis - this.f6878c) % Math.max(this.f6877b.duration(), 1)));
            float fMin = Math.min(canvas.getWidth() / this.f6879d, canvas.getHeight() / this.f6880e);
            float fAbs = (Math.abs(canvas.getWidth() - (this.f6879d * fMin)) / 2.0f) / fMin;
            float fAbs2 = (Math.abs(canvas.getHeight() - (this.f6880e * fMin)) / 2.0f) / fMin;
            canvas.scale(fMin, fMin);
            this.f6877b.draw(canvas, fAbs, fAbs2);
            if (this.f6881f) {
                invalidate();
            }
        }
    }

    /* renamed from: a */
    public void m7553a() {
        this.f6881f = false;
    }

    /* renamed from: b */
    public boolean m7554b() {
        return this.f6882g;
    }
}
