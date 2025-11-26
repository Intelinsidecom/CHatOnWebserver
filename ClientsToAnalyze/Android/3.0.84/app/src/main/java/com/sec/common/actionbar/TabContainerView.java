package com.sec.common.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.common.C3307b;
import com.sec.common.C3313d;
import com.sec.common.C3323e;
import com.sec.common.widget.HoneycombLinearLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class TabContainerView extends HoneycombLinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private List<TabView> f11910a;

    /* renamed from: b */
    private InterfaceC3306w f11911b;

    public TabContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11910a = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3323e.ActionBarCompat, C3307b.actionBarStyle, 0);
        setBackgroundResource(typedArrayObtainStyledAttributes.getResourceId(6, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private TabView m11569b(AbstractC3286c abstractC3286c) {
        TabView tabView = (TabView) LayoutInflater.from(getContext()).inflate(C3313d.actionbar_compat_tab_view, (ViewGroup) null);
        this.f11910a.add(tabView);
        tabView.f11912a = (C3296m) abstractC3286c;
        tabView.f11912a.m11629a(this.f11910a.size() - 1);
        tabView.f11912a.m11630a(new C3305v(this, tabView));
        return tabView;
    }

    /* renamed from: b */
    void m11573b(int i) {
        if (i <= this.f11910a.size()) {
            int i2 = 0;
            while (i2 < this.f11910a.size()) {
                boolean z = i2 == i;
                TabView tabView = this.f11910a.get(i2);
                tabView.setSelected(z);
                if (z && this.f11911b != null) {
                    this.f11911b.mo11628b(tabView.f11912a);
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    public void m11571a(AbstractC3286c abstractC3286c) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
        TabView tabViewM11569b = m11569b(abstractC3286c);
        tabViewM11569b.setTitle(abstractC3286c.mo11603c());
        tabViewM11569b.setFocusable(true);
        tabViewM11569b.setOnClickListener(this);
        if (abstractC3286c.mo11599a() != null) {
            tabViewM11569b.setCustomView(abstractC3286c.mo11599a());
        }
        addView(tabViewM11569b, layoutParams);
    }

    /* renamed from: c */
    public AbstractC3286c m11574c(int i) {
        return this.f11910a.get(i).f11912a;
    }

    /* renamed from: a */
    int m11570a() {
        return this.f11910a.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < this.f11910a.size(); i++) {
            if (view == this.f11910a.get(i)) {
                m11573b(i);
                return;
            }
        }
    }

    /* renamed from: a */
    public void m11572a(InterfaceC3306w interfaceC3306w) {
        this.f11911b = interfaceC3306w;
    }

    public class TabView extends LinearLayout {

        /* renamed from: a */
        private C3296m f11912a;

        /* renamed from: b */
        private TextView f11913b;

        /* renamed from: c */
        private View f11914c;

        public TabView(Context context) {
            super(context);
            m11577a();
        }

        public TabView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            m11577a();
        }

        /* renamed from: a */
        private void m11577a() {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(C3323e.CommonTheme);
            if (this.f11914c != null) {
                if (this.f11913b != null) {
                    this.f11913b.setVisibility(8);
                }
                if (this.f11914c.getParent() != this) {
                    addView(this.f11914c);
                }
            } else {
                if (this.f11913b == null) {
                    this.f11913b = new TextView(getContext());
                    this.f11913b.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(3, 0));
                    addView(this.f11913b);
                }
                if (this.f11914c != null) {
                    removeView(this.f11914c);
                    this.f11914c = null;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void setTitle(CharSequence charSequence) {
            if (this.f11913b != null) {
                this.f11913b.setText(charSequence);
            }
        }

        public void setCustomView(View view) {
            this.f11914c = view;
            m11577a();
        }
    }
}
