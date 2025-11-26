package com.sec.common.widget;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: DropPanelMenuItemImpl.java */
/* renamed from: com.sec.common.widget.d */
/* loaded from: classes.dex */
public final class MenuItemC3371d implements MenuItem {

    /* renamed from: a */
    private MenuC3370c f12229a;

    /* renamed from: c */
    private SubMenu f12231c;

    /* renamed from: d */
    private ContextMenu.ContextMenuInfo f12232d;

    /* renamed from: e */
    private final int f12233e;

    /* renamed from: f */
    private final int f12234f;

    /* renamed from: g */
    private final int f12235g;

    /* renamed from: h */
    private final int f12236h;

    /* renamed from: i */
    private CharSequence f12237i;

    /* renamed from: j */
    private CharSequence f12238j;

    /* renamed from: k */
    private Intent f12239k;

    /* renamed from: l */
    private char f12240l;

    /* renamed from: m */
    private char f12241m;

    /* renamed from: n */
    private Drawable f12242n;

    /* renamed from: p */
    private MenuItem.OnMenuItemClickListener f12244p;

    /* renamed from: b */
    private View f12230b = null;

    /* renamed from: o */
    private int f12243o = 0;

    /* renamed from: q */
    private int f12245q = 16;

    MenuItemC3371d(MenuC3370c menuC3370c, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f12229a = menuC3370c;
        this.f12233e = i2;
        this.f12234f = i;
        this.f12235g = i3;
        this.f12236h = i4;
        this.f12237i = charSequence;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f12233e;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f12234f;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f12235g;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f12237i = charSequence;
        this.f12229a.m11944a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f12229a.m11942a().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f12237i;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f12238j = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f12237i;
        }
        this.f12229a.m11944a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f12238j != null ? this.f12238j : this.f12237i;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f12243o = 0;
        this.f12242n = drawable;
        this.f12229a.m11944a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f12242n = null;
        this.f12243o = i;
        this.f12229a.m11944a(true);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f12242n != null) {
            return this.f12242n;
        }
        if (this.f12243o != 0) {
            return this.f12229a.m11946b().getDrawable(this.f12243o);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f12239k = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f12239k;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f12240l = c;
        this.f12241m = Character.toLowerCase(c2);
        this.f12229a.m11944a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f12240l != c) {
            this.f12240l = c;
            this.f12229a.m11944a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f12240l;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f12241m != c) {
            this.f12241m = Character.toLowerCase(c);
            this.f12229a.m11944a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f12241m;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f12245q;
        this.f12245q = (z ? 1 : 0) | (this.f12245q & (-2));
        if (i != this.f12245q) {
            this.f12229a.m11944a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f12245q & 1) == 1;
    }

    /* renamed from: a */
    void m11950a(boolean z) {
        int i = this.f12245q;
        this.f12245q = (z ? 2 : 0) | (this.f12245q & (-3));
        if (i != this.f12245q) {
            this.f12229a.m11944a(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        m11950a(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f12245q & 2) == 2;
    }

    /* renamed from: b */
    boolean m11952b(boolean z) {
        int i = this.f12245q;
        this.f12245q = (z ? 0 : 8) | (this.f12245q & (-9));
        return i != this.f12245q;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m11952b(z)) {
            this.f12229a.m11943a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f12245q & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f12245q |= 16;
        } else {
            this.f12245q &= -17;
        }
        if (this.f12230b != null) {
            LinearLayout linearLayout = (LinearLayout) this.f12230b;
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                linearLayout.getChildAt(i).setEnabled(z);
            }
        }
        this.f12229a.m11944a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f12245q & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f12231c != null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f12231c;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f12244p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f12232d;
    }

    /* renamed from: a */
    public int m11947a() {
        return this.f12236h;
    }

    /* renamed from: a */
    void m11948a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f12232d = contextMenuInfo;
    }

    /* renamed from: c */
    public void m11953c(boolean z) {
        this.f12245q = (z ? 4 : 0) | (this.f12245q & (-5));
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
    public void m11949a(View view) {
        if (view != null) {
            this.f12230b = view;
        }
    }

    /* renamed from: b */
    public View m11951b() {
        return this.f12230b;
    }
}
