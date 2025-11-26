package com.sec.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {

    /* renamed from: a */
    public boolean f13404a;

    /* renamed from: b */
    protected ListAdapter f13405b;

    /* renamed from: c */
    protected int f13406c;

    /* renamed from: d */
    protected int f13407d;

    /* renamed from: e */
    protected Scroller f13408e;

    /* renamed from: f */
    private int f13409f;

    /* renamed from: g */
    private int f13410g;

    /* renamed from: h */
    private int f13411h;

    /* renamed from: i */
    private int f13412i;

    /* renamed from: j */
    private GestureDetector f13413j;

    /* renamed from: k */
    private Queue<View> f13414k;

    /* renamed from: l */
    private AdapterView.OnItemSelectedListener f13415l;

    /* renamed from: m */
    private AdapterView.OnItemClickListener f13416m;

    /* renamed from: n */
    private AdapterView.OnItemLongClickListener f13417n;

    /* renamed from: o */
    private boolean f13418o;

    /* renamed from: p */
    private boolean f13419p;

    /* renamed from: q */
    private DataSetObserver f13420q;

    /* renamed from: r */
    private GestureDetector.OnGestureListener f13421r;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13404a = true;
        this.f13409f = -1;
        this.f13410g = 0;
        this.f13411h = Integer.MAX_VALUE;
        this.f13412i = 0;
        this.f13414k = new LinkedList();
        this.f13418o = false;
        this.f13419p = false;
        this.f13420q = new C3644al(this);
        this.f13421r = new C3648ap(this);
        m13121b();
    }

    /* renamed from: b */
    private void m13121b() {
        this.f13409f = -1;
        this.f13410g = 0;
        this.f13412i = 0;
        this.f13406c = 0;
        this.f13407d = 0;
        this.f13411h = Integer.MAX_VALUE;
        this.f13408e = new Scroller(getContext());
        this.f13413j = new GestureDetector(getContext(), this.f13421r);
        this.f13419p = false;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f13415l = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f13416m = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f13417n = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListAdapter getAdapter() {
        return this.f13405b;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.f13405b != null) {
            this.f13405b.unregisterDataSetObserver(this.f13420q);
        }
        this.f13405b = listAdapter;
        this.f13405b.registerDataSetObserver(this.f13420q);
        m13126c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13126c() {
        m13121b();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }

    /* renamed from: a */
    private void m13117a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13405b != null) {
            if (this.f13418o) {
                int i5 = this.f13406c;
                m13121b();
                removeAllViewsInLayout();
                this.f13407d = i5;
                this.f13418o = false;
            }
            if (this.f13408e.computeScrollOffset()) {
                this.f13407d = this.f13408e.getCurrX();
            }
            if (this.f13407d <= 0) {
                this.f13407d = 0;
                this.f13408e.forceFinished(true);
            }
            if (this.f13407d >= this.f13411h) {
                this.f13407d = this.f13411h;
                this.f13408e.forceFinished(true);
            }
            int i6 = this.f13406c - this.f13407d;
            m13122b(i6);
            m13115a(i6);
            m13127c(i6);
            this.f13406c = this.f13407d;
            if (!this.f13408e.isFinished()) {
                post(new RunnableC3647ao(this));
            }
        }
    }

    /* renamed from: a */
    private void m13115a(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        m13116a(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        m13123b(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    /* renamed from: a */
    private void m13116a(int i, int i2) {
        while (i + i2 < getWidth() && this.f13410g < this.f13405b.getCount()) {
            View view = this.f13405b.getView(this.f13410g, this.f13414k.poll(), this);
            m13117a(view, -1);
            i += view.getMeasuredWidth();
            if (this.f13410g == this.f13405b.getCount() - 1) {
                this.f13411h = (this.f13406c + i) - getWidth();
            }
            if (this.f13411h < 0) {
                this.f13411h = 0;
            }
            this.f13410g++;
        }
    }

    /* renamed from: b */
    private void m13123b(int i, int i2) {
        while (i + i2 > 0 && this.f13409f >= 0) {
            View view = this.f13405b.getView(this.f13409f, this.f13414k.poll(), this);
            m13117a(view, 0);
            i -= view.getMeasuredWidth();
            this.f13409f--;
            this.f13412i -= view.getMeasuredWidth();
        }
    }

    /* renamed from: b */
    private void m13122b(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.f13412i += childAt.getMeasuredWidth();
            this.f13414k.offer(childAt);
            removeViewInLayout(childAt);
            this.f13409f++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.f13414k.offer(childAt2);
            removeViewInLayout(childAt2);
            this.f13410g--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* renamed from: c */
    private void m13127c(int i) {
        if (getChildCount() > 0) {
            this.f13412i += i;
            int i2 = this.f13412i;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += measuredWidth;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean zOnTouchEvent = this.f13413j.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.f13419p) {
                this.f13419p = false;
                if (this.f13415l != null) {
                    this.f13415l.onNothingSelected(this);
                }
                return zOnTouchEvent;
            }
            Rect rect = new Rect();
            int i = 0;
            while (true) {
                if (i >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    i++;
                } else {
                    if (this.f13416m != null) {
                        this.f13416m.onItemClick(this, childAt, this.f13409f + 1 + i, this.f13405b.getItemId(this.f13409f + 1 + i));
                    }
                    if (this.f13415l != null) {
                        this.f13415l.onItemSelected(this, childAt, this.f13409f + 1 + i, this.f13405b.getItemId(this.f13409f + 1 + i));
                    }
                    z = true;
                }
            }
            if (!z && this.f13415l != null) {
                this.f13415l.onNothingSelected(this);
            }
        }
        return zOnTouchEvent;
    }

    /* renamed from: a */
    protected boolean m13131a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f13408e.fling(this.f13407d, 0, (int) (-f), 0, 0, this.f13411h, 0, 0);
        requestLayout();
        return true;
    }

    /* renamed from: a */
    protected boolean m13130a(MotionEvent motionEvent) {
        this.f13408e.forceFinished(true);
        return true;
    }
}
