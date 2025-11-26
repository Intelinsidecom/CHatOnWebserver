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
/* renamed from: com.sec.widget.p */
/* loaded from: classes.dex */
class C5173p {

    /* renamed from: a */
    private static int f18915a = 1;

    /* renamed from: b */
    private Drawable f18916b;

    /* renamed from: c */
    private Drawable f18917c;

    /* renamed from: d */
    private int f18918d;

    /* renamed from: e */
    private int f18919e;

    /* renamed from: f */
    private int f18920f;

    /* renamed from: g */
    private RectF f18921g;

    /* renamed from: h */
    private int f18922h;

    /* renamed from: i */
    private ExpandableListView f18923i;

    /* renamed from: j */
    private boolean f18924j;

    /* renamed from: k */
    private int f18925k;

    /* renamed from: l */
    private Paint f18926l;

    /* renamed from: m */
    private int f18927m;

    /* renamed from: o */
    private boolean f18929o;

    /* renamed from: p */
    private Object[] f18930p;

    /* renamed from: q */
    private String f18931q;

    /* renamed from: r */
    private boolean f18932r;

    /* renamed from: s */
    private RunnableC5174q f18933s;

    /* renamed from: t */
    private int f18934t;

    /* renamed from: v */
    private ExpandableListAdapter f18936v;

    /* renamed from: w */
    private SectionIndexer f18937w;

    /* renamed from: x */
    private boolean f18938x;

    /* renamed from: n */
    private int f18928n = -1;

    /* renamed from: u */
    private Handler f18935u = new Handler();

    public C5173p(Context context, ExpandableListView expandableListView) {
        this.f18923i = expandableListView;
        m19772a(context);
    }

    /* renamed from: a */
    public void m19778a(int i) {
        switch (i) {
            case 0:
                this.f18935u.removeCallbacks(this.f18933s);
                this.f18923i.invalidate();
                break;
            case 2:
                if (this.f18934t != 2) {
                    m19774d();
                }
            case 3:
                this.f18935u.removeCallbacks(this.f18933s);
                break;
            case 4:
                int width = this.f18923i.getWidth();
                this.f18923i.invalidate(width - this.f18919e, this.f18920f, width, this.f18920f + this.f18918d);
                break;
        }
        this.f18934t = i;
    }

    /* renamed from: a */
    public int m19777a() {
        return this.f18934t;
    }

    /* renamed from: d */
    private void m19774d() {
        if (this.f18923i != null) {
            int width = this.f18923i.getWidth();
            this.f18916b.setBounds(width - this.f18919e, 0, width, this.f18918d);
        }
    }

    /* renamed from: a */
    private void m19773a(Context context, Drawable drawable) {
        this.f18916b = drawable;
        this.f18919e = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_width);
        this.f18918d = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_height);
        this.f18938x = true;
    }

    /* renamed from: a */
    private void m19772a(Context context) {
        Resources resources = context.getResources();
        m19773a(context, resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2));
        this.f18917c = resources.getDrawable(R.drawable.fastscroll_menu_submenu_background);
        this.f18924j = true;
        m19775e();
        this.f18922h = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_overlay_size);
        this.f18921g = new RectF();
        this.f18933s = new RunnableC5174q(this);
        this.f18926l = new Paint();
        this.f18926l.setAntiAlias(true);
        this.f18926l.setTextAlign(Paint.Align.CENTER);
        this.f18926l.setTextSize((float) (this.f18922h * 0.75d));
        this.f18926l.setColor(-1277150);
        this.f18926l.setStyle(Paint.Style.FILL_AND_STROKE);
        if (this.f18923i.getWidth() > 0 && this.f18923i.getHeight() > 0) {
            m19779a(this.f18923i.getWidth(), this.f18923i.getHeight(), 0, 0);
        }
        this.f18934t = 0;
    }

    /* renamed from: b */
    void m19784b() {
        m19778a(0);
    }

    /* renamed from: c */
    boolean m19786c() {
        return this.f18934t != 0;
    }

    /* renamed from: a */
    public void m19780a(Canvas canvas) {
        if (this.f18934t != 0) {
            int i = this.f18920f;
            int width = this.f18923i.getWidth();
            RunnableC5174q runnableC5174q = this.f18933s;
            int iM19788b = -1;
            if (this.f18934t == 4) {
                iM19788b = runnableC5174q.m19788b();
                if (iM19788b < 104) {
                }
                this.f18916b.setBounds(width - ((this.f18919e * iM19788b) / 208), 0, width, this.f18918d);
                this.f18938x = true;
            }
            canvas.translate(0.0f, i);
            this.f18916b.draw(canvas);
            canvas.translate(0.0f, -i);
            if (this.f18934t == 3 && this.f18932r) {
                if (this.f18931q.length() != 0) {
                    this.f18917c.draw(canvas);
                    Paint paint = this.f18926l;
                    float fDescent = paint.descent();
                    RectF rectF = this.f18921g;
                    canvas.drawText(this.f18931q, (rectF.left + rectF.right) / 2.0f, (float) ((((rectF.top + rectF.bottom) / 2.0f) + (paint.getTextSize() / 2.0f)) - (fDescent / 1.5d)), paint);
                    return;
                }
                return;
            }
            if (this.f18934t == 4) {
                if (iM19788b == 0) {
                    m19778a(0);
                } else {
                    this.f18923i.invalidate(width - this.f18919e, i, width, this.f18918d + i);
                }
            }
        }
    }

    /* renamed from: a */
    void m19779a(int i, int i2, int i3, int i4) {
        if (this.f18916b != null) {
            this.f18916b.setBounds(i - this.f18919e, 0, i, this.f18918d);
        }
        RectF rectF = this.f18921g;
        rectF.left = (i - this.f18922h) / 2;
        rectF.right = rectF.left + this.f18922h;
        rectF.top = i2 / 10;
        rectF.bottom = rectF.top + this.f18922h;
        if (this.f18917c != null) {
            this.f18917c.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    /* renamed from: a */
    void m19781a(AbsListView absListView, int i, int i2, int i3) {
        if (this.f18928n != i3 && i2 > 0) {
            this.f18928n = i3;
            this.f18929o = this.f18928n / i2 >= f18915a;
        }
        if (!this.f18929o) {
            if (this.f18934t != 0) {
                m19778a(0);
                return;
            }
            return;
        }
        if (i3 - i2 > 0 && this.f18934t != 3) {
            this.f18920f = ((this.f18923i.getHeight() - this.f18918d) * i) / (i3 - i2);
            if (this.f18938x) {
                m19774d();
                this.f18938x = false;
            }
        }
        this.f18924j = true;
        if (i != this.f18925k) {
            this.f18925k = i;
            if (this.f18934t != 3) {
                m19778a(2);
                this.f18935u.postDelayed(this.f18933s, 1500L);
                this.f18932r = false;
            }
        }
    }

    /* renamed from: e */
    private void m19775e() {
        ExpandableListAdapter expandableListAdapter = this.f18923i.getExpandableListAdapter();
        this.f18937w = null;
        if (expandableListAdapter instanceof SectionIndexer) {
            this.f18937w = (SectionIndexer) expandableListAdapter;
            this.f18936v = expandableListAdapter;
            this.f18930p = this.f18937w.getSections();
        }
    }

    /* renamed from: a */
    private void m19771a(float f) {
        int i;
        int count = this.f18923i.getCount();
        this.f18924j = false;
        Object[] objArr = this.f18930p;
        if (objArr != null && objArr.length > 1) {
            int length = objArr.length;
            i = (int) (length * f);
            if (i >= length) {
                i = length - 1;
            }
            this.f18923i.setSelectedGroup(this.f18927m + i);
        } else {
            int i2 = (int) (count * f);
            this.f18923i.setSelectionFromTop(this.f18923i.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f18927m + i2)), 0);
            this.f18923i.setSelection(i2 + this.f18927m);
            i = -1;
        }
        if (i >= 0) {
            String string = objArr[i].toString();
            this.f18931q = string;
            this.f18932r = !(string.length() == 1 && string.charAt(0) == ' ') && i < objArr.length;
            return;
        }
        this.f18932r = false;
    }

    /* renamed from: f */
    private void m19776f() {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.f18923i.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: a */
    boolean m19783a(MotionEvent motionEvent) {
        if (this.f18934t <= 0 || motionEvent.getAction() != 0 || !m19782a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        m19778a(3);
        return true;
    }

    /* renamed from: b */
    boolean m19785b(MotionEvent motionEvent) {
        int i = 0;
        if (this.f18934t == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!m19782a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m19778a(3);
            if (this.f18936v == null && this.f18923i != null) {
                m19775e();
            }
            if (this.f18923i != null) {
                this.f18923i.requestDisallowInterceptTouchEvent(true);
                m19776f();
            }
            return true;
        }
        if (action == 1) {
            if (this.f18934t != 3) {
                return false;
            }
            if (this.f18923i != null) {
                this.f18923i.requestDisallowInterceptTouchEvent(false);
            }
            m19778a(2);
            Handler handler = this.f18935u;
            handler.removeCallbacks(this.f18933s);
            handler.postDelayed(this.f18933s, 1000L);
            return true;
        }
        if (action != 2 || this.f18934t != 3) {
            return false;
        }
        int height = this.f18923i.getHeight();
        int y = (((int) motionEvent.getY()) - this.f18918d) + 10;
        if (y >= 0) {
            i = this.f18918d + y > height ? height - this.f18918d : y;
        }
        if (Math.abs(this.f18920f - i) < 2) {
            return true;
        }
        this.f18920f = i;
        if (this.f18924j) {
            m19771a(this.f18920f / (height - this.f18918d));
        }
        return true;
    }

    /* renamed from: a */
    boolean m19782a(float f, float f2) {
        return f > ((float) (this.f18923i.getWidth() - this.f18919e)) && f2 >= ((float) this.f18920f) && f2 <= ((float) (this.f18920f + this.f18918d));
    }
}
