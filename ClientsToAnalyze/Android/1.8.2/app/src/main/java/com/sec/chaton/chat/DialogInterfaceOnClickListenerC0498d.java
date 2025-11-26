package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.R;
import com.sec.chaton.util.C1767bw;
import com.sec.widget.C2153y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0498d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f2092a;

    /* renamed from: b */
    final /* synthetic */ CharSequence[] f2093b;

    /* renamed from: c */
    final /* synthetic */ C0497c f2094c;

    DialogInterfaceOnClickListenerC0498d(C0497c c0497c, CheckBox checkBox, CharSequence[] charSequenceArr) {
        this.f2094c = c0497c;
        this.f2092a = checkBox;
        this.f2093b = charSequenceArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0 && !C1767bw.m6002a()) {
            C2153y.m7536a(this.f2094c.f2091a.getActivity(), this.f2094c.f2091a.getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (this.f2092a.isChecked()) {
            i += this.f2093b.length;
        }
        new AsyncTaskC0473ao(this.f2094c.f2091a).execute(Integer.valueOf(i));
    }
}
