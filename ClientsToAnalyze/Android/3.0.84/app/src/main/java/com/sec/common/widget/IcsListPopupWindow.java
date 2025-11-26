package com.sec.common.widget;

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

/* loaded from: classes.dex */
public class IcsListPopupWindow {

    /* renamed from: a */
    private Context f12175a;

    /* renamed from: b */
    private PopupWindow f12176b;

    /* renamed from: c */
    private ListAdapter f12177c;

    /* renamed from: d */
    private C3382o f12178d;

    /* renamed from: g */
    private int f12181g;

    /* renamed from: h */
    private int f12182h;

    /* renamed from: i */
    private boolean f12183i;

    /* renamed from: k */
    private View f12185k;

    /* renamed from: m */
    private DataSetObserver f12187m;

    /* renamed from: n */
    private View f12188n;

    /* renamed from: o */
    private Drawable f12189o;

    /* renamed from: p */
    private AdapterView.OnItemClickListener f12190p;

    /* renamed from: q */
    private AdapterView.OnItemSelectedListener f12191q;

    /* renamed from: r */
    private final RunnableC3387t f12192r;

    /* renamed from: s */
    private final ViewOnTouchListenerC3386s f12193s;

    /* renamed from: t */
    private final C3385r f12194t;

    /* renamed from: u */
    private final RunnableC3383p f12195u;

    /* renamed from: x */
    private boolean f12198x;

    /* renamed from: e */
    private int f12179e = -2;

    /* renamed from: f */
    private int f12180f = -2;

    /* renamed from: j */
    private int f12184j = Integer.MAX_VALUE;

    /* renamed from: l */
    private int f12186l = 0;

    /* renamed from: v */
    private Handler f12196v = new Handler();

    /* renamed from: w */
    private Rect f12197w = new Rect();

    public IcsListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        C3381n c3381n = null;
        this.f12192r = new RunnableC3387t(this, c3381n);
        this.f12193s = new ViewOnTouchListenerC3386s(this, c3381n);
        this.f12194t = new C3385r(this, c3381n);
        this.f12195u = new RunnableC3383p(this, c3381n);
        this.f12175a = context;
        this.f12176b = new PopupWindow(context, attributeSet, i);
        this.f12176b.setInputMethodMode(1);
    }

    public IcsListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        C3381n c3381n = null;
        this.f12192r = new RunnableC3387t(this, c3381n);
        this.f12193s = new ViewOnTouchListenerC3386s(this, c3381n);
        this.f12194t = new C3385r(this, c3381n);
        this.f12195u = new RunnableC3383p(this, c3381n);
        this.f12175a = context;
        if (Build.VERSION.SDK_INT < 11) {
            this.f12176b = new PopupWindow(new ContextThemeWrapper(context, i2), attributeSet, i);
        } else {
            this.f12176b = new PopupWindow(context, attributeSet, i, i2);
        }
        this.f12176b.setInputMethodMode(1);
    }

    /* renamed from: a */
    public void mo11918a(ListAdapter listAdapter) {
        if (this.f12187m == null) {
            this.f12187m = new C3384q(this, null);
        } else if (this.f12177c != null) {
            this.f12177c.unregisterDataSetObserver(this.f12187m);
        }
        this.f12177c = listAdapter;
        if (this.f12177c != null) {
            listAdapter.registerDataSetObserver(this.f12187m);
        }
        if (this.f12178d != null) {
            this.f12178d.setAdapter(this.f12177c);
        }
    }

    /* renamed from: a */
    public void m11914a(int i) {
        this.f12186l = i;
    }

    /* renamed from: a */
    public void m11919a(boolean z) {
        this.f12198x = true;
        this.f12176b.setFocusable(z);
    }

    /* renamed from: a */
    public void m11915a(Drawable drawable) {
        this.f12176b.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void m11916a(View view) {
        this.f12188n = view;
    }

    /* renamed from: b */
    public void m11921b(int i) {
        this.f12181g = i;
    }

    /* renamed from: c */
    public void m11923c(int i) {
        this.f12182h = i;
        this.f12183i = true;
    }

    /* renamed from: d */
    public void m11924d(int i) {
        Drawable background = this.f12176b.getBackground();
        if (background != null) {
            background.getPadding(this.f12197w);
            this.f12180f = this.f12197w.left + this.f12197w.right + i;
        } else {
            this.f12180f = i;
        }
    }

    /* renamed from: a */
    public void m11917a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f12190p = onItemClickListener;
    }

    /* renamed from: a */
    public void mo11913a() {
        int i;
        int width;
        int iM11912g = m11912g();
        boolean zM11910f = m11910f();
        if (this.f12176b.isShowing()) {
            if (this.f12180f == -1) {
                width = -1;
            } else if (this.f12180f == -2) {
                width = this.f12188n.getWidth();
            } else {
                width = this.f12180f;
            }
            if (this.f12179e == -1) {
                if (!zM11910f) {
                    iM11912g = -1;
                }
                if (zM11910f) {
                    this.f12176b.setWindowLayoutMode(this.f12180f != -1 ? 0 : -1, 0);
                } else {
                    this.f12176b.setWindowLayoutMode(this.f12180f == -1 ? -1 : 0, -1);
                }
            } else if (this.f12179e != -2) {
                iM11912g = this.f12179e;
            }
            this.f12176b.setOutsideTouchable(true);
            this.f12176b.update(this.f12188n, this.f12181g, this.f12182h, width, iM11912g);
            return;
        }
        if (this.f12180f == -1) {
            i = -1;
        } else if (this.f12180f == -2) {
            this.f12176b.setWidth(this.f12188n.getWidth());
            i = 0;
        } else {
            this.f12176b.setWidth(this.f12180f);
            i = 0;
        }
        if (this.f12179e == -1) {
            i = -1;
        } else if (this.f12179e == -2) {
            this.f12176b.setHeight(iM11912g);
        } else {
            this.f12176b.setHeight(this.f12179e);
        }
        this.f12176b.setWindowLayoutMode(i, i);
        this.f12176b.setOutsideTouchable(true);
        this.f12176b.setTouchInterceptor(this.f12193s);
        this.f12176b.showAsDropDown(this.f12188n, this.f12181g, this.f12182h);
        this.f12178d.setSelection(-1);
        if (!this.f12198x || this.f12178d.isInTouchMode()) {
            m11922c();
        }
        if (!this.f12198x) {
            this.f12196v.post(this.f12195u);
        }
    }

    /* renamed from: b */
    public void m11920b() {
        this.f12176b.dismiss();
        if (this.f12185k != null) {
            ViewParent parent = this.f12185k.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f12185k);
            }
        }
        this.f12176b.setContentView(null);
        this.f12178d = null;
        this.f12196v.removeCallbacks(this.f12192r);
    }

    /* renamed from: e */
    public void m11927e(int i) {
        this.f12176b.setInputMethodMode(i);
    }

    /* renamed from: c */
    public void m11922c() {
        C3382o c3382o = this.f12178d;
        if (c3382o == null) {
            return;
        }
        c3382o.f12254a = true;
        c3382o.requestLayout();
    }

    /* renamed from: d */
    public boolean m11925d() {
        return this.f12176b.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m11910f() {
        return this.f12176b.getInputMethodMode() == 2;
    }

    /* renamed from: e */
    public ListView m11926e() {
        return this.f12178d;
    }

    /* renamed from: g */
    private int m11912g() {
        int measuredHeight;
        int i;
        View view;
        int measuredHeight2;
        if (this.f12178d == null) {
            Context context = this.f12175a;
            this.f12178d = new C3382o(context, !this.f12198x);
            if (this.f12189o != null) {
                this.f12178d.setSelector(this.f12189o);
            }
            this.f12178d.setAdapter(this.f12177c);
            this.f12178d.setOnItemClickListener(this.f12190p);
            this.f12178d.setFocusable(true);
            this.f12178d.setFocusableInTouchMode(true);
            this.f12178d.setOnItemSelectedListener(new C3381n(this));
            this.f12178d.setOnScrollListener(this.f12194t);
            if (this.f12191q != null) {
                this.f12178d.setOnItemSelectedListener(this.f12191q);
            }
            View view2 = this.f12178d;
            View view3 = this.f12185k;
            if (view3 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.f12186l) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams);
                        linearLayout.addView(view3);
                        break;
                }
                view3.measure(View.MeasureSpec.makeMeasureSpec(this.f12180f, Integer.MIN_VALUE), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight2 = layoutParams2.bottomMargin + view3.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                view = view2;
                measuredHeight2 = 0;
            }
            this.f12176b.setContentView(view);
            measuredHeight = measuredHeight2;
        } else {
            View view4 = this.f12185k;
            if (view4 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                measuredHeight = layoutParams3.bottomMargin + view4.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f12176b.getBackground();
        if (background != null) {
            background.getPadding(this.f12197w);
            int i2 = this.f12197w.top + this.f12197w.bottom;
            if (!this.f12183i) {
                this.f12182h = -this.f12197w.top;
            }
            i = i2;
        } else {
            i = 0;
        }
        int iM11903a = m11903a(this.f12188n, this.f12182h, this.f12176b.getInputMethodMode() == 2);
        if (this.f12179e == -1) {
            return iM11903a + i;
        }
        int iM11902a = m11902a(0, 0, -1, iM11903a - measuredHeight, -1);
        if (iM11902a > 0) {
            measuredHeight += i;
        }
        return iM11902a + measuredHeight;
    }

    /* renamed from: a */
    private int m11903a(View view, int i, boolean z) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int iMax = Math.max((i2 - (iArr[1] + view.getHeight())) - i, (iArr[1] - rect.top) + i);
        if (this.f12176b.getBackground() != null) {
            this.f12176b.getBackground().getPadding(this.f12197w);
            return iMax - (this.f12197w.top + this.f12197w.bottom);
        }
        return iMax;
    }

    /* renamed from: a */
    private int m11902a(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.f12177c;
        if (listAdapter == null) {
            return this.f12178d.getListPaddingTop() + this.f12178d.getListPaddingBottom();
        }
        int listPaddingTop = this.f12178d.getListPaddingTop() + this.f12178d.getListPaddingBottom();
        int dividerHeight = (this.f12178d.getDividerHeight() <= 0 || this.f12178d.getDivider() == null) ? 0 : this.f12178d.getDividerHeight();
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        while (i2 <= i3) {
            View view = this.f12177c.getView(i2, null, this.f12178d);
            if (this.f12178d.getCacheColorHint() != 0) {
                view.setDrawingCacheBackgroundColor(this.f12178d.getCacheColorHint());
            }
            m11905a(view, i2, i);
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
    private void m11905a(View view, int i, int i2) {
        int iMakeMeasureSpec;
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.f12178d.getPaddingLeft() + this.f12178d.getPaddingRight(), layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, iMakeMeasureSpec);
    }
}
