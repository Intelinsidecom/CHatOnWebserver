package com.sec.chaton.p049b;

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
public class ContextMenuC1056a implements ContextMenu {

    /* renamed from: a */
    private Context f3345a;

    /* renamed from: b */
    private ContextMenu f3346b;

    public ContextMenuC1056a(Context context, ContextMenu contextMenu) {
        this.f3345a = context;
        this.f3346b = contextMenu;
    }

    @Override // android.view.ContextMenu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContextMenuC1056a setHeaderTitle(int i) {
        this.f3346b.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.ContextMenu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContextMenuC1056a setHeaderTitle(CharSequence charSequence) {
        this.f3346b.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return add(this.f3345a.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return this.f3346b.add(charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return add(i, i2, i3, this.f3345a.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return this.f3346b.add(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f3345a.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return this.f3346b.addSubMenu(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.f3346b.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(this.f3345a.getString(i));
    }

    @Override // android.view.Menu
    public void clear() {
        this.f3346b.clear();
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return this.f3346b.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        this.f3346b.removeItem(i);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        this.f3346b.removeGroup(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f3346b.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.f3346b.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.f3346b.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f3346b.hasVisibleItems();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return this.f3346b.findItem(i);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f3346b.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f3346b.getItem(i);
    }

    @Override // android.view.Menu
    public void close() {
        this.f3346b.close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f3346b.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f3346b.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.f3346b.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f3346b.setQwertyMode(z);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderIcon(int i) {
        return this.f3346b.setHeaderIcon(i);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderIcon(Drawable drawable) {
        return this.f3346b.setHeaderIcon(drawable);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderView(View view) {
        return this.f3346b.setHeaderView(view);
    }

    @Override // android.view.ContextMenu
    public void clearHeader() {
        this.f3346b.clearHeader();
    }
}
