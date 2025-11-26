package com.sec.widget;

import android.widget.EditText;
import android.widget.Toast;

/* compiled from: RemoveCharsFilter.java */
/* renamed from: com.sec.widget.ag */
/* loaded from: classes.dex */
final class C2127ag implements InterfaceC2128ah {

    /* renamed from: a */
    final /* synthetic */ EditText f7769a;

    /* renamed from: b */
    final /* synthetic */ int f7770b;

    C2127ag(EditText editText, int i) {
        this.f7769a = editText;
        this.f7770b = i;
    }

    @Override // com.sec.widget.InterfaceC2128ah
    /* renamed from: a */
    public void mo7481a() {
        Toast.makeText(this.f7769a.getContext(), this.f7770b, 0).show();
    }
}
