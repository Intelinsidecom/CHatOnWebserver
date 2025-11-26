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
public class HorizontalListView extends AdapterView {

    /* renamed from: a */
    public boolean f5673a;

    /* renamed from: b */
    protected ListAdapter f5674b;

    /* renamed from: c */
    protected int f5675c;

    /* renamed from: d */
    protected int f5676d;

    /* renamed from: e */
    protected Scroller f5677e;

    /* renamed from: f */
    private int f5678f;

    /* renamed from: g */
    private int f5679g;

    /* renamed from: h */
    private int f5680h;

    /* renamed from: i */
    private int f5681i;

    /* renamed from: j */
    private GestureDetector f5682j;

    /* renamed from: k */
    private Queue f5683k;

    /* renamed from: l */
    private AdapterView.OnItemSelectedListener f5684l;

    /* renamed from: m */
    private AdapterView.OnItemClickListener f5685m;

    /* renamed from: n */
    private AdapterView.OnItemLongClickListener f5686n;

    /* renamed from: o */
    private boolean f5687o;

    /* renamed from: p */
    private boolean f5688p;

    /* renamed from: q */
    private DataSetObserver f5689q;

    /* renamed from: r */
    private GestureDetector.OnGestureListener f5690r;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5673a = true;
        this.f5678f = -1;
        this.f5679g = 0;
        this.f5680h = Integer.MAX_VALUE;
        this.f5681i = 0;
        this.f5683k = new LinkedList();
        this.f5687o = false;
        this.f5688p = false;
        this.f5689q = new C1604aa(this);
        this.f5690r = new C1637y(this);
        m5861b();
    }

    /* renamed from: b */
    private void m5861b() {
        this.f5678f = -1;
        this.f5679g = 0;
        this.f5681i = 0;
        this.f5675c = 0;
        this.f5676d = 0;
        this.f5680h = Integer.MAX_VALUE;
        this.f5677e = new Scroller(getContext());
        this.f5682j = new GestureDetector(getContext(), this.f5690r);
        this.f5688p = false;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f5684l = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f5685m = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f5686n = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListAdapter getAdapter() {
        return this.f5674b;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.f5674b != null) {
            this.f5674b.unregisterDataSetObserver(this.f5689q);
        }
        this.f5674b = listAdapter;
        this.f5674b.registerDataSetObserver(this.f5689q);
        m5866c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5866c() {
        m5861b();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }

    /* renamed from: a */
    private void m5857a(View view, int i) {
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
        if (this.f5674b != null) {
            if (this.f5687o) {
                int i5 = this.f5675c;
                m5861b();
                removeAllViewsInLayout();
                this.f5676d = i5;
                this.f5687o = false;
            }
            if (this.f5677e.computeScrollOffset()) {
                this.f5676d = this.f5677e.getCurrX();
            }
            if (this.f5676d <= 0) {
                this.f5676d = 0;
                this.f5677e.forceFinished(true);
            }
            if (this.f5676d >= this.f5680h) {
                this.f5676d = this.f5680h;
                this.f5677e.forceFinished(true);
            }
            int i6 = this.f5675c - this.f5676d;
            m5862b(i6);
            m5855a(i6);
            m5867c(i6);
            this.f5675c = this.f5676d;
            if (!this.f5677e.isFinished()) {
                post(new RunnableC1638z(this));
            }
        }
    }

    /* renamed from: a */
    private void m5855a(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        m5856a(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        m5863b(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    /* renamed from: a */
    private void m5856a(int i, int i2) {
        while (i + i2 < getWidth() && this.f5679g < this.f5674b.getCount()) {
            View view = this.f5674b.getView(this.f5679g, (View) this.f5683k.poll(), this);
            m5857a(view, -1);
            i += view.getMeasuredWidth();
            if (this.f5679g == this.f5674b.getCount() - 1) {
                this.f5680h = (this.f5675c + i) - getWidth();
            }
            if (this.f5680h < 0) {
                this.f5680h = 0;
            }
            this.f5679g++;
        }
    }

    /* renamed from: b */
    private void m5863b(int i, int i2) {
        while (i + i2 > 0 && this.f5678f >= 0) {
            View view = this.f5674b.getView(this.f5678f, (View) this.f5683k.poll(), this);
            m5857a(view, 0);
            i -= view.getMeasuredWidth();
            this.f5678f--;
            this.f5681i -= view.getMeasuredWidth();
        }
    }

    /* renamed from: b */
    private void m5862b(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.f5681i += childAt.getMeasuredWidth();
            this.f5683k.offer(childAt);
            removeViewInLayout(childAt);
            this.f5678f++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.f5683k.offer(childAt2);
            removeViewInLayout(childAt2);
            this.f5679g--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* renamed from: c */
    private void m5867c(int i) {
        if (getChildCount() > 0) {
            this.f5681i += i;
            int i2 = this.f5681i;
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
        boolean zOnTouchEvent = this.f5682j.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.f5688p) {
                this.f5688p = false;
                if (this.f5684l != null) {
                    this.f5684l.onNothingSelected(this);
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
                    if (this.f5685m != null) {
                        this.f5685m.onItemClick(this, childAt, this.f5678f + 1 + i, this.f5674b.getItemId(this.f5678f + 1 + i));
                    }
                    if (this.f5684l != null) {
                        this.f5684l.onItemSelected(this, childAt, this.f5678f + 1 + i, this.f5674b.getItemId(this.f5678f + 1 + i));
                    }
                    z = true;
                }
            }
            if (!z && this.f5684l != null) {
                this.f5684l.onNothingSelected(this);
            }
        }
        return zOnTouchEvent;
    }

    /* renamed from: a */
    protected boolean m5871a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f5677e.fling(this.f5676d, 0, (int) (-f), 0, 0, this.f5680h, 0, 0);
        requestLayout();
        return true;
    }

    /* renamed from: a */
    protected boolean m5870a(MotionEvent motionEvent) {
        this.f5677e.forceFinished(true);
        return true;
    }
}
