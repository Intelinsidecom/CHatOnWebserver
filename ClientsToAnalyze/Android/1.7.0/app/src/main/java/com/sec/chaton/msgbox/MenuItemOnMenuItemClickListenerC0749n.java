package com.sec.chaton.msgbox;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1344s;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.n */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0749n implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2552a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f2553b;

    MenuItemOnMenuItemClickListenerC0749n(MsgboxFragment msgboxFragment, String str) {
        this.f2553b = msgboxFragment;
        this.f2552a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Bitmap bitmap;
        C1341p.m4660c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT start, Memory Address:" + this, this.f2553b.getClass().getSimpleName());
        String str = this.f2553b.f2507m;
        if (this.f2553b.f2511q == EnumC0665r.ONETOONE) {
            str = this.f2552a;
        }
        Intent intentM4673a = C1344s.m4673a(this.f2553b.getActivity(), str, this.f2553b.f2511q);
        try {
            bitmap = ((BitmapDrawable) this.f2553b.f2506l.getDrawable()).getBitmap();
        } catch (Exception e) {
            bitmap = null;
        }
        Bitmap bitmapM4497a = C1294aq.m4497a(this.f2553b.getActivity(), bitmap);
        if (this.f2553b.f2511q == EnumC0665r.GROUPCHAT) {
            MsgboxFragment.m3145a(this.f2553b, "(" + (this.f2553b.f2515u + 1) + ")");
        }
        C1344s.m4675a(this.f2553b.getActivity(), intentM4673a, this.f2553b.f2509o, Bitmap.createScaledBitmap(bitmapM4497a, C1344s.m4672a(this.f2553b.getResources().getDisplayMetrics().density), C1344s.m4672a(this.f2553b.getResources().getDisplayMetrics().density), true));
        C1341p.m4660c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT end, Memory Address:" + this, this.f2553b.getClass().getSimpleName());
        return true;
    }
}
