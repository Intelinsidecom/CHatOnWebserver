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
/* renamed from: com.sec.widget.p */
/* loaded from: classes.dex */
public class MenuC2144p implements Menu {

    /* renamed from: a */
    private static final int[] f7791a = {1, 4, 5, 3, 2, 0};

    /* renamed from: b */
    private DropPanelMenu f7792b;

    /* renamed from: c */
    private Context f7793c;

    /* renamed from: d */
    private Resources f7794d;

    /* renamed from: e */
    private ArrayList f7795e = new ArrayList();

    /* renamed from: f */
    private ContextMenu.ContextMenuInfo f7796f;

    MenuC2144p(Context context) {
        this.f7793c = context;
        this.f7794d = context.getResources();
    }

    /* renamed from: a */
    Context m7503a() {
        return this.f7793c;
    }

    /* renamed from: b */
    Resources m7508b() {
        return this.f7794d;
    }

    /* renamed from: a */
    public void m7504a(DropPanelMenu dropPanelMenu) {
        this.f7792b = dropPanelMenu;
    }

    /* renamed from: a */
    void m7506a(boolean z) {
        if (this.f7792b != null && z) {
            this.f7792b.setItemChanged(z);
        }
    }

    /* renamed from: a */
    void m7505a(MenuItemC2145q menuItemC2145q) {
        m7506a(true);
    }

    /* renamed from: a */
    private MenuItem m7498a(int i, int i2, int i3, CharSequence charSequence) {
        int iM7500c = m7500c(i3);
        MenuItemC2145q menuItemC2145q = new MenuItemC2145q(this, i, i2, i3, iM7500c, charSequence);
        if (this.f7796f != null) {
            menuItemC2145q.m7510a(this.f7796f);
        }
        this.f7795e.add(m7497a(this.f7795e, iM7500c), menuItemC2145q);
        m7506a(true);
        return menuItemC2145q;
    }

    /* renamed from: a */
    private static int m7497a(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((MenuItemC2145q) arrayList.get(size)).m7509a() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: c */
    private static int m7500c(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f7791a.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (f7791a[i2] << 16) | (65535 & i);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m7498a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m7498a(0, 0, 0, this.f7794d.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m7498a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m7498a(i, i2, i3, this.f7794d.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f7794d.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f7794d.getString(i4));
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
        m7499a(m7501a(i), true);
    }

    /* renamed from: a */
    public int m7501a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((MenuItemC2145q) this.f7795e.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public int m7507b(int i) {
        return m7502a(i, 0);
    }

    /* renamed from: a */
    public int m7502a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((MenuItemC2145q) this.f7795e.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iM7507b = m7507b(i);
        if (iM7507b >= 0) {
            int size = this.f7795e.size() - iM7507b;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((MenuItemC2145q) this.f7795e.get(iM7507b)).getGroupId() != i) {
                    break;
                }
                m7499a(iM7507b, false);
                i2 = i3;
            }
            m7506a(true);
        }
    }

    /* renamed from: a */
    private void m7499a(int i, boolean z) {
        if (i >= 0 && i < this.f7795e.size()) {
            this.f7795e.remove(i);
            if (z) {
                m7506a(true);
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        this.f7795e.clear();
        m7506a(true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f7795e.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC2145q menuItemC2145q = (MenuItemC2145q) this.f7795e.get(i2);
            if (menuItemC2145q.getGroupId() == i) {
                menuItemC2145q.m7515c(z2);
                menuItemC2145q.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f7795e.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            MenuItemC2145q menuItemC2145q = (MenuItemC2145q) this.f7795e.get(i2);
            i2++;
            z2 = (menuItemC2145q.getGroupId() == i && menuItemC2145q.m7514b(z)) ? true : z2;
        }
        if (z2) {
            m7506a(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f7795e.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC2145q menuItemC2145q = (MenuItemC2145q) this.f7795e.get(i2);
            if (menuItemC2145q.getGroupId() == i) {
                menuItemC2145q.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((MenuItemC2145q) this.f7795e.get(i)).isVisible()) {
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
            MenuItemC2145q menuItemC2145q = (MenuItemC2145q) this.f7795e.get(i2);
            if (menuItemC2145q.getItemId() != i) {
                if (menuItemC2145q.hasSubMenu() && (menuItemFindItem = menuItemC2145q.getSubMenu().findItem(i)) != null) {
                    return menuItemFindItem;
                }
            } else {
                return menuItemC2145q;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f7795e.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return (MenuItem) this.f7795e.get(i);
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
