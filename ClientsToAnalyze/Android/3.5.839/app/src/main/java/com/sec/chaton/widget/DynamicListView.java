package com.sec.chaton.widget;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class DynamicListView extends ListView {

    /* renamed from: y */
    private static final TypeEvaluator<Rect> f17892y;

    /* renamed from: a */
    public ArrayList<Object> f17893a;

    /* renamed from: b */
    private final int f17894b;

    /* renamed from: c */
    private final int f17895c;

    /* renamed from: d */
    private final int f17896d;

    /* renamed from: e */
    private int f17897e;

    /* renamed from: f */
    private int f17898f;

    /* renamed from: g */
    private int f17899g;

    /* renamed from: h */
    private int f17900h;

    /* renamed from: i */
    private boolean f17901i;

    /* renamed from: j */
    private boolean f17902j;

    /* renamed from: k */
    private int f17903k;

    /* renamed from: l */
    private final int f17904l;

    /* renamed from: m */
    private long f17905m;

    /* renamed from: n */
    private long f17906n;

    /* renamed from: o */
    private long f17907o;

    /* renamed from: p */
    private BitmapDrawable f17908p;

    /* renamed from: q */
    private Rect f17909q;

    /* renamed from: r */
    private Rect f17910r;

    /* renamed from: s */
    private final int f17911s;

    /* renamed from: t */
    private int f17912t;

    /* renamed from: u */
    private boolean f17913u;

    /* renamed from: v */
    private int f17914v;

    /* renamed from: w */
    private Activity f17915w;

    /* renamed from: x */
    private AdapterView.OnItemLongClickListener f17916x;

    /* renamed from: z */
    private AbsListView.OnScrollListener f17917z;

    /* renamed from: a */
    protected abstract void mo11675a(View view, View view2);

    /* renamed from: b */
    static /* synthetic */ int m18673b(DynamicListView dynamicListView, int i) {
        int i2 = dynamicListView.f17900h + i;
        dynamicListView.f17900h = i2;
        return i2;
    }

    public DynamicListView(Context context) {
        super(context);
        this.f17894b = 15;
        this.f17895c = 150;
        this.f17896d = 5;
        this.f17897e = -1;
        this.f17898f = -1;
        this.f17899g = -1;
        this.f17900h = 0;
        this.f17901i = false;
        this.f17902j = false;
        this.f17903k = 0;
        this.f17904l = -1;
        this.f17905m = -1L;
        this.f17906n = -1L;
        this.f17907o = -1L;
        this.f17911s = -1;
        this.f17912t = -1;
        this.f17913u = false;
        this.f17914v = 0;
        this.f17916x = new C4910c(this);
        this.f17917z = new C4915h(this);
        m18697a(context);
    }

    public DynamicListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17894b = 15;
        this.f17895c = 150;
        this.f17896d = 5;
        this.f17897e = -1;
        this.f17898f = -1;
        this.f17899g = -1;
        this.f17900h = 0;
        this.f17901i = false;
        this.f17902j = false;
        this.f17903k = 0;
        this.f17904l = -1;
        this.f17905m = -1L;
        this.f17906n = -1L;
        this.f17907o = -1L;
        this.f17911s = -1;
        this.f17912t = -1;
        this.f17913u = false;
        this.f17914v = 0;
        this.f17916x = new C4910c(this);
        this.f17917z = new C4915h(this);
        m18697a(context);
    }

    public DynamicListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17894b = 15;
        this.f17895c = 150;
        this.f17896d = 5;
        this.f17897e = -1;
        this.f17898f = -1;
        this.f17899g = -1;
        this.f17900h = 0;
        this.f17901i = false;
        this.f17902j = false;
        this.f17903k = 0;
        this.f17904l = -1;
        this.f17905m = -1L;
        this.f17906n = -1L;
        this.f17907o = -1L;
        this.f17911s = -1;
        this.f17912t = -1;
        this.f17913u = false;
        this.f17914v = 0;
        this.f17916x = new C4910c(this);
        this.f17917z = new C4915h(this);
        m18697a(context);
    }

    /* renamed from: a */
    public void m18697a(Context context) {
        setOnItemLongClickListener(this.f17916x);
        setOnScrollListener(this.f17917z);
        this.f17903k = (int) (15.0f / context.getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public BitmapDrawable m18666a(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        int top = view.getTop();
        int left = view.getLeft();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), m18674b(view));
        this.f17910r = new Rect(left, top, width + left, height + top);
        this.f17909q = new Rect(this.f17910r);
        bitmapDrawable.setBounds(this.f17909q);
        return bitmapDrawable;
    }

    /* renamed from: b */
    private Bitmap m18674b(View view) {
        Bitmap bitmapM18680c = m18680c(view);
        Canvas canvas = new Canvas(bitmapM18680c);
        Rect rect = new Rect(0, 0, bitmapM18680c.getWidth(), bitmapM18680c.getHeight());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5.0f);
        paint.setColor(-16777216);
        canvas.drawBitmap(bitmapM18680c, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(rect, paint);
        return bitmapM18680c;
    }

    /* renamed from: c */
    private Bitmap m18680c(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m18682c(long j) {
        int iM18699b = m18699b(j);
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            this.f17905m = adapter.getItemId(iM18699b - 1);
            this.f17907o = adapter.getItemId(iM18699b + 1);
        }
    }

    /* renamed from: a */
    public View m18695a(long j) {
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (adapter.getItemId(firstVisiblePosition + i) == j) {
                    return childAt;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public int m18699b(long j) {
        View viewM18695a = m18695a(j);
        if (viewM18695a == null) {
            return -1;
        }
        return getPositionForView(viewM18695a);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f17908p != null) {
            this.f17908p.draw(canvas);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ListAdapter adapter;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f17899g = (int) motionEvent.getX();
                this.f17898f = (int) motionEvent.getY();
                this.f17912t = motionEvent.getPointerId(0);
                m18681c();
                break;
            case 1:
                m18688f();
                if (!m18686e() && (adapter = getAdapter()) != null) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
                if (this.f17915w != null) {
                    this.f17915w.setRequestedOrientation(4);
                    break;
                }
                break;
            case 2:
                if (this.f17912t != -1) {
                    this.f17897e = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f17912t));
                    int i = this.f17897e - this.f17898f;
                    if (this.f17901i) {
                        this.f17909q.offsetTo(this.f17910r.left, i + this.f17910r.top + this.f17900h);
                        this.f17908p.setBounds(this.f17909q);
                        invalidate();
                        m18684d();
                        this.f17902j = false;
                        m18692h();
                        return false;
                    }
                }
                break;
            case 3:
                m18690g();
                break;
            case 6:
                if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.f17912t) {
                    m18688f();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: c */
    private void m18681c() {
        if (this.f17915w != null) {
            switch (this.f17915w.getResources().getConfiguration().orientation) {
                case 1:
                    this.f17915w.setRequestedOrientation(1);
                    break;
                case 2:
                    this.f17915w.setRequestedOrientation(0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m18684d() {
        m18670a(false);
    }

    /* renamed from: a */
    private void m18670a(boolean z) {
        int i = this.f17897e - this.f17898f;
        int i2 = this.f17910r.top + this.f17900h + i;
        View viewM18695a = m18695a(this.f17907o);
        View viewM18695a2 = m18695a(this.f17906n);
        View viewM18695a3 = m18695a(this.f17905m);
        boolean z2 = viewM18695a != null && i2 > viewM18695a.getTop();
        boolean z3 = viewM18695a3 != null && i2 < viewM18695a3.getTop();
        if (z2 || z3) {
            long j = z2 ? this.f17907o : this.f17905m;
            if (!z2) {
                viewM18695a = viewM18695a3;
            }
            int positionForView = getPositionForView(viewM18695a2);
            if (viewM18695a == null) {
                m18682c(this.f17906n);
                return;
            }
            m18669a(positionForView, getPositionForView(viewM18695a));
            mo11675a(viewM18695a2, viewM18695a);
            this.f17898f = this.f17897e;
            int top = viewM18695a.getTop();
            viewM18695a2.setVisibility(0);
            viewM18695a.setVisibility(4);
            m18682c(this.f17906n);
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC4911d(this, viewTreeObserver, j, i, top));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m18686e() {
        return Build.VERSION.SDK_INT >= 11;
    }

    /* renamed from: a */
    private void m18669a(int i, int i2) {
        Object obj = this.f17893a.get(i);
        this.f17893a.set(i, this.f17893a.get(i2));
        this.f17893a.set(i2, obj);
    }

    /* renamed from: a */
    public ArrayList<Object> m18696a() {
        return this.f17893a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m18688f() {
        View viewM18695a = m18695a(this.f17906n);
        if (this.f17901i || this.f17913u) {
            this.f17901i = false;
            this.f17913u = false;
            this.f17902j = false;
            this.f17912t = -1;
            if (this.f17914v != 0) {
                this.f17913u = true;
                return;
            }
            this.f17909q.offsetTo(this.f17910r.left, viewM18695a.getTop());
            if (m18686e()) {
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f17908p, "bounds", f17892y, this.f17909q);
                objectAnimatorOfObject.addUpdateListener(new C4912e(this));
                objectAnimatorOfObject.addListener(new C4913f(this, viewM18695a));
                objectAnimatorOfObject.start();
                return;
            }
            this.f17905m = -1L;
            this.f17906n = -1L;
            this.f17907o = -1L;
            viewM18695a.setVisibility(0);
            this.f17908p = null;
            setEnabled(true);
            invalidate();
            return;
        }
        m18690g();
    }

    /* renamed from: g */
    private void m18690g() {
        View viewM18695a = m18695a(this.f17906n);
        if (this.f17901i) {
            this.f17905m = -1L;
            this.f17906n = -1L;
            this.f17907o = -1L;
            viewM18695a.setVisibility(0);
            this.f17908p = null;
            invalidate();
        }
        this.f17901i = false;
        this.f17902j = false;
        this.f17912t = -1;
    }

    static {
        if (m18686e()) {
            f17892y = new C4914g();
        } else {
            f17892y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m18692h() {
        this.f17902j = m18698a(this.f17909q);
    }

    /* renamed from: a */
    public boolean m18698a(Rect rect) {
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int iComputeVerticalScrollExtent = computeVerticalScrollExtent();
        int iComputeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int iHeight = rect.height();
        if (i <= 0 && iComputeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.f17903k, 0);
            return true;
        }
        if (i + iHeight < height || iComputeVerticalScrollOffset + iComputeVerticalScrollExtent >= iComputeVerticalScrollRange) {
            return false;
        }
        smoothScrollBy(this.f17903k, 0);
        return true;
    }

    public void setDataList(ArrayList<Object> arrayList) {
        this.f17893a = arrayList;
    }

    public void setAttachedActivity(Activity activity) {
        this.f17915w = activity;
    }
}
