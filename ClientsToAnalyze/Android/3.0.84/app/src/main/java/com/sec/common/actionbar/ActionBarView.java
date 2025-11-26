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
import com.sec.common.C3307b;
import com.sec.common.C3310c;
import com.sec.common.C3313d;
import com.sec.common.C3323e;
import com.sec.common.widget.IcsAdapterView;
import com.sec.common.widget.IcsSpinner;
import com.sec.common.widget.InterfaceC3378k;

/* loaded from: classes.dex */
class ActionBarView extends LinearLayout implements View.OnClickListener, InterfaceC3378k {

    /* renamed from: a */
    private final int f11894a;

    /* renamed from: b */
    private int f11895b;

    /* renamed from: c */
    private int f11896c;

    /* renamed from: d */
    private Drawable f11897d;

    /* renamed from: e */
    private ViewGroup f11898e;

    /* renamed from: f */
    private View f11899f;

    /* renamed from: g */
    private ImageView f11900g;

    /* renamed from: h */
    private ImageView f11901h;

    /* renamed from: i */
    private TextView f11902i;

    /* renamed from: j */
    private TextView f11903j;

    /* renamed from: k */
    private IcsSpinner f11904k;

    /* renamed from: l */
    private SpinnerAdapter f11905l;

    /* renamed from: m */
    private View f11906m;

    /* renamed from: n */
    private ActionBarMenuView f11907n;

    /* renamed from: o */
    private View.OnClickListener f11908o;

    /* renamed from: p */
    private InterfaceC3285b f11909p;

    public ActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11894a = 0;
        this.f11895b = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3323e.ActionBarCompat, C3307b.actionBarStyle, 0);
        this.f11897d = typedArrayObtainStyledAttributes.getDrawable(2);
        View viewInflate = LayoutInflater.from(context).inflate(C3313d.actionbar_compat_view, this);
        this.f11898e = (ViewGroup) viewInflate.findViewById(C3310c.actionbar_home_navigation_layout);
        this.f11899f = viewInflate.findViewById(C3310c.actionbar_homeLayout);
        this.f11899f.setOnClickListener(this);
        this.f11900g = (ImageView) viewInflate.findViewById(C3310c.actionbar_up);
        this.f11901h = (ImageView) viewInflate.findViewById(C3310c.actionbar_logo);
        this.f11901h.setImageDrawable(this.f11897d);
        this.f11902i = (TextView) viewInflate.findViewById(C3310c.actionbar_compat_title);
        this.f11902i.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(4, 0));
        this.f11903j = (TextView) viewInflate.findViewById(C3310c.actionbar_compat_subtitle);
        this.f11903j.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(5, 0));
        this.f11907n = (ActionBarMenuView) viewInflate.findViewById(C3310c.actionbar_menu_layout);
        m11553a(typedArrayObtainStyledAttributes.getInt(3, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    int m11552a() {
        return this.f11895b;
    }

    /* renamed from: a */
    public void m11553a(int i) {
        int i2 = this.f11895b == -1 ? this.f11895b : this.f11895b ^ i;
        this.f11895b = i;
        if ((i2 & 4) != 0) {
            m11548b((i & 4) == 4);
        }
        if ((i2 & 1) == 0 || (i & 1) == 1) {
        }
        if ((i2 & 2) != 0) {
            m11550d((i & 2) == 2);
        }
        if ((i & 4) != 0 || (i & 2) != 0) {
            this.f11899f.setVisibility(0);
        } else {
            this.f11899f.setVisibility(8);
        }
        if ((i2 & 8) != 0) {
            m11549c((i & 8) == 8);
        }
        if ((i2 & 16) != 0) {
            m11551e((i & 16) == 16);
        }
    }

    /* renamed from: b */
    private void m11548b(boolean z) {
        if (z) {
            this.f11900g.setVisibility(0);
        } else {
            this.f11900g.setVisibility(4);
        }
    }

    /* renamed from: c */
    private void m11549c(boolean z) {
        if (z) {
            this.f11902i.setVisibility(0);
            if (TextUtils.isEmpty(this.f11903j.getText())) {
                this.f11903j.setVisibility(8);
                return;
            } else {
                this.f11903j.setVisibility(0);
                return;
            }
        }
        this.f11902i.setVisibility(8);
        this.f11903j.setVisibility(8);
    }

    /* renamed from: d */
    private void m11550d(boolean z) {
        if (z) {
            this.f11901h.setVisibility(0);
        } else {
            this.f11901h.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m11563a(boolean z) {
        if (z) {
            this.f11899f.setEnabled(true);
        } else {
            this.f11899f.setEnabled(false);
        }
    }

    /* renamed from: e */
    private void m11551e(boolean z) {
        if (this.f11906m != null) {
            if (z) {
                this.f11898e.addView(this.f11906m);
            } else {
                this.f11898e.removeView(this.f11906m);
            }
        }
    }

    /* renamed from: b */
    public View m11564b() {
        return this.f11906m;
    }

    /* renamed from: a */
    public void m11556a(View view) {
        boolean z = (this.f11895b & 16) == 16;
        if (this.f11906m != null && z) {
            this.f11898e.removeView(this.f11906m);
        }
        this.f11906m = view;
        if (this.f11906m != null && z) {
            this.f11898e.addView(this.f11906m);
        }
    }

    /* renamed from: a */
    public void m11562a(CharSequence charSequence) {
        this.f11902i.setText(charSequence);
    }

    /* renamed from: b */
    public void m11566b(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f11903j.setVisibility(8);
        } else {
            this.f11903j.setVisibility(0);
        }
        this.f11903j.setText(charSequence);
    }

    /* renamed from: a */
    public void m11555a(View.OnClickListener onClickListener) {
        this.f11908o = onClickListener;
    }

    /* renamed from: a */
    public void m11559a(InterfaceC3298o interfaceC3298o) {
        this.f11907n.setOnMenuItemClickListener(interfaceC3298o);
    }

    /* renamed from: a */
    public void m11554a(MenuItem menuItem) {
        this.f11907n.m11546a(menuItem);
    }

    /* renamed from: c */
    public void m11567c() {
        this.f11907n.m11545a();
    }

    /* renamed from: b */
    public void m11565b(int i) {
        this.f11896c = i;
        if (this.f11896c == 1) {
            if (this.f11904k == null) {
                this.f11904k = new IcsSpinner(getContext(), null, C3307b.actionDropDownStyle);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.gravity = 17;
                this.f11904k.setLayoutParams(layoutParams);
                this.f11904k.setAdapter(this.f11905l);
            }
            this.f11904k.setOnItemSelectedListener(this);
            this.f11898e.addView(this.f11904k);
            return;
        }
        if ((this.f11896c == 0 || this.f11896c == 2) && this.f11904k != null) {
            this.f11904k.setOnItemSelectedListener(null);
            this.f11898e.removeView(this.f11904k);
        }
    }

    /* renamed from: a */
    public void m11557a(SpinnerAdapter spinnerAdapter) {
        this.f11905l = spinnerAdapter;
        if (this.f11904k != null) {
            this.f11904k.setAdapter(spinnerAdapter);
        }
    }

    /* renamed from: c */
    public void m11568c(int i) {
        this.f11904k.setSelection(i);
    }

    /* renamed from: a */
    public void m11558a(InterfaceC3285b interfaceC3285b) {
        this.f11909p = interfaceC3285b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f11899f && this.f11908o != null) {
            this.f11908o.onClick(view);
        }
    }

    @Override // com.sec.common.widget.InterfaceC3378k
    /* renamed from: a */
    public void mo11561a(IcsAdapterView<?> icsAdapterView, View view, int i, long j) {
        if (this.f11909p != null) {
            this.f11909p.mo1154a(i, j);
        }
    }

    @Override // com.sec.common.widget.InterfaceC3378k
    /* renamed from: a */
    public void mo11560a(IcsAdapterView<?> icsAdapterView) {
    }
}
