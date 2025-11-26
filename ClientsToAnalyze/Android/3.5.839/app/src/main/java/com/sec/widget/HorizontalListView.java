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
    public boolean f18771a;

    /* renamed from: b */
    protected ListAdapter f18772b;

    /* renamed from: c */
    protected int f18773c;

    /* renamed from: d */
    protected int f18774d;

    /* renamed from: e */
    protected Scroller f18775e;

    /* renamed from: f */
    private int f18776f;

    /* renamed from: g */
    private int f18777g;

    /* renamed from: h */
    private int f18778h;

    /* renamed from: i */
    private int f18779i;

    /* renamed from: j */
    private GestureDetector f18780j;

    /* renamed from: k */
    private Queue<View> f18781k;

    /* renamed from: l */
    private AdapterView.OnItemSelectedListener f18782l;

    /* renamed from: m */
    private AdapterView.OnItemClickListener f18783m;

    /* renamed from: n */
    private AdapterView.OnItemLongClickListener f18784n;

    /* renamed from: o */
    private boolean f18785o;

    /* renamed from: p */
    private boolean f18786p;

    /* renamed from: q */
    private DataSetObserver f18787q;

    /* renamed from: r */
    private GestureDetector.OnGestureListener f18788r;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18771a = true;
        this.f18776f = -1;
        this.f18777g = 0;
        this.f18778h = Integer.MAX_VALUE;
        this.f18779i = 0;
        this.f18781k = new LinkedList();
        this.f18785o = false;
        this.f18786p = false;
        this.f18787q = new C5182y(this);
        this.f18788r = new C5140ac(this);
        m19654b();
    }

    /* renamed from: b */
    private void m19654b() {
        this.f18776f = -1;
        this.f18777g = 0;
        this.f18779i = 0;
        this.f18773c = 0;
        this.f18774d = 0;
        this.f18778h = Integer.MAX_VALUE;
        this.f18775e = new Scroller(getContext());
        this.f18780j = new GestureDetector(getContext(), this.f18788r);
        this.f18786p = false;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f18782l = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f18783m = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f18784n = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListAdapter getAdapter() {
        return this.f18772b;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.f18772b != null) {
            this.f18772b.unregisterDataSetObserver(this.f18787q);
        }
        this.f18772b = listAdapter;
        this.f18772b.registerDataSetObserver(this.f18787q);
        m19659c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m19659c() {
        m19654b();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }

    /* renamed from: a */
    private void m19650a(View view, int i) {
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
        if (this.f18772b != null) {
            if (this.f18785o) {
                int i5 = this.f18773c;
                m19654b();
                removeAllViewsInLayout();
                this.f18774d = i5;
                this.f18785o = false;
            }
            if (this.f18775e.computeScrollOffset()) {
                this.f18774d = this.f18775e.getCurrX();
            }
            if (this.f18774d <= 0) {
                this.f18774d = 0;
                this.f18775e.forceFinished(true);
            }
            if (this.f18774d >= this.f18778h) {
                this.f18774d = this.f18778h;
                this.f18775e.forceFinished(true);
            }
            int i6 = this.f18773c - this.f18774d;
            m19655b(i6);
            m19648a(i6);
            m19660c(i6);
            this.f18773c = this.f18774d;
            if (!this.f18775e.isFinished()) {
                post(new RunnableC5139ab(this));
            }
        }
    }

    /* renamed from: a */
    private void m19648a(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        m19649a(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        m19656b(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    /* renamed from: a */
    private void m19649a(int i, int i2) {
        while (i + i2 < getWidth() && this.f18777g < this.f18772b.getCount()) {
            View view = this.f18772b.getView(this.f18777g, this.f18781k.poll(), this);
            m19650a(view, -1);
            i += view.getMeasuredWidth();
            if (this.f18777g == this.f18772b.getCount() - 1) {
                this.f18778h = (this.f18773c + i) - getWidth();
            }
            if (this.f18778h < 0) {
                this.f18778h = 0;
            }
            this.f18777g++;
        }
    }

    /* renamed from: b */
    private void m19656b(int i, int i2) {
        while (i + i2 > 0 && this.f18776f >= 0) {
            View view = this.f18772b.getView(this.f18776f, this.f18781k.poll(), this);
            m19650a(view, 0);
            i -= view.getMeasuredWidth();
            this.f18776f--;
            this.f18779i -= view.getMeasuredWidth();
        }
    }

    /* renamed from: b */
    private void m19655b(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.f18779i += childAt.getMeasuredWidth();
            this.f18781k.offer(childAt);
            removeViewInLayout(childAt);
            this.f18776f++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.f18781k.offer(childAt2);
            removeViewInLayout(childAt2);
            this.f18777g--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* renamed from: c */
    private void m19660c(int i) {
        if (getChildCount() > 0) {
            this.f18779i += i;
            int i2 = this.f18779i;
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
        boolean zOnTouchEvent = this.f18780j.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.f18786p) {
                this.f18786p = false;
                if (this.f18782l != null) {
                    this.f18782l.onNothingSelected(this);
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
                    if (this.f18783m != null) {
                        this.f18783m.onItemClick(this, childAt, this.f18776f + 1 + i, this.f18772b.getItemId(this.f18776f + 1 + i));
                    }
                    if (this.f18782l != null) {
                        this.f18782l.onItemSelected(this, childAt, this.f18776f + 1 + i, this.f18772b.getItemId(this.f18776f + 1 + i));
                    }
                    z = true;
                }
            }
            if (!z && this.f18782l != null) {
                this.f18782l.onNothingSelected(this);
            }
        }
        return zOnTouchEvent;
    }

    /* renamed from: a */
    protected boolean m19664a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f18775e.fling(this.f18774d, 0, (int) (-f), 0, 0, this.f18778h, 0, 0);
        requestLayout();
        return true;
    }

    /* renamed from: a */
    protected boolean m19663a(MotionEvent motionEvent) {
        this.f18775e.forceFinished(true);
        return true;
    }
}
