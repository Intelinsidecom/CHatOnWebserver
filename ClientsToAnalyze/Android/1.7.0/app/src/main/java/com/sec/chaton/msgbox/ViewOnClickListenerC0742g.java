package com.sec.chaton.msgbox;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC0742g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0736a f2537a;

    ViewOnClickListenerC0742g(C0736a c0736a) {
        this.f2537a = c0736a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0746k c0746k = (C0746k) view.getTag();
        if (EnumC0665r.ONETOONE.m3012a() == c0746k.f2547f) {
            if (TextUtils.isEmpty(c0746k.f2544c)) {
                this.f2537a.f2530j.startQuery(1, null, C0654g.m2980a(c0746k.f2546e), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "rowid DESC");
            } else {
                this.f2537a.m3180a(c0746k.f2544c, c0746k.f2545d);
            }
        }
    }
}
