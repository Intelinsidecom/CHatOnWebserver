package com.sec.common.actionbar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MenuImpl.java */
/* renamed from: com.sec.common.actionbar.t */
/* loaded from: classes.dex */
public class MenuC4965t implements Menu {

    /* renamed from: a */
    private Context f18147a;

    /* renamed from: b */
    private Resources f18148b;

    /* renamed from: c */
    private List<MenuItemC4966u> f18149c = new ArrayList();

    /* renamed from: d */
    private Menu f18150d;

    /* renamed from: e */
    private ActionBarView f18151e;

    public MenuC4965t(Context context, ActionBarView actionBarView) {
        this.f18147a = context;
        this.f18148b = context.getResources();
        this.f18151e = actionBarView;
    }

    /* renamed from: a */
    void m18879a(Menu menu) {
        this.f18150d = menu;
        for (MenuItemC4966u menuItemC4966u : this.f18149c) {
            menuItemC4966u.m18885a(menu.add(menuItemC4966u.getGroupId(), menuItemC4966u.getItemId(), menuItemC4966u.getOrder(), menuItemC4966u.getTitle()));
        }
    }

    /* renamed from: a */
    public Context m18878a() {
        return this.f18147a;
    }

    /* renamed from: b */
    public Resources m18880b() {
        return this.f18148b;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m18875a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m18875a(0, 0, 0, this.f18148b.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m18875a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m18875a(i, i2, i3, this.f18148b.getString(i4));
    }

    /* renamed from: a */
    private MenuItem m18875a(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemC4966u menuItemC4966u = new MenuItemC4966u(this, i, i2, i3, charSequence);
        if (this.f18150d != null) {
            menuItemC4966u.m18885a(this.f18150d.add(i, i2, i3, charSequence));
        }
        this.f18149c.add(m18874a(this.f18149c, i3), menuItemC4966u);
        return menuItemC4966u;
    }

    /* renamed from: a */
    private static int m18874a(List<? extends MenuItem> list, int i) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).getOrder() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public int m18877a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f18149c.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m18876b(m18877a(i));
    }

    /* renamed from: b */
    private void m18876b(int i) {
        if (i >= 0 && i < this.f18149c.size()) {
            MenuItemC4966u menuItemC4966uRemove = this.f18149c.remove(i);
            if (this.f18150d != null) {
                this.f18150d.removeItem(menuItemC4966uRemove.getItemId());
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        this.f18149c.clear();
        if (this.f18150d != null) {
            this.f18150d.clear();
        }
        m18881c();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC4966u menuItemC4966u = this.f18149c.get(i2);
            if (menuItemC4966u.getItemId() == i) {
                return menuItemC4966u;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f18149c.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f18149c.get(i);
    }

    /* renamed from: c */
    void m18881c() {
        this.f18151e.m18805b();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                MenuItemC4966u menuItemC4966u = (MenuItemC4966u) getItem(i2);
                if (menuItemC4966u.m18883a() != 0) {
                    this.f18151e.m18795a(menuItemC4966u);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC4966u menuItemC4966u = this.f18149c.get(i2);
            if (menuItemC4966u.getGroupId() == i) {
                menuItemC4966u.setVisible(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        Iterator<MenuItemC4966u> it = this.f18149c.iterator();
        while (it.hasNext()) {
            if (it.next().isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public void close() {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        throw new UnsupportedOperationException("This operation is not supported for SimpleMenu");
    }
}
