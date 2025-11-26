package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.sec.chaton.chat.translate.C1865r;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.spp.push.Config;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1562ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1505a f5977a;

    /* renamed from: b */
    final /* synthetic */ CheckBox f5978b;

    /* renamed from: c */
    final /* synthetic */ CheckBox f5979c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f5980d;

    DialogInterfaceOnClickListenerC1562ai(ChatFragment chatFragment, C1505a c1505a, CheckBox checkBox, CheckBox checkBox2) {
        this.f5980d = chatFragment;
        this.f5977a = c1505a;
        this.f5978b = checkBox;
        this.f5979c = checkBox2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        boolean z2;
        if (ChatFragment.f5459P.equalsIgnoreCase(ChatFragment.f5467dk) && ChatFragment.f5460Q.equalsIgnoreCase(ChatFragment.f5468dl) && this.f5980d.f5697dj) {
            z = false;
        } else {
            C2198l.m9930a(GlobalApplication.m18732r().getContentResolver(), this.f5980d.f5750v, ChatFragment.f5467dk, ChatFragment.f5468dl);
            ChatFragment.f5459P = ChatFragment.f5467dk;
            ChatFragment.f5460Q = ChatFragment.f5468dl;
            this.f5980d.f5697dj = true;
            z = true;
        }
        if (!(this.f5980d.f5699dn && this.f5977a.m8356a()) && (this.f5980d.f5699dn || this.f5977a.m8356a())) {
            C2198l.m9937b(GlobalApplication.m18732r().getContentResolver(), this.f5980d.f5750v, this.f5977a.m8356a());
            this.f5980d.f5699dn = this.f5977a.m8356a();
            z2 = true;
        } else {
            z2 = false;
        }
        if (C1865r.m9070b()) {
            if ((!this.f5980d.f5700do || !this.f5978b.isChecked()) && (this.f5980d.f5700do || this.f5978b.isChecked())) {
                C2198l.m9945c(GlobalApplication.m18732r().getContentResolver(), this.f5980d.f5750v, this.f5978b.isChecked());
                this.f5980d.f5700do = this.f5978b.isChecked();
            }
        } else if ((!this.f5980d.f5700do || !this.f5979c.isChecked()) && (this.f5980d.f5700do || this.f5979c.isChecked())) {
            C2198l.m9945c(GlobalApplication.m18732r().getContentResolver(), this.f5980d.f5750v, this.f5979c.isChecked());
            this.f5980d.f5700do = this.f5979c.isChecked();
        }
        if ((this.f5977a.m8356a() && z) || z2) {
            StringBuilder sb = new StringBuilder();
            if (this.f5980d.f5699dn) {
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.TRANSLATE_ON.m10100a()), "TRANSLATE_ON", C1736gi.m8632a(ChatFragment.f5468dl))).append(Config.KEYVALUE_SPLIT);
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.TRANSLATE_ON.m10100a()), "TRANSLATE_ON", C1736gi.m8632a(ChatFragment.f5467dk))).append(Config.KEYVALUE_SPLIT);
            } else {
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.TRANSLATE_OFF.m10100a()), "TRANSLATE_OFF", C1736gi.m8632a("TRANSLATE_OFF"))).append(Config.KEYVALUE_SPLIT);
            }
            C2204r.m10033a(this.f5980d.f5546ao, 1, this.f5980d.f5750v, sb.toString(), this.f5980d.f5599bo);
        }
        this.f5980d.m7850M();
        dialogInterface.cancel();
    }
}
