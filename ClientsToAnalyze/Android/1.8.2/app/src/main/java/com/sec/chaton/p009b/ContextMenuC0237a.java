package com.sec.chaton.p009b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: ContextMenuWrapper.java */
/* renamed from: com.sec.chaton.b.a */
/* loaded from: classes.dex */
public class ContextMenuC0237a implements ContextMenu {

    /* renamed from: a */
    private boolean f769a = C0239c.m1825a();

    /* renamed from: b */
    private Context f770b;

    /* renamed from: c */
    private ContextMenu f771c;

    public ContextMenuC0237a(Context context, ContextMenu contextMenu) {
        this.f770b = context;
        this.f771c = contextMenu;
    }

    @Override // android.view.ContextMenu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContextMenuC0237a setHeaderTitle(int i) {
        if (this.f769a) {
            return setHeaderTitle(this.f770b.getString(i));
        }
        this.f771c.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.ContextMenu
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContextMenuC0237a setHeaderTitle(CharSequence charSequence) {
        if (this.f769a) {
            this.f771c.setHeaderTitle(AlertDialogBuilderC2120a.m7478a(charSequence));
        } else {
            this.f771c.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return add(this.f770b.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return this.f771c.add(charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return add(i, i2, i3, this.f770b.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return this.f771c.add(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f770b.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return this.f771c.addSubMenu(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.f771c.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(this.f770b.getString(i));
    }

    @Override // android.view.Menu
    public void clear() {
        this.f771c.clear();
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return this.f771c.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        this.f771c.removeItem(i);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        this.f771c.removeGroup(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f771c.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.f771c.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.f771c.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f771c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return this.f771c.findItem(i);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f771c.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f771c.getItem(i);
    }

    @Override // android.view.Menu
    public void close() {
        this.f771c.close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f771c.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f771c.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.f771c.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f771c.setQwertyMode(z);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderIcon(int i) {
        return this.f771c.setHeaderIcon(i);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderIcon(Drawable drawable) {
        return this.f771c.setHeaderIcon(drawable);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderView(View view) {
        return this.f771c.setHeaderView(view);
    }

    @Override // android.view.ContextMenu
    public void clearHeader() {
        this.f771c.clearHeader();
    }
}
