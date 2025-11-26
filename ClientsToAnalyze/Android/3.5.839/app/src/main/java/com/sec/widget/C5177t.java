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
/* renamed from: com.sec.widget.t */
/* loaded from: classes.dex */
class C5177t {

    /* renamed from: a */
    private static int f18943a = 4;

    /* renamed from: b */
    private Drawable f18944b;

    /* renamed from: c */
    private Drawable f18945c;

    /* renamed from: d */
    private int f18946d;

    /* renamed from: e */
    private int f18947e;

    /* renamed from: f */
    private int f18948f;

    /* renamed from: g */
    private RectF f18949g;

    /* renamed from: h */
    private int f18950h;

    /* renamed from: i */
    private AbsListView f18951i;

    /* renamed from: j */
    private boolean f18952j;

    /* renamed from: k */
    private int f18953k;

    /* renamed from: l */
    private Paint f18954l;

    /* renamed from: m */
    private int f18955m;

    /* renamed from: o */
    private boolean f18957o;

    /* renamed from: p */
    private Object[] f18958p;

    /* renamed from: q */
    private String f18959q;

    /* renamed from: r */
    private boolean f18960r;

    /* renamed from: s */
    private RunnableC5178u f18961s;

    /* renamed from: t */
    private int f18962t;

    /* renamed from: v */
    private BaseAdapter f18964v;

    /* renamed from: w */
    private SectionIndexer f18965w;

    /* renamed from: x */
    private boolean f18966x;

    /* renamed from: n */
    private int f18956n = -1;

    /* renamed from: u */
    private Handler f18963u = new Handler();

    public C5177t(Context context, AbsListView absListView) {
        this.f18951i = absListView;
        m19793a(context);
    }

    /* renamed from: a */
    public void m19799a(int i) {
        switch (i) {
            case 0:
                this.f18963u.removeCallbacks(this.f18961s);
                this.f18951i.invalidate();
                break;
            case 2:
                if (this.f18962t != 2) {
                    m19795d();
                }
            case 3:
                this.f18963u.removeCallbacks(this.f18961s);
                break;
            case 4:
                int width = this.f18951i.getWidth();
                this.f18951i.invalidate(width - this.f18947e, this.f18948f, width, this.f18948f + this.f18946d);
                break;
        }
        this.f18962t = i;
    }

    /* renamed from: a */
    public int m19798a() {
        return this.f18962t;
    }

    /* renamed from: d */
    private void m19795d() {
        if (this.f18951i != null) {
            int width = this.f18951i.getWidth();
            this.f18944b.setBounds(width - this.f18947e, 0, width, this.f18946d);
        }
    }

    /* renamed from: a */
    private void m19794a(Context context, Drawable drawable) {
        this.f18944b = drawable;
        this.f18947e = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_width);
        this.f18946d = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_thumb_height);
        this.f18966x = true;
    }

    /* renamed from: a */
    private void m19793a(Context context) {
        Resources resources = context.getResources();
        m19794a(context, resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2));
        this.f18945c = resources.getDrawable(R.drawable.fastscrollbar_handle_accelerated_anim2);
        this.f18952j = true;
        m19796e();
        this.f18950h = context.getResources().getDimensionPixelSize(R.dimen.fastscroll_overlay_size);
        this.f18949g = new RectF();
        this.f18961s = new RunnableC5178u(this);
        this.f18954l = new Paint();
        this.f18954l.setAntiAlias(true);
        this.f18954l.setTextAlign(Paint.Align.CENTER);
        this.f18954l.setTextSize(this.f18950h / 2);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.textColorPrimary});
        this.f18954l.setColor(typedArrayObtainStyledAttributes.getColorStateList(typedArrayObtainStyledAttributes.getIndex(0)).getDefaultColor());
        this.f18954l.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f18962t = 0;
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    void m19805b() {
        m19799a(0);
    }

    /* renamed from: c */
    boolean m19807c() {
        return this.f18962t != 0;
    }

    /* renamed from: a */
    public void m19801a(Canvas canvas) {
        if (this.f18962t != 0) {
            int i = this.f18948f;
            int width = this.f18951i.getWidth();
            RunnableC5178u runnableC5178u = this.f18961s;
            int iM19809b = -1;
            if (this.f18962t == 4) {
                iM19809b = runnableC5178u.m19809b();
                if (iM19809b < 104) {
                }
                this.f18944b.setBounds(width - ((this.f18947e * iM19809b) / 208), 0, width, this.f18946d);
                this.f18966x = true;
            }
            canvas.translate(0.0f, i);
            this.f18944b.draw(canvas);
            canvas.translate(0.0f, -i);
            if (this.f18962t == 3 && this.f18960r) {
                this.f18945c.draw(canvas);
                Paint paint = this.f18954l;
                float fDescent = paint.descent();
                RectF rectF = this.f18949g;
                canvas.drawText(this.f18959q, ((int) (rectF.left + rectF.right)) / 2, ((((int) (rectF.top + rectF.bottom)) / 2) + (this.f18950h / 4)) - fDescent, paint);
                return;
            }
            if (this.f18962t == 4) {
                if (iM19809b == 0) {
                    m19799a(0);
                } else {
                    this.f18951i.invalidate(width - this.f18947e, i, width, this.f18946d + i);
                }
            }
        }
    }

    /* renamed from: a */
    void m19800a(int i, int i2, int i3, int i4) {
        if (this.f18944b != null) {
            this.f18944b.setBounds(i - this.f18947e, 0, i, this.f18946d);
        }
        RectF rectF = this.f18949g;
        rectF.left = (i - this.f18950h) / 2;
        rectF.right = rectF.left + this.f18950h;
        rectF.top = i2 / 10;
        rectF.bottom = rectF.top + this.f18950h;
        if (this.f18945c != null) {
            this.f18945c.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    /* renamed from: a */
    void m19802a(AbsListView absListView, int i, int i2, int i3) {
        if (this.f18956n != i3 && i2 > 0) {
            this.f18956n = i3;
            this.f18957o = this.f18956n / i2 >= f18943a;
        }
        if (!this.f18957o) {
            if (this.f18962t != 0) {
                m19799a(0);
                return;
            }
            return;
        }
        if (i3 - i2 > 0 && this.f18962t != 3) {
            this.f18948f = ((this.f18951i.getHeight() - this.f18946d) * i) / (i3 - i2);
            if (this.f18966x) {
                m19795d();
                this.f18966x = false;
            }
        }
        this.f18952j = true;
        if (i != this.f18953k) {
            this.f18953k = i;
            if (this.f18962t != 3) {
                m19799a(2);
                this.f18963u.postDelayed(this.f18961s, 1500L);
            }
        }
    }

    /* renamed from: e */
    private void m19796e() {
        Object adapter = this.f18951i.getAdapter();
        this.f18965w = null;
        if (adapter instanceof HeaderViewListAdapter) {
            this.f18955m = ((HeaderViewListAdapter) adapter).getHeadersCount();
            adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        if (adapter instanceof SectionIndexer) {
            this.f18964v = (BaseAdapter) adapter;
            this.f18965w = (SectionIndexer) adapter;
            this.f18958p = this.f18965w.getSections();
        } else {
            this.f18964v = (BaseAdapter) adapter;
            this.f18958p = new String[]{" "};
        }
    }

    /* renamed from: a */
    private void m19792a(float f) {
        int i;
        int i2;
        int count = this.f18951i.getCount();
        this.f18952j = false;
        float f2 = (1.0f / count) / 8.0f;
        Object[] objArr = this.f18958p;
        if (objArr != null && objArr.length > 1) {
            int length = objArr.length;
            int i3 = (int) (length * f);
            if (i3 >= length) {
                i3 = length - 1;
            }
            int positionForSection = this.f18965w.getPositionForSection(i3);
            int i4 = i3 + 1;
            int positionForSection2 = i3 < length + (-1) ? this.f18965w.getPositionForSection(i3 + 1) : count;
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
                    int positionForSection3 = this.f18965w.getPositionForSection(i2);
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
            while (i7 < length && this.f18965w.getPositionForSection(i7) == positionForSection2) {
                i7++;
                i4++;
            }
            float f3 = i2 / length;
            int i8 = (i2 != i3 || f - f3 >= f2) ? ((int) (((positionForSection2 - positionForSection) * (f - f3)) / ((i4 / length) - f3))) + positionForSection : positionForSection;
            int i9 = i8 > count + (-1) ? count - 1 : i8;
            if (this.f18951i instanceof ExpandableListView) {
                ExpandableListView expandableListView = (ExpandableListView) this.f18951i;
                expandableListView.setSelectionFromTop(expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i9 + this.f18955m)), 0);
            } else if (this.f18951i instanceof ListView) {
                ((ListView) this.f18951i).setSelectionFromTop(i9 + this.f18955m, 0);
            } else {
                this.f18951i.setSelection(i9 + this.f18955m);
            }
        } else {
            int i10 = (int) (count * f);
            if (this.f18951i instanceof ExpandableListView) {
                ExpandableListView expandableListView2 = (ExpandableListView) this.f18951i;
                expandableListView2.setSelectionFromTop(expandableListView2.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i10 + this.f18955m)), 0);
            } else if (this.f18951i instanceof ListView) {
                ((ListView) this.f18951i).setSelectionFromTop(i10 + this.f18955m, 0);
            } else {
                this.f18951i.setSelection(i10 + this.f18955m);
            }
            i = -1;
        }
        if (i >= 0) {
            String string = objArr[i].toString();
            this.f18959q = string;
            this.f18960r = !(string.length() == 1 && string.charAt(0) == ' ') && i < objArr.length;
            return;
        }
        this.f18960r = false;
    }

    /* renamed from: f */
    private void m19797f() {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.f18951i.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: a */
    boolean m19804a(MotionEvent motionEvent) {
        if (this.f18962t <= 0 || motionEvent.getAction() != 0 || !m19803a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        m19799a(3);
        return true;
    }

    /* renamed from: b */
    boolean m19806b(MotionEvent motionEvent) {
        int i = 0;
        if (this.f18962t == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!m19803a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m19799a(3);
            if (this.f18964v == null && this.f18951i != null) {
                m19796e();
            }
            if (this.f18951i != null) {
                this.f18951i.requestDisallowInterceptTouchEvent(true);
                m19797f();
            }
            return true;
        }
        if (action == 1) {
            if (this.f18962t != 3) {
                return false;
            }
            if (this.f18951i != null) {
                this.f18951i.requestDisallowInterceptTouchEvent(false);
            }
            m19799a(2);
            Handler handler = this.f18963u;
            handler.removeCallbacks(this.f18961s);
            handler.postDelayed(this.f18961s, 1000L);
            return true;
        }
        if (action != 2 || this.f18962t != 3) {
            return false;
        }
        int height = this.f18951i.getHeight();
        int y = (((int) motionEvent.getY()) - this.f18946d) + 10;
        if (y >= 0) {
            i = this.f18946d + y > height ? height - this.f18946d : y;
        }
        if (Math.abs(this.f18948f - i) < 2) {
            return true;
        }
        this.f18948f = i;
        if (this.f18952j) {
            m19792a(this.f18948f / (height - this.f18946d));
        }
        return true;
    }

    /* renamed from: a */
    boolean m19803a(float f, float f2) {
        return f > ((float) (this.f18951i.getWidth() - this.f18947e)) && f2 >= ((float) this.f18948f) && f2 <= ((float) (this.f18948f + this.f18946d));
    }
}
