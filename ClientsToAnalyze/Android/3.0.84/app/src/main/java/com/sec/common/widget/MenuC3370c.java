package com.sec.common.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;

/* compiled from: DropPanelMenuImpl.java */
/* renamed from: com.sec.common.widget.c */
/* loaded from: classes.dex */
public class MenuC3370c implements Menu {

    /* renamed from: a */
    private static final int[] f12223a = {1, 4, 5, 3, 2, 0};

    /* renamed from: b */
    private DropPanelMenu f12224b;

    /* renamed from: c */
    private Context f12225c;

    /* renamed from: d */
    private Resources f12226d;

    /* renamed from: e */
    private ArrayList<MenuItemC3371d> f12227e;

    /* renamed from: f */
    private ContextMenu.ContextMenuInfo f12228f;

    /* renamed from: a */
    Context m11942a() {
        return this.f12225c;
    }

    /* renamed from: b */
    Resources m11946b() {
        return this.f12226d;
    }

    /* renamed from: a */
    void m11944a(boolean z) {
        if (this.f12224b != null && z) {
            this.f12224b.setItemChanged(z);
        }
    }

    /* renamed from: a */
    void m11943a(MenuItemC3371d menuItemC3371d) {
        m11944a(true);
    }

    /* renamed from: a */
    private MenuItem m11937a(int i, int i2, int i3, CharSequence charSequence) {
        int iM11939c = m11939c(i3);
        MenuItemC3371d menuItemC3371d = new MenuItemC3371d(this, i, i2, i3, iM11939c, charSequence);
        if (this.f12228f != null) {
            menuItemC3371d.m11948a(this.f12228f);
        }
        this.f12227e.add(m11936a(this.f12227e, iM11939c), menuItemC3371d);
        m11944a(true);
        return menuItemC3371d;
    }

    /* renamed from: a */
    private static int m11936a(ArrayList<MenuItemC3371d> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m11947a() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: c */
    private static int m11939c(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f12223a.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (f12223a[i2] << 16) | (65535 & i);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m11937a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m11937a(0, 0, 0, this.f12226d.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m11937a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m11937a(i, i2, i3, this.f12226d.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f12226d.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f12226d.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m11938a(m11940a(i), true);
    }

    /* renamed from: a */
    public int m11940a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f12227e.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public int m11945b(int i) {
        return m11941a(i, 0);
    }

    /* renamed from: a */
    public int m11941a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.f12227e.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iM11945b = m11945b(i);
        if (iM11945b >= 0) {
            int size = this.f12227e.size() - iM11945b;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f12227e.get(iM11945b).getGroupId() != i) {
                    break;
                }
                m11938a(iM11945b, false);
                i2 = i3;
            }
            m11944a(true);
        }
    }

    /* renamed from: a */
    private void m11938a(int i, boolean z) {
        if (i >= 0 && i < this.f12227e.size()) {
            this.f12227e.remove(i);
            if (z) {
                m11944a(true);
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        this.f12227e.clear();
        m11944a(true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f12227e.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC3371d menuItemC3371d = this.f12227e.get(i2);
            if (menuItemC3371d.getGroupId() == i) {
                menuItemC3371d.m11953c(z2);
                menuItemC3371d.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f12227e.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            MenuItemC3371d menuItemC3371d = this.f12227e.get(i2);
            i2++;
            z2 = (menuItemC3371d.getGroupId() == i && menuItemC3371d.m11952b(z)) ? true : z2;
        }
        if (z2) {
            m11944a(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f12227e.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC3371d menuItemC3371d = this.f12227e.get(i2);
            if (menuItemC3371d.getGroupId() == i) {
                menuItemC3371d.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f12227e.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC3371d menuItemC3371d = this.f12227e.get(i2);
            if (menuItemC3371d.getItemId() != i) {
                if (menuItemC3371d.hasSubMenu() && (menuItemFindItem = menuItemC3371d.getSubMenu().findItem(i)) != null) {
                    return menuItemFindItem;
                }
            } else {
                return menuItemC3371d;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f12227e.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f12227e.get(i);
    }

    @Override // android.view.Menu
    public void close() {
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return false;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
    }
}
