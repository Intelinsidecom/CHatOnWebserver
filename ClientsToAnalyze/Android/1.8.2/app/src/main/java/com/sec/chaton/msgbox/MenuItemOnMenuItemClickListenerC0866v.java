package com.sec.chaton.msgbox;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1790v;
import com.sec.chaton.util.C1791w;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.v */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0866v implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3196a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f3197b;

    MenuItemOnMenuItemClickListenerC0866v(MsgboxFragment msgboxFragment, String str) {
        this.f3197b = msgboxFragment;
        this.f3196a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) throws Resources.NotFoundException {
        Bitmap bitmap;
        C1786r.m6063c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT start, Memory Address:" + this, this.f3197b.getClass().getSimpleName());
        String str = this.f3197b.f3120n;
        if (this.f3197b.f3124r == EnumC0695j.ONETOONE) {
            str = this.f3196a;
        }
        Intent intentM6081a = C1790v.m6081a(this.f3197b.getActivity(), str, this.f3197b.f3124r);
        if (this.f3197b.f3124r == EnumC0695j.GROUPCHAT) {
            intentM6081a.putExtra("shortcut_from_chat_screen", "shortcut_from_chat_screen");
        }
        try {
            bitmap = ((BitmapDrawable) this.f3197b.f3119m.getDrawable()).getBitmap();
        } catch (Exception e) {
            bitmap = null;
        }
        Bitmap bitmapM6085a = C1791w.m6085a(this.f3197b.getActivity(), bitmap);
        if (this.f3197b.f3124r == EnumC0695j.GROUPCHAT) {
            MsgboxFragment.m3501a(this.f3197b, (Object) ("(" + (this.f3197b.f3128v + 1) + ")"));
        }
        C1790v.m6082a(this.f3197b.getActivity(), intentM6081a, this.f3197b.f3122p, Bitmap.createScaledBitmap(bitmapM6085a, C1790v.m6080a(this.f3197b.getResources().getDisplayMetrics().density), C1790v.m6080a(this.f3197b.getResources().getDisplayMetrics().density), true));
        C1786r.m6063c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT end, Memory Address:" + this, this.f3197b.getClass().getSimpleName());
        return true;
    }
}
