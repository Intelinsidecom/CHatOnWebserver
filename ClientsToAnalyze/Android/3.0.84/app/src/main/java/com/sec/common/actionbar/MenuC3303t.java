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
public class MenuC3303t implements Menu {

    /* renamed from: a */
    private Context f11949a;

    /* renamed from: b */
    private Resources f11950b;

    /* renamed from: c */
    private List<MenuItemC3304u> f11951c = new ArrayList();

    /* renamed from: d */
    private Menu f11952d;

    /* renamed from: e */
    private ActionBarView f11953e;

    public MenuC3303t(Context context, ActionBarView actionBarView) {
        this.f11949a = context;
        this.f11950b = context.getResources();
        this.f11953e = actionBarView;
    }

    /* renamed from: a */
    void m11640a(Menu menu) {
        this.f11952d = menu;
        for (MenuItemC3304u menuItemC3304u : this.f11951c) {
            menuItemC3304u.m11646a(menu.add(menuItemC3304u.getGroupId(), menuItemC3304u.getItemId(), menuItemC3304u.getOrder(), menuItemC3304u.getTitle()));
        }
    }

    /* renamed from: a */
    public Context m11639a() {
        return this.f11949a;
    }

    /* renamed from: b */
    public Resources m11641b() {
        return this.f11950b;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m11636a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m11636a(0, 0, 0, this.f11950b.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m11636a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m11636a(i, i2, i3, this.f11950b.getString(i4));
    }

    /* renamed from: a */
    private MenuItem m11636a(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemC3304u menuItemC3304u = new MenuItemC3304u(this, i, i2, i3, charSequence);
        if (this.f11952d != null) {
            menuItemC3304u.m11646a(this.f11952d.add(i, i2, i3, charSequence));
        }
        this.f11951c.add(m11635a(this.f11951c, i3), menuItemC3304u);
        return menuItemC3304u;
    }

    /* renamed from: a */
    private static int m11635a(List<? extends MenuItem> list, int i) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).getOrder() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public int m11638a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f11951c.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m11637b(m11638a(i));
    }

    /* renamed from: b */
    private void m11637b(int i) {
        if (i >= 0 && i < this.f11951c.size()) {
            MenuItemC3304u menuItemC3304uRemove = this.f11951c.remove(i);
            if (this.f11952d != null) {
                this.f11952d.removeItem(menuItemC3304uRemove.getItemId());
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        this.f11951c.clear();
        if (this.f11952d != null) {
            this.f11952d.clear();
        }
        m11642c();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC3304u menuItemC3304u = this.f11951c.get(i2);
            if (menuItemC3304u.getItemId() == i) {
                return menuItemC3304u;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f11951c.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f11951c.get(i);
    }

    /* renamed from: c */
    void m11642c() {
        this.f11953e.m11567c();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < size()) {
                MenuItemC3304u menuItemC3304u = (MenuItemC3304u) getItem(i2);
                if (menuItemC3304u.m11644a() != 0) {
                    this.f11953e.m11554a(menuItemC3304u);
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
            MenuItemC3304u menuItemC3304u = this.f11951c.get(i2);
            if (menuItemC3304u.getGroupId() == i) {
                menuItemC3304u.setVisible(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        Iterator<MenuItemC3304u> it = this.f11951c.iterator();
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
