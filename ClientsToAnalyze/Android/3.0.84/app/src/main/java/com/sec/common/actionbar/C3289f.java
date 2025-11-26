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
import com.sec.common.C3310c;
import com.sec.common.C3313d;
import com.sec.common.C3323e;
import com.sec.common.C3330f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ActionBarHelperBase.java */
/* renamed from: com.sec.common.actionbar.f */
/* loaded from: classes.dex */
class C3289f extends AbstractC3288e implements InterfaceC3298o {

    /* renamed from: b */
    private static final String f11916b = C3289f.class.getSimpleName();

    /* renamed from: c */
    private ViewGroup f11917c;

    /* renamed from: d */
    private ViewGroup f11918d;

    /* renamed from: e */
    private ActionBarView f11919e;

    /* renamed from: f */
    private AbstractC3284a f11920f;

    /* renamed from: g */
    private int f11921g;

    /* renamed from: h */
    private MenuC3303t f11922h;

    protected C3289f(Activity activity) {
        super(activity);
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11608a(Bundle bundle) {
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: b */
    public void mo11615b(Bundle bundle) {
        m11617c();
        m11619e();
    }

    @Override // com.sec.common.actionbar.InterfaceC3298o
    /* renamed from: a */
    public void mo11620a(View view, MenuItem menuItem) {
        try {
            MenuItem.OnMenuItemClickListener onMenuItemClickListenerM11647b = ((MenuItemC3304u) menuItem).m11647b();
            if (onMenuItemClickListenerM11647b != null) {
                if (onMenuItemClickListenerM11647b.onMenuItemClick(menuItem)) {
                    return;
                }
            }
        } catch (ClassCastException e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f11916b, e.getMessage(), e);
            }
        }
        this.f11915a.onMenuItemSelected(0, menuItem);
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11607a(int i) {
        m11618d();
        this.f11918d.removeAllViews();
        this.f11915a.getLayoutInflater().inflate(i, this.f11918d);
        Window.Callback callback = this.f11915a.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11609a(View view) {
        m11618d();
        this.f11918d.removeAllViews();
        this.f11918d.addView(view);
        Window.Callback callback = this.f11915a.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11610a(View view, ViewGroup.LayoutParams layoutParams) {
        m11618d();
        this.f11918d.removeAllViews();
        this.f11918d.addView(view, layoutParams);
        Window.Callback callback = this.f11915a.getWindow().getCallback();
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    /* renamed from: b */
    public boolean m11621b(int i) {
        if (this.f11918d != null) {
            throw new AndroidRuntimeException("requestFeature() must be called before adding content");
        }
        switch (i) {
            case 1:
            case 2:
            case 5:
            case 8:
            case 9:
            case 10:
                this.f11921g |= 1 << i;
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
    public boolean m11622c(int i) {
        return (this.f11921g & (1 << i)) != 0;
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: b */
    public AbstractC3284a mo11614b() {
        m11617c();
        return this.f11920f;
    }

    /* renamed from: c */
    private void m11617c() {
        m11618d();
        if (this.f11920f == null) {
            this.f11920f = new C3294k(this.f11915a);
        }
        if (this.f11919e == null) {
            this.f11919e = (ActionBarView) this.f11915a.findViewById(C3310c.actionbar_view);
            this.f11920f.mo11583a(this.f11915a.getTitle());
        }
    }

    /* renamed from: d */
    private void m11618d() {
        ArrayList arrayList;
        if (this.f11917c == null) {
            this.f11917c = (ViewGroup) this.f11915a.getWindow().getDecorView().findViewById(R.id.content);
            TypedArray typedArrayObtainStyledAttributes = this.f11915a.getTheme().obtainStyledAttributes(C3323e.ActionBarCompat);
            if (typedArrayObtainStyledAttributes.getBoolean(0, false)) {
                m11621b(1);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f11918d == null) {
            if (this.f11917c.getChildCount() <= 0) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList(1);
                int childCount = this.f11917c.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.f11917c.getChildAt(0);
                    this.f11917c.removeView(childAt);
                    arrayList2.add(childAt);
                }
                arrayList = arrayList2;
            }
            View viewInflate = this.f11915a.getLayoutInflater().inflate(C3313d.actionbar_compat_decor, this.f11917c);
            this.f11918d = (ViewGroup) viewInflate.findViewById(C3310c.content);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f11918d.addView((View) it.next());
                }
            }
            this.f11917c.setId(-1);
            this.f11918d.setId(R.id.content);
            if (m11622c(1)) {
                viewInflate.findViewById(C3310c.actionbar_layout).setVisibility(8);
            }
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    protected void mo11611a(CharSequence charSequence, int i) {
        if (this.f11920f != null) {
            this.f11920f.mo11583a(charSequence);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public boolean mo11612a(Menu menu) {
        if (menu instanceof MenuC3303t) {
            return ((InterfaceC3302s) this.f11915a).onSupportCreateOptionsMenu(menu);
        }
        this.f11922h.m11640a(menu);
        return true;
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: b */
    public boolean mo11616b(Menu menu) {
        return ((InterfaceC3302s) this.f11915a).onSupportPrepareOptionsMenu(this.f11922h);
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public boolean mo11613a(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            menuItem = this.f11922h.findItem(menuItem.getItemId());
        }
        return ((InterfaceC3302s) this.f11915a).onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11606a() {
        super.mo11606a();
        m11619e();
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public MenuInflater mo11605a(MenuInflater menuInflater) {
        return new C3291h(this, this.f11915a, menuInflater);
    }

    /* renamed from: e */
    private void m11619e() {
        m11617c();
        this.f11919e.m11567c();
        if (this.f11922h == null) {
            this.f11922h = new MenuC3303t(this.f11915a, this.f11919e);
            this.f11919e.m11559a(this);
        }
        this.f11922h.clear();
        this.f11915a.onCreatePanelMenu(0, this.f11922h);
        this.f11915a.onPreparePanel(0, null, this.f11922h);
        MenuItemC3304u menuItemC3304u = new MenuItemC3304u(this.f11922h, 0, R.id.home, 0, this.f11915a.getApplicationInfo().name);
        menuItemC3304u.setVisible(false);
        this.f11919e.m11555a(new ViewOnClickListenerC3290g(this, menuItemC3304u));
    }
}
