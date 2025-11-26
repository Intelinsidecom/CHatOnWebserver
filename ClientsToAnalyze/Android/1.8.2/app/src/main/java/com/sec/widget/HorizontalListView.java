package com.sec.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.sec.chaton.C0229at;
import com.sec.chaton.settings.InterfaceC1291cp;
import com.sec.chaton.util.C1722ae;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes.dex */
public class HorizontalListView extends AdapterView implements View.OnFocusChangeListener {

    /* renamed from: s */
    private static int f7728s = -1;

    /* renamed from: A */
    private int f7729A;

    /* renamed from: B */
    private int f7730B;

    /* renamed from: C */
    private int f7731C;

    /* renamed from: D */
    private int f7732D;

    /* renamed from: E */
    private DataSetObserver f7733E;

    /* renamed from: F */
    private GestureDetector.OnGestureListener f7734F;

    /* renamed from: a */
    public boolean f7735a;

    /* renamed from: b */
    protected ListAdapter f7736b;

    /* renamed from: c */
    protected int f7737c;

    /* renamed from: d */
    protected int f7738d;

    /* renamed from: e */
    protected Scroller f7739e;

    /* renamed from: f */
    InterfaceC1291cp f7740f;

    /* renamed from: g */
    private int f7741g;

    /* renamed from: h */
    private int f7742h;

    /* renamed from: i */
    private int f7743i;

    /* renamed from: j */
    private int f7744j;

    /* renamed from: k */
    private GestureDetector f7745k;

    /* renamed from: l */
    private Queue f7746l;

    /* renamed from: m */
    private AdapterView.OnItemSelectedListener f7747m;

    /* renamed from: n */
    private AdapterView.OnItemClickListener f7748n;

    /* renamed from: o */
    private AdapterView.OnItemLongClickListener f7749o;

    /* renamed from: p */
    private View.OnFocusChangeListener f7750p;

    /* renamed from: q */
    private boolean f7751q;

    /* renamed from: r */
    private int f7752r;

    /* renamed from: t */
    private int f7753t;

    /* renamed from: u */
    private int f7754u;

    /* renamed from: v */
    private boolean f7755v;

    /* renamed from: w */
    private int f7756w;

    /* renamed from: x */
    private int f7757x;

    /* renamed from: y */
    private int f7758y;

    /* renamed from: z */
    private int f7759z;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7735a = true;
        this.f7741g = -1;
        this.f7742h = 0;
        this.f7743i = Integer.MAX_VALUE;
        this.f7744j = 0;
        this.f7746l = new LinkedList();
        this.f7751q = false;
        this.f7752r = -1;
        this.f7753t = -1;
        this.f7754u = -1;
        this.f7755v = false;
        this.f7756w = 0;
        this.f7757x = 125;
        this.f7758y = 0;
        this.f7759z = 0;
        this.f7729A = 0;
        this.f7730B = 0;
        this.f7731C = 0;
        this.f7732D = 0;
        this.f7733E = new C2121aa(this);
        this.f7734F = new C2125ae(this);
        m7465b();
    }

    /* renamed from: b */
    private void m7465b() {
        this.f7741g = -1;
        this.f7742h = 0;
        this.f7744j = 0;
        this.f7737c = 0;
        this.f7738d = 0;
        this.f7743i = Integer.MAX_VALUE;
        this.f7739e = new Scroller(getContext());
        this.f7745k = new GestureDetector(getContext(), this.f7734F);
        this.f7755v = false;
        setHorizontalScrollBarEnabled(true);
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(C0229at.HorizontalSrollView);
        initializeScrollbars(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        setOnFocusChangeListener(this.f7750p);
        if (f7728s != -1 && this.f7754u != this.f7741g) {
            f7728s -= this.f7741g - this.f7754u;
            if (f7728s <= -1) {
                f7728s = 0;
            }
        }
        this.f7731C = C1722ae.m5896c(getWidth());
        this.f7732D = (int) ((C1722ae.m5896c(getWidth()) / (this.f7757x * this.f7756w)) * C1722ae.m5896c(getWidth()));
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return this.f7731C;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        return this.f7732D;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        int iM5896c = C1722ae.m5896c(getWidth()) - ((int) ((C1722ae.m5896c(getWidth()) / (this.f7757x * this.f7756w)) * C1722ae.m5896c(getWidth())));
        if (this.f7758y == 1) {
            return 0;
        }
        if (this.f7759z == this.f7756w) {
            return iM5896c;
        }
        if (this.f7730B != 0) {
            return (iM5896c / this.f7730B) * this.f7758y;
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f7747m = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f7748n = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f7749o = onItemLongClickListener;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f7750p = onFocusChangeListener;
    }

    public void setKeyDispatchListener(InterfaceC1291cp interfaceC1291cp) {
        this.f7740f = interfaceC1291cp;
    }

    public void setCurrentSelectedPosition(int i) {
        this.f7752r = i;
    }

    public void setFocusedPosition(int i) {
        f7728s = i;
    }

    @Override // android.widget.AdapterView
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListAdapter getAdapter() {
        return this.f7736b;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.f7736b != null) {
            this.f7736b.unregisterDataSetObserver(this.f7733E);
        }
        this.f7736b = listAdapter;
        this.f7736b.registerDataSetObserver(this.f7733E);
        m7470c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7470c() {
        m7465b();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }

    /* renamed from: a */
    private void m7461a(View view, int i) {
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
        if (this.f7736b != null) {
            if (this.f7751q) {
                int i5 = this.f7737c;
                m7465b();
                removeAllViewsInLayout();
                this.f7738d = i5;
                this.f7751q = false;
            }
            if (this.f7739e.computeScrollOffset()) {
                this.f7738d = this.f7739e.getCurrX();
            }
            if (this.f7738d <= 0) {
                this.f7738d = 0;
                this.f7739e.forceFinished(true);
            }
            if (this.f7738d >= this.f7743i) {
                this.f7738d = this.f7743i;
                this.f7739e.forceFinished(true);
            }
            int i6 = this.f7737c - this.f7738d;
            m7466b(i6);
            m7459a(i6);
            m7471c(i6);
            this.f7737c = this.f7738d;
            if (!this.f7739e.isFinished()) {
                post(new RunnableC2124ad(this));
            }
            this.f7741g = this.f7742h - (getChildCount() + 1);
            if (this.f7741g == -1) {
                this.f7753t = this.f7742h;
            } else {
                this.f7753t = (this.f7742h - this.f7741g) - 1;
            }
            this.f7756w = this.f7736b.getCount();
            this.f7729A = C1722ae.m5896c(getWidth());
            this.f7759z = this.f7742h;
            this.f7758y = (this.f7759z - getChildCount()) + 1;
            this.f7730B = this.f7756w - getChildCount();
            awakenScrollBars();
        }
    }

    /* renamed from: a */
    private void m7459a(int i) {
        int i2 = this.f7741g;
        View childAt = getChildAt(getChildCount() - 1);
        m7460a(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        m7467b(childAt2 != null ? childAt2.getLeft() : 0, i);
        if (f7728s != -1 && i2 != this.f7741g) {
            f7728s -= this.f7741g - i2;
            if (f7728s <= -1) {
                f7728s = 0;
            }
            if (f7728s >= getChildCount()) {
                f7728s = getChildCount() - 1;
            }
        }
        this.f7741g = this.f7742h - (getChildCount() + 1);
        this.f7754u = this.f7741g;
    }

    /* renamed from: a */
    private void m7460a(int i, int i2) {
        while (i + i2 < getWidth() && this.f7742h < this.f7736b.getCount()) {
            View view = this.f7736b.getView(this.f7742h, (View) this.f7746l.poll(), this);
            m7461a(view, -1);
            i += view.getMeasuredWidth();
            if (this.f7742h == this.f7736b.getCount() - 1) {
                this.f7743i = (this.f7737c + i) - getWidth();
            }
            if (this.f7743i < 0) {
                this.f7743i = 0;
            }
            this.f7742h++;
        }
    }

    /* renamed from: b */
    private void m7467b(int i, int i2) {
        while (i + i2 > 0 && this.f7741g >= 0) {
            View view = this.f7736b.getView(this.f7741g, (View) this.f7746l.poll(), this);
            m7461a(view, 0);
            i -= view.getMeasuredWidth();
            this.f7741g--;
            this.f7744j -= view.getMeasuredWidth();
        }
    }

    /* renamed from: b */
    private void m7466b(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.f7744j += childAt.getMeasuredWidth();
            this.f7746l.offer(childAt);
            removeViewInLayout(childAt);
            this.f7741g++;
            f7728s--;
            if (f7728s < 0) {
                f7728s = 0;
            }
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.f7746l.offer(childAt2);
            removeViewInLayout(childAt2);
            this.f7742h--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* renamed from: c */
    private void m7471c(int i) {
        if (getChildCount() > 0) {
            this.f7744j += i;
            int i2 = this.f7744j;
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
        boolean zOnTouchEvent = this.f7745k.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 1) {
            return zOnTouchEvent;
        }
        if (this.f7755v) {
            this.f7755v = false;
            if (this.f7747m != null) {
                this.f7747m.onNothingSelected(this);
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
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f7748n != null) {
                    this.f7752r = this.f7741g + 1 + i;
                    childAt.setSelected(true);
                    this.f7748n.onItemClick(this, childAt, this.f7741g + 1 + i, this.f7736b.getItemId(this.f7741g + 1 + i));
                }
                if (this.f7747m != null) {
                    this.f7747m.onItemSelected(this, childAt, this.f7741g + 1 + i, this.f7736b.getItemId(this.f7741g + 1 + i));
                }
                f7728s = i;
                z = true;
            } else {
                requestFocus();
                i++;
            }
        }
        if (!z && this.f7747m != null) {
            this.f7747m.onNothingSelected(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        if ((keyEvent.getKeyCode() == 19 || keyEvent.getKeyCode() == 20) && keyEvent.getAction() == 1 && this.f7740f != null) {
            this.f7740f.m4748a(keyEvent, this.f7752r);
            return true;
        }
        if (keyEvent.getKeyCode() == 22 && keyEvent.getAction() == 1) {
            int count = this.f7736b.getCount();
            if (f7728s < this.f7753t - 1) {
                f7728s++;
                if (f7728s >= this.f7753t) {
                    f7728s = this.f7753t - 1;
                }
            } else if (this.f7742h == count) {
                f7728s++;
                if (f7728s >= this.f7753t) {
                    f7728s = this.f7753t - 1;
                }
                this.f7738d = getChildAt(0).getWidth() + this.f7738d;
                requestLayout();
            } else {
                this.f7738d = getChildAt(0).getWidth() + this.f7738d;
                requestLayout();
                f7728s = this.f7753t - 1;
            }
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.f7750p != null) {
                    if (this.f7741g + i + 1 == this.f7752r) {
                        childAt.setSelected(true);
                        this.f7750p.onFocusChange(childAt, true);
                    } else {
                        childAt.setSelected(false);
                        this.f7750p.onFocusChange(childAt, false);
                    }
                }
            }
            View childAt2 = getChildAt(f7728s);
            if (this.f7750p == null || childAt2 == null) {
                return true;
            }
            childAt2.setSelected(true);
            this.f7750p.onFocusChange(childAt2, true);
            if (childAt2.getLeft() >= 0 && childAt2.getLeft() <= getWidth() - childAt2.getMeasuredWidth()) {
                return true;
            }
            requestLayout();
            return true;
        }
        if (keyEvent.getKeyCode() == 21 && keyEvent.getAction() == 1) {
            int childCount = getChildCount();
            if (f7728s >= 1) {
                f7728s--;
            } else {
                this.f7738d -= getChildAt(0).getWidth();
                requestLayout();
                f7728s = childCount - 1;
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt3 = getChildAt(i2);
                if (this.f7750p != null) {
                    if (this.f7741g + i2 + 1 == this.f7752r) {
                        childAt3.setSelected(true);
                        this.f7750p.onFocusChange(childAt3, true);
                    } else {
                        childAt3.setSelected(false);
                        this.f7750p.onFocusChange(childAt3, false);
                    }
                }
            }
            View childAt4 = getChildAt(f7728s);
            if (this.f7750p == null) {
                return true;
            }
            childAt4.setSelected(true);
            this.f7750p.onFocusChange(childAt4, true);
            if (childAt4.getLeft() >= 0 && childAt4.getLeft() <= getWidth() - childAt4.getMeasuredWidth()) {
                return true;
            }
            requestLayout();
            return true;
        }
        if (keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 1) {
            int i3 = 0;
            while (true) {
                if (i3 >= getChildCount()) {
                    break;
                }
                if (!getChildAt(i3).hasFocus()) {
                    i3++;
                } else {
                    f7728s = i3;
                    break;
                }
            }
            if (f7728s == -1) {
                f7728s = 0;
                z = true;
            } else {
                z = false;
            }
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt5 = getChildAt(i4);
                if (this.f7747m != null) {
                    if (i4 == f7728s) {
                        childAt5.setSelected(true);
                        this.f7747m.onItemSelected(this, childAt5, f7728s + this.f7741g + 1, this.f7736b.getItemId(this.f7741g + 1 + f7728s));
                    } else {
                        childAt5.setSelected(false);
                    }
                }
            }
            View childAt6 = getChildAt(f7728s);
            if (this.f7748n != null && !z) {
                this.f7752r = this.f7741g + 1 + f7728s;
                this.f7748n.onItemClick(this, childAt6, f7728s + this.f7741g + 1, this.f7736b.getItemId(this.f7741g + 1 + f7728s));
            }
            if (this.f7747m == null) {
                return true;
            }
            childAt6.setSelected(true);
            this.f7747m.onItemSelected(this, childAt6, f7728s + this.f7741g + 1, this.f7736b.getItemId(this.f7741g + 1 + f7728s));
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: a */
    protected boolean m7475a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f7739e.fling(this.f7738d, 0, (int) (-f), 0, 0, this.f7743i, 0, 0);
        requestLayout();
        return true;
    }

    /* renamed from: a */
    protected boolean m7474a(MotionEvent motionEvent) {
        this.f7739e.forceFinished(true);
        return true;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
    }
}
