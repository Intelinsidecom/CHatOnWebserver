package com.sec.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SectionIndexer;
import com.sec.chaton.R;

/* compiled from: FastScrollableExpandableListView.java */
/* renamed from: com.sec.widget.i */
/* loaded from: classes.dex */
class C1621i {

    /* renamed from: a */
    private static int f5713a = 1;

    /* renamed from: b */
    private Drawable f5714b;

    /* renamed from: c */
    private Drawable f5715c;

    /* renamed from: d */
    private int f5716d;

    /* renamed from: e */
    private int f5717e;

    /* renamed from: f */
    private int f5718f;

    /* renamed from: g */
    private RectF f5719g;

    /* renamed from: h */
    private int f5720h;

    /* renamed from: i */
    private ExpandableListView f5721i;

    /* renamed from: j */
    private boolean f5722j;

    /* renamed from: k */
    private int f5723k;

    /* renamed from: l */
    private Paint f5724l;

    /* renamed from: m */
    private int f5725m;

    /* renamed from: o */
    private boolean f5727o;

    /* renamed from: p */
    private Object[] f5728p;

    /* renamed from: q */
    private String f5729q;

    /* renamed from: r */
    private boolean f5730r;

    /* renamed from: s */
    private RunnableC1603a f5731s;

    /* renamed from: t */
    private int f5732t;

    /* renamed from: v */
    private ExpandableListAdapter f5734v;

    /* renamed from: w */
    private SectionIndexer f5735w;

    /* renamed from: x */
    private boolean f5736x;

    /* renamed from: n */
    private int f5726n = -1;

    /* renamed from: u */
    private Handler f5733u = new Handler();

    public C1621i(Context context, ExpandableListView expandableListView) {
        this.f5721i = expandableListView;
        m5894a(context);
    }

    /* renamed from: a */
    public void m5900a(int i) {
        switch (i) {
            case 0:
                this.f5733u.removeCallbacks(this.f5731s);
                this.f5721i.invalidate();
                break;
            case 2:
                if (this.f5732t != 2) {
                    m5896d();
                }
            case 3:
                this.f5733u.removeCallbacks(this.f5731s);
                break;
            case 4:
                int width = this.f5721i.getWidth();
                this.f5721i.invalidate(width - this.f5717e, this.f5718f, width, this.f5718f + this.f5716d);
                break;
        }
        this.f5732t = i;
    }

    /* renamed from: a */
    public int m5899a() {
        return this.f5732t;
    }

    /* renamed from: d */
    private void m5896d() {
        int width = this.f5721i.getWidth();
        this.f5714b.setBounds(width - this.f5717e, 0, width, this.f5716d);
        this.f5714b.setAlpha(208);
    }

    /* renamed from: a */
    private void m5895a(Context context, Drawable drawable) {
        this.f5714b = drawable;
        this.f5717e = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_width);
        this.f5716d = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_height);
        this.f5736x = true;
    }

    /* renamed from: a */
    private void m5894a(Context context) {
        Resources resources = context.getResources();
        m5895a(context, resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2));
        this.f5715c = resources.getDrawable(R.drawable.fastscroll_menu_submenu_background);
        this.f5722j = true;
        m5897e();
        this.f5720h = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_overlay_size);
        this.f5719g = new RectF();
        this.f5731s = new RunnableC1603a(this);
        this.f5724l = new Paint();
        this.f5724l.setAntiAlias(true);
        this.f5724l.setTextAlign(Paint.Align.CENTER);
        this.f5724l.setTextSize((this.f5720h * 2) / 3);
        this.f5724l.setColor(-1277150);
        this.f5724l.setStyle(Paint.Style.FILL_AND_STROKE);
        if (this.f5721i.getWidth() > 0 && this.f5721i.getHeight() > 0) {
            m5901a(this.f5721i.getWidth(), this.f5721i.getHeight(), 0, 0);
        }
        this.f5732t = 0;
    }

    /* renamed from: b */
    void m5906b() {
        m5900a(0);
    }

    /* renamed from: c */
    boolean m5908c() {
        return this.f5732t != 0;
    }

    /* renamed from: a */
    public void m5902a(Canvas canvas) {
        if (this.f5732t != 0) {
            int i = this.f5718f;
            int width = this.f5721i.getWidth();
            RunnableC1603a runnableC1603a = this.f5731s;
            int iM5875b = -1;
            if (this.f5732t == 4) {
                iM5875b = runnableC1603a.m5875b();
                if (iM5875b < 104) {
                    this.f5714b.setAlpha(iM5875b * 2);
                }
                this.f5714b.setBounds(width - ((this.f5717e * iM5875b) / 208), 0, width, this.f5716d);
                this.f5736x = true;
            }
            canvas.translate(0.0f, i);
            this.f5714b.draw(canvas);
            canvas.translate(0.0f, -i);
            if (this.f5732t == 3 && this.f5730r) {
                if (this.f5729q.length() != 0) {
                    this.f5715c.draw(canvas);
                    Paint paint = this.f5724l;
                    float fDescent = paint.descent();
                    RectF rectF = this.f5719g;
                    canvas.drawText(this.f5729q, ((int) (rectF.left + rectF.right)) / 2, ((((int) (rectF.top + rectF.bottom)) / 2) + (paint.getTextSize() / 2.0f)) - fDescent, paint);
                    return;
                }
                return;
            }
            if (this.f5732t == 4) {
                if (iM5875b == 0) {
                    m5900a(0);
                } else {
                    this.f5721i.invalidate(width - this.f5717e, i, width, this.f5716d + i);
                }
            }
        }
    }

    /* renamed from: a */
    void m5901a(int i, int i2, int i3, int i4) {
        if (this.f5714b != null) {
            this.f5714b.setBounds(i - this.f5717e, 0, i, this.f5716d);
        }
        RectF rectF = this.f5719g;
        rectF.left = (i - this.f5720h) / 2;
        rectF.right = rectF.left + this.f5720h;
        rectF.top = i2 / 10;
        rectF.bottom = rectF.top + this.f5720h;
        if (this.f5715c != null) {
            this.f5715c.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    /* renamed from: a */
    void m5903a(AbsListView absListView, int i, int i2, int i3) {
        if (this.f5726n != i3 && i2 > 0) {
            this.f5726n = i3;
            this.f5727o = this.f5726n / i2 >= f5713a;
        }
        if (!this.f5727o) {
            if (this.f5732t != 0) {
                m5900a(0);
                return;
            }
            return;
        }
        if (i3 - i2 > 0 && this.f5732t != 3) {
            this.f5718f = ((this.f5721i.getHeight() - this.f5716d) * i) / (i3 - i2);
            if (this.f5736x) {
                m5896d();
                this.f5736x = false;
            }
        }
        this.f5722j = true;
        if (i != this.f5723k) {
            this.f5723k = i;
            if (this.f5732t != 3) {
                m5900a(2);
                this.f5733u.postDelayed(this.f5731s, 1500L);
            }
        }
    }

    /* renamed from: e */
    private void m5897e() {
        ExpandableListAdapter expandableListAdapter = this.f5721i.getExpandableListAdapter();
        this.f5735w = null;
        if (expandableListAdapter instanceof SectionIndexer) {
            this.f5735w = (SectionIndexer) expandableListAdapter;
            this.f5734v = expandableListAdapter;
            this.f5728p = this.f5735w.getSections();
        }
    }

    /* renamed from: a */
    private void m5893a(float f) {
        int i;
        int count = this.f5721i.getCount();
        this.f5722j = false;
        float f2 = (1.0f / count) / 8.0f;
        Object[] objArr = this.f5728p;
        if (objArr != null && objArr.length > 1) {
            int length = objArr.length;
            i = (int) (length * f);
            if (i >= length) {
                i = length - 1;
            }
            this.f5721i.setSelectedGroup(this.f5725m + i);
        } else {
            int i2 = (int) (count * f);
            this.f5721i.setSelectionFromTop(this.f5721i.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f5725m + i2)), 0);
            this.f5721i.setSelection(i2 + this.f5725m);
            i = -1;
        }
        if (i >= 0) {
            String string = objArr[i].toString();
            this.f5729q = string;
            this.f5730r = !(string.length() == 1 && string.charAt(0) == ' ') && i < objArr.length;
            return;
        }
        this.f5730r = false;
    }

    /* renamed from: f */
    private void m5898f() {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.f5721i.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: a */
    boolean m5905a(MotionEvent motionEvent) {
        if (this.f5732t <= 0 || motionEvent.getAction() != 0 || !m5904a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        m5900a(3);
        return true;
    }

    /* renamed from: b */
    boolean m5907b(MotionEvent motionEvent) {
        int i = 0;
        if (this.f5732t == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!m5904a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m5900a(3);
            if (this.f5734v == null && this.f5721i != null) {
                m5897e();
            }
            if (this.f5721i != null) {
                this.f5721i.requestDisallowInterceptTouchEvent(true);
            }
            m5898f();
            return true;
        }
        if (action == 1) {
            if (this.f5732t != 3) {
                return false;
            }
            if (this.f5721i != null) {
                this.f5721i.requestDisallowInterceptTouchEvent(false);
            }
            m5900a(2);
            Handler handler = this.f5733u;
            handler.removeCallbacks(this.f5731s);
            handler.postDelayed(this.f5731s, 1000L);
            return true;
        }
        if (action != 2 || this.f5732t != 3) {
            return false;
        }
        int height = this.f5721i.getHeight();
        int y = (((int) motionEvent.getY()) - this.f5716d) + 10;
        if (y >= 0) {
            i = this.f5716d + y > height ? height - this.f5716d : y;
        }
        if (Math.abs(this.f5718f - i) < 2) {
            return true;
        }
        this.f5718f = i;
        if (this.f5722j) {
            m5893a(this.f5718f / (height - this.f5716d));
        }
        return true;
    }

    /* renamed from: a */
    boolean m5904a(float f, float f2) {
        return f > ((float) (this.f5721i.getWidth() - this.f5717e)) && f2 >= ((float) this.f5718f) && f2 <= ((float) (this.f5718f + this.f5716d));
    }
}
