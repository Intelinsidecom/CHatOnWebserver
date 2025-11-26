package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.sec.chaton.R;

/* compiled from: AMSToolPopup.java */
/* renamed from: com.sec.vip.amschaton.aw */
/* loaded from: classes.dex */
public class C3421aw extends PopupWindow {

    /* renamed from: a */
    protected boolean f12523a;

    /* renamed from: b */
    protected boolean f12524b;

    /* renamed from: c */
    protected Bitmap f12525c;

    /* renamed from: d */
    protected C3576i f12526d;

    /* renamed from: e */
    protected InterfaceC3434bi f12527e;

    /* renamed from: f */
    protected InterfaceC3423ay f12528f;

    /* renamed from: g */
    private Context f12529g;

    /* renamed from: h */
    private View f12530h;

    /* renamed from: i */
    private int f12531i;

    /* renamed from: j */
    private int f12532j;

    /* renamed from: k */
    private PopupWindow f12533k;

    /* renamed from: l */
    private ImageView f12534l;

    /* renamed from: m */
    private PopupWindow.OnDismissListener f12535m;

    public C3421aw(Context context, int i, boolean z) {
        super(context);
        this.f12530h = null;
        this.f12523a = false;
        this.f12524b = false;
        this.f12525c = null;
        this.f12526d = null;
        this.f12533k = null;
        this.f12534l = null;
        this.f12527e = null;
        this.f12528f = null;
        this.f12535m = new C3422ax(this);
        this.f12523a = z;
        this.f12524b = AMSActivity.f12277j;
        this.f12529g = context;
        setOnDismissListener(this.f12535m);
        m12236a(i);
    }

    /* renamed from: e */
    protected Context m12242e() {
        return this.f12529g;
    }

    /* renamed from: f */
    protected View m12243f() {
        return this.f12530h;
    }

    /* renamed from: a */
    public void m12240a(InterfaceC3434bi interfaceC3434bi) {
        this.f12527e = interfaceC3434bi;
    }

    /* renamed from: a */
    public void m12239a(InterfaceC3423ay interfaceC3423ay) {
        this.f12528f = interfaceC3423ay;
    }

    /* renamed from: a */
    public void m12241a(C3576i c3576i) {
        this.f12526d = c3576i;
    }

    /* renamed from: g */
    public C3576i m12244g() {
        return this.f12526d;
    }

    /* renamed from: a */
    private void m12236a(int i) {
        m12245h();
        setBackgroundDrawable(new BitmapDrawable(m12242e().getResources()));
        setWidth(-2);
        setHeight(-2);
        setTouchable(true);
        setFocusable(true);
        setOutsideTouchable(true);
        this.f12530h = ((LayoutInflater) m12242e().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        setContentView(this.f12530h);
        setAnimationStyle(R.style.AMSIcs2ToolPopupWindowAnimation);
        this.f12530h.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f12530h.measure(-2, -2);
    }

    /* renamed from: h */
    protected void m12245h() {
        Bitmap bitmapDecodeResource;
        this.f12533k = new PopupWindow(this.f12529g);
        this.f12533k.setBackgroundDrawable(new BitmapDrawable(m12242e().getResources()));
        this.f12533k.setWidth(-2);
        this.f12533k.setHeight(-2);
        this.f12533k.setTouchable(false);
        this.f12533k.setFocusable(false);
        this.f12533k.setOutsideTouchable(false);
        this.f12534l = new ImageView(this.f12529g);
        this.f12534l.setScaleType(ImageView.ScaleType.CENTER);
        if (this.f12523a) {
            bitmapDecodeResource = BitmapFactory.decodeResource(m12242e().getResources(), R.drawable.ams_popup_bg_point_port);
        } else {
            bitmapDecodeResource = BitmapFactory.decodeResource(m12242e().getResources(), R.drawable.ams_popup_bg_point_land);
        }
        this.f12531i = bitmapDecodeResource.getHeight();
        this.f12532j = bitmapDecodeResource.getWidth();
        this.f12534l.setImageBitmap(bitmapDecodeResource);
        this.f12533k.setContentView(this.f12534l);
        this.f12533k.setAnimationStyle(R.style.AMSIcs2ToolPopupWindowAnimation);
    }

    /* renamed from: a */
    protected void m12238a(View view, int i, int i2, boolean z) {
        if (this.f12533k != null) {
            if (z) {
                this.f12533k.showAsDropDown(view, i, i2);
            } else {
                this.f12533k.showAtLocation(view, 0, i, i2);
            }
        }
    }

    /* renamed from: i */
    protected void m12246i() {
        if (this.f12533k != null && this.f12533k.isShowing()) {
            this.f12533k.dismiss();
        }
    }

    /* renamed from: a */
    protected void m12237a(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (this.f12523a) {
            int measuredWidth = iArr[0] + (view.getMeasuredWidth() / 2);
            int measuredHeight = view.getMeasuredHeight() + iArr[1];
            int i3 = measuredWidth - (i / 2);
            int i4 = (this.f12531i + measuredHeight) - 4;
            if (i3 < 0) {
                i3 = 0;
            }
            showAtLocation(view, 0, i3, i4);
            m12238a(view, measuredWidth, measuredHeight, false);
            return;
        }
        int measuredWidth2 = iArr[0] + view.getMeasuredWidth();
        int measuredHeight2 = (view.getMeasuredHeight() / 2) + iArr[1];
        int i5 = (this.f12532j + measuredWidth2) - 3;
        int i6 = measuredHeight2 - (i2 / 2);
        if (i6 < 0) {
            i6 = 0;
        }
        showAtLocation(view, 0, i5, i6);
        m12238a(view, measuredWidth2, measuredHeight2, false);
    }
}
