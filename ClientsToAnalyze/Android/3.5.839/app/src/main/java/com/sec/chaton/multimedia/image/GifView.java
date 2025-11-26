package com.sec.chaton.multimedia.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.sec.chaton.util.C4904y;
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
    private static final String f10170a = GifView.class.getSimpleName();

    /* renamed from: b */
    private Movie f10171b;

    /* renamed from: c */
    private long f10172c;

    /* renamed from: d */
    private float f10173d;

    /* renamed from: e */
    private float f10174e;

    /* renamed from: f */
    private boolean f10175f;

    /* renamed from: g */
    private boolean f10176g;

    /* renamed from: h */
    private boolean f10177h;

    /* renamed from: i */
    private Handler f10178i;

    /* renamed from: j */
    private String f10179j;

    /* renamed from: k */
    private boolean f10180k;

    /* renamed from: l */
    private final int f10181l;

    public GifView(Context context, String str, Handler handler, boolean z) {
        Handler handler2;
        Message messageObtain;
        super(context);
        this.f10175f = true;
        this.f10181l = 2;
        this.f10180k = z;
        if (str != null) {
            try {
                this.f10179j = str;
                this.f10178i = handler;
                str = str.contains("file") ? Uri.parse(str).getPath() : str;
                this.f10171b = m11757a(str);
                if (this.f10171b != null && this.f10171b.duration() != 0) {
                    this.f10173d = this.f10171b.width();
                    this.f10174e = this.f10171b.height();
                    if (this.f10173d > 0.0f && this.f10174e > 0.0f) {
                        this.f10176g = true;
                    }
                    if (this.f10176g || this.f10178i == null) {
                        return;
                    }
                    handler2 = this.f10178i;
                    messageObtain = Message.obtain(this.f10178i, 1, str);
                } else {
                    if (this.f10176g || this.f10178i == null) {
                        return;
                    }
                    handler2 = this.f10178i;
                    messageObtain = Message.obtain(this.f10178i, 1, str);
                }
            } catch (Throwable th) {
                if (!this.f10176g && this.f10178i != null) {
                    this.f10178i.sendMessage(Message.obtain(this.f10178i, 1, str));
                }
                throw th;
            }
        } else {
            if (this.f10176g || this.f10178i == null) {
                return;
            }
            handler2 = this.f10178i;
            messageObtain = Message.obtain(this.f10178i, 1, str);
        }
        handler2.sendMessage(messageObtain);
    }

    /* renamed from: a */
    private static byte[] m11758a(InputStream inputStream) throws IOException {
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
                } catch (IOException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f10170a);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e2, f10170a);
                            }
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e3, f10170a);
                        }
                        throw th;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                if (!C4904y.f17875e) {
                    return byteArray;
                }
                C4904y.m18635a(e4, f10170a);
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
        this.f10175f = true;
        this.f10181l = 2;
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10175f = true;
        this.f10181l = 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        if (this.f10171b != null) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (this.f10172c == 0) {
                this.f10172c = jUptimeMillis;
            }
            int iMax = Math.max(this.f10171b.duration(), 1);
            if (!this.f10180k && (i = (int) (jUptimeMillis - this.f10172c)) > iMax * 2) {
                this.f10177h = true;
                if (C4904y.f17872b) {
                    C4904y.m18639b("relTime >= dur", getClass().getSimpleName());
                }
                if (this.f10178i != null) {
                    C4904y.m18639b("mHandler: " + this.f10178i, f10170a);
                    Message messageObtainMessage = this.f10178i.obtainMessage();
                    messageObtainMessage.what = 2;
                    this.f10178i.sendMessage(messageObtainMessage);
                }
            } else {
                i = (int) ((jUptimeMillis - this.f10172c) % iMax);
            }
            C4904y.m18639b("dur: " + iMax + ", relTime: " + i, getClass().getSimpleName());
            this.f10171b.setTime(i);
            float fMin = Math.min(canvas.getWidth() / this.f10173d, canvas.getHeight() / this.f10174e);
            float fAbs = (Math.abs(canvas.getWidth() - (this.f10173d * fMin)) / 2.0f) / fMin;
            float fAbs2 = (Math.abs(canvas.getHeight() - (this.f10174e * fMin)) / 2.0f) / fMin;
            canvas.scale(fMin, fMin);
            this.f10171b.draw(canvas, fAbs, fAbs2);
            if (this.f10175f && !this.f10177h) {
                invalidate();
            }
        }
    }

    /* renamed from: a */
    public void m11759a() {
        this.f10175f = false;
    }

    /* renamed from: b */
    public boolean m11760b() {
        return this.f10176g;
    }

    /* renamed from: a */
    public static Movie m11757a(String str) throws IOException {
        try {
            byte[] bArrM11758a = m11758a(new BufferedInputStream(new FileInputStream(new File(str)), MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND));
            if (bArrM11758a == null) {
                return null;
            }
            return Movie.decodeByteArray(bArrM11758a, 0, bArrM11758a.length);
        } catch (FileNotFoundException e) {
            C4904y.m18635a(e, f10170a);
            return null;
        }
    }
}
