package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.sec.chaton.R;

/* compiled from: AMSToolPopup.java */
/* renamed from: com.sec.vip.amschaton.y */
/* loaded from: classes.dex */
public class C1560y extends PopupWindow {

    /* renamed from: a */
    protected boolean f5415a;

    /* renamed from: b */
    protected boolean f5416b;

    /* renamed from: c */
    protected Bitmap f5417c;

    /* renamed from: d */
    protected InterfaceC1397bg f5418d;

    /* renamed from: e */
    private Context f5419e;

    /* renamed from: f */
    private View f5420f;

    /* renamed from: g */
    private PopupWindow f5421g;

    /* renamed from: h */
    private ImageView f5422h;

    /* renamed from: i */
    private PopupWindow.OnDismissListener f5423i;

    public C1560y(Context context, int i, boolean z) {
        super(context);
        this.f5420f = null;
        this.f5415a = false;
        this.f5416b = false;
        this.f5417c = null;
        this.f5421g = null;
        this.f5422h = null;
        this.f5418d = null;
        this.f5423i = new C1366ac(this);
        this.f5415a = z;
        this.f5416b = AMSActivity.f4630l;
        this.f5419e = context;
        setOnDismissListener(this.f5423i);
        m5645a(i);
    }

    /* renamed from: a */
    protected Context m5646a() {
        return this.f5419e;
    }

    /* renamed from: b */
    protected View m5650b() {
        return this.f5420f;
    }

    /* renamed from: a */
    public void m5649a(InterfaceC1397bg interfaceC1397bg) {
        this.f5418d = interfaceC1397bg;
    }

    /* renamed from: a */
    private void m5645a(int i) {
        if (this.f5416b || (!this.f5416b && this.f5415a)) {
            m5652c();
        }
        setBackgroundDrawable(new BitmapDrawable());
        setWidth(-2);
        setHeight(-2);
        setTouchable(true);
        setFocusable(true);
        setOutsideTouchable(true);
        this.f5420f = (ViewGroup) ((LayoutInflater) m5646a().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        setContentView(this.f5420f);
        setAnimationStyle(R.style.AMSIcs2ToolPopupWindowAnimation);
        this.f5420f.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f5420f.measure(-2, -2);
    }

    /* renamed from: c */
    protected void m5652c() {
        this.f5421g = new PopupWindow(this.f5419e);
        this.f5421g.setBackgroundDrawable(new BitmapDrawable());
        this.f5421g.setWidth(-2);
        this.f5421g.setHeight(-2);
        this.f5421g.setTouchable(false);
        this.f5421g.setFocusable(false);
        this.f5421g.setOutsideTouchable(false);
        this.f5422h = new ImageView(this.f5419e);
        this.f5422h.setScaleType(ImageView.ScaleType.CENTER);
        this.f5422h.setImageResource(R.drawable.ams_toolbar_menu_popup_01);
        this.f5421g.setContentView(this.f5422h);
        this.f5421g.setAnimationStyle(R.style.AMSIcs2ToolPopupWindowAnimation);
    }

    /* renamed from: a */
    protected void m5648a(View view, int i, int i2, boolean z) {
        if (this.f5421g != null) {
            if (z) {
                this.f5421g.showAsDropDown(view, i, i2);
            } else {
                this.f5421g.showAtLocation(view, 0, i, i2);
            }
        }
    }

    /* renamed from: d */
    protected void m5653d() {
        if (this.f5421g != null && this.f5421g.isShowing()) {
            this.f5421g.dismiss();
        }
    }

    /* renamed from: b */
    protected void m5651b(View view, int i, int i2, boolean z) {
        if (z && Build.VERSION.SDK_INT >= 11) {
            showAsDropDown(view, i, i2);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        showAtLocation(view, 0, iArr[0] + i, iArr[1] + view.getMeasuredHeight() + i2);
    }

    /* renamed from: a */
    protected void m5647a(View view, int i, int i2, int i3, int i4, boolean z) {
        if (z && Build.VERSION.SDK_INT >= 11) {
            showAsDropDown(view, i, i2);
            m5648a(view, i3, i4, z);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i5 = iArr[0];
        int measuredHeight = iArr[1] + view.getMeasuredHeight();
        showAtLocation(view, 0, i5 + i, measuredHeight + i2);
        m5648a(view, i5 + i3, measuredHeight + i4, z);
    }
}
