package com.sec.chaton.p018b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ContextMenuWrapper.java */
/* renamed from: com.sec.chaton.b.a */
/* loaded from: classes.dex */
public class ContextMenuC0453a implements ContextMenu {

    /* renamed from: a */
    private Context f1521a;

    /* renamed from: b */
    private ContextMenu f1522b;

    public ContextMenuC0453a(Context context, ContextMenu contextMenu) {
        this.f1521a = context;
        this.f1522b = contextMenu;
    }

    @Override // android.view.ContextMenu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContextMenuC0453a setHeaderTitle(int i) {
        this.f1522b.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.ContextMenu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContextMenuC0453a setHeaderTitle(CharSequence charSequence) {
        this.f1522b.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return add(this.f1521a.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return this.f1522b.add(charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return add(i, i2, i3, this.f1521a.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return this.f1522b.add(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1521a.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return this.f1522b.addSubMenu(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.f1522b.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(this.f1521a.getString(i));
    }

    @Override // android.view.Menu
    public void clear() {
        this.f1522b.clear();
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return this.f1522b.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        this.f1522b.removeItem(i);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        this.f1522b.removeGroup(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f1522b.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.f1522b.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.f1522b.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f1522b.hasVisibleItems();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return this.f1522b.findItem(i);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1522b.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f1522b.getItem(i);
    }

    @Override // android.view.Menu
    public void close() {
        this.f1522b.close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f1522b.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f1522b.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.f1522b.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1522b.setQwertyMode(z);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderIcon(int i) {
        return this.f1522b.setHeaderIcon(i);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderIcon(Drawable drawable) {
        return this.f1522b.setHeaderIcon(drawable);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderView(View view) {
        return this.f1522b.setHeaderView(view);
    }

    @Override // android.view.ContextMenu
    public void clearHeader() {
        this.f1522b.clearHeader();
    }
}
