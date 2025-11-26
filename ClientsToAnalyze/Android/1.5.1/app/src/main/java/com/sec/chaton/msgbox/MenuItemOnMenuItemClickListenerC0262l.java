package com.sec.chaton.msgbox;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONShortcutUtil;
import com.sec.chaton.util.ChatOnGraphics;

/* renamed from: com.sec.chaton.msgbox.l */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0262l implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2003a;

    MenuItemOnMenuItemClickListenerC0262l(MsgboxFragment msgboxFragment) {
        this.f2003a = msgboxFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) throws Resources.NotFoundException {
        Bitmap bitmap;
        ChatONLogWriter.m3508c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT start, Memory Address:" + this, this.f2003a.getClass().getSimpleName());
        Intent intentM3525a = ChatONShortcutUtil.m3525a(this.f2003a.getActivity(), this.f2003a.f1982u, this.f2003a.f1986y);
        try {
            bitmap = ((BitmapDrawable) this.f2003a.f1981t.getDrawable()).getBitmap();
        } catch (Exception e) {
            bitmap = null;
        }
        Bitmap bitmapM3527a = ChatOnGraphics.m3527a(this.f2003a.getActivity(), bitmap);
        if (this.f2003a.f1986y == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
            MsgboxFragment.m2418a(this.f2003a, (Object) ("(" + (this.f2003a.f1961C + 1) + ")"));
        }
        ChatONShortcutUtil.m3526a(this.f2003a.getActivity(), intentM3525a, this.f2003a.f1984w, Bitmap.createScaledBitmap(bitmapM3527a, ChatONShortcutUtil.m3524a(this.f2003a.getResources().getDisplayMetrics().density), ChatONShortcutUtil.m3524a(this.f2003a.getResources().getDisplayMetrics().density), true));
        ChatONLogWriter.m3508c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT end, Memory Address:" + this, this.f2003a.getClass().getSimpleName());
        return true;
    }
}
