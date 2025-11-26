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
/* renamed from: com.sec.widget.q */
/* loaded from: classes.dex */
public final class MenuItemC2145q implements MenuItem {

    /* renamed from: a */
    private MenuC2144p f7797a;

    /* renamed from: c */
    private SubMenu f7799c;

    /* renamed from: d */
    private ContextMenu.ContextMenuInfo f7800d;

    /* renamed from: e */
    private final int f7801e;

    /* renamed from: f */
    private final int f7802f;

    /* renamed from: g */
    private final int f7803g;

    /* renamed from: h */
    private final int f7804h;

    /* renamed from: i */
    private CharSequence f7805i;

    /* renamed from: j */
    private CharSequence f7806j;

    /* renamed from: k */
    private Intent f7807k;

    /* renamed from: l */
    private char f7808l;

    /* renamed from: m */
    private char f7809m;

    /* renamed from: n */
    private Drawable f7810n;

    /* renamed from: p */
    private MenuItem.OnMenuItemClickListener f7812p;

    /* renamed from: b */
    private View f7798b = null;

    /* renamed from: o */
    private int f7811o = 0;

    /* renamed from: q */
    private int f7813q = 16;

    MenuItemC2145q(MenuC2144p menuC2144p, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f7797a = menuC2144p;
        this.f7801e = i2;
        this.f7802f = i;
        this.f7803g = i3;
        this.f7804h = i4;
        this.f7805i = charSequence;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f7801e;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f7802f;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f7803g;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f7805i = charSequence;
        this.f7797a.m7506a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f7797a.m7503a().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f7805i;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f7806j = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f7805i;
        }
        this.f7797a.m7506a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f7806j != null ? this.f7806j : this.f7805i;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f7811o = 0;
        this.f7810n = drawable;
        this.f7797a.m7506a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f7810n = null;
        this.f7811o = i;
        this.f7797a.m7506a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f7810n != null) {
            return this.f7810n;
        }
        if (this.f7811o != 0) {
            return this.f7797a.m7508b().getDrawable(this.f7811o);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f7807k = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f7807k;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f7808l = c;
        this.f7809m = Character.toLowerCase(c2);
        this.f7797a.m7506a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f7808l != c) {
            this.f7808l = c;
            this.f7797a.m7506a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f7808l;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f7809m != c) {
            this.f7809m = Character.toLowerCase(c);
            this.f7797a.m7506a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f7809m;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f7813q;
        this.f7813q = (z ? 1 : 0) | (this.f7813q & (-2));
        if (i != this.f7813q) {
            this.f7797a.m7506a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f7813q & 1) == 1;
    }

    /* renamed from: a */
    void m7512a(boolean z) {
        int i = this.f7813q;
        this.f7813q = (z ? 2 : 0) | (this.f7813q & (-3));
        if (i != this.f7813q) {
            this.f7797a.m7506a(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        m7512a(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f7813q & 2) == 2;
    }

    /* renamed from: b */
    boolean m7514b(boolean z) {
        int i = this.f7813q;
        this.f7813q = (z ? 0 : 8) | (this.f7813q & (-9));
        return i != this.f7813q;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m7514b(z)) {
            this.f7797a.m7505a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f7813q & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f7813q |= 16;
        } else {
            this.f7813q &= -17;
        }
        if (this.f7798b != null) {
            LinearLayout linearLayout = (LinearLayout) this.f7798b;
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                linearLayout.getChildAt(i).setEnabled(z);
            }
        }
        this.f7797a.m7506a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f7813q & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f7799c != null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f7799c;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f7812p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f7800d;
    }

    /* renamed from: a */
    public int m7509a() {
        return this.f7804h;
    }

    /* renamed from: a */
    void m7510a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f7800d = contextMenuInfo;
    }

    /* renamed from: c */
    public void m7515c(boolean z) {
        this.f7813q = (z ? 4 : 0) | (this.f7813q & (-5));
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
    public void m7511a(View view) {
        if (view != null) {
            this.f7798b = view;
        }
    }

    /* renamed from: b */
    public View m7513b() {
        return this.f7798b;
    }
}
