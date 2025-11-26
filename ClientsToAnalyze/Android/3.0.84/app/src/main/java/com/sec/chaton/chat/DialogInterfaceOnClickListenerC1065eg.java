package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p025d.C1330h;
import java.util.ArrayList;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.eg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1065eg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1064ef f4183a;

    DialogInterfaceOnClickListenerC1065eg(HandlerC1064ef handlerC1064ef) {
        this.f4183a = handlerC1064ef;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f4183a.f4182a.f4173c.f3767i.size(); i2++) {
            arrayList.add(((C0513c) this.f4183a.f4182a.f4173c.f3767i.get(i2)).m3975b());
        }
        new C1330h(this.f4183a.f4182a.f4178h).m5716a("group", false, (String) null, this.f4183a.f4182a.f4175e.m11463a().toString(), (String[]) arrayList.toArray(new String[0]), 325);
        this.f4183a.f4182a.f4173c.m5071c();
    }
}
