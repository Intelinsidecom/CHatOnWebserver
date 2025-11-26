package com.sec.widget;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: DropPanelMenuItemImpl.java */
/* renamed from: com.sec.widget.v */
/* loaded from: classes.dex */
public final class MenuItemC3688v implements MenuItem {

    /* renamed from: a */
    private MenuC3687u f13602a;

    /* renamed from: c */
    private SubMenu f13604c;

    /* renamed from: d */
    private ContextMenu.ContextMenuInfo f13605d;

    /* renamed from: e */
    private final int f13606e;

    /* renamed from: f */
    private final int f13607f;

    /* renamed from: g */
    private final int f13608g;

    /* renamed from: h */
    private final int f13609h;

    /* renamed from: i */
    private CharSequence f13610i;

    /* renamed from: j */
    private CharSequence f13611j;

    /* renamed from: k */
    private Intent f13612k;

    /* renamed from: l */
    private char f13613l;

    /* renamed from: m */
    private char f13614m;

    /* renamed from: n */
    private Drawable f13615n;

    /* renamed from: p */
    private MenuItem.OnMenuItemClickListener f13617p;

    /* renamed from: b */
    private View f13603b = null;

    /* renamed from: o */
    private int f13616o = 0;

    /* renamed from: q */
    private int f13618q = 16;

    MenuItemC3688v(MenuC3687u menuC3687u, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f13602a = menuC3687u;
        this.f13606e = i2;
        this.f13607f = i;
        this.f13608g = i3;
        this.f13609h = i4;
        this.f13610i = charSequence;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f13606e;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f13607f;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f13608g;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f13610i = charSequence;
        this.f13602a.m13275a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f13602a.m13272a().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f13610i;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13611j = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f13610i;
        }
        this.f13602a.m13275a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f13611j != null ? this.f13611j : this.f13610i;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f13616o = 0;
        this.f13615n = drawable;
        this.f13602a.m13275a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f13615n = null;
        this.f13616o = i;
        this.f13602a.m13275a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f13615n != null) {
            return this.f13615n;
        }
        if (this.f13616o != 0) {
            return this.f13602a.m13277b().getDrawable(this.f13616o);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f13612k = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f13612k;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f13613l = c;
        this.f13614m = Character.toLowerCase(c2);
        this.f13602a.m13275a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f13613l != c) {
            this.f13613l = c;
            this.f13602a.m13275a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f13613l;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f13614m != c) {
            this.f13614m = Character.toLowerCase(c);
            this.f13602a.m13275a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f13614m;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f13618q;
        this.f13618q = (z ? 1 : 0) | (this.f13618q & (-2));
        if (i != this.f13618q) {
            this.f13602a.m13275a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f13618q & 1) == 1;
    }

    /* renamed from: a */
    void m13281a(boolean z) {
        int i = this.f13618q;
        this.f13618q = (z ? 2 : 0) | (this.f13618q & (-3));
        if (i != this.f13618q) {
            this.f13602a.m13275a(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        m13281a(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f13618q & 2) == 2;
    }

    /* renamed from: b */
    boolean m13283b(boolean z) {
        int i = this.f13618q;
        this.f13618q = (z ? 0 : 8) | (this.f13618q & (-9));
        return i != this.f13618q;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m13283b(z)) {
            this.f13602a.m13274a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f13618q & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f13618q |= 16;
        } else {
            this.f13618q &= -17;
        }
        if (this.f13603b != null) {
            LinearLayout linearLayout = (LinearLayout) this.f13603b;
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                linearLayout.getChildAt(i).setEnabled(z);
            }
        }
        this.f13602a.m13275a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f13618q & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f13604c != null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f13604c;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f13617p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f13605d;
    }

    /* renamed from: a */
    public int m13278a() {
        return this.f13609h;
    }

    /* renamed from: a */
    void m13279a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f13605d = contextMenuInfo;
    }

    /* renamed from: c */
    public void m13284c(boolean z) {
        this.f13618q = (z ? 4 : 0) | (this.f13618q & (-5));
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        return null;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        return null;
    }

    /* renamed from: a */
    public void m13280a(View view) {
        if (view != null) {
            this.f13603b = view;
        }
    }

    /* renamed from: b */
    public View m13282b() {
        return this.f13603b;
    }
}
