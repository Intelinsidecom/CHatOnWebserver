package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p055d.C2128i;
import java.util.ArrayList;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.fu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1721fu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1720ft f6332a;

    DialogInterfaceOnClickListenerC1721fu(HandlerC1720ft handlerC1720ft) {
        this.f6332a = handlerC1720ft;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f6332a.f6331a.f6323c.f5823h.size(); i2++) {
            arrayList.add(((C1106c) this.f6332a.f6331a.f6323c.f5823h.get(i2)).m7046a());
        }
        new C2128i(this.f6332a.f6331a.f6327g).m9489a("group", false, (String) null, this.f6332a.f6331a.f6324d.m18658a().toString(), (String[]) arrayList.toArray(new String[0]), 325);
        this.f6332a.f6331a.f6323c.m8339c();
    }
}
