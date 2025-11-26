package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.p018c.p019a.C0468e;
import com.sec.chaton.p018c.p019a.C0473j;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0565be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1974a;

    /* renamed from: b */
    final /* synthetic */ EnumC0665r f1975b;

    /* renamed from: c */
    final /* synthetic */ String f1976c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f1977d;

    DialogInterfaceOnClickListenerC0565be(ChatFragment chatFragment, String str, EnumC0665r enumC0665r, String str2) {
        this.f1977d = chatFragment;
        this.f1974a = str;
        this.f1975b = enumC0665r;
        this.f1976c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (TextUtils.isEmpty(this.f1974a) || this.f1975b == EnumC0665r.BROADCAST) {
            this.f1977d.f1760U.startDelete(1, null, C0671x.f2315a, "inbox_no IN ('" + this.f1976c + "')", null);
            this.f1977d.f1760U.startDelete(2, null, C0662o.f2289a, "message_inbox_no='" + this.f1976c + "'", null);
            C0473j.m2410a().m2413a(this.f1976c);
            C0468e.m2389a().m2392a(this.f1976c);
            this.f1977d.m2672r();
            return;
        }
        if (!this.f1977d.f1744E.isShowing()) {
            this.f1977d.f1744E.show();
        }
        this.f1977d.f1799ai.m835a(this.f1977d.f1866y, this.f1977d.f1867z, this.f1977d.f1861t, (String[]) this.f1977d.f1802al.toArray(new String[0]));
    }
}
