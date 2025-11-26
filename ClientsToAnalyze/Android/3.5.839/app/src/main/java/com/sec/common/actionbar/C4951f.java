package com.sec.common.actionbar;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.sec.common.C4972c;
import com.sec.common.C4975d;
import com.sec.common.C4991e;
import com.sec.common.C4996f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ActionBarHelperBase.java */
/* renamed from: com.sec.common.actionbar.f */
/* loaded from: classes.dex */
class C4951f extends AbstractC4950e implements InterfaceC4960o {

    /* renamed from: b */
    private static final String f18114b = C4951f.class.getSimpleName();

    /* renamed from: c */
    private ViewGroup f18115c;

    /* renamed from: d */
    private ViewGroup f18116d;

    /* renamed from: e */
    private ActionBarView f18117e;

    /* renamed from: f */
    private AbstractC4946a f18118f;

    /* renamed from: g */
    private int f18119g;

    /* renamed from: h */
    private MenuC4965t f18120h;

    protected C4951f(Activity activity) {
        super(activity);
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18847a(Bundle bundle) {
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: b */
    public void mo18854b(Bundle bundle) {
        m18856c();
        m18858e();
    }

    @Override // com.sec.common.actionbar.InterfaceC4960o
    /* renamed from: a */
    public void mo18859a(View view, MenuItem menuItem) {
        try {
            MenuItem.OnMenuItemClickListener onMenuItemClickListenerM18886b = ((MenuItemC4966u) menuItem).m18886b();
            if (onMenuItemClickListenerM18886b != null) {
                if (onMenuItemClickListenerM18886b.onMenuItemClick(menuItem)) {
                    return;
                }
            }
        } catch (ClassCastException e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f18114b, e.getMessage(), e);
            }
        }
        this.f18113a.onMenuItemSelected(0, menuItem);
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18846a(int i) {
        m18857d();
        this.f18116d.removeAllViews();
        this.f18113a.getLayoutInflater().inflate(i, this.f18116d);
        Window.Callback callback = this.f18113a.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18848a(View view) {
        m18857d();
        this.f18116d.removeAllViews();
        this.f18116d.addView(view);
        Window.Callback callback = this.f18113a.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18849a(View view, ViewGroup.LayoutParams layoutParams) {
        m18857d();
        this.f18116d.removeAllViews();
        this.f18116d.addView(view, layoutParams);
        Window.Callback callback = this.f18113a.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    /* renamed from: b */
    public boolean m18860b(int i) {
        if (this.f18116d != null) {
            throw new AndroidRuntimeException("requestFeature() must be called before adding content");
        }
        switch (i) {
            case 1:
            case 2:
            case 5:
            case 8:
            case 9:
            case 10:
                this.f18119g |= 1 << i;
                return true;
            case 3:
            case 4:
            case 6:
            case 7:
            default:
                return false;
        }
    }

    /* renamed from: c */
    public boolean m18861c(int i) {
        return (this.f18119g & (1 << i)) != 0;
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: b */
    public AbstractC4946a mo18853b() {
        m18856c();
        return this.f18118f;
    }

    /* renamed from: c */
    private void m18856c() {
        m18857d();
        if (this.f18118f == null) {
            this.f18118f = new C4956k(this.f18113a);
        }
        if (this.f18117e == null) {
            this.f18117e = (ActionBarView) this.f18113a.findViewById(C4972c.actionbar_view);
            this.f18118f.mo18823a(this.f18113a.getTitle());
        }
    }

    /* renamed from: d */
    private void m18857d() {
        ArrayList arrayList;
        if (this.f18115c == null) {
            this.f18115c = (ViewGroup) this.f18113a.getWindow().getDecorView().findViewById(R.id.content);
            TypedArray typedArrayObtainStyledAttributes = this.f18113a.getTheme().obtainStyledAttributes(C4991e.ActionBarCompat);
            if (typedArrayObtainStyledAttributes.getBoolean(0, false)) {
                m18860b(1);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f18116d == null) {
            if (this.f18115c.getChildCount() <= 0) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList(1);
                int childCount = this.f18115c.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.f18115c.getChildAt(0);
                    this.f18115c.removeView(childAt);
                    arrayList2.add(childAt);
                }
                arrayList = arrayList2;
            }
            View viewInflate = this.f18113a.getLayoutInflater().inflate(C4975d.actionbar_compat_decor, this.f18115c);
            this.f18116d = (ViewGroup) viewInflate.findViewById(C4972c.content);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f18116d.addView((View) it.next());
                }
            }
            this.f18115c.setId(-1);
            this.f18116d.setId(R.id.content);
            if (m18861c(1)) {
                viewInflate.findViewById(C4972c.actionbar_layout).setVisibility(8);
            }
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    protected void mo18850a(CharSequence charSequence, int i) {
        if (this.f18118f != null) {
            this.f18118f.mo18823a(charSequence);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public boolean mo18851a(Menu menu) {
        if (menu instanceof MenuC4965t) {
            return ((InterfaceC4964s) this.f18113a).onSupportCreateOptionsMenu(menu);
        }
        this.f18120h.m18879a(menu);
        return true;
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: b */
    public boolean mo18855b(Menu menu) {
        return ((InterfaceC4964s) this.f18113a).onSupportPrepareOptionsMenu(this.f18120h);
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public boolean mo18852a(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            menuItem = this.f18120h.findItem(menuItem.getItemId());
        }
        return ((InterfaceC4964s) this.f18113a).onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18845a() {
        super.mo18845a();
        m18858e();
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public MenuInflater mo18844a(MenuInflater menuInflater) {
        return new C4953h(this, this.f18113a, menuInflater);
    }

    /* renamed from: e */
    private void m18858e() {
        m18856c();
        this.f18117e.m18805b();
        if (this.f18120h == null) {
            this.f18120h = new MenuC4965t(this.f18113a, this.f18117e);
            this.f18117e.m18800a(this);
        }
        this.f18120h.clear();
        this.f18113a.onCreatePanelMenu(0, this.f18120h);
        this.f18113a.onPreparePanel(0, null, this.f18120h);
        MenuItemC4966u menuItemC4966u = new MenuItemC4966u(this.f18120h, 0, R.id.home, 0, this.f18113a.getApplicationInfo().name);
        menuItemC4966u.setVisible(false);
        this.f18117e.m18796a(new ViewOnClickListenerC4952g(this, menuItemC4966u));
    }
}
