package com.sec.common.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.common.C4969b;
import com.sec.common.C4975d;
import com.sec.common.C4991e;
import com.sec.common.widget.HoneycombLinearLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class TabContainerView extends HoneycombLinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private List<TabView> f18108a;

    /* renamed from: b */
    private InterfaceC4968w f18109b;

    public TabContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18108a = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4991e.ActionBarCompat, C4969b.actionBarStyle, 0);
        setBackgroundResource(typedArrayObtainStyledAttributes.getResourceId(6, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private TabView m18809b(AbstractC4948c abstractC4948c) {
        TabView tabView = (TabView) LayoutInflater.from(getContext()).inflate(C4975d.actionbar_compat_tab_view, (ViewGroup) null);
        this.f18108a.add(tabView);
        tabView.f18110a = (C4958m) abstractC4948c;
        tabView.f18110a.m18868a(this.f18108a.size() - 1);
        tabView.f18110a.m18869a(new C4967v(this, tabView));
        return tabView;
    }

    /* renamed from: b */
    void m18813b(int i) {
        if (i <= this.f18108a.size()) {
            int i2 = 0;
            while (i2 < this.f18108a.size()) {
                boolean z = i2 == i;
                TabView tabView = this.f18108a.get(i2);
                tabView.setSelected(z);
                if (z && this.f18109b != null) {
                    this.f18109b.mo18867b(tabView.f18110a);
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    public void m18811a(AbstractC4948c abstractC4948c) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
        TabView tabViewM18809b = m18809b(abstractC4948c);
        tabViewM18809b.setTitle(abstractC4948c.mo18842c());
        tabViewM18809b.setFocusable(true);
        tabViewM18809b.setOnClickListener(this);
        if (abstractC4948c.mo18838a() != null) {
            tabViewM18809b.setCustomView(abstractC4948c.mo18838a());
        }
        addView(tabViewM18809b, layoutParams);
    }

    /* renamed from: c */
    public AbstractC4948c m18814c(int i) {
        return this.f18108a.get(i).f18110a;
    }

    /* renamed from: a */
    int m18810a() {
        return this.f18108a.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < this.f18108a.size(); i++) {
            if (view == this.f18108a.get(i)) {
                m18813b(i);
                return;
            }
        }
    }

    /* renamed from: a */
    public void m18812a(InterfaceC4968w interfaceC4968w) {
        this.f18109b = interfaceC4968w;
    }

    public class TabView extends LinearLayout {

        /* renamed from: a */
        private C4958m f18110a;

        /* renamed from: b */
        private TextView f18111b;

        /* renamed from: c */
        private View f18112c;

        public TabView(Context context) {
            super(context);
            m18817a();
        }

        public TabView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            m18817a();
        }

        /* renamed from: a */
        private void m18817a() {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(C4991e.CommonTheme);
            if (this.f18112c != null) {
                if (this.f18111b != null) {
                    this.f18111b.setVisibility(8);
                }
                if (this.f18112c.getParent() != this) {
                    addView(this.f18112c);
                }
            } else {
                if (this.f18111b == null) {
                    this.f18111b = new TextView(getContext());
                    this.f18111b.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(3, 0));
                    addView(this.f18111b);
                }
                if (this.f18112c != null) {
                    removeView(this.f18112c);
                    this.f18112c = null;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void setTitle(CharSequence charSequence) {
            if (this.f18111b != null) {
                this.f18111b.setText(charSequence);
            }
        }

        public void setCustomView(View view) {
            this.f18112c = view;
            m18817a();
        }
    }
}
