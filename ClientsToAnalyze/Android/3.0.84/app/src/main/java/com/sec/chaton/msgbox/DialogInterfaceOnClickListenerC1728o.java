package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3159aa;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.o */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1728o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f6394a;

    /* renamed from: b */
    final /* synthetic */ String f6395b;

    /* renamed from: c */
    final /* synthetic */ EnumC1450r f6396c;

    /* renamed from: d */
    final /* synthetic */ String f6397d;

    /* renamed from: e */
    final /* synthetic */ String f6398e;

    /* renamed from: f */
    final /* synthetic */ int f6399f;

    /* renamed from: g */
    final /* synthetic */ MsgboxFragment f6400g;

    DialogInterfaceOnClickListenerC1728o(MsgboxFragment msgboxFragment, CheckBox checkBox, String str, EnumC1450r enumC1450r, String str2, String str3, int i) {
        this.f6400g = msgboxFragment;
        this.f6394a = checkBox;
        this.f6395b = str;
        this.f6396c = enumC1450r;
        this.f6397d = str2;
        this.f6398e = str3;
        this.f6399f = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        if (this.f6394a.isChecked()) {
            z = false;
        }
        C3159aa.m10962a().m10983b("msgbox_close_popup_show", Boolean.valueOf(z));
        this.f6400g.m7072b(this.f6395b, this.f6396c, this.f6397d, this.f6398e, this.f6399f);
    }
}
