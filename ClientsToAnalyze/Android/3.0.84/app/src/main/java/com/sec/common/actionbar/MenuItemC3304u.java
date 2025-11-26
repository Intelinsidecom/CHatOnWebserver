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
class MenuItemC3304u implements MenuItem {

    /* renamed from: a */
    private MenuC3303t f11954a;

    /* renamed from: b */
    private final int f11955b;

    /* renamed from: c */
    private final int f11956c;

    /* renamed from: d */
    private final int f11957d;

    /* renamed from: e */
    private CharSequence f11958e;

    /* renamed from: g */
    private Drawable f11960g;

    /* renamed from: k */
    private MenuItem f11964k;

    /* renamed from: m */
    private MenuItem.OnMenuItemClickListener f11966m;

    /* renamed from: h */
    private int f11961h = 0;

    /* renamed from: i */
    private boolean f11962i = true;

    /* renamed from: j */
    private boolean f11963j = true;

    /* renamed from: l */
    private int f11965l = 0;

    /* renamed from: f */
    private CharSequence f11959f = null;

    public MenuItemC3304u(MenuC3303t menuC3303t, int i, int i2, int i3, CharSequence charSequence) {
        this.f11954a = menuC3303t;
        this.f11955b = i;
        this.f11956c = i2;
        this.f11957d = i3;
        this.f11958e = charSequence;
    }

    /* renamed from: a */
    void m11646a(MenuItem menuItem) {
        this.f11964k = menuItem;
        this.f11964k.setTitle(this.f11958e);
        this.f11964k.setTitleCondensed(this.f11959f);
        if (this.f11960g != null) {
            this.f11964k.setIcon(this.f11960g);
        }
        if (this.f11961h != 0) {
            this.f11964k.setIcon(this.f11961h);
        }
        this.f11964k.setEnabled(this.f11962i);
        this.f11964k.setVisible(this.f11963j);
        if (this.f11965l != 0) {
            this.f11964k.setVisible(false);
        } else {
            this.f11964k.setVisible(this.f11963j);
        }
        if (this.f11966m != null) {
            this.f11964k.setOnMenuItemClickListener(this.f11966m);
        }
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f11956c;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f11957d;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f11958e = charSequence;
        if (this.f11964k != null) {
            this.f11964k.setTitle(charSequence);
        }
        m11643c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        setTitle(this.f11954a.m11639a().getString(i));
        if (this.f11964k != null) {
            this.f11964k.setTitle(i);
        }
        m11643c();
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f11958e;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f11959f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f11959f != null ? this.f11959f : this.f11958e;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f11961h = 0;
        this.f11960g = drawable;
        if (this.f11964k != null) {
            this.f11964k.setIcon(drawable);
        }
        m11643c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f11960g = null;
        this.f11961h = i;
        if (this.f11964k != null) {
            this.f11964k.setIcon(i);
        }
        m11643c();
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f11960g != null) {
            return this.f11960g;
        }
        if (this.f11961h != 0) {
            return this.f11954a.m11641b().getDrawable(this.f11961h);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f11962i = z;
        if (this.f11964k != null) {
            this.f11964k.setEnabled(z);
        }
        m11643c();
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f11962i;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f11955b;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f11963j = z;
        if (this.f11964k != null) {
            if (this.f11965l != 0) {
                this.f11964k.setVisible(false);
            } else {
                this.f11964k.setVisible(this.f11963j);
            }
        }
        m11643c();
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f11963j;
    }

    /* renamed from: c */
    private void m11643c() {
        if (this.f11954a != null) {
            this.f11954a.m11642c();
        }
    }

    /* renamed from: a */
    int m11644a() {
        return this.f11965l;
    }

    /* renamed from: a */
    public void m11645a(int i) {
        this.f11965l = i;
        if (this.f11964k != null) {
            if (this.f11965l != 0) {
                this.f11964k.setVisible(false);
            } else {
                this.f11964k.setVisible(this.f11963j);
            }
        }
        m11643c();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        return null;
    }

    /* renamed from: b */
    MenuItem.OnMenuItemClickListener m11647b() {
        return this.f11966m;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f11966m = onMenuItemClickListener;
        if (this.f11964k != null) {
            this.f11964k.setOnMenuItemClickListener(this.f11966m);
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
    public MenuItem setShortcut(char c, char c2) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return (char) 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
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
