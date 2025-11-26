package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.R;
import com.sec.chaton.util.C4873ck;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.am */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1566am implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f5984a;

    /* renamed from: b */
    final /* synthetic */ CharSequence[] f5985b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f5986c;

    DialogInterfaceOnClickListenerC1566am(ChatFragment chatFragment, CheckBox checkBox, CharSequence[] charSequenceArr) {
        this.f5986c = chatFragment;
        this.f5984a = checkBox;
        this.f5985b = charSequenceArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i != 0 || C4873ck.m18500a()) {
            if (this.f5986c.m7957aB()) {
                if (this.f5984a.isChecked()) {
                    i += this.f5985b.length;
                }
                new AsyncTaskC1677ed(this.f5986c).execute(Integer.valueOf(i));
                return;
            }
            return;
        }
        C5179v.m19811a(this.f5986c.f5624cN, this.f5986c.getString(R.string.toast_sdcard_amount), 1).show();
    }
}
