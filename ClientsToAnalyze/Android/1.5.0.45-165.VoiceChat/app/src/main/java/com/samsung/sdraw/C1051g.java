package com.samsung.sdraw;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.samsung.spen.lib.image.SPenImageFilterConstants;
import com.sec.spp.push.Config;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.g */
/* loaded from: classes.dex */
class C1051g extends ImageButton {

    /* renamed from: a */
    protected static final int f1731a = Color.rgb(19, 19, 19);

    /* renamed from: b */
    private int f1732b;

    /* renamed from: c */
    private int[] f1733c;

    /* renamed from: d */
    private Rect f1734d;

    /* renamed from: e */
    private Rect f1735e;

    /* renamed from: f */
    private Rect f1736f;

    /* renamed from: g */
    private Paint f1737g;

    /* renamed from: h */
    private Paint f1738h;

    /* renamed from: i */
    private a f1739i;

    /* renamed from: j */
    private BitmapDrawable f1740j;

    /* renamed from: k */
    private BitmapDrawable f1741k;

    /* renamed from: l */
    private BitmapDrawable f1742l;

    /* renamed from: com.samsung.sdraw.g$a */
    interface a {
        /* renamed from: a */
        void mo804a(int i, int i2, boolean z);
    }

    public C1051g(Context context) {
        super(context);
        this.f1732b = 0;
        this.f1733c = new int[]{Color.rgb(255, 255, 255), Color.rgb(253, 255, 45), Color.rgb(255, SPenImageFilterConstants.FILTER_POPART, 93), Color.rgb(255, 0, 0), Color.rgb(255, 73, 201), Color.rgb(202, SPenImageFilterConstants.FILTER_OILPAINT, 255), Color.rgb(56, 168, 255), Color.rgb(0, 0, 255), Color.rgb(22, ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, Config.RANDOM_RANGE_RETRY_INTERVAL), Color.rgb(1, 148, 46), Color.rgb(4, 103, 46), Color.rgb(165, 165, 165), Color.rgb(114, 114, 114), Color.rgb(48, 48, 48), f1731a, -16777217};
        this.f1739i = null;
        this.f1740j = new BitmapDrawable(BitmapFactory.decodeByteArray(C1003ap.f1526b, 0, C1003ap.f1526b.length));
        this.f1741k = new BitmapDrawable(BitmapFactory.decodeByteArray(C1003ap.f1528d, 0, C1003ap.f1528d.length));
        this.f1742l = new BitmapDrawable(BitmapFactory.decodeByteArray(C1003ap.f1525a, 0, C1003ap.f1525a.length));
        m1551d();
    }

    /* renamed from: d */
    private void m1551d() {
        this.f1737g = new Paint();
        this.f1737g.setColor(-16777216);
        this.f1737g.setStrokeWidth(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.f1737g.setStyle(Paint.Style.STROKE);
        this.f1738h = new Paint(1);
        setBackgroundColor(0);
    }

    /* renamed from: a */
    public void m1553a(a aVar, int i) {
        this.f1739i = aVar;
        m1549b(i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int arg0, int arg1) {
        int size = View.MeasureSpec.getSize(arg0);
        int i = (size + 0) / 8;
        float length = this.f1733c.length / 8.0f;
        int length2 = this.f1733c.length / 8;
        if (length > length2) {
            length2++;
        }
        setMeasuredDimension(size, (length2 * i) + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.f1734d = new Rect(getPaddingLeft() + getLeft(), getPaddingTop() + getTop(), getRight() - getPaddingRight(), getBottom() - getPaddingBottom());
        int iWidth = ((int) ((this.f1734d.width() + 0) / 8.0f)) - 1;
        this.f1735e = new Rect(0, 0, iWidth, iWidth);
        this.f1736f = new Rect(this.f1735e.left - 1, this.f1735e.top - 1, this.f1735e.right + 1, this.f1735e.bottom + 1);
        this.f1741k.setBounds(this.f1735e);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        playSoundEffect(0);
        switch (keyCode) {
            case 19:
                if (this.f1732b - 8 >= 0 && this.f1732b - 8 < 16) {
                    this.f1732b -= 8;
                    invalidate();
                    return true;
                }
                break;
            case 20:
                if (this.f1732b + 8 >= 0 && this.f1732b + 8 < 16) {
                    this.f1732b += 8;
                    invalidate();
                    return true;
                }
                break;
            case 21:
                if (this.f1732b - 1 >= 0 && this.f1732b - 1 < 16) {
                    this.f1732b--;
                    invalidate();
                    return true;
                }
                break;
            case 22:
                if (this.f1732b + 1 >= 0 && this.f1732b + 1 < 16) {
                    this.f1732b++;
                    invalidate();
                    return true;
                }
                break;
            case 23:
                if (this.f1739i == null) {
                    return true;
                }
                this.f1739i.mo804a(this.f1733c[this.f1732b], this.f1732b, true);
                return true;
            case 66:
                if (this.f1739i == null) {
                    return true;
                }
                this.f1739i.mo804a(this.f1733c[this.f1732b], this.f1732b, true);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft() + 0, getPaddingTop() + 0);
        m1548a(canvas);
        m1550b(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private void m1548a(Canvas canvas) {
        if (this.f1734d != null) {
            Rect rect = new Rect(this.f1735e);
            for (int i = 0; i < 2; i++) {
                for (int i2 = 0; i2 < 8; i2++) {
                    int i3 = this.f1733c[(i * 8) + i2];
                    this.f1738h.setColor(i3);
                    if (i3 == -16777217) {
                        this.f1742l.setBounds(rect);
                        this.f1742l.draw(canvas);
                    } else {
                        canvas.drawRect(rect, this.f1738h);
                        this.f1741k.setBounds(rect);
                        this.f1741k.draw(canvas);
                    }
                    rect.offset(rect.width() + 2, 0);
                }
                rect.offset(-rect.left, rect.height() + 3);
            }
        }
    }

    /* renamed from: b */
    private void m1550b(Canvas canvas) {
        int i = this.f1732b % 8;
        int i2 = this.f1732b / 8;
        this.f1736f.set(this.f1735e);
        this.f1736f.offset(i * (this.f1736f.width() + 2), i2 * (this.f1736f.height() + 3));
        Rect rect = this.f1736f;
        rect.left--;
        Rect rect2 = this.f1736f;
        rect2.top--;
        this.f1736f.right++;
        this.f1736f.bottom++;
        this.f1740j.setBounds(this.f1736f);
        this.f1740j.draw(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int iM1547a = this.f1732b;
        int action = event.getAction();
        if ((action == 2 || action == 0 || action == 1) && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        switch (event.getAction()) {
            case 0:
            case 2:
                iM1547a = m1547a(event.getX(), event.getY());
                break;
            case 1:
                playSoundEffect(0);
                break;
        }
        if (iM1547a != this.f1732b) {
            if (iM1547a != 15 || event.getAction() == 0) {
                this.f1732b = iM1547a;
            }
            if (this.f1739i != null) {
                this.f1739i.mo804a(this.f1733c[this.f1732b], this.f1732b, false);
            }
            invalidate();
        } else if (iM1547a == m1555b() - 1 && this.f1739i != null) {
            this.f1739i.mo804a(this.f1733c[this.f1732b], -1, false);
        }
        return true;
    }

    /* renamed from: a */
    private int m1547a(float f, float f2) {
        int i = 1;
        int i2 = 1;
        while (i2 <= 8 && f >= (this.f1735e.width() + 2) * i2) {
            i2++;
        }
        while (i <= 2 && f2 >= this.f1735e.height() * i) {
            i++;
        }
        return (((i <= 2 ? i : 2) - 1) * 8) + ((i2 <= 8 ? i2 : 8) - 1);
    }

    /* renamed from: b */
    private void m1549b(int i) {
        if (((-16777216) | i) == -10000537) {
            i = -16777216;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f1733c.length) {
                break;
            }
            if (i != this.f1733c[i2]) {
                i2++;
            } else {
                this.f1732b = i2;
                break;
            }
        }
        invalidate();
    }

    /* renamed from: a */
    public void m1552a(int i) {
        if ((i & (-16777216)) != -33554432) {
            if (i == -10000537) {
                i = -16777216;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.f1733c.length) {
                    break;
                }
                if (i != this.f1733c[i2]) {
                    i2++;
                } else {
                    this.f1732b = i2;
                    break;
                }
            }
            if (i2 == this.f1733c.length) {
                this.f1732b = 15;
                this.f1733c[15] = i;
            }
        } else {
            this.f1732b = 15;
            this.f1733c[15] = i;
        }
        invalidate();
    }

    /* renamed from: a */
    public int[] m1554a() {
        return this.f1733c;
    }

    /* renamed from: b */
    public int m1555b() {
        return this.f1733c.length;
    }

    /* renamed from: c */
    public int m1556c() {
        return -16777217;
    }
}
