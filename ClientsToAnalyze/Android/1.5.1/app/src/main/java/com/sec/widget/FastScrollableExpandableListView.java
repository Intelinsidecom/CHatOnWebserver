package com.sec.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SectionIndexer;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class FastScrollableExpandableListView extends ExpandableListView {

    /* renamed from: a */
    private ExpandableFastScroller f4527a;

    /* renamed from: b */
    private AbsListView.OnScrollListener f4528b;

    class ExpandableFastScroller {

        /* renamed from: a */
        private static int f4529a = 1;

        /* renamed from: b */
        private Drawable f4530b;

        /* renamed from: c */
        private Drawable f4531c;

        /* renamed from: d */
        private int f4532d;

        /* renamed from: e */
        private int f4533e;

        /* renamed from: f */
        private int f4534f;

        /* renamed from: g */
        private RectF f4535g;

        /* renamed from: h */
        private int f4536h;

        /* renamed from: i */
        private ExpandableListView f4537i;

        /* renamed from: j */
        private boolean f4538j;

        /* renamed from: k */
        private int f4539k;

        /* renamed from: l */
        private Paint f4540l;

        /* renamed from: m */
        private int f4541m;

        /* renamed from: o */
        private boolean f4543o;

        /* renamed from: p */
        private Object[] f4544p;

        /* renamed from: q */
        private String f4545q;

        /* renamed from: r */
        private boolean f4546r;

        /* renamed from: s */
        private ScrollFade f4547s;

        /* renamed from: t */
        private int f4548t;

        /* renamed from: v */
        private ExpandableListAdapter f4550v;

        /* renamed from: w */
        private SectionIndexer f4551w;

        /* renamed from: x */
        private boolean f4552x;

        /* renamed from: n */
        private int f4542n = -1;

        /* renamed from: u */
        private Handler f4549u = new Handler();

        public class ScrollFade implements Runnable {

            /* renamed from: a */
            long f4553a;

            /* renamed from: b */
            long f4554b;

            public ScrollFade() {
            }

            /* renamed from: a */
            void m4389a() {
                this.f4554b = 200L;
                this.f4553a = SystemClock.uptimeMillis();
                ExpandableFastScroller.this.m4380a(4);
            }

            /* renamed from: b */
            int m4390b() {
                if (ExpandableFastScroller.this.m4379a() != 4) {
                    return 208;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (jUptimeMillis > this.f4553a + this.f4554b) {
                    return 0;
                }
                return (int) (208 - (((jUptimeMillis - this.f4553a) * 208) / this.f4554b));
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ExpandableFastScroller.this.m4379a() != 4) {
                    m4389a();
                } else if (m4390b() > 0) {
                    ExpandableFastScroller.this.f4537i.invalidate();
                } else {
                    ExpandableFastScroller.this.m4380a(0);
                }
            }
        }

        public ExpandableFastScroller(Context context, ExpandableListView expandableListView) {
            this.f4537i = expandableListView;
            m4374a(context);
        }

        /* renamed from: a */
        private void m4373a(float f) {
            int i;
            int count = this.f4537i.getCount();
            this.f4538j = false;
            float f2 = (1.0f / count) / 8.0f;
            Object[] objArr = this.f4544p;
            if (objArr == null || objArr.length <= 1) {
                int i2 = (int) (count * f);
                this.f4537i.setSelectionFromTop(this.f4537i.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f4541m + i2)), 0);
                this.f4537i.setSelection(i2 + this.f4541m);
                i = -1;
            } else {
                int length = objArr.length;
                int i3 = (int) (length * f);
                i = i3 >= length ? length - 1 : i3;
                this.f4537i.setSelectedGroup(this.f4541m + i);
            }
            if (i < 0) {
                this.f4546r = false;
                return;
            }
            String string = objArr[i].toString();
            this.f4545q = string;
            this.f4546r = !(string.length() == 1 && string.charAt(0) == ' ') && i < objArr.length;
        }

        /* renamed from: a */
        private void m4374a(Context context) {
            Resources resources = context.getResources();
            m4375a(context, resources.getDrawable(C0062R.drawable.fastscrollbar_handle_accelerated_anim2));
            this.f4531c = resources.getDrawable(C0062R.drawable.fastscroll_menu_submenu_background);
            this.f4538j = true;
            m4377e();
            this.f4536h = context.getResources().getDimensionPixelSize(C0062R.dimen.fastscroll_overlay_size);
            this.f4535g = new RectF();
            this.f4547s = new ScrollFade();
            this.f4540l = new Paint();
            this.f4540l.setAntiAlias(true);
            this.f4540l.setTextAlign(Paint.Align.CENTER);
            this.f4540l.setTextSize((this.f4536h * 2) / 3);
            this.f4540l.setColor(-1277150);
            this.f4540l.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.f4537i.getWidth() > 0 && this.f4537i.getHeight() > 0) {
                m4381a(this.f4537i.getWidth(), this.f4537i.getHeight(), 0, 0);
            }
            this.f4548t = 0;
        }

        /* renamed from: a */
        private void m4375a(Context context, Drawable drawable) {
            this.f4530b = drawable;
            this.f4533e = context.getResources().getDimensionPixelSize(C0062R.dimen.fastscroll_thumb_width);
            this.f4532d = context.getResources().getDimensionPixelSize(C0062R.dimen.fastscroll_thumb_height);
            this.f4552x = true;
        }

        /* renamed from: d */
        private void m4376d() {
            int width = this.f4537i.getWidth();
            this.f4530b.setBounds(width - this.f4533e, 0, width, this.f4532d);
            this.f4530b.setAlpha(208);
        }

        /* renamed from: e */
        private void m4377e() {
            ExpandableListAdapter expandableListAdapter = this.f4537i.getExpandableListAdapter();
            this.f4551w = null;
            if (expandableListAdapter instanceof SectionIndexer) {
                this.f4551w = (SectionIndexer) expandableListAdapter;
                this.f4550v = expandableListAdapter;
                this.f4544p = this.f4551w.getSections();
            }
        }

        /* renamed from: f */
        private void m4378f() {
            MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
            this.f4537i.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }

        /* renamed from: a */
        public int m4379a() {
            return this.f4548t;
        }

        /* renamed from: a */
        public void m4380a(int i) {
            switch (i) {
                case 0:
                    this.f4549u.removeCallbacks(this.f4547s);
                    this.f4537i.invalidate();
                    break;
                case 2:
                    if (this.f4548t != 2) {
                        m4376d();
                    }
                case 3:
                    this.f4549u.removeCallbacks(this.f4547s);
                    break;
                case 4:
                    int width = this.f4537i.getWidth();
                    this.f4537i.invalidate(width - this.f4533e, this.f4534f, width, this.f4534f + this.f4532d);
                    break;
            }
            this.f4548t = i;
        }

        /* renamed from: a */
        void m4381a(int i, int i2, int i3, int i4) {
            if (this.f4530b != null) {
                this.f4530b.setBounds(i - this.f4533e, 0, i, this.f4532d);
            }
            RectF rectF = this.f4535g;
            rectF.left = (i - this.f4536h) / 2;
            rectF.right = rectF.left + this.f4536h;
            rectF.top = i2 / 10;
            rectF.bottom = rectF.top + this.f4536h;
            if (this.f4531c != null) {
                this.f4531c.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            }
        }

        /* renamed from: a */
        public void m4382a(Canvas canvas) {
            int iM4390b;
            if (this.f4548t == 0) {
                return;
            }
            int i = this.f4534f;
            int width = this.f4537i.getWidth();
            ScrollFade scrollFade = this.f4547s;
            if (this.f4548t == 4) {
                iM4390b = scrollFade.m4390b();
                if (iM4390b < 104) {
                    this.f4530b.setAlpha(iM4390b * 2);
                }
                this.f4530b.setBounds(width - ((this.f4533e * iM4390b) / 208), 0, width, this.f4532d);
                this.f4552x = true;
            } else {
                iM4390b = -1;
            }
            canvas.translate(0.0f, i);
            this.f4530b.draw(canvas);
            canvas.translate(0.0f, -i);
            if (this.f4548t != 3 || !this.f4546r) {
                if (this.f4548t == 4) {
                    if (iM4390b == 0) {
                        m4380a(0);
                        return;
                    } else {
                        this.f4537i.invalidate(width - this.f4533e, i, width, this.f4532d + i);
                        return;
                    }
                }
                return;
            }
            if (this.f4545q.length() != 0) {
                this.f4531c.draw(canvas);
                Paint paint = this.f4540l;
                float fDescent = paint.descent();
                RectF rectF = this.f4535g;
                canvas.drawText(this.f4545q, ((int) (rectF.left + rectF.right)) / 2, ((((int) (rectF.top + rectF.bottom)) / 2) + (paint.getTextSize() / 2.0f)) - fDescent, paint);
            }
        }

        /* renamed from: a */
        void m4383a(AbsListView absListView, int i, int i2, int i3) {
            if (this.f4542n != i3 && i2 > 0) {
                this.f4542n = i3;
                this.f4543o = this.f4542n / i2 >= f4529a;
            }
            if (!this.f4543o) {
                if (this.f4548t != 0) {
                    m4380a(0);
                    return;
                }
                return;
            }
            if (i3 - i2 > 0 && this.f4548t != 3) {
                this.f4534f = ((this.f4537i.getHeight() - this.f4532d) * i) / (i3 - i2);
                if (this.f4552x) {
                    m4376d();
                    this.f4552x = false;
                }
            }
            this.f4538j = true;
            if (i != this.f4539k) {
                this.f4539k = i;
                if (this.f4548t != 3) {
                    m4380a(2);
                    this.f4549u.postDelayed(this.f4547s, 1500L);
                }
            }
        }

        /* renamed from: a */
        boolean m4384a(float f, float f2) {
            return f > ((float) (this.f4537i.getWidth() - this.f4533e)) && f2 >= ((float) this.f4534f) && f2 <= ((float) (this.f4534f + this.f4532d));
        }

        /* renamed from: a */
        boolean m4385a(MotionEvent motionEvent) {
            if (this.f4548t <= 0 || motionEvent.getAction() != 0 || !m4384a(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            m4380a(3);
            return true;
        }

        /* renamed from: b */
        void m4386b() {
            m4380a(0);
        }

        /* renamed from: b */
        boolean m4387b(MotionEvent motionEvent) {
            if (this.f4548t == 0) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (m4384a(motionEvent.getX(), motionEvent.getY())) {
                    m4380a(3);
                    if (this.f4550v == null && this.f4537i != null) {
                        m4377e();
                    }
                    if (this.f4537i != null) {
                        this.f4537i.requestDisallowInterceptTouchEvent(true);
                    }
                    m4378f();
                    return true;
                }
            } else if (action == 1) {
                if (this.f4548t == 3) {
                    if (this.f4537i != null) {
                        this.f4537i.requestDisallowInterceptTouchEvent(false);
                    }
                    m4380a(2);
                    Handler handler = this.f4549u;
                    handler.removeCallbacks(this.f4547s);
                    handler.postDelayed(this.f4547s, 1000L);
                    return true;
                }
            } else if (action == 2 && this.f4548t == 3) {
                int height = this.f4537i.getHeight();
                int y = (((int) motionEvent.getY()) - this.f4532d) + 10;
                if (y < 0) {
                    y = 0;
                } else if (this.f4532d + y > height) {
                    y = height - this.f4532d;
                }
                if (Math.abs(this.f4534f - y) < 2) {
                    return true;
                }
                this.f4534f = y;
                if (this.f4538j) {
                    m4373a(this.f4534f / (height - this.f4532d));
                }
                return true;
            }
            return false;
        }

        /* renamed from: c */
        boolean m4388c() {
            return this.f4548t != 0;
        }
    }

    public FastScrollableExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f4527a != null) {
            this.f4527a.m4382a(canvas);
        }
        setVerticalScrollBarEnabled(this.f4527a == null || !this.f4527a.m4388c());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f4527a == null || !this.f4527a.m4385a(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f4527a != null) {
            this.f4527a.m4381a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.f4527a == null || !this.f4527a.m4387b(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        super.setFastScrollEnabled(false);
        if (z) {
            if (this.f4527a == null) {
                this.f4527a = new ExpandableFastScroller(getContext(), this);
            }
        } else if (this.f4527a != null) {
            this.f4527a.m4386b();
            this.f4527a = null;
        }
        setOnScrollListener(this.f4528b);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f4528b = onScrollListener;
        super.setOnScrollListener(new C0754a(this));
    }
}
