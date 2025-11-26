package com.sec.common.tooltip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sec.common.C4969b;
import com.sec.common.C4972c;
import com.sec.common.C4975d;
import com.sec.common.C4991e;

@TargetApi(11)
/* loaded from: classes.dex */
class ToolTipView extends FrameLayout implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: h */
    private static final Handler f18279h = new HandlerC5015e();

    /* renamed from: a */
    private C5011a f18280a;

    /* renamed from: b */
    private View f18281b;

    /* renamed from: c */
    private View f18282c;

    /* renamed from: d */
    private ViewGroup f18283d;

    /* renamed from: e */
    private TextView f18284e;

    /* renamed from: f */
    private boolean f18285f;

    /* renamed from: g */
    private int f18286g;

    public ToolTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4991e.ToolTip, C4969b.toolTipStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, C4975d.layout_tooltip_default);
        typedArrayObtainStyledAttributes.recycle();
        m19029a(resourceId);
    }

    /* renamed from: a */
    private void m19029a(int i) {
        getViewTreeObserver().addOnPreDrawListener(this);
        View viewInflate = LayoutInflater.from(getContext()).inflate(i, this);
        this.f18281b = viewInflate.findViewById(C4972c.toolTipArrowUp);
        this.f18282c = viewInflate.findViewById(C4972c.toolTipArrowDown);
        this.f18283d = (ViewGroup) viewInflate.findViewById(C4972c.toolTipContent);
        this.f18284e = (TextView) viewInflate.findViewById(C4972c.toolTipText);
    }

    /* renamed from: a */
    private void m19030a(View view) {
        this.f18283d.removeAllViews();
        this.f18283d.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m19033c() {
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        float f = ((rect.right - rect.left) / 2) - (this.f18286g / 2);
        float height = (((rect.bottom - rect.top) / 2) - (getHeight() / 2)) + m19036e();
        if (this.f18281b != null) {
            this.f18281b.setVisibility(4);
        }
        if (this.f18282c != null) {
            this.f18282c.setVisibility(4);
        }
        setX(f);
        setY(height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m19035d() {
        View view = this.f18280a.f18290d;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        Rect rect = new Rect();
        view.getLocationOnScreen(iArr);
        view.getWindowVisibleDisplayFrame(rect);
        ((View) getParent()).getLocationOnScreen(iArr2);
        int i = iArr[0] - iArr2[0];
        int i2 = iArr[1] - iArr2[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int i3 = i + (width / 2);
        float fMax = Math.max(0, i3 - (this.f18286g / 2));
        if (this.f18286g + fMax > rect.right) {
            fMax = rect.right - this.f18286g;
        }
        float height2 = i2 - getHeight();
        float fMax2 = Math.max(0, height + i2);
        if ((height2 - ((float) rect.top)) - ((float) m19036e()) < 0.0f) {
            if (this.f18281b != null) {
                this.f18281b.setVisibility(0);
            }
            if (this.f18282c != null) {
                this.f18282c.setVisibility(4);
            }
        } else {
            if (this.f18281b != null) {
                this.f18281b.setVisibility(4);
            }
            if (this.f18282c != null) {
                this.f18282c.setVisibility(0);
            }
            fMax2 = height2;
        }
        setX(fMax);
        setY(fMax2);
        m19031b(i3);
    }

    /* renamed from: a */
    void m19037a() {
        if (this.f18285f) {
            Message.obtain(f18279h, 0, this).sendToTarget();
        }
    }

    /* renamed from: b */
    private void m19031b(int i) {
        float fMax = (i - (Math.max(this.f18281b != null ? this.f18281b.getMeasuredWidth() : 0, this.f18282c != null ? this.f18282c.getMeasuredWidth() : 0) / 2)) - getX();
        if (this.f18281b != null) {
            this.f18281b.setX(fMax);
        }
        if (this.f18282c != null) {
            this.f18282c.setX(fMax);
        }
    }

    /* renamed from: e */
    private int m19036e() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        return 0;
    }

    /* renamed from: a */
    void m19038a(C5011a c5011a) {
        this.f18280a = c5011a;
        if (c5011a.f18288b != null) {
            m19030a(c5011a.f18288b);
        }
        if (c5011a.f18289c != -1) {
            m19030a(LayoutInflater.from(getContext()).inflate(c5011a.f18289c, this.f18283d, false));
        }
        if (c5011a.f18291e != -1) {
            this.f18284e.setText(c5011a.f18291e);
        }
        if (this.f18285f) {
            if (this.f18280a.f18290d != null) {
                m19035d();
            } else {
                m19033c();
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f18285f = true;
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.f18286g = getWidth();
        if (this.f18280a != null) {
            if (this.f18280a.f18290d != null) {
                m19035d();
            } else {
                m19033c();
            }
        }
        return true;
    }

    /* renamed from: b */
    public void m19039b() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f18285f) {
            Message.obtain(f18279h, 0, this).sendToTarget();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f18280a.f18292f != null) {
            this.f18280a.f18292f.m19052a(this.f18280a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f18279h.removeMessages(0, this);
        if (this.f18280a.f18292f != null) {
            this.f18280a.f18292f.m19053b(this.f18280a);
        }
    }
}
