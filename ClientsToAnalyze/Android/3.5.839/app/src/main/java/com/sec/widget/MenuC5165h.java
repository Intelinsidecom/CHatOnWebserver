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
/* renamed from: com.sec.widget.h */
/* loaded from: classes.dex */
public class MenuC5165h implements Menu {

    /* renamed from: a */
    private static final int[] f18887a = {1, 4, 5, 3, 2, 0};

    /* renamed from: b */
    private DropPanelMenu f18888b;

    /* renamed from: c */
    private Context f18889c;

    /* renamed from: d */
    private Resources f18890d;

    /* renamed from: e */
    private ArrayList<MenuItemC5166i> f18891e = new ArrayList<>();

    /* renamed from: f */
    private ContextMenu.ContextMenuInfo f18892f;

    MenuC5165h(Context context) {
        this.f18889c = context;
        this.f18890d = context.getResources();
    }

    /* renamed from: a */
    Context m19757a() {
        return this.f18889c;
    }

    /* renamed from: b */
    Resources m19762b() {
        return this.f18890d;
    }

    /* renamed from: a */
    public void m19758a(DropPanelMenu dropPanelMenu) {
        this.f18888b = dropPanelMenu;
    }

    /* renamed from: a */
    void m19760a(boolean z) {
        if (this.f18888b != null && z) {
            this.f18888b.setItemChanged(z);
        }
    }

    /* renamed from: a */
    void m19759a(MenuItemC5166i menuItemC5166i) {
        m19760a(true);
    }

    /* renamed from: a */
    private MenuItem m19752a(int i, int i2, int i3, CharSequence charSequence) {
        int iM19754c = m19754c(i3);
        MenuItemC5166i menuItemC5166i = new MenuItemC5166i(this, i, i2, i3, iM19754c, charSequence);
        if (this.f18892f != null) {
            menuItemC5166i.m19764a(this.f18892f);
        }
        this.f18891e.add(m19751a(this.f18891e, iM19754c), menuItemC5166i);
        m19760a(true);
        return menuItemC5166i;
    }

    /* renamed from: a */
    private static int m19751a(ArrayList<MenuItemC5166i> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m19763a() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: c */
    private static int m19754c(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f18887a.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (f18887a[i2] << 16) | (65535 & i);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m19752a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m19752a(0, 0, 0, this.f18890d.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m19752a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m19752a(i, i2, i3, this.f18890d.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f18890d.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f18890d.getString(i4));
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
        m19753a(m19755a(i), true);
    }

    /* renamed from: a */
    public int m19755a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f18891e.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public int m19761b(int i) {
        return m19756a(i, 0);
    }

    /* renamed from: a */
    public int m19756a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.f18891e.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iM19761b = m19761b(i);
        if (iM19761b >= 0) {
            int size = this.f18891e.size() - iM19761b;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f18891e.get(iM19761b).getGroupId() != i) {
                    break;
                }
                m19753a(iM19761b, false);
                i2 = i3;
            }
            m19760a(true);
        }
    }

    /* renamed from: a */
    private void m19753a(int i, boolean z) {
        if (i >= 0 && i < this.f18891e.size()) {
            this.f18891e.remove(i);
            if (z) {
                m19760a(true);
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        this.f18891e.clear();
        m19760a(true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f18891e.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC5166i menuItemC5166i = this.f18891e.get(i2);
            if (menuItemC5166i.getGroupId() == i) {
                menuItemC5166i.m19769c(z2);
                menuItemC5166i.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f18891e.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            MenuItemC5166i menuItemC5166i = this.f18891e.get(i2);
            i2++;
            z2 = (menuItemC5166i.getGroupId() == i && menuItemC5166i.m19768b(z)) ? true : z2;
        }
        if (z2) {
            m19760a(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f18891e.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemC5166i menuItemC5166i = this.f18891e.get(i2);
            if (menuItemC5166i.getGroupId() == i) {
                menuItemC5166i.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f18891e.get(i).isVisible()) {
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
            MenuItemC5166i menuItemC5166i = this.f18891e.get(i2);
            if (menuItemC5166i.getItemId() != i) {
                if (menuItemC5166i.hasSubMenu() && (menuItemFindItem = menuItemC5166i.getSubMenu().findItem(i)) != null) {
                    return menuItemFindItem;
                }
            } else {
                return menuItemC5166i;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f18891e.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f18891e.get(i);
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
