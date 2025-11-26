package com.sec.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.sec.chaton.R;

/* compiled from: FastScrollableListView.java */
/* renamed from: com.sec.widget.x */
/* loaded from: classes.dex */
class C1636x {

    /* renamed from: a */
    private static int f5760a = 4;

    /* renamed from: b */
    private Drawable f5761b;

    /* renamed from: c */
    private Drawable f5762c;

    /* renamed from: d */
    private int f5763d;

    /* renamed from: e */
    private int f5764e;

    /* renamed from: f */
    private int f5765f;

    /* renamed from: g */
    private RectF f5766g;

    /* renamed from: h */
    private int f5767h;

    /* renamed from: i */
    private AbsListView f5768i;

    /* renamed from: j */
    private boolean f5769j;

    /* renamed from: k */
    private int f5770k;

    /* renamed from: l */
    private Paint f5771l;

    /* renamed from: m */
    private int f5772m;

    /* renamed from: o */
    private boolean f5774o;

    /* renamed from: p */
    private Object[] f5775p;

    /* renamed from: q */
    private String f5776q;

    /* renamed from: r */
    private boolean f5777r;

    /* renamed from: s */
    private RunnableC1624l f5778s;

    /* renamed from: t */
    private int f5779t;

    /* renamed from: v */
    private BaseAdapter f5781v;

    /* renamed from: w */
    private SectionIndexer f5782w;

    /* renamed from: x */
    private boolean f5783x;

    /* renamed from: n */
    private int f5773n = -1;

    /* renamed from: u */
    private Handler f5780u = new Handler();

    public C1636x(Context context, AbsListView absListView) {
        this.f5768i = absListView;
        m5926a(context);
    }

    /* renamed from: a */
    public void m5932a(int i) {
        switch (i) {
            case 0:
                this.f5780u.removeCallbacks(this.f5778s);
                this.f5768i.invalidate();
                break;
            case 2:
                if (this.f5779t != 2) {
                    m5928d();
                }
            case 3:
                this.f5780u.removeCallbacks(this.f5778s);
                break;
            case 4:
                int width = this.f5768i.getWidth();
                this.f5768i.invalidate(width - this.f5764e, this.f5765f, width, this.f5765f + this.f5763d);
                break;
        }
        this.f5779t = i;
    }

    /* renamed from: a */
    public int m5931a() {
        return this.f5779t;
    }

    /* renamed from: d */
    private void m5928d() {
        int width = this.f5768i.getWidth();
        this.f5761b.setBounds(width - this.f5764e, 0, width, this.f5763d);
        this.f5761b.setAlpha(208);
    }

    /* renamed from: a */
    private void m5927a(Context context, Drawable drawable) {
        this.f5761b = drawable;
        this.f5764e = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_width);
        this.f5763d = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_height);
        this.f5783x = true;
    }

    /* renamed from: a */
    private void m5926a(Context context) {
        Resources resources = context.getResources();
        m5927a(context, resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2));
        this.f5762c = resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2);
        this.f5769j = true;
        m5929e();
        this.f5767h = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_overlay_size);
        this.f5766g = new RectF();
        this.f5778s = new RunnableC1624l(this);
        this.f5771l = new Paint();
        this.f5771l.setAntiAlias(true);
        this.f5771l.setTextAlign(Paint.Align.CENTER);
        this.f5771l.setTextSize(this.f5767h / 2);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.textColorPrimary});
        this.f5771l.setColor(typedArrayObtainStyledAttributes.getColorStateList(typedArrayObtainStyledAttributes.getIndex(0)).getDefaultColor());
        this.f5771l.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f5779t = 0;
    }

    /* renamed from: b */
    void m5938b() {
        m5932a(0);
    }

    /* renamed from: c */
    boolean m5940c() {
        return this.f5779t != 0;
    }

    /* renamed from: a */
    public void m5934a(Canvas canvas) {
        if (this.f5779t != 0) {
            int i = this.f5765f;
            int width = this.f5768i.getWidth();
            RunnableC1624l runnableC1624l = this.f5778s;
            int iM5910b = -1;
            if (this.f5779t == 4) {
                iM5910b = runnableC1624l.m5910b();
                if (iM5910b < 104) {
                    this.f5761b.setAlpha(iM5910b * 2);
                }
                this.f5761b.setBounds(width - ((this.f5764e * iM5910b) / 208), 0, width, this.f5763d);
                this.f5783x = true;
            }
            canvas.translate(0.0f, i);
            this.f5761b.draw(canvas);
            canvas.translate(0.0f, -i);
            if (this.f5779t == 3 && this.f5777r) {
                this.f5762c.draw(canvas);
                Paint paint = this.f5771l;
                float fDescent = paint.descent();
                RectF rectF = this.f5766g;
                canvas.drawText(this.f5776q, ((int) (rectF.left + rectF.right)) / 2, ((((int) (rectF.top + rectF.bottom)) / 2) + (this.f5767h / 4)) - fDescent, paint);
                return;
            }
            if (this.f5779t == 4) {
                if (iM5910b == 0) {
                    m5932a(0);
                } else {
                    this.f5768i.invalidate(width - this.f5764e, i, width, this.f5763d + i);
                }
            }
        }
    }

    /* renamed from: a */
    void m5933a(int i, int i2, int i3, int i4) {
        if (this.f5761b != null) {
            this.f5761b.setBounds(i - this.f5764e, 0, i, this.f5763d);
        }
        RectF rectF = this.f5766g;
        rectF.left = (i - this.f5767h) / 2;
        rectF.right = rectF.left + this.f5767h;
        rectF.top = i2 / 10;
        rectF.bottom = rectF.top + this.f5767h;
        if (this.f5762c != null) {
            this.f5762c.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    /* renamed from: a */
    void m5935a(AbsListView absListView, int i, int i2, int i3) {
        if (this.f5773n != i3 && i2 > 0) {
            this.f5773n = i3;
            this.f5774o = this.f5773n / i2 >= f5760a;
        }
        if (!this.f5774o) {
            if (this.f5779t != 0) {
                m5932a(0);
                return;
            }
            return;
        }
        if (i3 - i2 > 0 && this.f5779t != 3) {
            this.f5765f = ((this.f5768i.getHeight() - this.f5763d) * i) / (i3 - i2);
            if (this.f5783x) {
                m5928d();
                this.f5783x = false;
            }
        }
        this.f5769j = true;
        if (i != this.f5770k) {
            this.f5770k = i;
            if (this.f5779t != 3) {
                m5932a(2);
                this.f5780u.postDelayed(this.f5778s, 1500L);
            }
        }
    }

    /* renamed from: e */
    private void m5929e() {
        Object adapter = this.f5768i.getAdapter();
        this.f5782w = null;
        if (adapter instanceof HeaderViewListAdapter) {
            this.f5772m = ((HeaderViewListAdapter) adapter).getHeadersCount();
            adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        if (adapter instanceof SectionIndexer) {
            this.f5781v = (BaseAdapter) adapter;
            this.f5782w = (SectionIndexer) adapter;
            this.f5775p = this.f5782w.getSections();
        } else {
            this.f5781v = (BaseAdapter) adapter;
            this.f5775p = new String[]{" "};
        }
    }

    /* renamed from: a */
    private void m5925a(float f) {
        int i;
        int i2;
        int count = this.f5768i.getCount();
        this.f5769j = false;
        float f2 = (1.0f / count) / 8.0f;
        Object[] objArr = this.f5775p;
        if (objArr != null && objArr.length > 1) {
            int length = objArr.length;
            int i3 = (int) (length * f);
            if (i3 >= length) {
                i3 = length - 1;
            }
            int positionForSection = this.f5782w.getPositionForSection(i3);
            int i4 = i3 + 1;
            int positionForSection2 = i3 < length + (-1) ? this.f5782w.getPositionForSection(i3 + 1) : count;
            if (positionForSection2 == positionForSection) {
                int i5 = positionForSection;
                int i6 = i3;
                while (true) {
                    if (i6 <= 0) {
                        positionForSection = i5;
                        i = i3;
                        i2 = i3;
                        break;
                    }
                    i2 = i6 - 1;
                    int positionForSection3 = this.f5782w.getPositionForSection(i2);
                    if (positionForSection3 != positionForSection) {
                        positionForSection = positionForSection3;
                        i = i2;
                        break;
                    } else {
                        if (i2 == 0) {
                            positionForSection = positionForSection3;
                            i = 0;
                            i2 = i3;
                            break;
                        }
                        i6 = i2;
                        i5 = positionForSection3;
                    }
                }
            } else {
                i2 = i3;
                i = i3;
            }
            int i7 = i4 + 1;
            while (i7 < length && this.f5782w.getPositionForSection(i7) == positionForSection2) {
                i7++;
                i4++;
            }
            float f3 = i2 / length;
            int i8 = (i2 != i3 || f - f3 >= f2) ? ((int) (((positionForSection2 - positionForSection) * (f - f3)) / ((i4 / length) - f3))) + positionForSection : positionForSection;
            int i9 = i8 > count + (-1) ? count - 1 : i8;
            if (this.f5768i instanceof ExpandableListView) {
                ExpandableListView expandableListView = (ExpandableListView) this.f5768i;
                expandableListView.setSelectionFromTop(expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i9 + this.f5772m)), 0);
            } else if (this.f5768i instanceof ListView) {
                ((ListView) this.f5768i).setSelectionFromTop(i9 + this.f5772m, 0);
            } else {
                this.f5768i.setSelection(i9 + this.f5772m);
            }
        } else {
            int i10 = (int) (count * f);
            if (this.f5768i instanceof ExpandableListView) {
                ExpandableListView expandableListView2 = (ExpandableListView) this.f5768i;
                expandableListView2.setSelectionFromTop(expandableListView2.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i10 + this.f5772m)), 0);
            } else if (this.f5768i instanceof ListView) {
                ((ListView) this.f5768i).setSelectionFromTop(i10 + this.f5772m, 0);
            } else {
                this.f5768i.setSelection(i10 + this.f5772m);
            }
            i = -1;
        }
        if (i >= 0) {
            String string = objArr[i].toString();
            this.f5776q = string;
            this.f5777r = !(string.length() == 1 && string.charAt(0) == ' ') && i < objArr.length;
            return;
        }
        this.f5777r = false;
    }

    /* renamed from: f */
    private void m5930f() {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.f5768i.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: a */
    boolean m5937a(MotionEvent motionEvent) {
        if (this.f5779t <= 0 || motionEvent.getAction() != 0 || !m5936a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        m5932a(3);
        return true;
    }

    /* renamed from: b */
    boolean m5939b(MotionEvent motionEvent) {
        int i = 0;
        if (this.f5779t == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!m5936a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m5932a(3);
            if (this.f5781v == null && this.f5768i != null) {
                m5929e();
            }
            if (this.f5768i != null) {
                this.f5768i.requestDisallowInterceptTouchEvent(true);
            }
            m5930f();
            return true;
        }
        if (action == 1) {
            if (this.f5779t != 3) {
                return false;
            }
            if (this.f5768i != null) {
                this.f5768i.requestDisallowInterceptTouchEvent(false);
            }
            m5932a(2);
            Handler handler = this.f5780u;
            handler.removeCallbacks(this.f5778s);
            handler.postDelayed(this.f5778s, 1000L);
            return true;
        }
        if (action != 2 || this.f5779t != 3) {
            return false;
        }
        int height = this.f5768i.getHeight();
        int y = (((int) motionEvent.getY()) - this.f5763d) + 10;
        if (y >= 0) {
            i = this.f5763d + y > height ? height - this.f5763d : y;
        }
        if (Math.abs(this.f5765f - i) < 2) {
            return true;
        }
        this.f5765f = i;
        if (this.f5769j) {
            m5925a(this.f5765f / (height - this.f5763d));
        }
        return true;
    }

    /* renamed from: a */
    boolean m5936a(float f, float f2) {
        return f > ((float) (this.f5768i.getWidth() - this.f5764e)) && f2 >= ((float) this.f5765f) && f2 <= ((float) (this.f5765f + this.f5763d));
    }
}
