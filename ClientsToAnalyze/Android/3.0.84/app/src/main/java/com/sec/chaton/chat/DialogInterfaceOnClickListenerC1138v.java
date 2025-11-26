package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.spp.push.Config;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1138v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0887a f4559a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f4560b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f4561c;

    DialogInterfaceOnClickListenerC1138v(ChatFragment chatFragment, C0887a c0887a, CheckBox checkBox) {
        this.f4561c = chatFragment;
        this.f4559a = c0887a;
        this.f4560b = checkBox;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        boolean z2;
        if (this.f4561c.f3643cM.equalsIgnoreCase(ChatFragment.f3485cP) && this.f4561c.f3644cN.equalsIgnoreCase(ChatFragment.f3486cQ) && this.f4561c.f3645cO) {
            z = false;
        } else {
            C1370n.m6127a(GlobalApplication.m11493l().getContentResolver(), this.f4561c.f3703r, ChatFragment.f3485cP, ChatFragment.f3486cQ);
            this.f4561c.f3643cM = ChatFragment.f3485cP;
            this.f4561c.f3644cN = ChatFragment.f3486cQ;
            this.f4561c.f3645cO = true;
            z = true;
        }
        if (!(this.f4561c.f3647cS && this.f4559a.m5086a()) && (this.f4561c.f3647cS || this.f4559a.m5086a())) {
            C1370n.m6133b(GlobalApplication.m11493l().getContentResolver(), this.f4561c.f3703r, this.f4559a.m5086a());
            this.f4561c.f3647cS = this.f4559a.m5086a();
            z2 = true;
        } else {
            z2 = false;
        }
        if ((!this.f4561c.f3648cT || !this.f4560b.isChecked()) && (this.f4561c.f3648cT || this.f4560b.isChecked())) {
            C1370n.m6138c(GlobalApplication.m11493l().getContentResolver(), this.f4561c.f3703r, this.f4560b.isChecked());
            this.f4561c.f3648cT = this.f4560b.isChecked();
        }
        if ((this.f4559a.m5086a() && z) || z2) {
            StringBuilder sb = new StringBuilder();
            if (this.f4561c.f3647cS) {
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.TRANSLATE_ON.m6248a()), "TRANSLATE_ON", C1075eq.m5318a(ChatFragment.f3486cQ))).append(Config.KEYVALUE_SPLIT);
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.TRANSLATE_ON.m6248a()), "TRANSLATE_ON", C1075eq.m5318a(ChatFragment.f3485cP))).append(Config.KEYVALUE_SPLIT);
            } else {
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC1391ai.TRANSLATE_OFF.m6248a()), "TRANSLATE_OFF", C1075eq.m5318a("TRANSLATE_OFF"))).append(Config.KEYVALUE_SPLIT);
            }
            C1373q.m6181a(this.f4561c.f3551aa, 1, this.f4561c.f3703r, sb.toString(), this.f4561c.f3544aT);
        }
        this.f4561c.m4686G();
        dialogInterface.cancel();
    }
}
