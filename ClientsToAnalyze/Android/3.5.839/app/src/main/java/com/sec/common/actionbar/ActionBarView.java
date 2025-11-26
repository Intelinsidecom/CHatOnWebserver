package com.sec.common.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.sec.common.C4969b;
import com.sec.common.C4972c;
import com.sec.common.C4975d;
import com.sec.common.C4991e;
import com.sec.common.widget.IcsAdapterView;
import com.sec.common.widget.IcsSpinner;
import com.sec.common.widget.InterfaceC5062g;

/* loaded from: classes.dex */
class ActionBarView extends LinearLayout implements View.OnClickListener, InterfaceC5062g {

    /* renamed from: a */
    private int f18093a;

    /* renamed from: b */
    private int f18094b;

    /* renamed from: c */
    private Drawable f18095c;

    /* renamed from: d */
    private ViewGroup f18096d;

    /* renamed from: e */
    private View f18097e;

    /* renamed from: f */
    private ImageView f18098f;

    /* renamed from: g */
    private ImageView f18099g;

    /* renamed from: h */
    private TextView f18100h;

    /* renamed from: i */
    private TextView f18101i;

    /* renamed from: j */
    private IcsSpinner f18102j;

    /* renamed from: k */
    private SpinnerAdapter f18103k;

    /* renamed from: l */
    private View f18104l;

    /* renamed from: m */
    private ActionBarMenuView f18105m;

    /* renamed from: n */
    private View.OnClickListener f18106n;

    /* renamed from: o */
    private InterfaceC4947b f18107o;

    public ActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18093a = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4991e.ActionBarCompat, C4969b.actionBarStyle, 0);
        this.f18095c = typedArrayObtainStyledAttributes.getDrawable(2);
        View viewInflate = LayoutInflater.from(context).inflate(C4975d.actionbar_compat_view, this);
        this.f18096d = (ViewGroup) viewInflate.findViewById(C4972c.actionbar_home_navigation_layout);
        this.f18097e = viewInflate.findViewById(C4972c.actionbar_homeLayout);
        this.f18097e.setOnClickListener(this);
        this.f18098f = (ImageView) viewInflate.findViewById(C4972c.actionbar_up);
        this.f18099g = (ImageView) viewInflate.findViewById(C4972c.actionbar_logo);
        this.f18099g.setImageDrawable(this.f18095c);
        this.f18100h = (TextView) viewInflate.findViewById(C4972c.actionbar_compat_title);
        this.f18100h.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(4, 0));
        this.f18101i = (TextView) viewInflate.findViewById(C4972c.actionbar_compat_subtitle);
        this.f18101i.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(5, 0));
        this.f18105m = (ActionBarMenuView) viewInflate.findViewById(C4972c.actionbar_menu_layout);
        m18794a(typedArrayObtainStyledAttributes.getInt(3, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    int m18793a() {
        return this.f18093a;
    }

    /* renamed from: a */
    public void m18794a(int i) {
        int i2 = this.f18093a == -1 ? this.f18093a : this.f18093a ^ i;
        this.f18093a = i;
        if ((i2 & 4) != 0) {
            m18789b((i & 4) == 4);
        }
        if ((i2 & 1) == 0 || (i & 1) == 1) {
        }
        if ((i2 & 2) != 0) {
            m18791d((i & 2) == 2);
        }
        if ((i & 4) != 0 || (i & 2) != 0) {
            this.f18097e.setVisibility(0);
        } else {
            this.f18097e.setVisibility(8);
        }
        if ((i2 & 8) != 0) {
            m18790c((i & 8) == 8);
        }
        if ((i2 & 16) != 0) {
            m18792e((i & 16) == 16);
        }
    }

    /* renamed from: b */
    private void m18789b(boolean z) {
        if (z) {
            this.f18098f.setVisibility(0);
        } else {
            this.f18098f.setVisibility(4);
        }
    }

    /* renamed from: c */
    private void m18790c(boolean z) {
        if (z) {
            this.f18100h.setVisibility(0);
            if (TextUtils.isEmpty(this.f18101i.getText())) {
                this.f18101i.setVisibility(8);
                return;
            } else {
                this.f18101i.setVisibility(0);
                return;
            }
        }
        this.f18100h.setVisibility(8);
        this.f18101i.setVisibility(8);
    }

    /* renamed from: d */
    private void m18791d(boolean z) {
        if (z) {
            this.f18099g.setVisibility(0);
        } else {
            this.f18099g.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m18804a(boolean z) {
        if (z) {
            this.f18097e.setEnabled(true);
        } else {
            this.f18097e.setEnabled(false);
        }
    }

    /* renamed from: e */
    private void m18792e(boolean z) {
        if (this.f18104l != null) {
            if (z) {
                this.f18096d.addView(this.f18104l);
            } else {
                this.f18096d.removeView(this.f18104l);
            }
        }
    }

    /* renamed from: a */
    public void m18797a(View view) {
        boolean z = (this.f18093a & 16) == 16;
        if (this.f18104l != null && z) {
            this.f18096d.removeView(this.f18104l);
        }
        this.f18104l = view;
        if (this.f18104l != null && z) {
            this.f18096d.addView(this.f18104l);
        }
    }

    /* renamed from: a */
    public void m18803a(CharSequence charSequence) {
        this.f18100h.setText(charSequence);
    }

    /* renamed from: b */
    public void m18807b(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f18101i.setVisibility(8);
        } else {
            this.f18101i.setVisibility(0);
        }
        this.f18101i.setText(charSequence);
    }

    /* renamed from: a */
    public void m18796a(View.OnClickListener onClickListener) {
        this.f18106n = onClickListener;
    }

    /* renamed from: a */
    public void m18800a(InterfaceC4960o interfaceC4960o) {
        this.f18105m.setOnMenuItemClickListener(interfaceC4960o);
    }

    /* renamed from: a */
    public void m18795a(MenuItem menuItem) {
        this.f18105m.m18787a(menuItem);
    }

    /* renamed from: b */
    public void m18805b() {
        this.f18105m.m18786a();
    }

    /* renamed from: b */
    public void m18806b(int i) {
        this.f18094b = i;
        if (this.f18094b == 1) {
            if (this.f18102j == null) {
                this.f18102j = new IcsSpinner(getContext(), null, C4969b.actionDropDownStyle);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.gravity = 17;
                this.f18102j.setLayoutParams(layoutParams);
                this.f18102j.setAdapter(this.f18103k);
            }
            this.f18102j.setOnItemSelectedListener(this);
            this.f18096d.addView(this.f18102j);
            return;
        }
        if ((this.f18094b == 0 || this.f18094b == 2) && this.f18102j != null) {
            this.f18102j.setOnItemSelectedListener(null);
            this.f18096d.removeView(this.f18102j);
        }
    }

    /* renamed from: a */
    public void m18798a(SpinnerAdapter spinnerAdapter) {
        this.f18103k = spinnerAdapter;
        if (this.f18102j != null) {
            this.f18102j.setAdapter(spinnerAdapter);
        }
    }

    /* renamed from: c */
    public void m18808c(int i) {
        this.f18102j.setSelection(i);
    }

    /* renamed from: a */
    public void m18799a(InterfaceC4947b interfaceC4947b) {
        this.f18107o = interfaceC4947b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f18097e && this.f18106n != null) {
            this.f18106n.onClick(view);
        }
    }

    @Override // com.sec.common.widget.InterfaceC5062g
    /* renamed from: a */
    public void mo18802a(IcsAdapterView<?> icsAdapterView, View view, int i, long j) {
        if (this.f18107o != null) {
            this.f18107o.mo2908a(i, j);
        }
    }

    @Override // com.sec.common.widget.InterfaceC5062g
    /* renamed from: a */
    public void mo18801a(IcsAdapterView<?> icsAdapterView) {
    }
}
