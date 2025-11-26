package com.sec.common.actionbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: MenuItemImpl.java */
/* renamed from: com.sec.common.actionbar.u */
/* loaded from: classes.dex */
class MenuItemC4966u implements MenuItem {

    /* renamed from: a */
    private MenuC4965t f18152a;

    /* renamed from: b */
    private final int f18153b;

    /* renamed from: c */
    private final int f18154c;

    /* renamed from: d */
    private final int f18155d;

    /* renamed from: e */
    private CharSequence f18156e;

    /* renamed from: g */
    private Drawable f18158g;

    /* renamed from: k */
    private MenuItem f18162k;

    /* renamed from: m */
    private MenuItem.OnMenuItemClickListener f18164m;

    /* renamed from: h */
    private int f18159h = 0;

    /* renamed from: i */
    private boolean f18160i = true;

    /* renamed from: j */
    private boolean f18161j = true;

    /* renamed from: l */
    private int f18163l = 0;

    /* renamed from: f */
    private CharSequence f18157f = null;

    public MenuItemC4966u(MenuC4965t menuC4965t, int i, int i2, int i3, CharSequence charSequence) {
        this.f18152a = menuC4965t;
        this.f18153b = i;
        this.f18154c = i2;
        this.f18155d = i3;
        this.f18156e = charSequence;
    }

    /* renamed from: a */
    void m18885a(MenuItem menuItem) {
        this.f18162k = menuItem;
        this.f18162k.setTitle(this.f18156e);
        this.f18162k.setTitleCondensed(this.f18157f);
        if (this.f18158g != null) {
            this.f18162k.setIcon(this.f18158g);
        }
        if (this.f18159h != 0) {
            this.f18162k.setIcon(this.f18159h);
        }
        this.f18162k.setEnabled(this.f18160i);
        this.f18162k.setVisible(this.f18161j);
        if (this.f18163l != 0) {
            this.f18162k.setVisible(false);
        } else {
            this.f18162k.setVisible(this.f18161j);
        }
        if (this.f18164m != null) {
            this.f18162k.setOnMenuItemClickListener(this.f18164m);
        }
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f18154c;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f18155d;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f18156e = charSequence;
        if (this.f18162k != null) {
            this.f18162k.setTitle(charSequence);
        }
        m18882c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        setTitle(this.f18152a.m18878a().getString(i));
        if (this.f18162k != null) {
            this.f18162k.setTitle(i);
        }
        m18882c();
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f18156e;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f18157f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f18157f != null ? this.f18157f : this.f18156e;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f18159h = 0;
        this.f18158g = drawable;
        if (this.f18162k != null) {
            this.f18162k.setIcon(drawable);
        }
        m18882c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f18158g = null;
        this.f18159h = i;
        if (this.f18162k != null) {
            this.f18162k.setIcon(i);
        }
        m18882c();
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f18158g != null) {
            return this.f18158g;
        }
        if (this.f18159h != 0) {
            return this.f18152a.m18880b().getDrawable(this.f18159h);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f18160i = z;
        if (this.f18162k != null) {
            this.f18162k.setEnabled(z);
        }
        m18882c();
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f18160i;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f18153b;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f18161j = z;
        if (this.f18162k != null) {
            if (this.f18163l != 0) {
                this.f18162k.setVisible(false);
            } else {
                this.f18162k.setVisible(this.f18161j);
            }
        }
        m18882c();
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f18161j;
    }

    /* renamed from: c */
    private void m18882c() {
        if (this.f18152a != null) {
            this.f18152a.m18881c();
        }
    }

    /* renamed from: a */
    int m18883a() {
        return this.f18163l;
    }

    /* renamed from: a */
    public void m18884a(int i) {
        this.f18163l = i;
        if (this.f18162k != null) {
            if (this.f18163l != 0) {
                this.f18162k.setVisible(false);
            } else {
                this.f18162k.setVisible(this.f18161j);
            }
        }
        m18882c();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        return null;
    }

    /* renamed from: b */
    MenuItem.OnMenuItemClickListener m18886b() {
        return this.f18164m;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f18164m = onMenuItemClickListener;
        if (this.f18162k != null) {
            this.f18162k.setOnMenuItemClickListener(this.f18164m);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return (char) 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return (char) 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        return this;
    }
}
