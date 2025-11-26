package com.sec.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class IcsListPopupWindow {

    /* renamed from: a */
    private Context f18445a;

    /* renamed from: b */
    private PopupWindow f18446b;

    /* renamed from: c */
    private ListAdapter f18447c;

    /* renamed from: d */
    private C5066k f18448d;

    /* renamed from: g */
    private int f18451g;

    /* renamed from: h */
    private int f18452h;

    /* renamed from: i */
    private boolean f18453i;

    /* renamed from: k */
    private View f18455k;

    /* renamed from: m */
    private DataSetObserver f18457m;

    /* renamed from: n */
    private View f18458n;

    /* renamed from: o */
    private Drawable f18459o;

    /* renamed from: p */
    private AdapterView.OnItemClickListener f18460p;

    /* renamed from: q */
    private AdapterView.OnItemSelectedListener f18461q;

    /* renamed from: r */
    private final RunnableC5071p f18462r;

    /* renamed from: s */
    private final ViewOnTouchListenerC5070o f18463s;

    /* renamed from: t */
    private final C5069n f18464t;

    /* renamed from: u */
    private final RunnableC5067l f18465u;

    /* renamed from: x */
    private boolean f18468x;

    /* renamed from: e */
    private int f18449e = -2;

    /* renamed from: f */
    private int f18450f = -2;

    /* renamed from: j */
    private int f18454j = Integer.MAX_VALUE;

    /* renamed from: l */
    private int f18456l = 0;

    /* renamed from: v */
    private Handler f18466v = new Handler();

    /* renamed from: w */
    private Rect f18467w = new Rect();

    public IcsListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        C5065j c5065j = null;
        this.f18462r = new RunnableC5071p(this, c5065j);
        this.f18463s = new ViewOnTouchListenerC5070o(this, c5065j);
        this.f18464t = new C5069n(this, c5065j);
        this.f18465u = new RunnableC5067l(this, c5065j);
        this.f18445a = context;
        this.f18446b = new PopupWindow(context, attributeSet, i);
        this.f18446b.setInputMethodMode(1);
    }

    public IcsListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        C5065j c5065j = null;
        this.f18462r = new RunnableC5071p(this, c5065j);
        this.f18463s = new ViewOnTouchListenerC5070o(this, c5065j);
        this.f18464t = new C5069n(this, c5065j);
        this.f18465u = new RunnableC5067l(this, c5065j);
        this.f18445a = context;
        if (Build.VERSION.SDK_INT < 11) {
            this.f18446b = new PopupWindow(new ContextThemeWrapper(context, i2), attributeSet, i);
        } else {
            this.f18446b = new PopupWindow(context, attributeSet, i, i2);
        }
        this.f18446b.setInputMethodMode(1);
    }

    /* renamed from: a */
    public void mo19260a(ListAdapter listAdapter) {
        if (this.f18457m == null) {
            this.f18457m = new C5068m(this, null);
        } else if (this.f18447c != null) {
            this.f18447c.unregisterDataSetObserver(this.f18457m);
        }
        this.f18447c = listAdapter;
        if (this.f18447c != null) {
            listAdapter.registerDataSetObserver(this.f18457m);
        }
        if (this.f18448d != null) {
            this.f18448d.setAdapter(this.f18447c);
        }
    }

    /* renamed from: a */
    public void m19256a(int i) {
        this.f18456l = i;
    }

    /* renamed from: a */
    public void m19261a(boolean z) {
        this.f18468x = true;
        this.f18446b.setFocusable(z);
    }

    /* renamed from: a */
    public void m19257a(Drawable drawable) {
        this.f18446b.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void m19258a(View view) {
        this.f18458n = view;
    }

    /* renamed from: b */
    public void m19263b(int i) {
        this.f18451g = i;
    }

    /* renamed from: c */
    public void m19265c(int i) {
        this.f18452h = i;
        this.f18453i = true;
    }

    /* renamed from: d */
    public void m19266d(int i) {
        Drawable background = this.f18446b.getBackground();
        if (background != null) {
            background.getPadding(this.f18467w);
            this.f18450f = this.f18467w.left + this.f18467w.right + i;
        } else {
            this.f18450f = i;
        }
    }

    /* renamed from: a */
    public void m19259a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f18460p = onItemClickListener;
    }

    /* renamed from: a */
    public void mo19255a() {
        int i;
        int width;
        int iM19254g = m19254g();
        boolean zM19252f = m19252f();
        if (this.f18446b.isShowing()) {
            if (this.f18450f == -1) {
                width = -1;
            } else if (this.f18450f == -2) {
                width = this.f18458n.getWidth();
            } else {
                width = this.f18450f;
            }
            if (this.f18449e == -1) {
                if (!zM19252f) {
                    iM19254g = -1;
                }
                if (zM19252f) {
                    this.f18446b.setWindowLayoutMode(this.f18450f != -1 ? 0 : -1, 0);
                } else {
                    this.f18446b.setWindowLayoutMode(this.f18450f == -1 ? -1 : 0, -1);
                }
            } else if (this.f18449e != -2) {
                iM19254g = this.f18449e;
            }
            this.f18446b.setOutsideTouchable(true);
            this.f18446b.update(this.f18458n, this.f18451g, this.f18452h, width, iM19254g);
            return;
        }
        if (this.f18450f == -1) {
            i = -1;
        } else if (this.f18450f == -2) {
            this.f18446b.setWidth(this.f18458n.getWidth());
            i = 0;
        } else {
            this.f18446b.setWidth(this.f18450f);
            i = 0;
        }
        if (this.f18449e == -1) {
            i = -1;
        } else if (this.f18449e == -2) {
            this.f18446b.setHeight(iM19254g);
        } else {
            this.f18446b.setHeight(this.f18449e);
        }
        this.f18446b.setWindowLayoutMode(i, i);
        this.f18446b.setOutsideTouchable(true);
        this.f18446b.setTouchInterceptor(this.f18463s);
        this.f18446b.showAsDropDown(this.f18458n, this.f18451g, this.f18452h);
        this.f18448d.setSelection(-1);
        if (!this.f18468x || this.f18448d.isInTouchMode()) {
            m19264c();
        }
        if (!this.f18468x) {
            this.f18466v.post(this.f18465u);
        }
    }

    /* renamed from: b */
    public void m19262b() {
        this.f18446b.dismiss();
        if (this.f18455k != null) {
            ViewParent parent = this.f18455k.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f18455k);
            }
        }
        this.f18446b.setContentView(null);
        this.f18448d = null;
        this.f18466v.removeCallbacks(this.f18462r);
    }

    /* renamed from: e */
    public void m19269e(int i) {
        this.f18446b.setInputMethodMode(i);
    }

    /* renamed from: c */
    public void m19264c() {
        C5066k c5066k = this.f18448d;
        if (c5066k == null) {
            return;
        }
        c5066k.f18500a = true;
        c5066k.requestLayout();
    }

    /* renamed from: d */
    public boolean m19267d() {
        return this.f18446b.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m19252f() {
        return this.f18446b.getInputMethodMode() == 2;
    }

    /* renamed from: e */
    public ListView m19268e() {
        return this.f18448d;
    }

    /* renamed from: g */
    private int m19254g() {
        int measuredHeight;
        int i;
        View view;
        int measuredHeight2;
        if (this.f18448d == null) {
            Context context = this.f18445a;
            this.f18448d = new C5066k(context, !this.f18468x);
            if (this.f18459o != null) {
                this.f18448d.setSelector(this.f18459o);
            }
            this.f18448d.setAdapter(this.f18447c);
            this.f18448d.setOnItemClickListener(this.f18460p);
            this.f18448d.setFocusable(true);
            this.f18448d.setFocusableInTouchMode(true);
            this.f18448d.setOnItemSelectedListener(new C5065j(this));
            this.f18448d.setOnScrollListener(this.f18464t);
            if (this.f18461q != null) {
                this.f18448d.setOnItemSelectedListener(this.f18461q);
            }
            View view2 = this.f18448d;
            View view3 = this.f18455k;
            if (view3 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.f18456l) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams);
                        linearLayout.addView(view3);
                        break;
                }
                view3.measure(View.MeasureSpec.makeMeasureSpec(this.f18450f, Integer.MIN_VALUE), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight2 = layoutParams2.bottomMargin + view3.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                view = view2;
                measuredHeight2 = 0;
            }
            this.f18446b.setContentView(view);
            measuredHeight = measuredHeight2;
        } else {
            View view4 = this.f18455k;
            if (view4 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                measuredHeight = layoutParams3.bottomMargin + view4.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f18446b.getBackground();
        if (background != null) {
            background.getPadding(this.f18467w);
            int i2 = this.f18467w.top + this.f18467w.bottom;
            if (!this.f18453i) {
                this.f18452h = -this.f18467w.top;
            }
            i = i2;
        } else {
            i = 0;
        }
        int iM19245a = m19245a(this.f18458n, this.f18452h, this.f18446b.getInputMethodMode() == 2);
        if (this.f18449e == -1) {
            return iM19245a + i;
        }
        int iM19244a = m19244a(0, 0, -1, iM19245a - measuredHeight, -1);
        if (iM19244a > 0) {
            measuredHeight += i;
        }
        return iM19244a + measuredHeight;
    }

    /* renamed from: a */
    private int m19245a(View view, int i, boolean z) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int iMax = Math.max((i2 - (iArr[1] + view.getHeight())) - i, (iArr[1] - rect.top) + i);
        if (this.f18446b.getBackground() != null) {
            this.f18446b.getBackground().getPadding(this.f18467w);
            return iMax - (this.f18467w.top + this.f18467w.bottom);
        }
        return iMax;
    }

    /* renamed from: a */
    private int m19244a(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.f18447c;
        if (listAdapter == null) {
            return this.f18448d.getListPaddingTop() + this.f18448d.getListPaddingBottom();
        }
        int listPaddingTop = this.f18448d.getListPaddingTop() + this.f18448d.getListPaddingBottom();
        int dividerHeight = (this.f18448d.getDividerHeight() <= 0 || this.f18448d.getDivider() == null) ? 0 : this.f18448d.getDividerHeight();
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        while (i2 <= i3) {
            View view = this.f18447c.getView(i2, null, this.f18448d);
            if (this.f18448d.getCacheColorHint() != 0) {
                view.setDrawingCacheBackgroundColor(this.f18448d.getCacheColorHint());
            }
            m19247a(view, i2, i);
            if (i2 > 0) {
                listPaddingTop += dividerHeight;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i2 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            }
            if (i5 >= 0 && i2 >= i5) {
                i6 = listPaddingTop;
            }
            i2++;
        }
        return listPaddingTop;
    }

    /* renamed from: a */
    private void m19247a(View view, int i, int i2) {
        int iMakeMeasureSpec;
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.f18448d.getPaddingLeft() + this.f18448d.getPaddingRight(), layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, iMakeMeasureSpec);
    }
}
