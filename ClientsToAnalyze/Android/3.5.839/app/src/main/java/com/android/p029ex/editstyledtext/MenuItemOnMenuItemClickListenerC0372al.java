package com.android.p029ex.editstyledtext;

import android.view.MenuItem;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.al */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0372al implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ EditStyledText f912a;

    private MenuItemOnMenuItemClickListenerC0372al(EditStyledText editStyledText) {
        this.f912a = editStyledText;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f912a.onTextContextMenuItem(menuItem.getItemId());
    }
}
