package com.sec.widget;

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
/* renamed from: com.sec.widget.u */
/* loaded from: classes.dex */
public class MenuC3687u implements Menu {

    /* renamed from: a */
    private static final int[] f13596a = {1, 4, 5, 3, 2, 0};

    /* renamed from: b */
    private DropPanelMenu f13597b;

    /* renamed from: c */
    private Context f13598c;

    /* renamed from: d */
    private Resources f13599d;

    /* renamed from: e */
    private ArrayList<MenuItemC3688v> f13600e = new ArrayList<>();

    /* renamed from: f */
    private ContextMenu.ContextMenuInfo f13601f;

    MenuC3687u(Context context) {
        this.f13598c = context;
        this.f13599d = context.getResources();
    }

    /* renamed from: a */
    Context m13272a() {
        return this.f13598c;
    }

    /* renamed from: b */
    Resources m13277b() {
        return this.f13599d;
    }

    /* renamed from: a */
    public void m13273a(DropPanelMenu dropPanelMenu) {
        this.f13597b = dropPanelMenu;
    }

    /* renamed from: a */
    void m13275a(boolean z) {
        if (this.f13597b != null && z) {
            this.f13597b.setItemChanged(z);
        }
    }

    /* renamed from: a */
    void m13274a(MenuItemC3688v menuItemC3688v) {
        m13275a(true);
    }

    /* renamed from: a */
    private MenuItem m13267a(int i, int i2, int i3, CharSequence charSequence) {
        int iM13269c = m13269c(i3);
        MenuItemC3688v menuItemC3688v = new MenuItemC3688v(this, i, i2, i3, iM13269c, charSequence);
        if (this.f13601f != null) {
            menuItemC3688v.m13279a(this.f13601f);
        }
        this.f13600e.add(m13266a(this.f13600e, iM13269c), menuItemC3688v);
        m13275a(true);
        return menuItemC3688v;
    }

    /* renamed from: a */
    private static int m13266a(ArrayList<MenuItemC3688v> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m13278a() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: c */
    private static int m13269c(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f13596a.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (f13596a[i2] << 16) | (65535 & i);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m13267a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m13267a(0, 0, 0, this.f13599d.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m13267a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m13267a(i, i2, i3, this.f13599d.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f13599d.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f13599d.getString(i4));
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
        m13268a(m13270a(i), true);
    }

    /* renamed from: a */
    public int m13270a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f13600e.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public int m13276b(int i) {
        return m13271a(i, 0);
    }

    /* renamed from: a */
    public int m13271a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.f13600e.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iM13276b = m13276b(i);
        if (iM13276b >= 0) {
            int size = this.f13600e.size() - iM13276b;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f13600e.get(iM13276b).getGroupId() != i) {
                    break;
                }
                m13268a(iM13276b, false);
                i2 = i3;
            }
            m13275a(true);
        }
    }

    /* renamed from: a */
    private void m13268a(int i, boolean z) {
        if (i >= 0 && i < this.f13600e.size()) {
            this.f13600e.remove(i);
            if (z) {
                m13275a(true);
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        this.f13600e.clear();
        m13275a(true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f13600e.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC3688v menuItemC3688v = this.f13600e.get(i2);
            if (menuItemC3688v.getGroupId() == i) {
                menuItemC3688v.m13284c(z2);
                menuItemC3688v.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f13600e.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            MenuItemC3688v menuItemC3688v = this.f13600e.get(i2);
            i2++;
            z2 = (menuItemC3688v.getGroupId() == i && menuItemC3688v.m13283b(z)) ? true : z2;
        }
        if (z2) {
            m13275a(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f13600e.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC3688v menuItemC3688v = this.f13600e.get(i2);
            if (menuItemC3688v.getGroupId() == i) {
                menuItemC3688v.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f13600e.get(i).isVisible()) {
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
            MenuItemC3688v menuItemC3688v = this.f13600e.get(i2);
            if (menuItemC3688v.getItemId() != i) {
                if (menuItemC3688v.hasSubMenu() && (menuItemFindItem = menuItemC3688v.getSubMenu().findItem(i)) != null) {
                    return menuItemFindItem;
                }
            } else {
                return menuItemC3688v;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f13600e.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f13600e.get(i);
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
