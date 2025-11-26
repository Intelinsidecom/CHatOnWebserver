package com.sec.chaton.msgbox;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0848d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0845a f3147a;

    ViewOnClickListenerC0848d(C0845a c0845a) {
        this.f3147a = c0845a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0850f c0850f = (C0850f) view.getTag();
        if (EnumC0695j.ONETOONE.m3146a() == c0850f.f3154f) {
            if (TextUtils.isEmpty(c0850f.f3151c)) {
                this.f3147a.f3143k.startQuery(1, null, C0701p.m3164a(c0850f.f3153e), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "rowid DESC");
            } else {
                this.f3147a.m3543a(c0850f.f3151c, c0850f.f3152d);
            }
        }
    }
}
