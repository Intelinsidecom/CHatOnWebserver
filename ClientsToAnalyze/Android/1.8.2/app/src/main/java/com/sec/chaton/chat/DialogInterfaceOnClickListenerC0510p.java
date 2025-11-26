package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p022h.p025c.C0777a;
import com.sec.chaton.p022h.p025c.C0779c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0510p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2117a;

    /* renamed from: b */
    final /* synthetic */ EnumC0695j f2118b;

    /* renamed from: c */
    final /* synthetic */ String f2119c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f2120d;

    DialogInterfaceOnClickListenerC0510p(ChatFragment chatFragment, String str, EnumC0695j enumC0695j, String str2) {
        this.f2120d = chatFragment;
        this.f2117a = str;
        this.f2118b = enumC0695j;
        this.f2119c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (TextUtils.isEmpty(this.f2117a) || this.f2118b == EnumC0695j.BROADCAST) {
            this.f2120d.f1783X.startDelete(1, null, C0694i.f2616a, "inbox_no IN ('" + this.f2119c + "')", null);
            this.f2120d.f1783X.startDelete(2, null, C0698m.f2626a, "message_inbox_no='" + this.f2119c + "'", null);
            C0777a.m3326a().m3329a(this.f2120d.f1912z);
            C0779c.m3335a().m3339a(this.f2120d.f1912z);
            this.f2120d.m2560o();
            return;
        }
        if (!this.f2120d.f1771L.isShowing()) {
            this.f2120d.f1771L.show();
        }
        this.f2120d.f1831at.m2937a(this.f2120d.f1765F, this.f2120d.f1766G, this.f2120d.f1912z, (String[]) this.f2120d.f1834aw.toArray(new String[0]));
    }
}
