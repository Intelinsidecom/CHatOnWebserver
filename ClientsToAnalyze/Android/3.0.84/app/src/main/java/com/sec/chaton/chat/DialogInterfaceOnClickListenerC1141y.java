package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.R;
import com.sec.chaton.util.C3223ck;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1141y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f4564a;

    /* renamed from: b */
    final /* synthetic */ CharSequence[] f4565b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f4566c;

    DialogInterfaceOnClickListenerC1141y(ChatFragment chatFragment, CheckBox checkBox, CharSequence[] charSequenceArr) {
        this.f4566c = chatFragment;
        this.f4564a = checkBox;
        this.f4565b = charSequenceArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i != 0 || C3223ck.m11327a()) {
            if (this.f4566c.m4834am()) {
                if (this.f4564a.isChecked()) {
                    i += this.f4565b.length;
                }
                new AsyncTaskC1033db(this.f4566c).execute(Integer.valueOf(i));
                return;
            }
            return;
        }
        C3641ai.m13211a(this.f4566c.f3672cr, this.f4566c.getString(R.string.toast_sdcard_amount), 1).show();
    }
}
