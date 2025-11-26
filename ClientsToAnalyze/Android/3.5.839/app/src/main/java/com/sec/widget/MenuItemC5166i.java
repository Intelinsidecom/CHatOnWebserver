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
/* renamed from: com.sec.widget.i */
/* loaded from: classes.dex */
public final class MenuItemC5166i implements MenuItem {

    /* renamed from: a */
    private MenuC5165h f18893a;

    /* renamed from: c */
    private SubMenu f18895c;

    /* renamed from: d */
    private ContextMenu.ContextMenuInfo f18896d;

    /* renamed from: e */
    private final int f18897e;

    /* renamed from: f */
    private final int f18898f;

    /* renamed from: g */
    private final int f18899g;

    /* renamed from: h */
    private final int f18900h;

    /* renamed from: i */
    private CharSequence f18901i;

    /* renamed from: j */
    private CharSequence f18902j;

    /* renamed from: k */
    private Intent f18903k;

    /* renamed from: l */
    private char f18904l;

    /* renamed from: m */
    private char f18905m;

    /* renamed from: n */
    private Drawable f18906n;

    /* renamed from: p */
    private MenuItem.OnMenuItemClickListener f18908p;

    /* renamed from: b */
    private View f18894b = null;

    /* renamed from: o */
    private int f18907o = 0;

    /* renamed from: q */
    private int f18909q = 16;

    MenuItemC5166i(MenuC5165h menuC5165h, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f18893a = menuC5165h;
        this.f18897e = i2;
        this.f18898f = i;
        this.f18899g = i3;
        this.f18900h = i4;
        this.f18901i = charSequence;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f18897e;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f18898f;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f18899g;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f18901i = charSequence;
        this.f18893a.m19760a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f18893a.m19757a().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f18901i;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f18902j = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f18901i;
        }
        this.f18893a.m19760a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f18902j != null ? this.f18902j : this.f18901i;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f18907o = 0;
        this.f18906n = drawable;
        this.f18893a.m19760a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f18906n = null;
        this.f18907o = i;
        this.f18893a.m19760a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f18906n != null) {
            return this.f18906n;
        }
        if (this.f18907o != 0) {
            return this.f18893a.m19762b().getDrawable(this.f18907o);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f18903k = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f18903k;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f18904l = c2;
        this.f18905m = Character.toLowerCase(c3);
        this.f18893a.m19760a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f18904l != c2) {
            this.f18904l = c2;
            this.f18893a.m19760a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f18904l;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f18905m != c2) {
            this.f18905m = Character.toLowerCase(c2);
            this.f18893a.m19760a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f18905m;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f18909q;
        this.f18909q = (z ? 1 : 0) | (this.f18909q & (-2));
        if (i != this.f18909q) {
            this.f18893a.m19760a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f18909q & 1) == 1;
    }

    /* renamed from: a */
    void m19766a(boolean z) {
        int i = this.f18909q;
        this.f18909q = (z ? 2 : 0) | (this.f18909q & (-3));
        if (i != this.f18909q) {
            this.f18893a.m19760a(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        m19766a(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f18909q & 2) == 2;
    }

    /* renamed from: b */
    boolean m19768b(boolean z) {
        int i = this.f18909q;
        this.f18909q = (z ? 0 : 8) | (this.f18909q & (-9));
        return i != this.f18909q;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m19768b(z)) {
            this.f18893a.m19759a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f18909q & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f18909q |= 16;
        } else {
            this.f18909q &= -17;
        }
        if (this.f18894b != null) {
            LinearLayout linearLayout = (LinearLayout) this.f18894b;
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                linearLayout.getChildAt(i).setEnabled(z);
            }
        }
        this.f18893a.m19760a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f18909q & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f18895c != null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f18895c;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f18908p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f18896d;
    }

    /* renamed from: a */
    public int m19763a() {
        return this.f18900h;
    }

    /* renamed from: a */
    void m19764a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f18896d = contextMenuInfo;
    }

    /* renamed from: c */
    public void m19769c(boolean z) {
        this.f18909q = (z ? 4 : 0) | (this.f18909q & (-5));
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
    public void m19765a(View view) {
        if (view != null) {
            this.f18894b = view;
        }
    }

    /* renamed from: b */
    public View m19767b() {
        return this.f18894b;
    }
}
