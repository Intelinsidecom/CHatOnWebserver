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
/* renamed from: com.sec.vip.amschaton.at */
/* loaded from: classes.dex */
public class C1860at extends PopupWindow {

    /* renamed from: a */
    protected boolean f6812a;

    /* renamed from: b */
    protected boolean f6813b;

    /* renamed from: c */
    protected Bitmap f6814c;

    /* renamed from: d */
    protected DialogC1891h f6815d;

    /* renamed from: e */
    protected InterfaceC1872be f6816e;

    /* renamed from: f */
    private Context f6817f;

    /* renamed from: g */
    private View f6818g;

    /* renamed from: h */
    private PopupWindow f6819h;

    /* renamed from: i */
    private ImageView f6820i;

    /* renamed from: j */
    private PopupWindow.OnDismissListener f6821j;

    public C1860at(Context context, int i, boolean z) {
        super(context);
        this.f6818g = null;
        this.f6812a = false;
        this.f6813b = false;
        this.f6814c = null;
        this.f6815d = null;
        this.f6819h = null;
        this.f6820i = null;
        this.f6816e = null;
        this.f6821j = new C1861au(this);
        this.f6812a = z;
        this.f6813b = AMSActivity.f6617j;
        this.f6817f = context;
        setOnDismissListener(this.f6821j);
        m6438a(i);
    }

    /* renamed from: e */
    protected Context m6443e() {
        return this.f6817f;
    }

    /* renamed from: f */
    protected View m6444f() {
        return this.f6818g;
    }

    /* renamed from: a */
    public void m6441a(InterfaceC1872be interfaceC1872be) {
        this.f6816e = interfaceC1872be;
    }

    /* renamed from: a */
    private void m6438a(int i) {
        if (this.f6813b || (!this.f6813b && this.f6812a)) {
            m6445g();
        }
        setBackgroundDrawable(new BitmapDrawable());
        setWidth(-2);
        setHeight(-2);
        setTouchable(true);
        setFocusable(true);
        setOutsideTouchable(true);
        this.f6818g = (ViewGroup) ((LayoutInflater) m6443e().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        setContentView(this.f6818g);
        setAnimationStyle(R.style.AMSIcs2ToolPopupWindowAnimation);
        this.f6818g.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f6818g.measure(-2, -2);
    }

    /* renamed from: g */
    protected void m6445g() {
        this.f6819h = new PopupWindow(this.f6817f);
        this.f6819h.setBackgroundDrawable(new BitmapDrawable());
        this.f6819h.setWidth(-2);
        this.f6819h.setHeight(-2);
        this.f6819h.setTouchable(false);
        this.f6819h.setFocusable(false);
        this.f6819h.setOutsideTouchable(false);
        this.f6820i = new ImageView(this.f6817f);
        this.f6820i.setScaleType(ImageView.ScaleType.CENTER);
        this.f6820i.setImageResource(R.drawable.ams_toolbar_menu_popup_01);
        this.f6819h.setContentView(this.f6820i);
        this.f6819h.setAnimationStyle(R.style.AMSIcs2ToolPopupWindowAnimation);
    }

    /* renamed from: a */
    protected void m6440a(View view, int i, int i2, boolean z) {
        if (this.f6819h != null) {
            if (z) {
                this.f6819h.showAsDropDown(view, i, i2);
            } else {
                this.f6819h.showAtLocation(view, 0, i, i2);
            }
        }
    }

    /* renamed from: h */
    protected void m6446h() {
        if (this.f6819h != null && this.f6819h.isShowing()) {
            this.f6819h.dismiss();
        }
    }

    /* renamed from: b */
    protected void m6442b(View view, int i, int i2, boolean z) {
        if (z && Build.VERSION.SDK_INT >= 11) {
            showAsDropDown(view, i, i2);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        showAtLocation(view, 0, iArr[0] + i, iArr[1] + view.getMeasuredHeight() + i2);
    }

    /* renamed from: a */
    protected void m6439a(View view, int i, int i2, int i3, int i4, boolean z) {
        if (z && Build.VERSION.SDK_INT >= 11) {
            showAsDropDown(view, i, i2);
            m6440a(view, i3, i4, z);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i5 = iArr[0];
        int measuredHeight = iArr[1] + view.getMeasuredHeight();
        showAtLocation(view, 0, i5 + i, measuredHeight + i2);
        m6440a(view, i5 + i3, measuredHeight + i4, z);
    }
}
