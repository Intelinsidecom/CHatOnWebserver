package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p018c.C0476aa;
import com.sec.chaton.p018c.p019a.C0468e;
import com.sec.chaton.p018c.p019a.C0473j;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1332g;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0755t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2559a;

    /* renamed from: b */
    final /* synthetic */ EnumC0665r f2560b;

    /* renamed from: c */
    final /* synthetic */ String f2561c;

    /* renamed from: d */
    final /* synthetic */ String f2562d;

    /* renamed from: e */
    final /* synthetic */ int f2563e;

    /* renamed from: f */
    final /* synthetic */ MsgboxFragment f2564f;

    DialogInterfaceOnClickListenerC0755t(MsgboxFragment msgboxFragment, String str, EnumC0665r enumC0665r, String str2, String str3, int i) {
        this.f2564f = msgboxFragment;
        this.f2559a = str;
        this.f2560b = enumC0665r;
        this.f2561c = str2;
        this.f2562d = str3;
        this.f2563e = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C1332g.m4605a(this.f2564f.getActivity()).m4610a(this.f2564f.f2513s);
        if (TextUtils.isEmpty(this.f2559a) || this.f2560b == EnumC0665r.BROADCAST) {
            this.f2564f.f2504j.startDelete(1, null, C0671x.f2315a, "inbox_no IN ('" + this.f2561c + "')", null);
            this.f2564f.f2504j.startDelete(2, null, C0662o.f2289a, "message_inbox_no='" + this.f2561c + "'", null);
            C0473j.m2410a().m2413a(this.f2561c);
            C0468e.m2389a().m2392a(this.f2561c);
            this.f2564f.m3153e();
            return;
        }
        this.f2564f.f2489C = C0223v.m806a(this.f2561c, this.f2560b);
        this.f2564f.f2489C.m848a(this.f2564f.f2495I);
        this.f2564f.f2489C.m851a(this.f2561c, this.f2562d, this.f2563e);
        this.f2564f.f2489C.m841a(Long.MAX_VALUE);
        if (!this.f2564f.f2490D.isShowing()) {
            this.f2564f.f2490D.show();
        }
        this.f2564f.f2489C.m835a(this.f2560b, this.f2559a, this.f2561c, (String[]) this.f2564f.f2505k.toArray(new String[0]));
        C0476aa.m2436a().m2440b();
        this.f2564f.f2489C.m852b(true);
    }
}
